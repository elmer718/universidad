package com.examen.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.entidades.Materia;
import com.examen.repositorio.MateriaRepositorio;

@Service
public class MateriaServicio {
	
	@Autowired
	private MateriaRepositorio materiaRepositorio;
	
	public List<Materia> listar(){
		return materiaRepositorio.findAll();
	}
	
	public int save (Materia m) {
		int res=0;
		Materia materia = materiaRepositorio.save(m);
		if(!materia.equals(null)) {
			res=1;
		}
		return res;
	}
	
	@Transactional
	public void delete(int codigo) {
		materiaRepositorio.deleteByCodigo(codigo);
	}
	
	public Optional<Materia> listarId(int codigo) {
		return materiaRepositorio.findByCodigo(codigo);
	}

}
