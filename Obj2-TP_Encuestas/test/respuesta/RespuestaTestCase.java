package respuesta;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pregunta.*;

import static org.mockito.Mockito.*;

class RespuestaTestCase {

	private Respuesta respuestaLibre, respuestaCerrada;
	private PreguntaAbierta preguntaAResponderLibre;
	private PreguntaDeSeleccion preguntaAResponderCerrada;
	
	@BeforeEach
	public void setUp() {
		preguntaAResponderLibre = mock(PreguntaAbierta.class);
		preguntaAResponderCerrada = mock(PreguntaDeSeleccion.class);
		respuestaCerrada = new RespuestaCerrada("Mas de 30",preguntaAResponderCerrada);
		respuestaLibre = new RespuestaLibre(preguntaAResponderLibre);
	}
	
	@Test
	void testUnaRespuestaTieneUnTexto() {
		assertEquals("", respuestaLibre.getTextoRespuesta());
		assertEquals("Mas de 30",respuestaCerrada.getTextoRespuesta());
	}

}