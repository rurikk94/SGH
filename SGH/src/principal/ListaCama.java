
package principal;

import java.util.ArrayList;

public class ListaCama 
{    
    private final ArrayList<Cama> arrayCama; //no puede ser heredada
    
    public ListaCama()
    {
        arrayCama = new ArrayList<Cama>();
    }
    
    
    public int getTotalCama()
    {
        return arrayCama.size();
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean existeCama(int numero)//busca la cama por el numero de esta y retorna un booleano 
    {
        for(int i=0;i<arrayCama.size();i++)
        {
            if(arrayCama.get(i)!=null) //si existe
            {
                if(numero == arrayCama.get(i).getNumeroCama() ) //si los numeros son iguales
                    return true;
            }
        }
        return false;//no existe cama con ese numero
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean agregarCama(int numeroCama,String rutPaciente,String especialidad)
    {
        if(existeCama(numeroCama)==false)//no se encontro la cama
        {
        	Cama nuevaCama = new Cama();//se crea el objeto cama
            nuevaCama.setEspecialidad(especialidad);
            nuevaCama.setNumeroCama(numeroCama);
            nuevaCama.setRutPaciente(rutPaciente);
            arrayCama.add(nuevaCama);//se agrega la cama
            return true;//se agrego
        }
        return false;//no se agrego
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public Cama buscarCamaEspecifica(int numeroCama)//busca la cama por codigo y retorna su indice
    {
        if(existeCama(numeroCama)==true) 
        {
        	for(int i=0;i<arrayCama.size();i++)
            {
                if(arrayCama.get(i)!=null)//si existe
                { 
                    if(arrayCama.get(i).getNumeroCama()==numeroCama) 
                        return (Cama)arrayCama.get(i);//retorna la cama
                }
            }
        }
        
        return null;//no existe cama con ese numero
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean vaciarCama(int numeroCama)//vacia la cama
    {
        if(existeCama(numeroCama)==true)
        {
        	for(int i=0; i<arrayCama.size();i++)
        	{
        		if(arrayCama.get(i) != null && arrayCama.get(i).getNumeroCama() == numeroCama)
        		{
        			arrayCama.get(i).vaciarCama();
        			return true;
        		}
        	}
        }
        
        return false;
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean ocuparCama(int numeroCama, String rutPaciente)//ocupa la cama
    {
        if(existeCama(numeroCama)==true)
        {
        	for(int i=0; i<arrayCama.size(); i++)
        	{
        		if(arrayCama.get(i) != null && arrayCama.get(i).getNumeroCama() == numeroCama)
        		{
        			arrayCama.get(i).ocuparCama(rutPaciente);
        			return true;
        		}
        	}
        }
        
        return false;
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public Cama buscarCamaDisponible()//retorna la primera cama disponible
    {
        if(arrayCama.isEmpty())
        	return null;
        
    	for(int i=0;i<arrayCama.size();i++)
        {
            if(arrayCama.get(i)!=null)//si es distinto de null
            {
                if(arrayCama.get(i).getCamaDisponible()==true)//si la disponibilidad de la cama es true
                    return (Cama)arrayCama.get(i);//retorna la cama
            }
        }
        return null;//no existen camas disponibles
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public int getNumeroCamasDisponibles()//retorna la cantidad de camas disponibles para ser ocupadas
    {
        int cont=0;
        for(int i=0;i<arrayCama.size();i++)
        {
            if(arrayCama.get(i)!=null)//si el iterador es distinto de null 
            {
                if(arrayCama.get(i).getCamaDisponible()==true)//si la cama esta disponible
                    cont++;//contador aumenta en 1
            }
        }
        return cont;//retorna la cantidad de camas disponibles
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean eliminarCama(int numeroCama)//elimina una cama
    {
        if(arrayCama.isEmpty())
        	return false;
        
        if(existeCama(numeroCama) == true)
        {
        	for(int i=0; i<arrayCama.size();i++)
        	{
        		if(arrayCama.get(i).getNumeroCama()==numeroCama && arrayCama.get(i).getCamaDisponible()==true) //Se encuentra la cama buscada y está vacía
        		{
        			arrayCama.remove(i);
        			return true;
        		}
        	}
        }
        
        return false;
    }
    
    public Cama eliminarObjetoCama(int numeroCama)
    {
    	Cama camaEliminada = new Cama();
    	if(arrayCama.isEmpty())
        	return null;
        
        if(existeCama(numeroCama) == true)
        {
        	for(int i=0; i<arrayCama.size();i++)
        	{
        		if(arrayCama.get(i).getNumeroCama()==numeroCama && arrayCama.get(i).getCamaDisponible()==true) //Se encuentra la cama y está vacía
        		{
        			camaEliminada = (Cama)arrayCama.get(i);
        			arrayCama.remove(i);
        			return camaEliminada;
        		}
        	}
        }
        
        return null;
    }
    
}