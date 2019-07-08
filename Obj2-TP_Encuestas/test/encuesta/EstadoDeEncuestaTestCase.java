package encuesta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class EstadoDeEncuestaTestCase {

	private EstadoDeEncuesta estadoDisponible, estadoEnEdicion,estadoCerrado;
	private Encuesta encuesta1,encuesta2,encuesta3;
	
	@BeforeEach
	public void setUp() {
		encuesta1 = mock(Encuesta.class);
		encuesta2 = mock(Encuesta.class);
		encuesta3 = mock(Encuesta.class);
		estadoDisponible = new EstadoDeEncuestaDisponible(encuesta1);
		estadoEnEdicion = new EstadoDeEncuestaEnEdicion(encuesta2);
		estadoCerrado = new EstadoDeEncuestaCerrada(encuesta3);
	}
	
	@Test
	void testSiElEstadoNoEsCerradoLaEncuestaNoEstaFinalizada() {
		assertFalse(estadoDisponible.finalizada());
		assertFalse(estadoEnEdicion.finalizada());
		assertTrue(estadoCerrado.finalizada());
	}
	
	@Test
	void testSiElEstadoNoEsDiponibleLaEncuestaNoEstaDisponible() {
		assertFalse(estadoCerrado.esDisponible());
		assertFalse(estadoEnEdicion.finalizada());
		assertTrue(estadoDisponible.esDisponible());
	}
	
}
