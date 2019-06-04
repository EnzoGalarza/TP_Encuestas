package workflow;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pregunta.Pregunta;
import pregunta.PreguntaAbierta;
import pregunta.PreguntaDeSeleccionMultiple;
import respuesta.Respuesta;
import respuesta.RespuestaCerrada;

class WorkflowConArbolTestCase {

	/*private Pregunta pregunta, otraPregunta;
	private WorkflowConArbol workflow;
	private RespuestaCerrada respuesta;
	
	@BeforeEach
	public void setUp() {
		pregunta = new PreguntaAbierta("De qué color es");
		otraPregunta = new PreguntaAbierta("Toma mate");
		respuesta = new RespuestaCerrada("Sí", preguntaDeSeleccionMultiple("Tiene heladera"));
	}
	// Protocolo de factory
	private PreguntaDeSeleccionMultiple preguntaDeSeleccionMultiple(String textoDePregunta) {
		return new PreguntaDeSeleccionMultiple(textoDePregunta,respuestasAPreguntaDeSeleccion());
	}
	private HashSet<Respuesta> respuestasAPreguntaDeSeleccion() {
		HashSet<Respuesta> posiblesRespuestas;
		posiblesRespuestas = new HashSet<Respuesta>();
		RespuestaCerrada respuestaPosible1 = mock(RespuestaCerrada.class);
		RespuestaCerrada respuestaPosible2 = mock(RespuestaCerrada.class);
		posiblesRespuestas.add(respuestaPosible1);
		posiblesRespuestas.add(respuestaPosible2);
		posiblesRespuestas.add(respuesta);
		return posiblesRespuestas;
	}
	private WorkflowConArbol workflowConPreguntas() {
		workflow = nuevoWorkflow();
		workflow.agregar(pregunta);
		workflow.agregar(otraPregunta);
		return workflow;
	}
	private WorkflowConArbol nuevoWorkflow() {
		WorkflowConArbol workflow = new WorkflowConArbol();
		return workflow;
	}

	@Test
	void test_InicialmenteNoTieneSiguientePregunta() {
		WorkflowConArbol workflow = nuevoWorkflow();
		assertFalse(workflow.tieneSiguiente());
	}
	@Test
	void test_TieneSiguientePreguntaAlAgregarUnaPregunta() {
		WorkflowConArbol workflow = nuevoWorkflow();
		workflow.agregar(pregunta);
		
		assertTrue(workflow.tieneSiguiente());
	}
	@Test
	void test_PuedeAgregarMasDeUnaPregunta() {
		workflow = workflowConPreguntas();
		
		assertEquals(otraPregunta, workflow.ultima());
	}
	@Test
	void puedeBuscarUnaPreguntaQueExistaEnSuSecuencia() {
		workflowConPreguntas();
		assertEquals(pregunta, workflow.obtener(pregunta));
	}
	@Test
	void puedeSeguirEnUnaPreguntaDistintaSegunUnaRepsuesta() {
		workflowConPreguntas();
		workflow.agregar(preguntaDeSeleccionMultiple("Tiene heladera"));
		workflow.agregarOtroCaminoPara(
				preguntaDeSeleccionMultiple("Qué días trbaja"), 
				respuesta, preguntaDeSeleccionMultiple("Tiene heladera"));
		
		fail("whatever");
	}*/


	
	
	

}