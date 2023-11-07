package view.adapters;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Curso;
import service.FormacionServiceFactory;

public class ComboCursosModel extends DefaultComboBoxModel<Curso> {

	private static final long serialVersionUID = 1L;
	List<Curso> cursos;
	
	// CONSTRUCTOR
	public ComboCursosModel() {
		// cursos = new ArrayList<>(new FormacionService().listadoCursos());
		cursos = new ArrayList<>(FormacionServiceFactory.getFormacionService().listadoCursos());
		cursos.add(0, new Curso(0, "-Todos-", 0, 0, null, null));
	}
	
	@Override
	public int getSize() {
		return cursos.size();
	}

	@Override
	public Curso getElementAt(int index) {
		return cursos.get(index);
	}
}