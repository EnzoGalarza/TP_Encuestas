package pregunta;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import respuesta.Respuesta;
import respuesta.RespuestaCerrada;

import static org.mockito.Mockito.*;

class PreguntaDeSeleccionMultipleTestCase {

	private PreguntaDeSeleccionMultiple preguntaSeleccionMultiple;
	private Pregunta siguientePregunta;
    private RespuestaCerrada respuestaPosible1 ,respuestaPosible2;
    private Set<Respuesta> posiblesRespuestas;
	
	@BeforeEach
	public void setUp() {
		this.posiblesRespuestas = new HashSet<Respuesta>();
		this.siguientePregunta = mock(Pregunta.class);
		respuestaPosible1 = mock(RespuestaCerrada.class);
		respuestaPosible2 = mock(RespuestaCerrada.class);
		posiblesRespuestas.add(respuestaPosible1);
		posiblesRespuestas.add(respuestaPosible2);
		this.preguntaSeleccionMultiple = new PreguntaDeSeleccionMultiple("Cuanto gana por mes",posiblesRespuestas);
	}
	
	@Test
	void testUnaPreguntaDeSeleccionMultipleTieneUnTextoYUnasPosiblesRespuestas(){
		assertEquals(posiblesRespuestas,preguntaSeleccionMultiple.getPosiblesRespuestas());
		assertEquals("Cuanto gana por mes?",this.preguntaSeleccionMultiple.getTextoPregunta());
	}
	
	@Test
	void testUnaPreguntaDeSeleccionMultiplePuedeSetearSuSiguientePregunta() {
		this.preguntaSeleccionMultiple.setSiguientePregunta(siguientePregunta);
		assertEquals(siguientePregunta,this.preguntaSeleccionMultiple.getSiguientePregunta(respuestaPosible1));
	}
	
	@Test
	void testUnaPreguntaDeSeleccionMultipleNoEsUnaPreguntaNula() {
		assertFalse(this.preguntaSeleccionMultiple.esUltimaPregunta());
	}

}
