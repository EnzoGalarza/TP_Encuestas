package encuesta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pregunta.Pregunta;
import respuesta.Respuesta;
import workflow.Workflow;

import static org.mockito.Mockito.*;

class EncuestaTestCase {

	private Encuesta encuesta;
	private Workflow protocolo;
	private Encuesta encuestaNoRespondible;
	private Pregunta primerPreguntaProtocolo;
	private Pregunta segundaPreguntaProtocolo;
	private Respuesta respuestaAPrimerPregunta, respuestaASegundaPregunta;
	
	@BeforeEach
	public void setUp() {
		this.respuestaAPrimerPregunta = mock(Respuesta.class);
		this.respuestaASegundaPregunta = mock(Respuesta.class);
		this.primerPreguntaProtocolo = mock(Pregunta.class);
		this.segundaPreguntaProtocolo = mock(Pregunta.class);
		this.protocolo = mock(Workflow.class);
		this.encuesta = new Encuesta(protocolo,40);
		this.encuestaNoRespondible = new Encuesta(protocolo,0);
		
		//exercise
		this.encuesta.agregarPregunta(primerPreguntaProtocolo);
	}

	@Test
	void testUnaEncuestaNaceConUnaCantidadDeRespuestasComoProposito() {
		assertEquals(40,this.encuesta.getCantidadDeRespuestasLimite());
		assertEquals(0,this.encuestaNoRespondible.getCantidadDeRespuestasLimite());
	}
	
	@Test
	void testUnaEncuestaConUnTotalDeRespuestasEsperadasCumplidoNoSePuedeResponder() {
		assertTrue(this.encuestaNoRespondible.finalizada());
		assertFalse(this.encuesta.finalizada());
	}
	
	@Test
	void testUnaEncuestaPuedeAgregarUnaPreguntaASuProtocolo() {
		verify(protocolo,times(1)).agregarPregunta(primerPreguntaProtocolo);
	}
	
	@Test
	void testUnaEncuestaMuestraUnaSolaPreguntaQuePuedeMostrar() {
		when(protocolo.getPregunta()).thenReturn(primerPreguntaProtocolo);
		assertEquals(primerPreguntaProtocolo,this.encuesta.getPreguntaActual());
	}
	
	@Test
	void testUnaEncuestaConUnaPreguntaSiguientePuedeIrASuSiguientePregunta() {
		this.encuesta.agregarPregunta(segundaPreguntaProtocolo);
		this.encuesta.siguiente();
		verify(protocolo,times(1)).siguiente();
	}
	
	@Test
	void testUnaEncuestaConUnaPreguntaAnteriorPuedeIrASuPreguntaAnterior() {
		this.encuesta.agregarPregunta(segundaPreguntaProtocolo);
		this.encuesta.siguiente();
		verify(protocolo,times(1)).siguiente();
		this.encuesta.anterior();
		verify(protocolo,times(1)).anterior();
	}
	
	@Test
	void testUnaPreguntaDeLaEncuestaSeRespondeConUnaRespuesta() {
		agregarUnaPreguntaYResponderla();
		verify(primerPreguntaProtocolo,times(1)).responder(respuestaAPrimerPregunta);
	}

	private void agregarUnaPreguntaYResponderla() {
		when(protocolo.getPregunta()).thenReturn(primerPreguntaProtocolo);
		this.encuesta.responderPreguntaActual(respuestaAPrimerPregunta);
	}
	
	@Test
	void testUnaEncuestaGuardaLaRespuestaASusPreguntas() {
		agregarPreguntasYResponderlas();
		
		assertEquals(2,this.encuesta.cantidadDeRespuestasRealizadas());
	}

	private void agregarPreguntasYResponderlas() {
		when(protocolo.getPregunta()).thenReturn(primerPreguntaProtocolo);
		this.encuesta.agregarPregunta(segundaPreguntaProtocolo);
		this.encuesta.responderPreguntaActual(respuestaAPrimerPregunta);
		when(protocolo.getPregunta()).thenReturn(segundaPreguntaProtocolo);
		this.encuesta.siguiente();
		this.encuesta.responderPreguntaActual(respuestaASegundaPregunta);
	}
}