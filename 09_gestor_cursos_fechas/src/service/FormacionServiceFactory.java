package service;

public class FormacionServiceFactory {
	
	public static FormacionService getFormacionService() {
		return new FormacionServiceImpl();
	}
}