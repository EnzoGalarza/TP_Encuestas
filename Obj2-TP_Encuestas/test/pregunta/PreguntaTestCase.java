package pregunta;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import respuesta.Respuesta;

class PreguntaTestCase {

	private Pregunta pregunta;
	private Pregunta pregunta2;
	private List<Respuesta> posiblesRespuestas;
	
	@BeforeEach
	public void setUp() {
		pregunta2 = new PreguntaDeSeleccionSimple("De que color te gustaria",posiblesRespuestas);
		pregunta = new PreguntaAbierta("De que color es",pregunta2);
	}
	
	@Test
	void testUnaPreguntaTieneUnTexto() {
		assertEquals("De que color es?",pregunta.getTextoPregunta());
	}
}
