package respuesta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pregunta.PreguntaAbierta;
import static org.mockito.Mockito.*;

class RespuestaLibreTestCase {
	private RespuestaLibre respuesta;
	private PreguntaAbierta preguntaAResponder;
	
	@BeforeEach
	public void setUp() {
		this.preguntaAResponder = mock(PreguntaAbierta.class);
		this.respuesta = new RespuestaLibre(preguntaAResponder);
	}
	
	@Test
	void testUnaRespuestaLibreEsUnaRespuestaLibre() {
		assertTrue(respuesta.esRespuestaLibre());
	}
	
	@Test
	void testUnaNuevaRespuestaLibreTieneUnTextoVacioComoRespuestaYUnaPreguntaAResponder() {
		assertEquals("",respuesta.getTextoRespuesta());
		assertEquals(preguntaAResponder,this.respuesta.getPreguntaRespondida());
	}

	@Test
	void testResponderUnaPreguntaAbiertaConTextoRespuesta() {
		this.respuesta.responder("15 años");
		assertEquals("15 años",respuesta.getTextoRespuesta());
	}
	
}