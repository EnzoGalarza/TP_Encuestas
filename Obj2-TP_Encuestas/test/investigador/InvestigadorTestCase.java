package investigador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import investigador.Investigador;
import pregunta.Pregunta;
import pregunta.PreguntaDeSeleccionSimple;
import proyecto.Proyecto;
import respuesta.Respuesta;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List; 

class InvestigadorTestCase {

	private Investigador investigador;
	private Proyecto proyecto1;
	private Encuesta encuesta;
	private Pregunta pregunta1;
	private Pregunta pregunta2;
	private Pregunta pregunta3;
	private Respuesta respuesta1, respuesta2;
	
	@BeforeEach 
	public void setUp() {
		respuesta1 = mock(Respuesta.class);
		respuesta2 = mock(Respuesta.class);
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
	void testProyectosInvestigador() {
		List<Proyecto> proyectosInv = new ArrayList<Proyecto>();
		proyectosInv.add(proyecto1);
		assertEquals(proyectosInv,this.investigador.getProyectos());
	}
	
	@Test
	void creaUnaEncuestaEnUnProyecto() {
		investigador.crearEncuesta(proyecto1,38);
		
		assertEquals(1,investigador.cantidadDeEncuestasEn(proyecto1));
	}

	@Test
	void defineUnaEncuestaAgregandoPreguntas() {
		//when(encuesta.getPreguntaActual()).thenReturn(pregunta1);
		Encuesta encuestaCreada = investigador.crearEncuesta(proyecto1,32);
		investigador.agregarPreguntaEn(proyecto1, encuestaCreada, pregunta1);
		
		assertEquals(pregunta1,investigador.getEncuesta(proyecto1, encuestaCreada).getPreguntaActual());
	}
	
	@Test
	void testInvestigadorAgregarPreguntaDeInteres() {
		List<Pregunta> preguntasDeInteres = new ArrayList<Pregunta>();
		preguntasDeInteres.add(pregunta1);
		this.investigador.agregarPreguntaDeInteres(pregunta1);
		assertEquals(preguntasDeInteres,investigador.getPreguntasDeInteres());
	}

	@Test
	void testInvestigadorAgregarRespuestaDeInteres() {
		List<Respuesta> respuestasDeInteres = new ArrayList<Respuesta>();
		respuestasDeInteres.add(respuesta1);
		this.investigador.agregarRespuestaDeInteres(respuesta1);
		assertEquals(respuestasDeInteres, this.investigador.getRespuestasDeInteres());
	}
	
	@Test
	void testEsDeInteres() {
		this.investigador.agregarPreguntaDeInteres(pregunta1);
		this.investigador.agregarRespuestaDeInteres(respuesta1);
		assertTrue(this.investigador.esDeInteres(pregunta1, respuesta1));
		
		assertFalse(this.investigador.esDeInteres(pregunta2, respuesta2));
		
		assertTrue(this.investigador.esDeInteres(pregunta2, respuesta1));
	}
	
	
	
}