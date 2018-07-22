package main.java.sgh;

import main.java.utiles.Rut;

public abstract class Habitacion 
{
	private String id;
	private boolean disponibilidad;
	private String especialidad; //Pediatria, Adultos, cirugía, quemados, fracturas, etc etc
	
	// Constructor
	
	public Habitacion(String id, String especialidad)
	{
		this.id = id;
		this.especialidad = especialidad;
		this.disponibilidad = true; //la habitación se crea e inmediatamente queda disponible;
	}

	// Getters y Setters
	
	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public boolean getDisponibilidad() 
	{
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) 
	{
		this.disponibilidad = disponibilidad;
	}
	
	public String getEspecialidad()
	{
		return especialidad;
	}
	
	public void setEspecialidad(String especialidad)
	{
		this.especialidad = especialidad;
	}
	
	// Métodos
        public String toString() {
        return id + " " + disponibilidad + " " + especialidad;
    }

	
	public abstract boolean darDeAlta(Rut rut); //Método abstracto
	public abstract boolean existeCama(int numeroCama);
}
