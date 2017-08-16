package app;
import controlador.LogicaHistorias;
import modelo.HistoriaClinica;
import modelo.Paciente;
import vista.Pantalla;

public class HistoriaClinicaDNIapp {
	
	public static void main(String[] args) {
		
		Pantalla vista = new Pantalla();
		LogicaHistorias controlador = new LogicaHistorias();
		
		String dniPaciente = vista.ingresarValor( "Buscar Paciente por DNI" );
		int dni = Integer.parseInt(dniPaciente);
		Paciente encontrado = controlador.buscarPaciente( dni );
		
		
		
		if( encontrado != null ){
			vista.mostrarMensaje( "Paciente : " + encontrado.getNombre() + " DNI : " + encontrado.getDni() );
			
			vista.mostrarMensaje( "Total Historias : " + controlador.verTotalHistorias() );
			
			HistoriaClinica historia = controlador.buscarHistoriaClinica(dni);
			
			vista.mostrarMensaje( historia.getFecha() + "  " + historia.getDiagnostico() );
		} else {
			vista.mostrarMensaje( "No existe este paciente en la BD" );
		}
		
	}

}
