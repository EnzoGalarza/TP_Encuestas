package pregunta;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import respuesta.Respuesta;

import static org.mockito.Mockito.*;

class PreguntaAbiertaTestCase {

	private PreguntaAbierta pregunta; 
	private Pregunta preguntaSiguiente;
	private Respuesta respuesta;
	
	@BeforeEach
	public void setUp() {
		this.pregunta = new PreguntaAbierta("Es de color verde");
		this.preguntaSiguiente = mock(Pregunta.class);
		this.respuesta = mock(Respuesta.class);
	}
	
	@Test
	void testUnaPreguntaAbiertaTieneUnTextoDePregunta() {
		assertEquals("Es de color verde?",this.pregunta.getTextoPregunta());
	}
	
	@Test
	void testUnaPreguntaAbiertaPuedeSetearSuSiguientePregunta() {
		this.pregunta.setSiguientePregunta(preguntaSiguiente);
		assertEquals(preguntaSiguiente,pregunta.getSiguientePregunta(respuesta));
	}
	
	@Test
	void testUnaPreguntaAbiertaNoEsUnaPreguntaNula() {
	    assertFalse(this.pregunta.esUltimaPregunta());
	}
	
}
