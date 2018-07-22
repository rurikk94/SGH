package main.java.sgh;

import main.java.utiles.Rut;

public class Hospitalizados extends Habitacion 
{
	private Rut rutEnfermero;
	private int capacidad; //Numero que indica la cantidad de camas que caben en la habitacion de hospitalizdos
	private ListaCama camas;

	// Constructor
	
	public Hospitalizados(String id, String especialidad, Rut rutEnfermero, int capacidad) 
	{
		super(id, especialidad);
		this.rutEnfermero = rutEnfermero;
		this.capacidad = capacidad;
		camas = new ListaCama();
	}

	// Getters y Setters
	
	public Rut getRutEnfermero() 
	{
		return rutEnfermero;
	}

	public void setRutEnfermero(Rut rutEnfermero) 
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
	
	public boolean darDeAlta(Rut rutPaciente) //Sobreescritura de método abstracto
	{
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
	
	public boolean agregarCama(int numeroCama, String especialidad, Rut rutPaciente)
	{
		if(camas.getTotalCama() < capacidad)
		{
			if(camas.existeCama(numeroCama) == false)
			{
				return(camas.agregarCama(numeroCama, rutPaciente, especialidad));
			}
		}
		
		return false;
	}
	
	public Cama buscarCamaEspecifica(int numeroCama)
	{
		return(camas.buscarCamaEspecifica(numeroCama));
	}
	
	public boolean ocuparCama(int numeroCama, Rut rutPaciente)
	{
		return (camas.ocuparCama(numeroCama, rutPaciente));
	}
	
	public Cama buscarCamaDisponible()
	{
		return (camas.buscarCamaDisponible());
	}
	
	public int camasDisponibles()
	{
		return (camas.getNumeroCamasDisponibles());
	}
	
	public boolean eliminarCama(int numeroCama)
	{
		return(camas.eliminarCama(numeroCama));
	}
	
	public Cama eliminarObjetoCama(int numeroCama)
	{
		return(camas.eliminarObjetoCama(numeroCama));
	}
        
        public String toString(){
            return "Hospitalizado: " + getId() + " " + getDisponibilidad()+ " " + getEspecialidad() + "Medico: " + rutEnfermero.toString() + "\n Camas: " + camas.toString();
        }

}
