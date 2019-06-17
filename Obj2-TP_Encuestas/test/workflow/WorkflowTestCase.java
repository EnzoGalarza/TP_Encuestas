package workflow;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import archivo.ArchivoDeRespuestas;
import pregunta.Pregunta;
import respuesta.Respuesta;
import workflow.Workflow;

class WorkflowTestCase {

	private Workflow workflow;
	private Pregunta preguntaInicial,segundaPregunta,tercerPregunta ,ultimaPregunta;
	private ArchivoDeRespuestas archivo;
	private Respuesta respuesta,respuesta2;
	
	@BeforeEach
	public void setUp() {
		this.archivo = mock(ArchivoDeRespuestas.class);
		this.preguntaInicial = mock(Pregunta.class);
		this.segundaPregunta = mock(Pregunta.class);
		this.tercerPregunta = mock(Pregunta.class);
		this.ultimaPregunta = mock(Pregunta.class);
		this.respuesta = mock(Respuesta.class);
		this.respuesta2 = mock(Respuesta.class);
		this.workflow = new Workflow(archivo,preguntaInicial);
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
		assertEquals(tercerPregunta,workflow.getPregunta());
	}
	
	@Test
	void testUnWorkflowQueNoContinuaNoTieneUnaPreguntaSiguiente() {
		when(preguntaInicial.getSiguientePregunta(respuesta)).thenReturn(segundaPregunta);
		when(segundaPregunta.getSiguientePregunta(respuesta2)).thenReturn(tercerPregunta);
		this.workflow.siguiente(respuesta);
		this.workflow.siguiente(respuesta2);
		assertEquals(tercerPregunta,workflow.getPregunta());
	}
	
}