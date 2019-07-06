package respuesta;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import observer.Observador;
import pregunta.*;

import static org.mockito.Mockito.*;

class RespuestaTestCase {

	private Respuesta respuestaLibre, respuestaCerrada;
	private Pregunta pregunta;
	private Observador observador1, observador2;
	private Encuesta encuesta;
	
	@BeforeEach
	public void setUp() {
		respuestaCerrada = new RespuestaCerrada("Mas de 30");
		respuestaLibre = new RespuestaLibre("Si");
		observador1 = mock(Observador.class);
		observador2 = mock(Observador.class);
	}
	
	@Test
	void testUnaRespuestaTieneUnTexto() {
		assertEquals("Si", respuestaLibre.getTextoRespuesta());
		assertEquals("Mas de 30",respuestaCerrada.getTextoRespuesta());
	}
	
	@Test
	void testLaSiguientePreguntaDeUnaRespuestaLibreEsNula() {
		Pregunta pregunta = new PreguntaNula();
		assertTrue(pregunta.getClass().equals(this.respuestaLibre.getSiguientePregunta().getClass()));
	}
	
	@Test
	void testNotificar() {
		this.respuestaLibre.register(observador1);
		this.respuestaLibre.register(observador2);
		this.respuestaLibre.notificar(encuesta, pregunta);
		verify(observador1,times(1)).update(encuesta, pregunta, respuestaLibre);
		verify(observador1,times(1)).update(encuesta, pregunta, respuestaLibre);
	}

}