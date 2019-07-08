package encuesta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pregunta.Pregunta;
import respuesta.Respuesta;
import workflow.Workflow;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;

class EncuestaTestCase {

	private Encuesta encuesta;
	private Workflow protocolo;
	private Pregunta primerPreguntaProtocolo;
	private Pregunta segundaPreguntaProtocolo;
	private Respuesta respuesta1, respuesta2;
    private EstadoDeEncuesta estadoCerrado,estadoDisponible;
    
	@BeforeEach
	public void setUp() {
		estadoCerrado = mock(EstadoDeEncuestaCerrada.class);
		estadoDisponible = mock(EstadoDeEncuestaDisponible.class);
		respuesta1 = mock(Respuesta.class);
		respuesta2 = mock(Respuesta.class);
		this.primerPreguntaProtocolo = mock(Pregunta.class);
		this.segundaPreguntaProtocolo = mock(Pregunta.class);
		this.protocolo = mock(Workflow.class);
		this.encuesta = new Encuesta(protocolo,40, LocalDate.of(2019, Month.JUNE, 1));
	}

	@Test
	void testUnaEncuestaNaceConEstadoEnEdicion() {
		EstadoDeEncuesta nuevoEstado = new EstadoDeEncuestaEnEdicion(this.encuesta);
		assertTrue(this.encuesta.getEstado().getClass().equals(nuevoEstado.getClass()));
	}
	
	@Test
	void testUnaEncuestaNaceConUnaCantidadDeRespuestasComoProposito() {
		assertEquals(40,this.encuesta.getCantidadDeRespuestasLimite());
	}
	
	@Test
	void testUnaEncuestaTieneUnaSolaPreguntaQuePuedeMostrar() {
		when(protocolo.getPregunta()).thenReturn(primerPreguntaProtocolo);
		assertEquals(primerPreguntaProtocolo,this.encuesta.getPreguntaActual());
	}
	
	@Test
	void testUnaEncuestaConUnaPreguntaSiguientePuedeIrASuSiguientePregunta() {
		when(protocolo.getPregunta()).thenReturn(segundaPreguntaProtocolo);
		this.encuesta.siguiente(respuesta1);
		verify(protocolo,times(1)).siguiente(respuesta1);
		assertEquals(segundaPreguntaProtocolo,encuesta.getPreguntaActual());
	}
	
	@Test
	void testUnaEncuestaConUnaPreguntaAnteriorPuedeIrASuPreguntaAnterior() {
		this.encuesta.siguiente(respuesta1);
		verify(protocolo,times(1)).siguiente(respuesta1);
		this.encuesta.anterior();
		verify(protocolo,times(1)).anterior();
	}
	
	@Test
	void testUnaEncuestaEnEstadoDeEdicionSePuedeModificar() {
		this.encuesta.setPregunta(segundaPreguntaProtocolo);
		verify(protocolo,times(1)).setPregunta(segundaPreguntaProtocolo);
	}
	
	@Test
	void testUnaEncuestaEnEstadoDeEdicionNoSePuedeResponder() {
		this.encuesta.setPregunta(primerPreguntaProtocolo);
		this.encuesta.responder(respuesta1);
		verify(protocolo,times(0)).siguiente(respuesta1);
	}
	
	@Test
	void testUnaEncuestaEnEstadoEdicionPuedePasarAEstadoDisponible() {
		this.encuesta.finalizarEdicion();
		assertTrue(this.encuesta.disponible());
	}
	
	@Test
	void testUnaEncuestaEnEstadoDisponibleNoSePuedeModificar() {
		this.encuesta.finalizarEdicion();
		this.encuesta.setPregunta(primerPreguntaProtocolo);
		
		verifyZeroInteractions(protocolo);
	}
	
	@Test
	void testUnaEncuestaEnEstadoDisponibleSePuedeResponder() {
		when(protocolo.getPregunta()).thenReturn(primerPreguntaProtocolo);
		this.encuesta.finalizarEdicion();
		this.encuesta.responder(respuesta2);
		verify(protocolo,times(1)).siguiente(respuesta2);
		verify(this.encuesta.getPreguntaActual(),times(1)).notificar(encuesta, respuesta2);
		verify(respuesta2,times(1)).notificar(encuesta, primerPreguntaProtocolo);
	}
	
	@Test
	void testUnaEncuestaEnEstadoEdicionNoPuedePasarAEstadoCerrado() {
		EstadoDeEncuesta nuevoEstado = new EstadoDeEncuestaCerrada(this.encuesta);
		this.encuesta.cerrarEncuesta();
		assertFalse(this.encuesta.getEstado().getClass().equals(nuevoEstado.getClass()));
	}
	
	@Test
	void testUnaEncuestaEnEstadoDisponiblePuedePasarAEstadoCerrado() {
		EstadoDeEncuesta nuevoEstado = new EstadoDeEncuestaCerrada(this.encuesta);
		this.encuesta.finalizarEdicion();
		this.encuesta.cerrarEncuesta();
		assertTrue(this.encuesta.getEstado().getClass().equals(nuevoEstado.getClass()));
	}
	
	@Test
	void testUnaEncuestaCerradaNoSePuedeResponderNiModificar() {
		 this.encuesta.setPregunta(primerPreguntaProtocolo);
		 this.encuesta.finalizarEdicion();
	     this.encuesta.cerrarEncuesta();
	     this.encuesta.responder(respuesta1);
	     this.encuesta.setPregunta(segundaPreguntaProtocolo);
	     verify(protocolo,times(0)).setPregunta(segundaPreguntaProtocolo);
	     verify(protocolo,times(0)).siguiente(respuesta1);
	}
	
	@Test
	void seCreaConUnaFecha() {
	     assertEquals(encuesta.fechaDeCreacion(),LocalDate.of(2019, Month.JUNE, 1));
	}
	
	@Test
	void testUnaEncuestaEnEstadoDisponibleYEnUltimaPreguntaPuedeGuardarCambios() {
		this.encuesta.setPregunta(primerPreguntaProtocolo);
		this.encuesta.finalizarEdicion();
		when(protocolo.getPregunta()).thenReturn(primerPreguntaProtocolo);
		when(primerPreguntaProtocolo.esUltimaPregunta()).thenReturn(true);
		this.encuesta.guardarCambios();
		
		// verifico que se cambia La cantidadDeRespuestaCompletasLimiteAlCuestionario Y la cantidad
		// de respuestasCompletas
		assertEquals(39,this.encuesta.getCantidadDeRespuestasLimite());
		assertEquals(1,this.encuesta.cantidadDeRespuestasCompletas());
	}
	
	@Test
	void testUnaEncuestaSiEstaEnDisponibleYNoEsLaUltimaPreguntaNoGuardaLosCambios() {
		when(protocolo.getPregunta()).thenReturn(primerPreguntaProtocolo);
		when(primerPreguntaProtocolo.esUltimaPregunta()).thenReturn(false);
		this.encuesta.finalizarEdicion();
		this.encuesta.guardarCambios();
		// verifico que no se cambia La cantidadDeRespuestaLimiteAlCuestionario
		assertEquals(40,this.encuesta.getCantidadDeRespuestasLimite());
		assertEquals(0,this.encuesta.cantidadDeRespuestasCompletas());
	}
	
	@Test
	void testUnaEncuestaNoPuedeGuardarSiNoEstaEnDisponible() {
		when(protocolo.getPregunta()).thenReturn(segundaPreguntaProtocolo);
		when(segundaPreguntaProtocolo.esUltimaPregunta()).thenReturn(true);
		
		this.encuesta.guardarCambios();
		// verifico que no se cambia La cantidadDeRespuestaLimiteAlCuestionario
		assertEquals(40,this.encuesta.getCantidadDeRespuestasLimite());
		assertEquals(0,this.encuesta.cantidadDeRespuestasCompletas());
		
		
		this.encuesta.finalizarEdicion();
		this.encuesta.cerrarEncuesta();
		this.encuesta.guardarCambios();
		assertEquals(40,this.encuesta.getCantidadDeRespuestasLimite());
		assertEquals(0,this.encuesta.cantidadDeRespuestasCompletas());
	}
	
	@Test
	void testUnaEncuestaDisponibleYEnLaUltimaPreguntaPuedeGuardarCambios(){
		
		when(protocolo.getPregunta()).thenReturn(segundaPreguntaProtocolo);
		when(segundaPreguntaProtocolo.esUltimaPregunta()).thenReturn(true);
		
		this.encuesta.finalizarEdicion();
		this.encuesta.guardarCambios();
		// verifico que no se cambia La cantidadDeRespuestaLimiteAlCuestionario
		assertEquals(39,this.encuesta.getCantidadDeRespuestasLimite());
		assertEquals(1,this.encuesta.cantidadDeRespuestasCompletas());
		
	}
	
	@Test
	void testEncuestaCompletaSuProposito() {
		when(protocolo.getPregunta()).thenReturn(primerPreguntaProtocolo);
		when(primerPreguntaProtocolo.esUltimaPregunta()).thenReturn(true);
		when(estadoCerrado.finalizada()).thenReturn(true);
		Encuesta encuestaParaFinalizar = new Encuesta(protocolo,1,LocalDate.of(2019,Month.APRIL,11));
		encuestaParaFinalizar.setEstado(estadoDisponible);
		encuestaParaFinalizar.actualizarCantidadDeRespuestasEsperada();
		verify(estadoDisponible,times(1)).cerrarEncuesta();
		encuestaParaFinalizar.setEstado(estadoCerrado);
		assertTrue(encuestaParaFinalizar.finalizada());
	}
	
}