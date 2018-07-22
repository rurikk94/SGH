package main.java.sgh;

import main.java.utiles.Rut;

public class Consulta extends Habitacion 
{
	private Rut rutMedico; 
	private Cama camilla;
	
	// Constructor

	public Consulta(String id, String especialidad, Rut rutMedico) {
		super(id, especialidad);
		this.rutMedico = rutMedico;
		this.camilla = new Cama();
	}

	// Getters y setters
	
	public Rut getRutMedico() {
		return rutMedico;
	}

	public void setRutMedico(Rut rutMedico) {
		this.rutMedico = rutMedico;
	}
	
	// Métodos
	
	public boolean ocuparCamilla(Rut rutPaciente)
	{
		camilla.ocuparCama(rutPaciente);
                this.setDisponibilidad(false);
		return (camilla.ocuparCama(rutPaciente));
	}
	
	public boolean darDeAlta(Rut rutPaciente) //Sobreescritura de método abstracto
	{
		if(camilla.getRutPaciente().esIgual(rutPaciente))
		{
			camilla.vaciarCama();
			this.setDisponibilidad(true);
			return true;
		}
		return false;
	}
	
	public boolean modificarCamilla(int numeroCama, boolean disponibilidad, String especialidad)
	{
		camilla.setNumeroCama(numeroCama);
		camilla.setCamaDisponible(disponibilidad);
		camilla.setEspecialidad(especialidad);
                return true;
	}
	
	public boolean existeCama(int numeroCama)
	{
		if(camilla.getNumeroCama() == numeroCama)
			return true;
		
		else
			return false;
	}

        @Override
        public String toString(){
            return ("Consulta: " + getId() + " " + getDisponibilidad()+ " " + getEspecialidad() + "Medico: " + rutMedico.toString() + "Camilla: " + camilla.toString());
        }
}
