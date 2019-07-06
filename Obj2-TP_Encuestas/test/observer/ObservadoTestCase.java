package observer;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import pregunta.Pregunta;
import pregunta.PreguntaAbierta;
import respuesta.Respuesta;

import static org.mockito.Mockito.*;

class ObservadoTestCase {

	private Observado observado;
	private Observador observador1,observador2;
	private Encuesta encuesta;
	private Respuesta respuesta;
	private Pregunta pregunta;
	
	@BeforeEach
	public void setUp() {
		this.observado = new PreguntaAbierta("Que dia");
		this.observador1 = mock(Observador.class);
		this.observador2 = mock(Observador.class);
		this.pregunta = mock(Pregunta.class);
		this.respuesta = mock(Respuesta.class);
	}
	
	@Test
	void testAgregarObservador() {
		this.observado.register(observador1);
		assertTrue(observado.esObservador(observador1));
	}
	
	@Test
	void testEliminarObservador() {
		this.observado.register(observador1);
		this.observado.unregister(observador1);
		assertFalse(observado.esObservador(observador1));
	}
	
	@Test
	void testNotify() {
		this.observado.register(observador1);
		this.observado.register(observador2);
		this.observado.notify(encuesta, pregunta, respuesta);
		verify(observador1,times(1)).update(encuesta, pregunta, respuesta);
	}

}
