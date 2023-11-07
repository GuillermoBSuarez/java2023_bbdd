package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="cursos")

public class Curso {

	@Id
	private int idCurso;
	private String curso;
	private int duracion;
	private double precio;
	private LocalDate fechaInicio;
	@Transient						// Etiqueta para que ignore la List<Alumno>, que no existe en la BD y daría error.
	private List<Alumno> alumnos;
	
	@Override
	public String toString() {
		return curso;
	}
}