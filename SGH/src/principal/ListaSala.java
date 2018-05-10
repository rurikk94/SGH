
package principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaSala 
{    
    private final ArrayList<Sala> arraySala; //se instancia la lista
    
    public ListaSala() throws IOException
    {
        arraySala = new ArrayList<Sala>();
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public int getCantidadSalas()
    {
        return arraySala.size();
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean buscarSalaRepetida(int numeroSala)//Retorna el true de la sala si existe, sino ,retorna false; codigoCama
    { 
        if(arraySala==null) return false; //lista vacia
        for(int i=0;i<arraySala.size();i++)
        {
            if(arraySala.get(i)!=null)//si la sala existe
            {
                if(arraySala.get(i).getNumeroSala()==numeroSala)//si el numero de sala es igual al de la sala actual
                    return true;//la sala existe
            }
        }
        return false;//no se encuentra la sala
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public Sala buscarSala(int numeroSala)//Retorna la sala si existe, sino ,retorna null;
    { 
        if(numeroSala<0)return null;
        if(arraySala==null) return null; //lista vacia
        for(int i=0;i<arraySala.size();i++)
        {
            if(arraySala.get(i)!=null)//si la sala existe
            {
                if(numeroSala==arraySala.get(i).getNumeroSala())//si el numero de sala es igual al de la sala actual
                    return arraySala.get(i);//retorna la sala
            }
        }
        return null;//la sala no existe
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean agregarSala(String nombreSala,int capacidadMaxima,int numero,String rutDoctor,String sector,int nivel)//Verdadero si se agrego la sala, falso si ya existia
    { 
        Sala nuevaSala = new Sala();//le asignamos memoria
        if(capacidadMaxima!=-1)nuevaSala.setTotalCamas(capacidadMaxima);//si la capacidad es mayor a -1 (por defecto), se agrega
        if(nivel!=-10)nuevaSala.setPiso(nivel);//si es distinto al piso -10 (por defecto) se agrega el nivel de la sala referente al piso en el cual esta
        nuevaSala.setEspecialidad(sector);
        nuevaSala.setNombreSala(nombreSala);
        nuevaSala.setNumeroSala(numero);
        nuevaSala.setRutDoctor(rutDoctor);
        if(numero==-1==true)return false;//no existen salas con un numero menor a 0
        if(sector.equals("")==true) return false;//el sector es un dato importante, debe estar si o si junto con el numero de sala
        if(buscarSalaRepetida(nuevaSala.getNumeroSala())==false)//no existe la sala
        { 
            return arraySala.add(nuevaSala); //se agrega
        }
        return false;//la sala existe
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean agregarCama(int numeroSala,int numeroCama,String codigoVerificador,String rutPaciente,String especialidad)//retorna true si se agrego, sino false
    { 
        if(codigoVerificador.equals("")==true)return false;
        if(arraySala==null) return false;//no existen salas
        if(numeroSala<0) return false;//numero de cama no valido
        Sala seleccionada=buscarSala(numeroSala);//obtengo la sala
        if(seleccionada!=null)//existe la sala
        {
            if(seleccionada.getCantidadActual()<seleccionada.getCapacidadMaxima())//si la cantidad de camas actual es menor a la capacidad total de ellas
            {
                if(seleccionada.agregarCama(numeroCama,codigoVerificador,rutPaciente,especialidad))
                    return true;//se agrega la cama
            }
        }
        return false;
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean asignarDoctor(String rutDoctor, int numeroSala)//retorna true si se asigno, retorna false si no
    {
        if(rutDoctor==null)return false;//doctor es null
        if(numeroSala<0)return false;//la sala no existe
        Sala seleccionada = buscarSala(numeroSala);//se ingresa a la sala correspondiente
        seleccionada.setRutDoctor(rutDoctor);//se añade el doctor a esa sala
        return true;
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean asignarEspacioDeSala(int capacidad, int numeroSala)//retorna true si se pudo asigna, si no, false
    {
        if(numeroSala<=0) return false; //la sala no existe
        if(buscarSala(numeroSala)==null) return false; //significa que la sala no existe
        Sala seleccionada=buscarSala(numeroSala);//se asigna la sala
        seleccionada.setTotalCamas(capacidad);//se asigna la capacidad nueva a la sala
        return true;
    }
    
    public Sala buscarSalaPorCodigoCama(String codigoCama){//se ingresa el codigo de la cama, y retorna la sala en la cual se encuentre
        for(int i=0;i<arraySala.size();i++)//se comienza a iterar
        {
            if(arraySala.get(i)!=null)//si existe
            {
                Sala seleccionada = arraySala.get(i);//se asigna
                if(seleccionada.buscarCamaRepetida(codigoCama)==true)//si la cama se encuentra en la sala
                {
                    return seleccionada;//retorna la sala
                }
            }
        }
        return null;//sino, retorna null
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean vaciarCama(String codigoCama) //retorna verdadero si se vacio, sino false
    {
        Sala seleccionada = buscarSalaPorCodigoCama(codigoCama);//se asigna la sala
        if(seleccionada==null) return false;
        return seleccionada.vaciarCama(codigoCama);//la funcion retorna verdadero si se vacia, sino, false
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean especialidadDeLaSala(String especialidad, int numeroSala)
    {
        Sala seleccionada = buscarSala(numeroSala);//obtenemos la supuesta "sala"
        if(seleccionada==null) return false;//si la sala existe
        seleccionada.setEspecialidad(especialidad);//se le añade la especialidad
        return true;
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public Sala buscarSalaPorDisponibilidadDeCama(String especialidad)//recibe la especialidad y retorna la sala que tenga camas disponibles
    {
        for(int i=0;i<arraySala.size();i++)//se comienza a iterar
        {
            if(arraySala.get(i)!=null)//si existe
            {
                Sala seleccionada=arraySala.get(i);//se asigna
                if(seleccionada.getEspecialidad().equals(especialidad)==true)//si la sala es de la especialidad correspondiente
                {
                    if(seleccionada.getNumeroCamasDisponibles()>0)//si las camas disponibles son mayores a 0
                        return seleccionada;//retornara la sala
                }
            }
        }
        return null;//no hay salas con esa especialidad que tengan camas disponibles
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public String agregarPacienteACama(String especialidad, String rutPaciente)//retorna true/fasle si se pudo agregar el paciente a la cama
    {
        if(rutPaciente.equals("")==true)return null;
        Sala seleccionada = buscarSalaPorDisponibilidadDeCama(especialidad);//retorna la sala especificada con camas disponibles
        if(seleccionada==null)return null;//no existe la sala o no hay camas disponibles
        return seleccionada.agregarPacienteACama(rutPaciente);//llama al metodo agregarPacienteACama
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean eliminarCama(String codigoCama){//retorna tur/false si la cama fue eliminada o no
        if(codigoCama.equals("")==true)return false;
        Sala seleccionada = buscarSalaPorCodigoCama(codigoCama);//se busca la sala en done se encuentre la cama buscada
        if(seleccionada==null)return false;//si no existe, retorna false
        return seleccionada.eliminarCama(codigoCama);//si existe, llama al metodo eliminarCama
    }
    public Cama buscarCamaEspecifica(String codigoCama)//busca la cama dependiendo del codigo de ella que se ingrese
    {
        if(codigoCama.equals("")==true)return null;//si el usuario ingreso nada retorna null
        for(int i=0;i<arraySala.size();i++)//recorre
        {
            if(arraySala.get(i)!=null)//si existe
            {
                Sala seleccionada = arraySala.get(i);//se asigna la sala
                return seleccionada.buscarCamaEspecifica(codigoCama);//retorna la cama si la encuentra, sino null;
            }
        }
        return null;
    }
    
    public int totalPacienteEspecialidad (String especialidad)
    {
        int totalPacienteEspe=0;
        int camasOcupadas;
        for(int i=0;i<arraySala.size();i++)
        {
            if(arraySala.get(i)!=null)//si la sala existe
            {
               if(arraySala.get(i).getEspecialidad().equals(especialidad)) // veo que sea de la especialidad deseada.
               {
                   camasOcupadas = arraySala.get(i).getCantidadActual() - arraySala.get(i).getNumeroCamasDisponibles(); //calculo la cantidad de camas ocupadas restando de la cantidad total de camas las camas disponibles.
                   totalPacienteEspe = totalPacienteEspe + camasOcupadas;
               }                
            }
        }
        
        
        return totalPacienteEspe; //retorno la cantidad de pacientes que corresponden a la especialidad deseada.
    }
    
    
    public int totalPacienteHospital ()
    {
        int camasOcupadas;
        int totalPacientes = 0;
        for(int i=0;i<arraySala.size();i++)//se comienza a iterar
        {
            if(arraySala.get(i)!=null)//si existe
            {
                camasOcupadas = arraySala.get(i).getCantidadActual() - arraySala.get(i).getNumeroCamasDisponibles();  //calculo la cantidad de camas ocupadas restando de la cantidad total de camas las camas disponibles.  
                totalPacientes = totalPacientes + camasOcupadas;
            }
        }
        
        return totalPacientes; // retorno el total de pacientes en el hospital.
    }
}