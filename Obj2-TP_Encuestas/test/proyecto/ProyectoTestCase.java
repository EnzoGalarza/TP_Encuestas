package proyecto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import encuesta.Encuesta;
import static org.mockito.Mockito.*;

import java.util.ArrayList;  

class testProyecto {

	private Proyecto proyecto1;
	private Encuesta encuesta1, encuesta2;
	private ArrayList<Encuesta> encuestas;
	
	@BeforeEach  
	void setUp()  { 
		encuestas = new ArrayList<Encuesta>();
		encuesta1 = mock(Encuesta.class);
		encuesta2 = mock(Encuesta.class);
		proyecto1 = new Proyecto("Descripcion", "Proposito");
		encuestas.add(encuesta1); encuestas.add(encuesta2);
	}

	@Test
	void tieneUnPropositoYUnaDescripcion() {
		assertEquals("Descripcion", proyecto1.descripcion());
		assertEquals("Proposito", proyecto1.proposito());
	}

	@Test
	void poseeUnConjuntoDeEncuestas() {
		proyecto1.agregarEncuesta(encuesta1);
		proyecto1.agregarEncuesta(encuesta2);
		
		assertEquals(encuestas, proyecto1.getEncuestas());
		assertEquals(2,proyecto1.cantidadDeEncuestas());
	}
	
}	