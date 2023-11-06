package model;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Curso {
	private int idCurso;
	private String curso;
	private int duracion;
	private double precio;
	private LocalDate fechaInicio;
	private List<Alumno> alumnos;
	
	@Override
	public String toString() {
		return curso;
	}
}