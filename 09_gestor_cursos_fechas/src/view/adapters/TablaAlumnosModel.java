package view.adapters;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import DAO.AlumnoDAO;
import model.Alumno;
import model.Curso;
import service.FormacionService;
import service.FormacionServiceFactory;

public class TablaAlumnosModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	List<Alumno> alumnos;
	
	// CONSTRUCTOR
	public TablaAlumnosModel() {
		// alumnos = new FormacionService().listadoAlumnos(0);
		alumnos = FormacionServiceFactory.getFormacionService().listadoAlumnos(0);
	}

	public TablaAlumnosModel(int idCurso) {
		// alumnos = new FormacionService().listadoAlumnos(idCurso);
		alumnos = FormacionServiceFactory.getFormacionService().listadoAlumnos(idCurso);
	}

	@Override
	public int getRowCount() {
		return alumnos.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int column) {
		return switch (column) {
			case 0 -> "DNI";
			case 1 -> "Nombre";
			case 2 -> "Edad";
			case 3 -> "Nota";
			default -> "Indeterminado";
		};
	}

	@Override
	public Object getValueAt(int row, int column) {
		switch (column) {
			case 0: return alumnos.get(row).getDni();
			case 1: return alumnos.get(row).getNombre();
			case 2: return alumnos.get(row).getEdad();
			case 3: return alumnos.get(row).getNota();
			default: return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0: return String.class;
			case 1: return String.class;
			case 2: return int.class;
			case 3: return double.class;
			default: return null;
		}
	}
}