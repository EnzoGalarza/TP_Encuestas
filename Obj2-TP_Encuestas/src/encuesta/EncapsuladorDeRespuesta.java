package encuesta;

import java.util.ArrayList;
import java.util.List;

import archivo.ArchivoDeRespuestas;
import pregunta.Pregunta;
import respuesta.Respuesta;

public class EncapsuladorDeRespuesta {

	private List<ArchivoDeRespuestas> sesiones;
	private ArchivoDeRespuestas sesionActual;
	
	public EncapsuladorDeRespuesta() {
		this.sesionActual = new ArchivoDeRespuestas();
		this.sesiones = new ArrayList<ArchivoDeRespuestas>();
	}
	
	public void agregarRespuestaRealizada(Pregunta pregunta, Respuesta unaRespuesta) {
		// Agrega al archivador actual una pregunta con su respuesta
		this.sesionActual.guardar(pregunta, unaRespuesta);
	}

	public void nuevaSesion() {
		// Crea un nuevoArchivador guardando al anterior
		this.sesiones.add(sesionActual);
		this.sesionActual = new ArchivoDeRespuestas();
	}
	
	
}
