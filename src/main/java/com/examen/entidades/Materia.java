package com.examen.entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Materia {
	
	@Id
	private int codigo;
	
	private String nombre;
	
	@ManyToMany(mappedBy = "materias")
    private List<Estudiante> estudiantes;

}
