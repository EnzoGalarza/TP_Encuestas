package proyecto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;

import static org.mockito.Mockito.*;  

class testProyecto {

	private Proyecto proyecto1;
	private Encuesta encuesta1;
	
	@BeforeEach  
	void setUp()  { 
		
		encuesta1 = mock(Encuesta.class);
		proyecto1 = new Proyecto("Proyecto");
		proyecto1.agregarEncuesta(encuesta1);
	}

	@Test
	void testProyectoTieneUnNombre() {
		assertEquals("Proyecto", proyecto1.getNombre());
	}

	@Test
	void testAgregarEncuesta() {
		assertEquals(1,proyecto1.cantidadDeEncuestas());
	}
	
}	