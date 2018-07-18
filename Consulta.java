package main.java.sgh;

public class Consulta extends Habitacion 
{
	private String rutMedico; 
	private Cama camilla;
	
	// Constructor

	public Consulta(String id, String especialidad, String rutMedico) {
		super(id, especialidad);
		this.rutMedico = rutMedico;
		this.camilla = new Cama();
	}

	// Getters y setters
	
	public String getRutMedico() {
		return rutMedico;
	}

	public void setRutMedico(String rutMedico) {
		this.rutMedico = rutMedico;
	}
	
	// Métodos
	
	public boolean ocuparCamilla(String rutPaciente)
	{
		camilla.ocuparCama(rutPaciente);
		return (camilla.ocuparCama(rutPaciente));
	}
	
	public boolean darDeAlta(String rutPaciente) //Sobreescritura de método abstracto
	{
		if(camilla.getRutPaciente().equalsIgnoreCase(rutPaciente))
		{
			camilla.vaciarCama();
			this.setDisponibilidad(true);
			return true;
		}
		return false;
	}
	
	public void modificarCamilla(int numeroCama, boolean disponibilidad, String especialidad)
	{
		camilla.setNumeroCama(numeroCama);
		camilla.setCamaDisponible(disponibilidad);
		camilla.setEspecialidad(especialidad);
	}

}
