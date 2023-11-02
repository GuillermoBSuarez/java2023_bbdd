package view.adapters;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Empleado;
import service.EmpleadoService;

public class TablaEmpleadoModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Empleado> empleados;
	
	// CONSTRUCTOR
	public TablaEmpleadoModel(String departamento) {
		empleados = new EmpleadoService().buscarEmpleadosPorDepartamento(departamento);
	}

	@Override
	public int getRowCount() {
		return empleados.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		return switch (column) {
			case 0 -> "Nombre";
			case 1 -> "E-mail";
			case 2 -> "Salario";
			default -> "Indeterminado";
		};
	}

	@Override
	public Object getValueAt(int row, int column) {
		switch (column) {
			case 0: return empleados.get(row).getNombre();
			case 1: return empleados.get(row).getEmail();
			case 2: return empleados.get(row).getSalario();
			default: return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0: return String.class;
			case 1: return String.class;
			case 2: return Double.class;
			default: return null;
		}
	}
}