package encapsulador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.EncapsuladorDeRespuesta;
import pregunta.Pregunta;
import respuesta.Respuesta;

import static org.mockito.Mockito.*;

class EncapsuladorDeRespuestaTestCase {

	private EncapsuladorDeRespuesta encapsulador;
	
	private Respuesta respuesta1;
	private Respuesta respuesta2;
	private Pregunta pregunta1;
	private Pregunta pregunta2;
	
	@BeforeEach
	public void setUp() {
		this.encapsulador = new EncapsuladorDeRespuesta();
		this.respuesta1 = mock(Respuesta.class);
		this.respuesta2 = mock(Respuesta.class);
	}
	
	@Test
	void testAgregarRespuestasRealizadas() {
		this.encapsulador.agregarRespuestaRealizada(pregunta1, respuesta1);
		this.encapsulador.agregarRespuestaRealizada(pregunta2, respuesta2);
		assertEquals(2,this.encapsulador.cantidadDeRespuestasSesionActual());
	}
	
	@Test
	void testNuevaSesionYCantidadDeFormulariosCompletos() {
		this.encapsulador.nuevaSesion();
		assertEquals(0,this.encapsulador.cantidadDeRespuestasSesionActual());
		assertEquals(1,this.encapsulador.cantidadDeFormulariosCompletos());
	}

}
