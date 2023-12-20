package com.examen.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TipoDocumento {
	
	@Id
	private int id;
	
	private String descripcion;

}
