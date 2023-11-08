package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity														// Etiquetas de persistencia
@Table(name="empleados")

public class Empleado {
	@Id														// Indica la PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// Si es autogenerado se indica el tipo de autogeneración,
															// en este caso Identity, que es autoincremental.
	private int idEmpleado;
	private String nombre;
	private String email;
	private String departamento;
	private double salario;

}
