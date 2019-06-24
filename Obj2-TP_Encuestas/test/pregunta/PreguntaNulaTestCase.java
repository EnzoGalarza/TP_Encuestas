package pregunta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import respuesta.Respuesta;

class PreguntaNulaTestCase {

	private PreguntaNula pregunta;
	private Respuesta respuesta;
	
	@Test
	void test() {
		pregunta = new PreguntaNula();
		assertEquals("Pregunta nula",this.pregunta.getTextoPregunta());
		assertEquals(this.pregunta,this.pregunta.getSiguientePregunta(respuesta));
		assertTrue(this.pregunta.esUltimaPregunta());
	}

}
