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
	private Respuesta respuesta1, respuesta2;
	
	@BeforeEach
	public void setUp() {
		respuesta1 = mock(Respuesta.class);
		respuesta2 = mock(Respuesta.class);
		this.primerPreguntaProtocolo = mock(Pregunta.class);
		this.segundaPreguntaProtocolo = mock(Pregunta.class);
		this.protocolo = mock(Workflow.class);
		this.encuesta = new Encuesta(protocolo,40);
		this.encuestaNoRespondible = new Encuesta(protocolo,0);
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
	void testUnaEncuestaMuestraUnaSolaPreguntaQuePuedeMostrar() {
		when(protocolo.getPregunta()).thenReturn(primerPreguntaProtocolo);
		assertEquals(primerPreguntaProtocolo,this.encuesta.getPreguntaActual());
	}
	
	@Test
	void testUnaEncuestaConUnaPreguntaSiguientePuedeIrASuSiguientePregunta() {
		when(protocolo.getPregunta()).thenReturn(segundaPreguntaProtocolo);
		this.encuesta.siguiente(respuesta1);
		verify(protocolo,times(1)).siguiente(respuesta1);
		assertEquals(segundaPreguntaProtocolo,encuesta.getPreguntaActual());
	}
	
	@Test
	void testUnaEncuestaConUnaPreguntaAnteriorPuedeIrASuPreguntaAnterior() {
		this.encuesta.siguiente(respuesta1);
		verify(protocolo,times(1)).siguiente(respuesta1);
		this.encuesta.anterior();
		verify(protocolo,times(1)).anterior();
	}
	
}