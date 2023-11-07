package view.adapters;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Curso;
import service.FormacionServiceFactory;

public class TablaCursosFechaModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	List<Curso> cursos;
	
	// CONSTRUCTOR
	public TablaCursosFechaModel() {
		cursos = FormacionServiceFactory.getFormacionService().listadoCursos();
	}

	public TablaCursosFechaModel(LocalDate fechaInicio, LocalDate fechaFin) {
		cursos = FormacionServiceFactory.getFormacionService().listadoCursos(fechaInicio, fechaFin);
	}

	@Override
	public int getRowCount() {
		return cursos.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int column) {
		return switch (column) {
			case 0 -> "curso";
			case 1 -> "duracion";
			case 2 -> "precio";
			case 3 -> "fechaInicio";
			default -> "Indeterminado";
		};
	}

	@Override
	public Object getValueAt(int row, int column) {
		switch (column) {
			case 0: return cursos.get(row).getCurso();
			case 1: return cursos.get(row).getDuracion();
			case 2: return cursos.get(row).getPrecio();
			case 3: return Date.valueOf(cursos.get(row).getFechaInicio());
			default: return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0: return String.class;
			case 1: return int.class;
			case 2: return double.class;
			case 3: return LocalDate.class;
			default: return null;
		}
	}
}