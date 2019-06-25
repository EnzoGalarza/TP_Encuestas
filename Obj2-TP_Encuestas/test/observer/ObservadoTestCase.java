package observer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import workflow.Workflow;
import static org.mockito.Mockito.*;

class ObservadoTestCase {

	private Observado observado;
	private Workflow workflow;
	private Observador observador1;
	
	@BeforeEach
	public void setUp() {
		this.workflow = mock(Workflow.class);
		this.observado = new Encuesta(workflow,10);
	}
	
	@Test
	void testAgregarObservador() {
		this.observado.register(observador1);
		assertTrue(observado.esObservador(observador1));
	}
	
	@Test
	void testEliminarObservador() {
		this.observado.register(observador1);
		this.observado.unregister(observador1);
		assertFalse(observado.esObservador(observador1));
	}

}
