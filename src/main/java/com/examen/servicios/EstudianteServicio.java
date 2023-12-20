package com.examen.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.entidades.Estudiante;
import com.examen.repositorio.EstudianteRepositorio;

@Service
public class EstudianteServicio {

	@Autowired
	private EstudianteRepositorio estudianteRepositorio;
	
	public List<Estudiante> listar(){
		return estudianteRepositorio.findAllWithTipoDocumento();
	}
	
	public int save(Estudiante es) {
		int res=0;
		Estudiante estudiante = this.estudianteRepositorio.save(es);
		if(!estudiante.equals(null)) {
			res=1;
		}
		return res;
	}
	
	@Transactional
	public void delete(int codigo) {
		estudianteRepositorio.deleteByCodigo(codigo);
	}

	public Optional<Estudiante> listarId(int codigo) {
		return estudianteRepositorio.findByCodigo(codigo);
	}
}
