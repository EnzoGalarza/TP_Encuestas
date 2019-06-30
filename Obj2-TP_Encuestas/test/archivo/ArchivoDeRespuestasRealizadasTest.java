package archivo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pregunta.PreguntaDeSeleccionSimple;
import respuesta.Respuesta;
import respuesta.RespuestaCerrada;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

class ArchivoDeRespuestasRealizadasTest {

	
	private PreguntaDeSeleccionSimple pregunta;
	private RespuestaCerrada respuesta;
	private ArrayList<Respuesta> respuestas;
	private RespuestaCerrada respuesta2, respuesta3;
	
	@BeforeEach
	public void setUp() {
		pregunta = mock(PreguntaDeSeleccionSimple.class);
		respuesta = mock(RespuestaCerrada.class);
		respuesta2 = mock(RespuestaCerrada.class);
		respuesta3 = mock(RespuestaCerrada.class);
		respuestas =  new ArrayList<>();
		respuestas.add(respuesta); respuestas.add(respuesta2);
	}
	
	@Test
	void puedeGuardarLaRespuestaAUnaPregunta() {
		ArchivoDeRespuestas archivo = new ArchivoDeRespuestas();		
		List<Respuesta> listaDeRespuestas = new ArrayList<>();
		listaDeRespuestas.add(respuesta);
		
		archivo.guardar(pregunta, respuesta);
		
		assertEquals(archivo.respuestaDe(pregunta), listaDeRespuestas);
	}
	
	@Test
	void puedeGuardarMasDeUnaRespuestaAUnaPregunta() {
		ArchivoDeRespuestas archivo = new ArchivoDeRespuestas();		

		archivo.guardarMuchas(pregunta, respuestas);
		
		assertEquals(archivo.respuestaDe(pregunta), respuestas);
		assertTrue(archivo.contieneRespuesta(pregunta, respuesta));
		assertTrue(archivo.contieneRespuesta(pregunta, respuesta2));
	}
	
	@Test
	void puedeNoTenerLaRespuestaAUnaPregunta() {
		ArchivoDeRespuestas archivo = new ArchivoDeRespuestas();		

		archivo.guardarMuchas(pregunta, respuestas);
		
		assertFalse(archivo.contieneRespuesta(pregunta, respuesta3));
	}
	
	@Test
	void noPuedeDevolverUnaRespuestaAUnaPreguntaQueNoExiste() {
		ArchivoDeRespuestas archivo = new ArchivoDeRespuestas();		
		
		RuntimeException excepcion = 
			assertThrows(RuntimeException.class, () -> archivo.respuestaDe(pregunta));
		assertEquals(ArchivoDeRespuestas.NO_EXISTE_LA_PREGUNTA, excepcion.getMessage());
		
	}

}