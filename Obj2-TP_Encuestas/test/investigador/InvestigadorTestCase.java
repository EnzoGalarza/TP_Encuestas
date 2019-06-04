package investigador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import investigador.Investigador;
import pregunta.Pregunta;
import proyecto.Proyecto;

import static org.mockito.Mockito.*; 

class InvestigadorTestCase {

	private Investigador investigador;
	private Proyecto proyecto1;
	private Encuesta encuesta;
	private Pregunta pregunta1;
	private Pregunta pregunta2;
	private Pregunta pregunta3;
	
	@BeforeEach 
	public void setUp() {
		proyecto1 = mock(Proyecto.class);
		encuesta = mock(Encuesta.class);
		pregunta1 = mock(Pregunta.class);
		pregunta2 = mock(Pregunta.class);
		pregunta3 = mock(Pregunta.class);
		investigador = new Investigador("Luca","12345");
		investigador.agregarProyecto(proyecto1);
	}
	
	@Test
	void testNombreYPasswordInvestigador() {
		assertEquals("Luca", investigador.getUser());
		assertEquals("12345", investigador.getPassword()); 
	}

	@Test
	void testAgregarProyecto() {
		assertEquals(1,investigador.getProyectos().size());
	} 

	@Test
	void testInvestigadorDefinirEncuesta() {
		when(encuesta.getPreguntaActual()).thenReturn(pregunta1);
		
		investigador.agregarPreguntaAEncuesta(encuesta,pregunta1);
	    investigador.agregarPreguntaAEncuesta(encuesta, pregunta2);
	    investigador.agregarPreguntaAEncuesta(encuesta, pregunta3);
	    
	    
	    verify(encuesta).agregarPregunta(pregunta1);
	    verify(encuesta).agregarPregunta(pregunta2);
	    verify(encuesta).agregarPregunta(pregunta3);
	    
	    assertEquals(pregunta1,encuesta.getPreguntaActual());
	}
	
	
	
}