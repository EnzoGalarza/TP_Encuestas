package proyecto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import encuesta.Encuesta;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;  

class ProyectoTestCase {

	private Proyecto proyecto1, proyecto2, proyecto3, proyecto4;
	private Encuesta encuesta1, encuesta2, encuesta3, encuesta4, encuesta5;
	private ArrayList<Encuesta> encuestas;
	private ArrayList<Proyecto> subProyectos;
	
	@BeforeEach  
	void setUp()  { 
		encuestas = new ArrayList<Encuesta>();
		encuesta1 = mock(Encuesta.class);
		encuesta2 = mock(Encuesta.class);
		encuesta3 = mock(Encuesta.class);
		encuesta4 = mock(Encuesta.class);
		encuesta5 = mock(Encuesta.class);
		proyecto1 = new Proyecto("Descripcion", "Proposito");
		proyecto2 = new Proyecto("Recibos","Archivar");
		proyecto3 = new Proyecto("Papeleo","Controlar");
		proyecto4 = new Proyecto("Copias","Copiar");
		subProyectos = new ArrayList<Proyecto>();
		encuestas.add(encuesta1); encuestas.add(encuesta2);
		subProyectos.add(proyecto2); subProyectos.add(proyecto3);
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
	
	@Test
	void tieneSubProyecto() {
		proyecto1.agregarSubProyecto(proyecto2);
		proyecto1.agregarSubProyecto(proyecto3);
		
		assertEquals(subProyectos, proyecto1.getSubProyectos());
	}
	
	@Test
	void subProyectoQueContieneAlProyectoContenedorNoSeAgrega() {
		proyecto1.agregarSubProyecto(proyecto3);
		proyecto1.agregarSubProyecto(proyecto4);
		proyecto2.agregarSubProyecto(proyecto1);
		
		proyecto4.agregarSubProyecto(proyecto1); // No se puede agregar
		proyecto1.agregarSubProyecto(proyecto2); // No se puede agregar
		
		List<Proyecto> subProyectos2 = new ArrayList<Proyecto>(); //esto es una lista vacia de subproyectos
		List<Proyecto> subProyectos3 = new ArrayList<Proyecto>();
		subProyectos3.add(proyecto3);
		subProyectos3.add(proyecto4);
		
		assertEquals(subProyectos2, proyecto4.getSubProyectos());
		assertEquals(subProyectos3, proyecto1.getSubProyectos());
		
	}
	
	@Test
	void encuestasFinalizadas() {
		when(encuesta1.finalizada()).thenReturn(true);
		when(encuesta2.finalizada()).thenReturn(true);
		
		proyecto1.agregarEncuesta(encuesta1);
		proyecto1.agregarEncuesta(encuesta2);
		//No sé si habria que hacer algo mas con las encuestas
		//ecuensta1 y encuesta2 estan finalizadas?
		assertTrue(proyecto1.encuestasFinalizadas());
	}
	
	@Test
	void testEncuestasNoFinalizadas() {
		when(encuesta1.finalizada()).thenReturn(true);
		when(encuesta3.finalizada()).thenReturn(true);
		when(encuesta4.finalizada()).thenReturn(true);
		when(encuesta2.finalizada()).thenReturn(false);
		when(encuesta5.finalizada()).thenReturn(true);
		
		proyecto1.agregarEncuesta(encuesta1);
		proyecto1.agregarEncuesta(encuesta2);
		proyecto1.agregarEncuesta(encuesta3);
		proyecto1.agregarEncuesta(encuesta4);
		proyecto1.agregarEncuesta(encuesta5);
		
		assertFalse(proyecto1.encuestasFinalizadas());
	}
	
	@Test 
	void proyectoFinalizado() {
		when(encuesta1.finalizada()).thenReturn(true);
		when(encuesta2.finalizada()).thenReturn(true);
		when(encuesta3.finalizada()).thenReturn(true);
		proyecto2.agregarEncuesta(encuesta1);
		proyecto2.agregarEncuesta(encuesta2);
		proyecto1.agregarSubProyecto(proyecto2);
		proyecto1.agregarEncuesta(encuesta3);
		//solo si encuesta1 y encuesta2 estan finalizados
		assertTrue(proyecto1.subProyectosYEncuestasFinalizados());
	}
	
    @Test
	void testProyectoNoEstaFinalizadoSiAlgunaEncuestaNoEstaFinalizada() {
    	
    	when(encuesta1.finalizada()).thenReturn(true);
		when(encuesta2.finalizada()).thenReturn(false);
		when(encuesta3.finalizada()).thenReturn(true);
		proyecto2.agregarEncuesta(encuesta1);
		proyecto2.agregarEncuesta(encuesta2);
		proyecto1.agregarSubProyecto(proyecto2);
		proyecto1.agregarEncuesta(encuesta3);

		assertFalse(proyecto1.subProyectosYEncuestasFinalizados());
    	
    }
    
    @Test
    void testSePuedeObtenerLasEncuestasDisponiblesDeUnProyecto() {
    	when(encuesta1.disponible()).thenReturn(true);
		when(encuesta2.disponible()).thenReturn(false);
		
		proyecto2.agregarEncuesta(encuesta1);
		proyecto2.agregarEncuesta(encuesta2);
		
		ArrayList<Encuesta> encuestas = new ArrayList<>();
		encuestas.add(encuesta1);
		
		assertEquals(proyecto2.getEncuestasDisponibles(), encuestas);
    }
    
    
	
}	