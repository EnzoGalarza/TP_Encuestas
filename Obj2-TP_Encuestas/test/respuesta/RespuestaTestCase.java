package respuesta;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pregunta.*;
import workflow.Workflow;

import static org.mockito.Mockito.*;

class RespuestaTestCase {

	private Respuesta respuestaLibre, respuestaCerrada;
	private PreguntaAbierta preguntaAResponderLibre;
	private PreguntaDeSeleccion preguntaAResponderCerrada;
	private Workflow workflow;
	
	@BeforeEach
	public void setUp() {
		workflow = mock(Workflow.class);
		preguntaAResponderLibre = mock(PreguntaAbierta.class);
		preguntaAResponderCerrada = mock(PreguntaDeSeleccion.class);
		respuestaCerrada = new RespuestaCerrada("Mas de 30");
		respuestaLibre = new RespuestaLibre(preguntaAResponderLibre);
	}
	
	@Test
	void testUnaRespuestaTieneUnTexto() {
		assertEquals("", respuestaLibre.getTextoRespuesta());
		assertEquals("Mas de 30",respuestaCerrada.getTextoRespuesta());
	}

}