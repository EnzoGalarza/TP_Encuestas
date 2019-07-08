package respuesta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	
	@Test
	void testSetTextoRespuesta() {
		this.respuesta.setTextoRespuesta("Hace 2 años");
		assertEquals("Hace 2 años",this.respuesta.getTextoRespuesta());
	}
	
}