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

import com.examen.entidades.Materia;
import com.examen.servicios.MateriaServicio;

@Controller
@RequestMapping("/materia")
public class MateriaControlador {
	
	@Autowired
	private MateriaServicio materiaServicio;
	
	@GetMapping("/listar")
	public String listar(Model model){
		List<Materia> materias = materiaServicio.listar();
		model.addAttribute("materias", materias);
		return "materia.html";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("materia", new Materia());
		return "";
	}
	
	@PostMapping("/save")
	public String save(@Validated Materia m, Model model) {
		materiaServicio.save(m);
		return "redirect:/materia/listar";
	}
	
	@GetMapping("/editar/{codigo}")
	public String editar(@PathVariable int codigo, Model model) {
		Optional<Materia> materia = materiaServicio.listarId(codigo);
		model.addAttribute("materia", materia);
		return "";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String delete(@PathVariable int codigo, Model model) {
		materiaServicio.delete(codigo);
		return "redirect:/materia/listar";
	}

}
