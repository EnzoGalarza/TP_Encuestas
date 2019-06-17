package apiladorDePreguntas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import pregunta.Pregunta;

class ApiladorDePreguntaTestCase {

	private ApiladorDePregunta apilador;
	private Pregunta pregunta1,pregunta2,pregunta3;
	
	@BeforeEach
	public void setUp() {
		this.apilador = new ApiladorDePregunta();
		this.pregunta1 = mock(Pregunta.class);
		this.pregunta2 = mock(Pregunta.class);
		this.pregunta3 = mock(Pregunta.class);
	}
	
	@Test
	void testAgregarPreguntaAApiladorYCantidadDePreguntas() {
		this.apilador.apilarPregunta(pregunta1);
		this.apilador.apilarPregunta(pregunta2);
		this.apilador.apilarPregunta(pregunta3);
		assertEquals(3,apilador.getCantidadDePreguntas());
	}
	
	@Test
	void testObtenerPreguntaDeApilador() {
		this.apilador.apilarPregunta(pregunta1);
		this.apilador.apilarPregunta(pregunta2);
		assertEquals(pregunta2,this.apilador.obtenerPregunta());
		assertEquals(1,apilador.getCantidadDePreguntas());
	}
	
	@Test
	void testApiladorRemoverPregunta() {
		this.apilador.apilarPregunta(pregunta1);
		this.apilador.apilarPregunta(pregunta2);
		this.apilador.apilarPregunta(pregunta3);
		assertEquals(3,this.apilador.getCantidadDePreguntas());
		this.apilador.removerPregunta(pregunta2);
		assertEquals(2,this.apilador.getCantidadDePreguntas());
	}
}
