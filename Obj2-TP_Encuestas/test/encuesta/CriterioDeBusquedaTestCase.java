package encuesta;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import criterioDeBusqueda.CriterioUltimasCreadas;
import pregunta.PreguntaNula;
import proyecto.Proyecto;
import workflow.Workflow;

class CriterioDeBusquedaTestCase {

	private Proyecto proyec1;
	private Encuesta encuest1;
	private Encuesta encuest2;
	private Encuesta encuest3;
	private Encuesta encuest4;
	private Encuesta encuest5;
	private Encuesta encuest6;
	private Encuesta encuest7;
	private CriterioUltimasCreadas criterio;
	
	@BeforeEach
	void setUp() throws Exception {
		proyec1 = new Proyecto("Descripcion", "Proposito");
		criterio = new CriterioUltimasCreadas();
		encuest1 = new Encuesta(new Workflow(new PreguntaNula()), 0, LocalDate.of(2019, Month.JUNE, 26));
		encuest2 = new Encuesta(new Workflow(new PreguntaNula()), 0, LocalDate.of(2019, Month.JUNE, 25));
		encuest3 = new Encuesta(new Workflow(new PreguntaNula()), 0, LocalDate.of(2019, Month.JUNE, 24));
		encuest4 = new Encuesta(new Workflow(new PreguntaNula()), 0, LocalDate.of(2019, Month.JUNE, 23));
		encuest5 = new Encuesta(new Workflow(new PreguntaNula()), 0, LocalDate.of(2019, Month.JUNE, 22));
		encuest6 = new Encuesta(new Workflow(new PreguntaNula()), 0, LocalDate.of(2019, Month.JUNE, 21));
		encuest7 = new Encuesta(new Workflow(new PreguntaNula()), 0, LocalDate.of(2019, Month.JUNE, 20));
	}
	
	@Test
	void listaOrdenadaPorFecha() {
		
		List<Encuesta> encuestas = new ArrayList<>();
		encuestas.add(encuest1);
		encuestas.add(encuest2);
		encuestas.add(encuest3);
		encuestas.add(encuest4);
		encuestas.add(encuest5);
		encuestas.add(encuest6);
		encuestas.add(encuest7);
		
		proyec1.agregarEncuesta(encuest2);
		proyec1.agregarEncuesta(encuest6);
		proyec1.agregarEncuesta(encuest5);
		proyec1.agregarEncuesta(encuest4);
		proyec1.agregarEncuesta(encuest1);
		proyec1.agregarEncuesta(encuest3);
		proyec1.agregarEncuesta(encuest7);
		
		
		assertEquals(encuestas,criterio.filtrarPorCriterio(proyec1.getEncuestas()));
	}
}

