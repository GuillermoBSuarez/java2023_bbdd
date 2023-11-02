package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Empleado;
import service.EmpleadoService;

class TestEmpleadoService {
	
	EmpleadoService es;

	@BeforeEach
	void setUp() throws Exception {
		es = new EmpleadoService();
	}

	@Test
	void testGrabarEmpleado() {
		assertTrue(es.grabarEmpleado(new Empleado(0, "e1", "mail1", "depto1", 1)));;
	}
}
