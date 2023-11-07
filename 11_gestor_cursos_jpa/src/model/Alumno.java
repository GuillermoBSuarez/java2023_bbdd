package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="alumnos")

public class Alumno {
	
	@Id
	private String dni;
	private String nombre;
	private int edad;
	private double nota;
	private int curso;
}
