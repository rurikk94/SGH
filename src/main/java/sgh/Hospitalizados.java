package main.java.sgh;

public class Hospitalizados extends Habitacion 
{
	private String rutEnfermero;
	private int capacidad; //Numero que indica la cantidad de camas que caben en la habitacion de hospitalizdos
	private ListaCama camas;

	// Constructor
	
	public Hospitalizados(String id, String especialidad, String rutEnfermero, int capacidad) 
	{
		super(id, especialidad);
		this.rutEnfermero = rutEnfermero;
		this.capacidad = capacidad;
		camas = new ListaCama();
	}

	// Getters y Setters
	
	public String getRutEnfermero() 
	{
		return rutEnfermero;
	}

	public void setRutEnfermero(String rutEnfermero) 
	{
		this.rutEnfermero = rutEnfermero;
	}

	public int getCapacidad() 
	{
		return capacidad;
	}

	public void setCapacidad(int capacidad) 
	{
		this.capacidad = capacidad;
	}
	
	// Métodos
	
	public boolean darDeAlta(String rutPaciente) //Sobreescritura de método abstracto
	{
		camas.vaciarCama(rutPaciente);
		return (camas.vaciarCama(rutPaciente));
	}
	
	public boolean darDeAlta(int numCama)
	{
		if(camas.existeCama(numCama))
		{
			camas.vaciarCama(numCama);
			return true;
		}
		
		return false;
	}
	

}
