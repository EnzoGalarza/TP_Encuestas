package respuesta;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pregunta.PreguntaDeSeleccion;
import workflow.Workflow;

import static org.mockito.Mockito.*;

class RespuestaCerradaTestCase {

	private PreguntaDeSeleccion preguntaAResponderMultiple;
    private PreguntaDeSeleccion preguntaAResponderSimple;
    private RespuestaCerrada respuestaAMultiple;
    private RespuestaCerrada respuestaASimple;
	private Workflow workflow;
    
	@BeforeEach
	public void setUp() {
		this.workflow = mock(Workflow.class);
		this.preguntaAResponderMultiple = mock(PreguntaDeSeleccion.class);
		this.preguntaAResponderSimple = mock(PreguntaDeSeleccion.class);
		this.respuestaAMultiple = new RespuestaCerrada("25",preguntaAResponderMultiple,workflow);
		this.respuestaASimple = new RespuestaCerrada("35",preguntaAResponderSimple,workflow);
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
	void testUnaRespuestaCerradaSeRespondeConUnTextoDeRespuestaSiEsPosibleResponderYCambiaLaSiguientePreguntaDeSuWorkflow() {
		when(preguntaAResponderMultiple.comprobarSiEsRespuestaPosible(respuestaAMultiple)).thenReturn(true);
		respuestaAMultiple.responder(respuestaAMultiple.getTextoRespuesta());
		
		assertEquals("25",respuestaAMultiple.getTextoRespuesta());
		verify(workflow,times(1)).siguiente();
	}
	
	@Test
	void testUnaRespuestaCerradaNoSeRespondeSiNoEsPosibleLaRespuestaYNoCambiaSuWorkflow() {
		when(preguntaAResponderSimple.comprobarSiEsRespuestaPosible(respuestaASimple)).thenReturn(false);
		respuestaASimple.responder("Es Nueva");
		assertEquals("35",respuestaASimple.getTextoRespuesta());
		verifyZeroInteractions(workflow);
	}
	
}