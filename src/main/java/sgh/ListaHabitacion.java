/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.sgh;
import java.util.*;
import main.java.utiles.Rut;

/**
 *
 * @author Rurikk
 */
public class ListaHabitacion 
{
    private ArrayList<Habitacion> habitaciones;
    
    public ListaHabitacion()
    {
    	habitaciones = new ArrayList<Habitacion>();
    }
    
    public boolean agregarHabitacionConsulta(String id, String especialidad, Rut rutMedico)
    {
    	Habitacion nuevo = new Consulta(id, especialidad, rutMedico);
    	
    	if(!(habitaciones.isEmpty()))
    	{
    		for(int i=0; i<habitaciones.size();i++)
    		{
    			if((habitaciones.get(i) != null) && (habitaciones.get(i).getId().equalsIgnoreCase(id)))
    			{
    				return false;
    			}
    		}
    	}
    	
    	habitaciones.add(nuevo);
    	return true;
  
    }
    
    public boolean agregarHabitacionHospitalizados(String id, String especialidad, Rut rutEnfermero, int capacidad)
    {
    	Habitacion nuevo = new Hospitalizados(id, especialidad, rutEnfermero, capacidad);
    	
    	if(!(habitaciones.isEmpty()))
    	{
    		for(int i=0; i<habitaciones.size(); i++)
    		{
    			if((habitaciones.get(i) != null)&&(habitaciones.get(i).getId().equalsIgnoreCase(id)))
    			{
    				return false;
    			}
    		}
    	}
    		
    	habitaciones.add(nuevo);
    	return true;	
    }
    
    public boolean eliminarHabitación(String id)
    {
    	for(int i=0; i<habitaciones.size(); i++)
    	{
    		if((habitaciones.get(i) != null)&&(habitaciones.get(i).getId().equalsIgnoreCase(id)))
    		{
    			habitaciones.remove(i);
    			return true;
    		}
    	}
    	return false;
    }
    
    public Habitacion mostrarHabitacion(int indicador) //Metodo que retorna el objeto Habitacion en la posicion del indicador en la lista
    {
    	if(!(habitaciones.isEmpty()))
    	{
    		if(habitaciones.get(indicador) != null)
    		{
    			return (Habitacion)habitaciones.get(indicador);
    		}
    	}
    	
    	return null;
    }
    
    public Habitacion mostrarHabitacion(String id) //Metodo que retorna el objeto Habitacion con la id especificada 
    {
    	if(!(habitaciones.isEmpty()))
    	{
    		for(int i=0; i<habitaciones.size(); i++)
    		{
    			if(habitaciones.get(i) != null)
    			{
    				if(habitaciones.get(i).getId().equalsIgnoreCase(id))
    				{
    					return (Habitacion)habitaciones.get(i);
    				}
    			}
    		}
    	}
    	
    	return null;
    }
    
    public int contarHabitacionesHospitalizados() //Cuenta de entre todas las habitaciones de la lista cuales de estas son de Hospitalizados
    {
    	int contador = 0;
    	
    	if(!(habitaciones.isEmpty()))
    	{
    		for(int i=0; i<habitaciones.size(); i++)
    		{
    			if(habitaciones.get(i) != null)
    			{
    				if(habitaciones.get(i) instanceof Hospitalizados)
    				{
    					contador ++;
    				}
    			}
    		}
    	}
    	
    	return contador;
    }
    
    public int contarHabitacionesConsulta() //Cuenta de entre todas las habitaciones de la lista cuales de estas son de Consulta
    {
    	int contador = 0;
    	
    	if(!(habitaciones.isEmpty()))
    	{
    		for(int i=0; i<habitaciones.size(); i++)
    		{
    			if(habitaciones.get(i) != null)
    			{
    				if(habitaciones.get(i) instanceof Consulta)
    				{
    					contador ++;
    				}
    			}
    		}
    	}
    	
    	return contador;
    }
    
    public boolean darDeAlta(Rut rutPaciente)
    {
    	if(!(habitaciones.isEmpty()))
    	{
    		for(int i=0; i<habitaciones.size(); i++)
    		{
    			if(habitaciones.get(i) != null)
    			{
    				if(habitaciones.get(i).darDeAlta(rutPaciente) == true)
    				{
    					habitaciones.get(i).darDeAlta(rutPaciente);
    					return true;
    				}
    			}
    		}
    	}
    	
    	return false;
    }
    
    public boolean darDeAlta(int numeroCama)
    {
    	if(!(habitaciones.isEmpty()))
    	{
    		for(int i=0; i<habitaciones.size(); i++)
    		{
    			if((habitaciones.get(i) != null) && (habitaciones.get(i) instanceof Hospitalizados))
    			{
    				if(((Hospitalizados)habitaciones.get(i)).darDeAlta(numeroCama) == true)
    				{
    					((Hospitalizados)habitaciones.get(i)).darDeAlta(numeroCama);
    					return true;
    				}
    			}
    		}
    	}
    	
    	return false;
    }
    
    public boolean agregarCamaHospitalizados(String idHabitacion, int numeroCama, String especialidad, Rut rutPaciente)
    {
    	if(!(habitaciones.isEmpty()))
    	{
    		for(int i=0; i<habitaciones.size(); i++)
    		{
    			if(habitaciones.get(i) != null)
    			{
    				if((habitaciones.get(i).getId().equalsIgnoreCase(idHabitacion)) && (habitaciones.get(i) instanceof Hospitalizados))
    				{
    					((Hospitalizados)habitaciones.get(i)).agregarCama(numeroCama, especialidad, rutPaciente);
    					return (((Hospitalizados)habitaciones.get(i)).agregarCama(numeroCama, especialidad, rutPaciente));
    				}
    			}
    		}
    	}
    	
    	return false;
    }
    
    public Cama buscarCamaEspecifica(int numeroCama)
    {
    	if(!(habitaciones.isEmpty()))
    	{
    		for(int i=0; i<habitaciones.size(); i++)
    		{
    			if((habitaciones.get(i) != null)&&(habitaciones.get(i) instanceof Hospitalizados))
    			{
    				return (((Hospitalizados)habitaciones.get(i)).buscarCamaEspecifica(numeroCama));
    			}
    		}
    	}
    	
    	return null;
    }
    
    public boolean ocuparCama(int numeroCama, Rut rutPaciente)
    {
    	if(!(habitaciones.isEmpty()))
    	{
    		for(int i=0; i<habitaciones.size(); i++)
    		{
    			if((habitaciones.get(i) != null)&&(habitaciones.get(i) instanceof Hospitalizados))
    			{
    				((Hospitalizados)habitaciones.get(i)).ocuparCama(numeroCama, rutPaciente);
    				return(((Hospitalizados)habitaciones.get(i)).ocuparCama(numeroCama, rutPaciente));
    			}
    		}
    	}
    	
    	return false;
    }
    
    public Cama buscarCamaDisponible()
    {
    	if(!(habitaciones.isEmpty()))
    	{
    		for(int i=0; i<habitaciones.size(); i++)
    		{
    			if((habitaciones.get(i) != null)&&(habitaciones.get(i) instanceof Hospitalizados))
    			{
    				return(((Hospitalizados)habitaciones.get(i)).buscarCamaDisponible());
    			}
    		}
    	}
    	
    	return null;
    
    }
    
    public boolean eliminarCamaHospitalizados(int numeroCama)
    {
    	if(!(habitaciones.isEmpty()))
    	{
    		for(int i=0; i<habitaciones.size(); i++)
    		{
    			if((habitaciones.get(i) != null)&&(habitaciones.get(i) instanceof Hospitalizados))
    			{
    				((Hospitalizados)habitaciones.get(i)).eliminarCama(numeroCama);
    				return(((Hospitalizados)habitaciones.get(i)).eliminarCama(numeroCama));
    			}
    		}
    	}
    	
    	return false;
    }
    
    public Cama eliminarObjetocamaHospitalizados(int numeroCama)
    {
    	if(!(habitaciones.isEmpty()))
    	{
    		for(int i=0; i<habitaciones.size(); i++)
    		{
    			if((habitaciones.get(i) != null)&&(habitaciones.get(i) instanceof Hospitalizados))
    			{
    				return(((Hospitalizados)habitaciones.get(i)).eliminarObjetoCama(numeroCama));
    			}
    		}
    	}
    	
    	return null;
    }
    
    public void modificarCamillaConsulta(String idHabitacion,int numeroCama, boolean disponibilidad, String especialidad)
    {
    	if(!(habitaciones.isEmpty()))
    	{
    		for(int i=0; i<habitaciones.size(); i++)
    		{
    			if((habitaciones.get(i) != null)&&(habitaciones.get(i) instanceof Consulta)&&(habitaciones.get(i).getId().equalsIgnoreCase(idHabitacion)))
    			{
    				((Consulta)habitaciones.get(i)).modificarCamilla(numeroCama, disponibilidad, especialidad);
    			}
    		}
    	}
    	
    }
    
    public boolean ocuparCamillaConsulta(String idHabitacion, Rut rutPaciente)
    {
    	if(!(habitaciones.isEmpty()))
    	{
    		for(int i=0; i<habitaciones.size(); i++)
    		{
    			if((habitaciones.get(i) != null)&&(habitaciones.get(i) instanceof Consulta)&&(habitaciones.get(i).getId().equalsIgnoreCase(idHabitacion)))
    			{
    				((Consulta)habitaciones.get(i)).ocuparCamilla(rutPaciente);
    				return(((Consulta)habitaciones.get(i)).ocuparCamilla(rutPaciente));
    			}
    		}
    	}
    	
    	return false;
    }
        
}
