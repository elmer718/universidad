package com.examen.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.entidades.TipoDocumento;
import com.examen.repositorio.TipoDocumentoRepositorio;

@Service
public class TipoDocumentoServicios {
	
	@Autowired
	private TipoDocumentoRepositorio tipoDocumentoRepositorio;
	
	public List<TipoDocumento> listar(){
		return tipoDocumentoRepositorio.findAll();
	}
	
	public Optional<TipoDocumento> getId(int id){
		return tipoDocumentoRepositorio.findById(id);
	}
	

}
