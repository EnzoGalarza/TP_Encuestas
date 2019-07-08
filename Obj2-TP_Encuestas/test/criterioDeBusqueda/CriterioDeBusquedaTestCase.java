package criterioDeBusqueda;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import criterioDeBusqueda.CriterioUltimasCreadas;
import encuesta.Encuesta;
import pregunta.PreguntaNula;
import proyecto.Proyecto;
import workflow.Workflow;
import static org.mockito.Mockito.*;

class CriterioDeBusquedaTestCase {

	private Proyecto proyec1,proyec2,proyect3,proyect4,proyect5;
	private Encuesta encuest1,encuest2,encuest3,encuest4,encuest5,encuest6,encuest7;
	private Encuesta encuesta8,encuesta9,encuesta10,encuesta11,encuesta12,encuesta13;
	private CriterioDeBusqueda criterioPorFecha, criterioPorProyecto,criterioPorUtilizaciones;
	
	@BeforeEach
	void setUp() throws Exception {
		proyec1 = new Proyecto("Descripcion", "Proposito");
		criterioPorFecha = new CriterioUltimasCreadas(25);
		encuest1 = new Encuesta(new Workflow(new PreguntaNula()), 0, LocalDate.of(2019, Month.JUNE, 26));
		encuest2 = new Encuesta(new Workflow(new PreguntaNula()), 0, LocalDate.of(2019, Month.JUNE, 25));
		encuest3 = new Encuesta(new Workflow(new PreguntaNula()), 0, LocalDate.of(2019, Month.JUNE, 24));
		encuest4 = new Encuesta(new Workflow(new PreguntaNula()), 0, LocalDate.of(2019, Month.JUNE, 23));
		encuest5 = new Encuesta(new Workflow(new PreguntaNula()), 0, LocalDate.of(2019, Month.JUNE, 22));
		encuest6 = new Encuesta(new Workflow(new PreguntaNula()), 0, LocalDate.of(2019, Month.JUNE, 21));
		encuest7 = new Encuesta(new Workflow(new PreguntaNula()), 0, LocalDate.of(2019, Month.JUNE, 20));
		encuesta8 = mock(Encuesta.class);
		encuesta9 = mock(Encuesta.class);
		encuesta10 = mock(Encuesta.class);
		encuesta11 = mock(Encuesta.class);
		encuesta12 = mock(Encuesta.class);
		encuesta13 = mock(Encuesta.class);
		proyec2 = new Proyecto("Composicion", "Delegacion");
		proyect3 = new Proyecto("a","a");
		proyect4 = new Proyecto("b","b");
		proyect5 = new Proyecto("c","c");
		criterioPorProyecto = new CriterioPorProyecto();
		criterioPorUtilizaciones = new CriterioMasUtilizadas(15);
	}
	
	@Test
	void testListaOrdenadaPorFecha() {
		//este test es para CriterioUtimasCreadas
		
		List<Encuesta> encuestasOrdenadas = new ArrayList<>(); //es lo que se espera que retorne filtrarPorCriterio(proyectos)
		encuestasOrdenadas.add(encuest1);
		encuestasOrdenadas.add(encuest2);
		encuestasOrdenadas.add(encuest3);
		encuestasOrdenadas.add(encuest4);
		encuestasOrdenadas.add(encuest5);
		encuestasOrdenadas.add(encuest6);
		encuestasOrdenadas.add(encuest7);
		
		
		List<Proyecto> proyectos = new ArrayList<Proyecto>(); //lista de proyectos que se le pasa como parametro a
		proyectos.add(proyec1); 						      // filtrarPorCriterio(proyectos)
		proyectos.add(proyec2);
		
		proyec1.agregarEncuesta(encuest2);
		proyec1.agregarEncuesta(encuest6);
		proyec2.agregarEncuesta(encuest5);
		proyec1.agregarEncuesta(encuest4);
		proyec1.agregarEncuesta(encuest1);
		proyec1.agregarEncuesta(encuest3);
		proyec1.agregarEncuesta(encuest7);
		
		assertEquals(encuestasOrdenadas,criterioPorFecha.filtrarPorCriterio(proyectos));
	}
	
	@Test
	void testEncuestaOrdenadaPorCriterios() {
		List<Encuesta> encuestasPorProyectos = new ArrayList<Encuesta>();
		encuestasPorProyectos.add(encuest3);
		encuestasPorProyectos.add(encuest4);
		encuestasPorProyectos.add(encuest6);
		encuestasPorProyectos.add(encuest7);
		encuestasPorProyectos.add(encuest5);
		
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		proyectos.add(proyect4);
		proyectos.add(proyect5);
		proyectos.add(proyect3);
		
		proyect3.agregarEncuesta(encuest3);
		proyect3.agregarEncuesta(encuest4);
		proyect5.agregarEncuesta(encuest5);
		proyect4.agregarEncuesta(encuest6);
		proyect4.agregarEncuesta(encuest7);
		
		assertEquals(encuestasPorProyectos,criterioPorProyecto.filtrarPorCriterio(proyectos));
	}
	
	@Test
	void testEncuestasOrdenadasPorMasUtilizaciones() {
		when(encuesta8.cantidadDeRespuestasCompletas()).thenReturn(7);
		when(encuesta9.cantidadDeRespuestasCompletas()).thenReturn(22);
		when(encuesta10.cantidadDeRespuestasCompletas()).thenReturn(13);
		when(encuesta11.cantidadDeRespuestasCompletas()).thenReturn(5);
		when(encuesta12.cantidadDeRespuestasCompletas()).thenReturn(15);
		when(encuesta13.cantidadDeRespuestasCompletas()).thenReturn(1);
		
		List<Encuesta> encuestasPorUtilizacion = new ArrayList<Encuesta>();
		encuestasPorUtilizacion.add(encuesta13);
		encuestasPorUtilizacion.add(encuesta11);
		encuestasPorUtilizacion.add(encuesta8);
		encuestasPorUtilizacion.add(encuesta10);
		encuestasPorUtilizacion.add(encuesta12);
		encuestasPorUtilizacion.add(encuesta9);
		
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		proyectos.add(proyect4);
		//proyectos.add(proyect5);
		//proyectos.add(proyect3);
		
		proyect4.agregarEncuesta(encuesta10);
		proyect4.agregarEncuesta(encuesta13);
		proyect4.agregarEncuesta(encuesta9);
		proyect4.agregarEncuesta(encuesta11);
		proyect4.agregarEncuesta(encuesta12);
		proyect4.agregarEncuesta(encuesta8);
		
		assertEquals(encuestasPorUtilizacion,criterioPorUtilizaciones.filtrarPorCriterio(proyectos));
	}
}

