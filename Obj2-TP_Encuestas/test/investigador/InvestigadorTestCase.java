package investigador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import investigador.Investigador;
import pregunta.Pregunta;
import pregunta.PreguntaDeSeleccionSimple;
import proyecto.Proyecto;

import static org.mockito.Mockito.*;

import java.util.ArrayList; 

class InvestigadorTestCase {

	private Investigador investigador;
	private Proyecto proyecto1;
	private Encuesta encuesta;
	private Pregunta pregunta1;
	private Pregunta pregunta2;
	private Pregunta pregunta3;
	
	@BeforeEach 
	public void setUp() {
		proyecto1 = new Proyecto("descripcion", "proposito");
		encuesta = mock(Encuesta.class);
		pregunta1 = new PreguntaDeSeleccionSimple("Viaja en tren", new ArrayList<>());
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
	void puedeCrearUnProyectoConUnPropositoYUnaDescripcion() {
	investigador.crearProyecto("Mi proyecto", "Descripcion");
		
	assertTrue(investigador.tieneProyectos());
	}
	
	@Test
	void creaUnaEncuestaEnUnProyecto() {
		investigador.crearEncuesta(proyecto1);
		
		assertEquals(1,investigador.cantidadDeEncuestasEn(proyecto1));
	}

	@Test
	void defineUnaEncuestaAgregandoPreguntas() {
		
		Encuesta encuestaCreada = investigador.crearEncuesta(proyecto1);
		investigador.agregarPreguntaEn(proyecto1, encuestaCreada, pregunta1);
		
		assertEquals(pregunta1,investigador.getEncuesta(proyecto1, encuesta).getPreguntaActual());
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}