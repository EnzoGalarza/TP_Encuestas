package pregunta;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import respuesta.Respuesta;
import respuesta.RespuestaCerrada;

import static org.mockito.Mockito.*;

class PreguntaDeSeleccionMultipleTestCase {

	private PreguntaDeSeleccionMultiple pregunta;
    private RespuestaCerrada respuestaPosible1 ,respuestaPosible2, respuestaNoPosible;
    private Pregunta siguientePregunta;
	
	@BeforeEach
	public void setUp() {
		Set<Respuesta> posiblesRespuestas = new HashSet<Respuesta>();
		siguientePregunta = mock(Pregunta.class);
		respuestaPosible1 = mock(RespuestaCerrada.class);
		respuestaPosible2 = mock(RespuestaCerrada.class);
		respuestaNoPosible = mock(RespuestaCerrada.class);
		posiblesRespuestas.add(respuestaPosible1);
		posiblesRespuestas.add(respuestaPosible2);
		this.pregunta = new PreguntaDeSeleccionMultiple("Cuanto gana por mes",posiblesRespuestas);
	}

}
