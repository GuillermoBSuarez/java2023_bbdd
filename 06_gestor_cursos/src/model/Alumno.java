package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Alumno {
	private String dni;
	private String nombre;
	private int edad;
	private double nota;
	private int curso;
}
