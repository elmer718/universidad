package com.examen.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante {

	private int documento;

	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "codigo")
	private int codigo;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_documento")
	private TipoDocumento tipoDocumento;
}
