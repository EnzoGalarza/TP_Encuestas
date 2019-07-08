package workflow;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pregunta.Pregunta;
import respuesta.Respuesta;
import workflow.Workflow;

class WorkflowTestCase {

	private Workflow workflow;
	private Pregunta preguntaInicial,segundaPregunta,tercerPregunta ,ultimaPregunta;
	private Respuesta respuesta,respuesta2, respuesta3;
	
	@BeforeEach
	public void setUp() {
		this.preguntaInicial = mock(Pregunta.class);
		this.segundaPregunta = mock(Pregunta.class);
		this.tercerPregunta = mock(Pregunta.class);
		this.ultimaPregunta = mock(Pregunta.class);
		this.respuesta = mock(Respuesta.class);
		this.respuesta2 = mock(Respuesta.class);
		this.respuesta3 = mock(Respuesta.class);
		this.workflow = new Workflow(preguntaInicial);
	}
	
	@Test
	void testPrimerPreguntaWorkflow() {
		assertEquals(preguntaInicial,this.workflow.getPregunta());
	}
	
	
	@Test
	void testUnWorkflowParadoEnLaPrimerPreguntaConMasDeUnaPreguntaTieneUnaSiguientePregunta() {
		when(preguntaInicial.getSiguientePregunta(respuesta)).thenReturn(segundaPregunta);
		workflow.siguiente(respuesta);
		assertEquals(segundaPregunta,workflow.getPregunta());
	}
	
	@Test
	void testUnWorkflowEnLaSegundaPreguntaTieneUnaPreguntaAnterior() {
		when(preguntaInicial.getSiguientePregunta(respuesta)).thenReturn(segundaPregunta);
		when(segundaPregunta.getSiguientePregunta(respuesta2)).thenReturn(tercerPregunta);
		this.workflow.siguiente(respuesta);
		this.workflow.siguiente(respuesta2);
		assertEquals(tercerPregunta,workflow.getPregunta());
		this.workflow.anterior();
		assertEquals(segundaPregunta,workflow.getPregunta());
	}
	
	@Test
	void testUnWorkflowQueNoContinuaNoTieneUnaPreguntaSiguiente() {
		when(preguntaInicial.getSiguientePregunta(respuesta)).thenReturn(segundaPregunta);
		when(segundaPregunta.getSiguientePregunta(respuesta2)).thenReturn(tercerPregunta);
		when(tercerPregunta.getSiguientePregunta(respuesta3)).thenReturn(ultimaPregunta);
		when(ultimaPregunta.esUltimaPregunta()).thenReturn(true);
		this.workflow.siguiente(respuesta);
		this.workflow.siguiente(respuesta2);
		this.workflow.siguiente(respuesta3);
		assertEquals(ultimaPregunta,workflow.getPregunta());
		assertFalse(workflow.continua());
		this.workflow.siguiente(respuesta3);
		assertEquals(ultimaPregunta,workflow.getPregunta());
	}
	
	@Test
	void testUnWorkflowSinAnteriorNoTienePreguntaAnterior() {
		assertEquals(preguntaInicial,this.workflow.getPregunta());
		this.workflow.anterior();
		assertEquals(preguntaInicial,this.workflow.getPregunta());
	}
	
	@Test
	void testUnWorkflowPuedeCambiarSuPregunta() {
		this.workflow.setPregunta(segundaPregunta);
		assertEquals(workflow.getPregunta(),segundaPregunta);
	}
	
	@Test
	void testVaciarApiladorWorkflow() {
		when(preguntaInicial.getSiguientePregunta(respuesta)).thenReturn(segundaPregunta);
		workflow.siguiente(respuesta);
		assertTrue(this.workflow.tieneAnterior());
		this.workflow.vaciarApilador();
		assertFalse(this.workflow.tieneAnterior());
	}
	
}