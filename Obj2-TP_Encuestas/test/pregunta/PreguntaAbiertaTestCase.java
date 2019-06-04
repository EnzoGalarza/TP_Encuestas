package pregunta;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import respuesta.RespuestaLibre;

import static org.mockito.Mockito.*;

class PreguntaAbiertaTestCase {

	private PreguntaAbierta pregunta; 
	private Pregunta siguientePregunta2;
	private PreguntaAbierta siguientePregunta;
	private RespuestaLibre respuesta;
	
	@BeforeEach
	public void setUp() {
		
		this.siguientePregunta2 = mock(Pregunta.class);
		this.siguientePregunta = new PreguntaAbierta("Hace cuantos años la tenes",siguientePregunta2);
		this.pregunta = new PreguntaAbierta("De que color es",siguientePregunta);
		this.respuesta = mock(RespuestaLibre.class);
	}
	
	@Test
	void testUnaPreguntaAbiertaTieneUnaSiguientePregunta() {
		assertEquals(siguientePregunta,pregunta.getSiguientePregunta());
	}
	
	@Test
	void testUnaPreguntaAbiertaAlResponderseTieneUnaRespuestaLibre() {
		when(respuesta.getTextoRespuesta()).thenReturn("Verde");
		when(respuesta.esRespuestaLibre()).thenReturn(true);
		pregunta.responder(respuesta);
		assertEquals("Verde",pregunta.respuestaElegida().getTextoRespuesta());
	}

	@Test
	void testUnaSiguientePreguntaAbiertaTieneUnTextoYUnaSiguientePregunta() {
		assertEquals("Hace cuantos años la tenes?",pregunta.getSiguientePregunta().getTextoPregunta());
		assertEquals(siguientePregunta2,pregunta.getSiguientePregunta().getSiguientePregunta());
	}
	
	
}
