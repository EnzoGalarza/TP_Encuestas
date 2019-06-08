package pregunta;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import respuesta.Respuesta;
import respuesta.RespuestaCerrada;
import static org.mockito.Mockito.*;

class PreguntaDeSeleccionSimpleTestCase {

	private PreguntaDeSeleccionSimple pregunta;
	private RespuestaCerrada respuestaPosible1,respuestaPosible2,respuestaNoPosible;
	private Collection<Respuesta> posiblesRespuestas;
	
	@BeforeEach
	public void setUp() {
		this.respuestaPosible1 = mock(RespuestaCerrada.class);
		this.respuestaPosible2 = mock(RespuestaCerrada.class);
		this.respuestaNoPosible = mock(RespuestaCerrada.class);
		this.posiblesRespuestas = new HashSet<Respuesta>();
		this.posiblesRespuestas.add(respuestaPosible1);
		this.posiblesRespuestas.add(respuestaPosible2);
		this.pregunta = new PreguntaDeSeleccionSimple("Cuántos años tiene",posiblesRespuestas);
	}
	
	@Test
	void testUnaPreguntaDeSeleccionSimpleTieneUnasPosiblesRespuestas() {
	    assertEquals(posiblesRespuestas,pregunta.getPosiblesRespuestas());
	}

}
