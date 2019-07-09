package investigador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import investigador.Investigador;
import pregunta.Pregunta;
import proyecto.Proyecto;
import respuesta.Respuesta;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List; 

class InvestigadorTestCase {

	private Investigador investigador,investigador2;
	private Proyecto proyecto1;
	private Encuesta encuesta;
	private Pregunta pregunta1;
	private Respuesta respuesta1;
	
	@BeforeEach 
	public void setUp() {
		respuesta1 = mock(Respuesta.class);
		proyecto1 = new Proyecto("descripcion", "proposito");
		encuesta = mock(Encuesta.class);
		//pregunta1 = new PreguntaDeSeleccionSimple("Viaja en tren", new ArrayList<>());
		pregunta1 = mock(Pregunta.class);
		investigador = new Investigador("Luca","12345");
		investigador.agregarProyecto(proyecto1);
		investigador2 = new Investigador("Pedro","1333");
	}
	
	@Test
	void testNombreYPasswordInvestigador() {
		assertEquals("Luca", investigador.getUser());
		assertEquals("12345", investigador.getPassword()); 
	}
	
	@Test
	void puedeCrearUnProyectoConUnPropositoYUnaDescripcion() {
	investigador.crearProyecto("Mi proyecto", "Descripcion");
		
	assertTrue(investigador.tieneProyectos());
	}
	
	@Test
	void testProyectosInvestigador() {
		List<Proyecto> proyectosInv = new ArrayList<Proyecto>();
		proyectosInv.add(proyecto1);
		assertEquals(proyectosInv,this.investigador.getProyectos());
	}
	
	@Test
	void creaUnaEncuestaEnUnProyecto() {
		investigador.crearEncuesta(proyecto1,38, LocalDate.now());
		
		assertEquals(1,investigador.cantidadDeEncuestasEn(proyecto1));
	}

	@Test
	void testDefineUnaEncuestaAgregandoPreguntas() {
		when(encuesta.getPreguntaActual()).thenReturn(pregunta1);
		Encuesta encuestaCreada = investigador.crearEncuesta(proyecto1,32, LocalDate.now());
		investigador.setearPregunta(encuestaCreada, pregunta1);
		
		assertEquals(pregunta1,encuesta.getPreguntaActual());
	}
	
	@Test
	void testNoTieneProyectos() {
		assertFalse(investigador2.tieneProyectos());
	}
	
	@Test
	void testEjecucionDeUpdateInvestigador() {
		//Verifico que se ejecuta el notificar en pregunta y respuesta, ya que no hay especificacion
		//en el update
		Encuesta encuestaCreada = investigador.crearEncuesta(proyecto1, 23, LocalDate.now());
		encuestaCreada.setPregunta(pregunta1);
		encuestaCreada.finalizarEdicion();
		pregunta1.register(investigador);
		respuesta1.register(investigador);
		encuestaCreada.responder(respuesta1);
		verify(pregunta1,times(1)).notificar(encuestaCreada, respuesta1);
		verify(respuesta1,times(1)).notificar(encuestaCreada,pregunta1);
	}
	
}