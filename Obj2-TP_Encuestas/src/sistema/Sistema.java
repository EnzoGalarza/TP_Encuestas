package sistema;

import java.util.ArrayList;
import java.util.List;

import investigador.Investigador;

public class Sistema {
	
	private List<Investigador> investigadores;
	
	public Sistema() {
		this.investigadores = new ArrayList<Investigador>();
	}
	
	public void registrarInvestigador(Investigador i) {
		this.investigadores.add(i);
	}

	public List<Investigador> getInvestigadores() {
		// TODO Auto-generated method stub
		return this.investigadores;
	}
	
	
	
}
