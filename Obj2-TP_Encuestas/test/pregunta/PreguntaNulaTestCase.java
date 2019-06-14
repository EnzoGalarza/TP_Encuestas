package pregunta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PreguntaNulaTestCase {

	private PreguntaNula pregunta;
	
	@Test
	void test() {
		pregunta = new PreguntaNula();
		assertEquals("Pregunta nula",this.pregunta.getTextoPregunta());
	}

}
