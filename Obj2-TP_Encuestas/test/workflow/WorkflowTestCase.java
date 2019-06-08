package workflow;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import archivo.ArchivoDeRespuestasRealizadas;
import pregunta.Pregunta;
import respuesta.Respuesta;
import workflow.Workflow;

class WorkflowTestCase {

	private Workflow workflow;
	private Pregunta preguntaInicial,segundaPregunta,tercerPregunta ,ultimaPregunta;
	private ArchivoDeRespuestasRealizadas archivo;
	private Respuesta respuesta,respuesta2;
	
	@BeforeEach
	public void setUp() {
		this.archivo = mock(ArchivoDeRespuestasRealizadas.class);
		this.preguntaInicial = mock(Pregunta.class);
		this.segundaPregunta = mock(Pregunta.class);
		this.tercerPregunta = mock(Pregunta.class);
		this.ultimaPregunta = mock(Pregunta.class);
		this.workflow = new Workflow(archivo);
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
	void testResponderPreguntaWorkflow() {
		agregarPreguntasAlProtocolo();
		this.workflow.responder(respuesta);
		verify(archivo,times(1)).registrarRespuesta(preguntaInicial,respuesta);
		assertTrue(workflow.continua());
		this.workflow.siguiente();
		this.workflow.responder(respuesta2);
		verify(archivo,times(1)).registrarRespuesta(segundaPregunta, respuesta);
	}

	private void agregarPreguntasAlProtocolo() {
		this.workflow.agregarPregunta(segundaPregunta);
		this.workflow.agregarPregunta(tercerPregunta);
		this.workflow.agregarPregunta(ultimaPregunta);
	}
	
}