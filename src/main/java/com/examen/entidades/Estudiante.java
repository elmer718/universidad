package com.examen.entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	@ManyToMany
    @JoinTable(
            name = "estudiante_materia",
            joinColumns = @JoinColumn(name = "estudiante_codigo"),
            inverseJoinColumns = @JoinColumn(name = "materia_codigo")
    )
	private List<Materia> materias;
}
