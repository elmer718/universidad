package com.examen.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examen.entidades.Materia;

public interface MateriaRepositorio extends JpaRepository<Materia, String>{
	
	@Query("SELECT m FROM Materia m WHERE m.codigo = :codigo")
	Optional<Materia> findByCodigo(@Param("codigo") int codigo);
	
	@Modifying
	@Query("DELETE FROM Materia WHERE codigo = :codigo")
	void deleteByCodigo(@Param("codigo") int codigo);

}
