package pregunta;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import respuesta.RespuestaLibre;

import static org.mockito.Mockito.*;

class PreguntaAbiertaTestCase {

	private PreguntaAbierta pregunta; 
	
	@BeforeEach
	public void setUp() {
		this.pregunta = new PreguntaAbierta("Es de color verde");
	}
	
	@Test
	void testUnaPreguntaAbiertaTieneUnTextoDePregunta() {
		assertEquals("Es de color verde?",this.pregunta.getTextoPregunta());
	}
	
}
