package com.examen.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Materia {
	
	@Id
	private int codigo;
	
	private String nombre;

}
