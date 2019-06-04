package respuesta;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pregunta.PreguntaDeSeleccion;
import static org.mockito.Mockito.*;

class RespuestaCerradaTestCase {

	private PreguntaDeSeleccion preguntaAResponderMultiple;
    private PreguntaDeSeleccion preguntaAResponderSimple;
    private RespuestaCerrada respuestaAMultiple;
    private RespuestaCerrada respuestaASimple;
	
	@BeforeEach
	public void setUp() {
		this.preguntaAResponderMultiple = mock(PreguntaDeSeleccion.class);
		this.preguntaAResponderSimple = mock(PreguntaDeSeleccion.class);
		this.respuestaAMultiple = new RespuestaCerrada("25",preguntaAResponderMultiple);
		this.respuestaASimple = new RespuestaCerrada("35",preguntaAResponderSimple);
	}
	
	@Test
	void testUnaRespuestaCerradaNoEsUnaRespuestaLibre() {
		assertFalse(respuestaAMultiple.esRespuestaLibre());
		assertFalse(respuestaASimple.esRespuestaLibre());
	}
	
	@Test
	void testUnaRespuestaCerradaTieneUnaPreguntaMultipleOpcionALaCualResponder() {
		assertEquals(respuestaAMultiple.getPreguntaRespondida(),this.preguntaAResponderMultiple);
		assertEquals(respuestaASimple.getPreguntaRespondida(),this.preguntaAResponderSimple);
	}
	
	@Test
	void testUnaRespuestaCerradaSeRespondeConUnTextoDeRespuestaSiEsPosibleResponder() {
		when(preguntaAResponderMultiple.comprobarSiEsRespuestaPosible(respuestaAMultiple)).thenReturn(true);
		respuestaAMultiple.responder("26");
		
		assertEquals("26",respuestaAMultiple.getTextoRespuesta());
	}
	
	@Test
	void testUnaRespuestaCerradaNoSeRespondeSiNoEsPosibleLaRespuesta() {
		when(preguntaAResponderSimple.comprobarSiEsRespuestaPosible(respuestaASimple)).thenReturn(false);
		respuestaASimple.responder("Es Nueva");
		
		assertEquals("35",respuestaASimple.getTextoRespuesta());
	}
	
}