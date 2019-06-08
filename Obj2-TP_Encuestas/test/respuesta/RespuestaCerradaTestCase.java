package respuesta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pregunta.PreguntaAbierta;
import pregunta.PreguntaDeSeleccionMultiple;
import pregunta.PreguntaDeSeleccionSimple;
import workflow.Workflow;

import static org.mockito.Mockito.*;

class RespuestaCerradaTestCase {

	private PreguntaDeSeleccionMultiple preguntaAResponderMultiple;
    private PreguntaDeSeleccionSimple preguntaAResponderSimple;
    private PreguntaAbierta preguntaAbierta;
    private RespuestaCerrada respuestaAMultiple;
    private RespuestaCerrada respuestaASimple;
    private RespuestaCerrada respuesta;
	private Workflow workflow;
    
	@BeforeEach
	public void setUp() {
		this.workflow = mock(Workflow.class);
		this.preguntaAResponderMultiple = mock(PreguntaDeSeleccionMultiple.class);
		this.preguntaAResponderSimple = mock(PreguntaDeSeleccionSimple.class);
		this.preguntaAbierta = mock(PreguntaAbierta.class);
		this.respuestaAMultiple = new RespuestaCerrada("25",preguntaAResponderMultiple);
		this.respuestaASimple = new RespuestaCerrada("35",preguntaAResponderSimple);
		this.respuesta = new RespuestaCerrada("Estamos casados",preguntaAbierta);
	}
	
	@Test
	void testRespuestaCerradaConoceAUnaProximaPregunta() {
	    assertEquals(preguntaAResponderMultiple,respuestaAMultiple.getSiguientePregunta());
	    assertEquals(preguntaAResponderSimple,respuestaASimple.getSiguientePregunta());
	    assertEquals(preguntaAbierta,respuesta.getSiguientePregunta());
	}
	
}