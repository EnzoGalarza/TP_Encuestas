package workflow;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pregunta.Pregunta;
import workflow.Workflow;

class WorkflowTestCase {

	private Workflow workflow;
	private Pregunta preguntaInicial;
	private Pregunta segundaPregunta;
	private Pregunta tercerPregunta;
	private Pregunta ultimaPregunta;
	
	@BeforeEach
	public void setUp() {
		this.preguntaInicial = mock(Pregunta.class);
		this.segundaPregunta = mock(Pregunta.class);
		this.tercerPregunta = mock(Pregunta.class);
		this.ultimaPregunta = mock(Pregunta.class);
		this.workflow = new Workflow();
		this.workflow.agregarPregunta(preguntaInicial);
	}
	
	@Test
	void testAgregarPregunta() {
		assertEquals(preguntaInicial,this.workflow.getPregunta());
	}
	
	
	@Test
	void testUnWorkflowParadoEnLaPrimeraPosicionConMasDeUnaPreguntaTieneUnaPreguntaSiguiente() {
		this.workflow.agregarPregunta(segundaPregunta);
		workflow.siguiente();
		assertEquals(segundaPregunta,workflow.getPregunta());
		assertEquals(1,this.workflow.posicionPreguntaActual());
	}
	
	@Test
	void testUnWorkflowEnLaSegundaPosicionOPosteriorTieneUnaPreguntaAnterior() {
		agregarPreguntasAlProtocolo();
		
		this.workflow.siguiente();
		this.workflow.siguiente();
		this.workflow.siguiente();
		
		this.workflow.anterior();
		assertEquals(tercerPregunta,workflow.getPregunta());
		assertEquals(2,workflow.posicionPreguntaActual());
	}
	
	@Test
	void testUnWorkflowQueNoContinuaNoTieneUnaPreguntaSiguiente() {
		this.workflow.agregarPregunta(segundaPregunta);
		this.workflow.siguiente();
		this.workflow.siguiente();
		this.workflow.siguiente();
		assertEquals(segundaPregunta,workflow.getPregunta());
		assertFalse(workflow.continua());
	}
	
	@Test
	void test_unWorkflowPuedeDireccionarseAUnaProximaPregunta() {
		agregarPreguntasAlProtocolo();
		
	}

	private void agregarPreguntasAlProtocolo() {
		this.workflow.agregarPregunta(segundaPregunta);
		this.workflow.agregarPregunta(tercerPregunta);
		this.workflow.agregarPregunta(ultimaPregunta);
	}
	

}