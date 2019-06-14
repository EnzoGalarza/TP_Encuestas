package respuesta;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pregunta.*;
import workflow.Workflow;

import static org.mockito.Mockito.*;

class RespuestaTestCase {

	private Respuesta respuestaLibre, respuestaCerrada;
	
	@BeforeEach
	public void setUp() {
		respuestaCerrada = new RespuestaCerrada("Mas de 30");
		respuestaLibre = new RespuestaLibre("Si");
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

}