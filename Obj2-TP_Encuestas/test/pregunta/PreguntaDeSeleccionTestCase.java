package pregunta;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Collection;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import respuesta.Respuesta;
import respuesta.RespuestaCerrada;

import static org.mockito.Mockito.*;

class PreguntaDeSeleccionTestCase {

	private PreguntaDeSeleccion pregunta;
	private RespuestaCerrada respuestaPosible1;
	private RespuestaCerrada respuestaPosible2;
	private Collection<Respuesta> posiblesRespuestas;
	private Pregunta siguientePregunta;
	
	@BeforeEach
	void setUp() {
		posiblesRespuestas = new HashSet<Respuesta>();
		siguientePregunta = mock(Pregunta.class);
		respuestaPosible1 = mock(RespuestaCerrada.class);
		respuestaPosible2 = mock(RespuestaCerrada.class);
		posiblesRespuestas.add(respuestaPosible1);
		posiblesRespuestas.add(respuestaPosible2);
		this.pregunta = new PreguntaDeSeleccionMultiple("Cuantos hijos tiene",posiblesRespuestas,siguientePregunta);
	}
	
	@Test
	void testUnaPreguntaMultipleOpcionTieneMultiplesRespuestasPosibles() {
		assertEquals(posiblesRespuestas,pregunta.getPosiblesRespuestas());
	}

}
