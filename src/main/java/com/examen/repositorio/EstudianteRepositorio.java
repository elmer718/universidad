package com.examen.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examen.entidades.Estudiante;
import com.examen.entidades.Materia;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, String>{

	@Query("SELECT e FROM Estudiante e LEFT JOIN FETCH e.tipoDocumento")
	List<Estudiante> findAllWithTipoDocumento();

	
	@Query("SELECT e FROM Estudiante e WHERE e.codigo = :codigo")
	Optional<Estudiante> findByCodigo(@Param("codigo") int codigo);
	
	@Modifying
	@Query("DELETE FROM Estudiante WHERE codigo = :codigo")
	void deleteByCodigo(@Param("codigo") int codigo);
	
	@EntityGraph(attributePaths = "materias")
    @Query("SELECT e FROM Estudiante e WHERE e.codigo = :codigo")
    Optional<Estudiante> findByCodigoWithMaterias(@Param("codigo") int codigo);
	
}
