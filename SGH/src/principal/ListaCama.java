
package principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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
    public boolean buscarCamaRepetida(String codigo)//busca la cama por codigo y retorna un booleano
    {
        if(codigo==null) return false;//codigo null
        for(int i=0;i<arrayCama.size();i++)
        {
            if(arrayCama.get(i)!=null) //si existe
            {
                if(codigo.equals(arrayCama.get(i).getCodigoCama())==true) //si los codigos son iguales
                    return true;
            }
        }
        return false;//no existe cama con ese codigo
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean agregarCama(int numeroCama,String codigoVerificador,String rutPaciente,String especialidad)
    {
        Cama nuevaCama = new Cama();//se crea el objeto cama
        nuevaCama.setCodigoCama(codigoVerificador);
        nuevaCama.setEspecialidad(especialidad);
        nuevaCama.setNumeroCama(numeroCama);
        nuevaCama.setRutPaciente(rutPaciente);
        if(nuevaCama.getCodigoCama()!=null && buscarCamaRepetida(nuevaCama.getCodigoCama())==false)//no se encontro la cama
        {
            arrayCama.add(nuevaCama);//se agrega la cama
            return true;//se agrego
        }
        return false;//no se agrego
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public Cama buscarCamaEspecifica(String codigo)//busca la cama por codigo y retorna su indice
    {
        if(codigo==null) return null;//codigo no valido
        for(int i=0;i<arrayCama.size();i++)
        {
            if(arrayCama.get(i)!=null)//si existe
            { 
                Cama seleccionada = arrayCama.get(i);//se asigna la sala
                if(codigo.equals(seleccionada.getCodigoCama())==true) //si los codigos son iguales
                    return seleccionada;//retorna la cama
            }
        }
        return null;//no existe con ese codigo
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean vaciarCama(String codigoCama)//vacia la cama
    {
        if(codigoCama==null) return false;//codigo no valido
        Cama seleccionada=buscarCamaEspecifica(codigoCama);//recive la cama
        if(seleccionada==null) return false;//no existe la cama
        return seleccionada.vaciarCama();//retorna el resultado de la funcion (true/false)
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public String ocuparCama(String codigoCama, String rutPaciente)//ocupa la cama
    {
        if(codigoCama==null) return null;//codigo no valido
        Cama seleccionada=buscarCamaEspecifica(codigoCama);//recive el indice
        if(seleccionada==null) return null;//no existe la cama
        return seleccionada.ocuparCama(rutPaciente);//retorna el resultado de la funcion (true/false)
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public Cama buscarCamaDisponible()//retorna la primera cama disponible
    {
        for(int i=0;i<arrayCama.size();i++)
        {
            if(arrayCama.get(i)!=null)//si es distinto de null
            {
                Cama seleccionada = arrayCama.get(i); //se asigna
                if(seleccionada.getCamaDisponible()==true)//si la disponibilidad de la cama es true
                    return seleccionada;//retorna la cama
            }
        }
        return null;//no existen camas disponibles
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public String agregarPacienteACama(String rutPaciente)//retorna true/false dependiendo si el paciente se agrego o no a la cama
    {
        Cama seleccionada = buscarCamaDisponible(); //busca la primera cama disponible
        if(seleccionada==null)return null;//si no encontro retorna false
        return seleccionada.ocuparCama(rutPaciente);//llama al metodo ocupar el cual retorna true/false dependiendo si se ocupo la cama
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public int getNumeroCamasDisponibles()//retorna la cantidad de camas disponibles para ser ocupadas
    {
        int cont=0;
        for(int i=0;i<arrayCama.size();i++)
        {
            if(arrayCama.get(i)!=null)//si el iterador es distinto de null 
            {
                Cama seleccionada = arrayCama.get(i);//se asigna
                if(seleccionada.getCamaDisponible()==true)//si la cama esta disponible
                    cont++;//contador aumenta en 1
            }
        }
        return cont;//retorna la cantidad de camas disponibles
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean eliminarCama(String codigoCama)//elimina una cama
    {
        Cama seleccionada = buscarCamaEspecifica(codigoCama);//busca una cama especifica
        if(seleccionada==null)return false;//si la cama no existe, retorna false
        if(seleccionada.getRutPaciente()==null)//si la cama existe y no tiene un paciente
        {
            return eliminar(codigoCama);//retorna verdadero ya que se pudo eliminar
        }
        if(agregarPacienteACama(seleccionada.getRutPaciente())!=null)//si la cama existe y tiene un paciente, agregara al paciente a alguna cama disponible
        {
            return eliminar(codigoCama);//retorna true ya que se 
        }else //si no se pudo agregar al paciente a otra cama
            return false;//retornara falso ya que si tiene un paciente, no puede ser eliminada
    }
    public boolean eliminar(String codigoCama)
    {
        for(int i=0;i<arrayCama.size();i++)//comiensa a iterar las camas
        {
            if(arrayCama.get(i)!=null)//si existe
            {
                if(arrayCama.get(i).getCodigoCama()!=null && arrayCama.get(i).getCodigoCama().equals(codigoCama)==true)//valida que los datos no sean null y comprueba si son iguales
                {
                    arrayCama.remove(i);//remueve el objeto posicionado en i
                    return true;
                }
            }
        }
        return false;
    }
}