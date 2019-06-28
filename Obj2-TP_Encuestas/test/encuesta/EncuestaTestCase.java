package encuesta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import observer.Observador;
import pregunta.Pregunta;
import respuesta.Respuesta;
import workflow.Workflow;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;

class EncuestaTestCase {

	private Encuesta encuesta;
	private Workflow protocolo;
	private Encuesta encuestaNoRespondible;
	private Pregunta primerPreguntaProtocolo;
	private Pregunta segundaPreguntaProtocolo;
	private Respuesta respuesta1, respuesta2;
	private Observador observador1, observador2;
	
	@BeforeEach
	public void setUp() {
		observador1 = mock(Observador.class);
		observador2 = mock(Observador.class);
		respuesta1 = mock(Respuesta.class);
		respuesta2 = mock(Respuesta.class);
		this.primerPreguntaProtocolo = mock(Pregunta.class);
		this.segundaPreguntaProtocolo = mock(Pregunta.class);
		this.protocolo = mock(Workflow.class);
		this.encuesta = new Encuesta(protocolo,40, LocalDate.of(2019, Month.JUNE, 1));
		this.encuestaNoRespondible = new Encuesta(protocolo,0, LocalDate.of(2019, Month.JUNE, 1));
		this.encuestaNoRespondible.cerrarEncuesta();
		this.encuesta.register(observador1);
		this.encuesta.register(observador2);
	}

	@Test
	void testUnaEncuestaNaceConUnaCantidadDeRespuestasComoProposito() {
		assertEquals(40,this.encuesta.getCantidadDeRespuestasLimite());
		assertEquals(0,this.encuestaNoRespondible.getCantidadDeRespuestasLimite());
	}
	
	@Test
	void testUnaEncuestaTieneUnaSolaPreguntaQuePuedeMostrar() {
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
	
	@Test
	void testNotifyObservadores() {
		this.encuesta.notify(primerPreguntaProtocolo, respuesta1);
		verify(observador1).update(encuesta, primerPreguntaProtocolo, respuesta1);
		verify(observador2).update(encuesta, primerPreguntaProtocolo, respuesta1);
	}
	
	@Test
	void testUnaEncuestaNoDisponibleSePuedeModificar() {
		assertFalse(this.encuesta.disponible());
		this.encuesta.setPregunta(segundaPreguntaProtocolo);
		verify(protocolo,times(1)).setPregunta(segundaPreguntaProtocolo);
	}
	
	@Test
	void testUnaEncuestaDisponibleNoSePuedeModificar() {
		this.encuesta.finalizarEdicion();
		this.encuesta.setPregunta(primerPreguntaProtocolo);
		assertTrue(this.encuesta.disponible());
		verifyZeroInteractions(protocolo);
	}
	
	@Test
	void testUnaEncuestaDisponibleSePuedeResponder() {
		when(protocolo.getPregunta()).thenReturn(primerPreguntaProtocolo);
		this.encuesta.finalizarEdicion();
		assertTrue(this.encuesta.disponible());
		this.encuesta.responder(respuesta2);
		verify(protocolo,times(1)).siguiente(respuesta2);
		verify(observador1).update(encuesta, primerPreguntaProtocolo, respuesta2);
		verify(observador2).update(encuesta, primerPreguntaProtocolo, respuesta2);
	}
	
	@Test
	void testUnaEncuestaCerradaNoSePuedeResponderNiModificar() {
	     this.encuesta.cerrarEncuesta();
	     assertTrue(this.encuesta.finalizada());
	     this.encuesta.responder(respuesta1);
	     this.encuesta.setPregunta(segundaPreguntaProtocolo);
	     verifyZeroInteractions(protocolo);
	}
	
	@Test
	void seCreaConUnaFecha() {
	     assertEquals(encuesta.fechaDeCreacion(),LocalDate.of(2019, Month.JUNE, 1));
	}
	void testGuardarCambiosEnUltimaPreguntaEncuesta() {
		when(protocolo.getPregunta()).thenReturn(primerPreguntaProtocolo);
		when(primerPreguntaProtocolo.esUltimaPregunta()).thenReturn(true);
		this.encuesta.guardarCambios();
		
		// verifico que se cambia La cantidadDeRespuestaLimiteAlCuestionario
		assertEquals(39,this.encuesta.getCantidadDeRespuestasLimite());
	}
	
	@Test
	void testUnaEncuestaNoPuedeGuardarLosCambiosSiNoEstaEnLaUltimaPreguntaOSiNoSePuedeResponder() {
		when(protocolo.getPregunta()).thenReturn(primerPreguntaProtocolo);
		when(primerPreguntaProtocolo.esUltimaPregunta()).thenReturn(false);
		
		this.encuesta.guardarCambios();
		// verifico que no se cambia La cantidadDeRespuestaLimiteAlCuestionario
		assertEquals(40,this.encuesta.getCantidadDeRespuestasLimite());
	}
	
}