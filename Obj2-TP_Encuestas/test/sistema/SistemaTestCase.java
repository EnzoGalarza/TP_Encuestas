package sistema;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import criterioDeBusqueda.CriterioUltimasCreadas;
import encuesta.Encuesta;
import investigador.Investigador;
import pregunta.PreguntaNula;
import proyecto.Proyecto;
import workflow.Workflow;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class SistemaTestCase {

	private Sistema sistema;
	private Investigador investigador1, investigador2, investigador3;
	private Encuesta encuesta1;
	private Encuesta encuesta2;
	
	@BeforeEach
	public void setUp() {
		this.sistema = new Sistema();
		this.investigador1 = new Investigador("", "");
		this.investigador2 = mock(Investigador.class);
		this.investigador3 = mock(Investigador.class);
		this.encuesta1 = new Encuesta(new Workflow(new PreguntaNula()), 0, LocalDate.of(2019, 7, 8));
		this.encuesta2 = new Encuesta(new Workflow(new PreguntaNula()), 0, LocalDate.of(2019, 7, 9));

	}
	
	@Test
	void testRegistrarInvestigador() {
		this.sistema.registrarInvestigador(investigador1);
		this.sistema.registrarInvestigador(investigador2); 
		this.sistema.registrarInvestigador(investigador3);
		
		// creo Una Lista donde agrego a los investigadores para comprobar
        List<Investigador> listaDeInvestigadores = new ArrayList<Investigador>();
		
		listaDeInvestigadores.add(investigador1);
		listaDeInvestigadores.add(investigador2);
		listaDeInvestigadores.add(investigador3);
	
		assertEquals(listaDeInvestigadores,this.sistema.getInvestigadores());
	}
	@Test
	void testLasEncuestasDeProyectosSePuedenObtenerPorElCriterioDeMasEncuestasRealizadas() {
		this.sistema.registrarInvestigador(investigador1);
		this.sistema.registrarInvestigador(investigador2); 
		this.sistema.registrarInvestigador(investigador3);
		
		// creo Una Lista donde agrego a los investigadores para comprobar
        List<Investigador> listaDeInvestigadores = new ArrayList<Investigador>();
		
		listaDeInvestigadores.add(investigador1);
		listaDeInvestigadores.add(investigador2);
		listaDeInvestigadores.add(investigador3);
	
		assertEquals(listaDeInvestigadores,this.sistema.getInvestigadores());
	}
	@Test
	void testSePuedeObtenerLasEncuestasOrdenadasPorUnCriterioDeTodosLosInvestigadores() {
		
		Proyecto proyecto = investigador1.crearProyecto("descripcion", "proposito");
		Encuesta encuesta = investigador1.crearEncuesta(proyecto, 0, LocalDate.of(2019, 7, 7));
		investigador1.crearEncuesta(proyecto, 0, LocalDate.of(2019, 7, 6));
		
		this.sistema.registrarInvestigador(investigador1);
		encuesta.finalizarEdicion();
		List<Encuesta> encuestas = new ArrayList<>();
		encuestas.add(encuesta);
		
		assertEquals(this.sistema.ordenarPorCriterio(new CriterioUltimasCreadas(1)), encuestas);
	}

}
