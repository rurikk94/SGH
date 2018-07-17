/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.sgh;
import java.util.*;

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
    
    public boolean agregarHabitacionConsulta(String id, String especialidad, String rutMedico)
    {
    	Habitacion nuevo = new Consulta(id, especialidad, rutMedico);
    	if(!(habitaciones.contains(nuevo)))
    	{
    		habitaciones.add(nuevo);
    		return true;
    	}
    	
    	return false;
    }
    
    public boolean agregarHabitacionHospitalizados(String id, String especialidad, String rutEnfermero, int capacidad)
    {
    	Habitacion nuevo = new Hospitalizados(id, especialidad, rutEnfermero, capacidad);
    	
    	if(!(habitaciones.contains(nuevo)))
    	{
    		habitaciones.add(nuevo);
    		return true;
    	}
    	
    	return false;
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
    
    public boolean agregarCamaHospitalizados(String idHabitacion, int numeroCama, String especialidad, String rutPaciente)
    {
    	if(!(habitaciones.isEmpty()))
    	{
    		for(int i=0; i<habitaciones.size(); i++)
    		{
    			if(habitaciones.get(i) != null)
    			{
    				if((habitaciones.get(i).getId().equalsIgnoreCase(idHabitacion)) && (habitaciones.get(i) instanceof Hospitalizados))
    				{
    					
    				}
    			}
    		}
    	}
        return false;
    }
    
}
