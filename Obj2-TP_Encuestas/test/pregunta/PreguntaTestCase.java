package pregunta;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import respuesta.Respuesta;

class PreguntaTestCase {

	private Pregunta preguntaAbierta;
	private Pregunta preguntaSeleccionSimple;
	private List<Respuesta> posiblesRespuestas;
	
	@BeforeEach
	public void setUp() {
		preguntaSeleccionSimple = new PreguntaDeSeleccionSimple("De que color te gustaria",posiblesRespuestas);
		preguntaAbierta = new PreguntaAbierta("De que color es");
	}
	
	@Test
	void testUnaPreguntaTieneUnTexto() {
		assertEquals("De que color es?",preguntaAbierta.getTextoPregunta());
		assertEquals("De que color te gustaria?",preguntaSeleccionSimple.getTextoPregunta());
	}
}
