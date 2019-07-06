package pregunta;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import observer.Observador;
import respuesta.Respuesta;
import static org.mockito.Mockito.*;

class PreguntaTestCase {

	private Pregunta preguntaAbierta;
	private Pregunta preguntaSeleccionSimple;
	private List<Respuesta> posiblesRespuestas;
	private Respuesta respuesta;
	private Encuesta encuesta;
	private Observador observador1;
	private Observador observador2;
	
	
	@BeforeEach
	public void setUp() {
		preguntaSeleccionSimple = new PreguntaDeSeleccionSimple("De que color te gustaria",posiblesRespuestas);
		preguntaAbierta = new PreguntaAbierta("De que color es");
		this.observador1 = mock(Observador.class);
		this.observador2 = mock(Observador.class);
		
	}
	
	@Test
	void testUnaPreguntaTieneUnTexto() {
		assertEquals("De que color es?",preguntaAbierta.getTextoPregunta());
		assertEquals("De que color te gustaria?",preguntaSeleccionSimple.getTextoPregunta());
	}
	
	@Test
	void testNotificar() {
		this.preguntaAbierta.register(observador1);
		this.preguntaAbierta.register(observador2);
		this.preguntaAbierta.notificar(encuesta, respuesta);
		verify(observador1,times(1)).update(encuesta, preguntaAbierta, respuesta);
		verify(observador1,times(1)).update(encuesta, preguntaAbierta, respuesta);
	}
}
