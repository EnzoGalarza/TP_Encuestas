package archivo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pregunta.Pregunta;
import respuesta.Respuesta;

public class ArchivoDeRespuestas {
	
	public static final String NO_EXISTE_LA_PREGUNTA = "No existe la pregunta";
	private Map<Pregunta, List<Respuesta> > asociaciones = new HashMap<>();

	public void guardar(Pregunta pregunta, Respuesta respuesta) {
		if(!asociaciones.containsKey(pregunta)) {
			ArrayList<Respuesta> listaDeRespuestas = new ArrayList<Respuesta>();
			asociaciones.put(pregunta, listaDeRespuestas);
		}
			asociaciones.get(pregunta).add(respuesta);
	}

	public List<Respuesta> respuestaDe(Pregunta pregunta) {
		assertExisteLaPregunta(pregunta);
		return asociaciones.get(pregunta);
	}

	private void assertExisteLaPregunta(Pregunta pregunta) {
		if(!asociaciones.containsKey(pregunta)) {
			throw new RuntimeException(NO_EXISTE_LA_PREGUNTA);
		}
	}

	public void guardarMuchas(Pregunta pregunta, ArrayList<Respuesta> respuestas) {
		
		for(Respuesta respuesta : respuestas) {
			guardar(pregunta, respuesta);
		}
	}

	public Boolean contieneRespuesta(Pregunta pregunta, Respuesta respuesta) {
	
		return asociaciones.containsKey(pregunta) && asociaciones.get(pregunta).contains(respuesta);
		
	}
	

}
