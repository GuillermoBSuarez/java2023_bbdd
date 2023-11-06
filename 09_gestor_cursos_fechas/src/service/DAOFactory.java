package service;

import DAO.AlumnoDAO;
import DAO.AlumnoDAOImpl;
import DAO.CursoDAO;
import DAO.CursoDAOImpl;

public class DAOFactory {
	
	public static AlumnoDAO getAlumnoDAO() {
		return new AlumnoDAOImpl();
	}
	
	public static CursoDAO getCursoDAO() {
		return new CursoDAOImpl();
	}
}