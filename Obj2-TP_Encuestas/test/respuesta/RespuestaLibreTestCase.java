package respuesta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pregunta.PreguntaAbierta;
import static org.mockito.Mockito.*;

class RespuestaLibreTestCase {
	
	private RespuestaLibre respuesta;
	private PreguntaAbierta preguntaAResponder;
	
	@BeforeEach
	public void setUp() {
		this.preguntaAResponder = mock(PreguntaAbierta.class);
		this.respuesta = new RespuestaLibre(preguntaAResponder);
	}
	
}