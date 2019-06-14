package respuesta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pregunta.PreguntaAbierta;
import static org.mockito.Mockito.*;

class RespuestaLibreTestCase {
	
	private RespuestaLibre respuesta;
	
	@BeforeEach
	public void setUp() {
		this.respuesta = new RespuestaLibre("Hace 1 año");
	}
	
	@Test
	void testUnaRespuestaAbiertaTieneUnTextoDeRespuesta() {
		assertEquals("Hace 1 año",respuesta.getTextoRespuesta());
	}
	
}