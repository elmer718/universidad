package com.examen.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.examen.entidades.Estudiante;
import com.examen.entidades.Materia;
import com.examen.entidades.TipoDocumento;
import com.examen.servicios.EstudianteServicio;
import com.examen.servicios.TipoDocumentoServicios;

@Controller
@RequestMapping("/estudiante")
public class EstudianteControlador {
	
	@Autowired
	private EstudianteServicio estudianteServico;
	
	@Autowired
	private TipoDocumentoServicios tipoDocumentoServicio;
	
	@GetMapping("/listar")
	public String listar(Model model){
		List<Estudiante> estudiantes = this.estudianteServico.listar();
		model.addAttribute("estudiantes", estudiantes);
		return "index.html";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		List<TipoDocumento> tipos = tipoDocumentoServicio.listar();
		model.addAttribute("estudiante", new Estudiante());
		model.addAttribute("tipoDoc", tipos);
		return "formEstudiante.html";
	}
	
	@PostMapping("/save")
	public String save(@Validated Estudiante e,@RequestParam("tipoDocumentoId") int tipoDocumentoId, Model model) {
		
		Optional<TipoDocumento> tipoDocumento = tipoDocumentoServicio.getId(tipoDocumentoId);
		e.setTipoDocumento(tipoDocumento.get());
		estudianteServico.save(e);
		return "redirect:/estudiante/listar";
	}
	
	@GetMapping("/editar/{codigo}")
	public String editar(@PathVariable int codigo, Model model) {
		Optional<Estudiante> estudiante = estudianteServico.listarId(codigo);
		TipoDocumento tipoDocumento = tipoDocumentoServicio.getId(estudiante.get().getTipoDocumento().getId()).get();
		List<TipoDocumento> tipos = tipoDocumentoServicio.listar();
		model.addAttribute("estudiante", estudiante);
		model.addAttribute("tipoDocumento", tipoDocumento);
		model.addAttribute("tipoDoc", tipos);
		return "formEstudiante.html";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String delete(@PathVariable int codigo, Model model) {
		estudianteServico.delete(codigo);
		return "redirect:/estudiante/listar";
	}
	
	@GetMapping("/materia/{codigo}")
	public String materias(@PathVariable int codigo, Model model) {
		Optional<Estudiante> estudiante = estudianteServico.listarId(codigo);
		TipoDocumento tipoDocumento = tipoDocumentoServicio.getId(estudiante.get().getTipoDocumento().getId()).get();
		List<Materia> materias = estudianteServico.materias(codigo);
		model.addAttribute("estudiante", estudiante);
		model.addAttribute("tipoDocumento", tipoDocumento);
		model.addAttribute("materias", materias);
		return "matricula.html";
	}

}
