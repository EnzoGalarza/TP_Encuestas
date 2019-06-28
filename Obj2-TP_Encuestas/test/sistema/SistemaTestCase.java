package sistema;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import investigador.Investigador;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

class SistemaTestCase {

	private Sistema sistema;
	private Investigador investigador1, investigador2, investigador3;
	
	@BeforeEach
	public void setUp() {
		this.sistema = new Sistema();
		this.investigador1 = mock(Investigador.class);
		this.investigador2 = mock(Investigador.class);
		this.investigador3 = mock(Investigador.class);

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

}
