package com.examen.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examen.entidades.TipoDocumento;

public interface TipoDocumentoRepositorio extends JpaRepository<TipoDocumento, String>{
	
	@Query("SELECT t FROM TipoDocumento t WHERE t.id = :id")
	Optional<TipoDocumento> findById(@Param("id") int id);
	
}
