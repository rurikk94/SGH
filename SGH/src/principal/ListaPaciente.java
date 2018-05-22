
package principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListaPaciente 
{        
    private ArrayList<Paciente> arrayPaciente;
    private Secundaria sec;
    // contructor 
    public ListaPaciente()
    {
        arrayPaciente = new ArrayList<Paciente>();
        sec = new Secundaria();
    }
//------------------------------------------------------------------------------
//metodos  
    public boolean existePaciente(String rut)//verifica si existe el paciente envia por parametro el rut
    {
        if(rut.equals("")==true)return false;
        if(arrayPaciente!=null)//la lista tiene pacientes
        {
            for(int i =0; i<arrayPaciente.size();i++)//recorre la lista de pacientes
            {
                if(arrayPaciente.get(i).getRut().equals(rut))//compara el rut del paciente de la lista con el rut enviado por parametro
                {
                    return false ;//existe el paciente en la lista
                }
            }
        }
        return true;//lista vacia no se encuentran pacientes 
    }
//------------------------------------------------------------------------------    
    public boolean agregarPacienteLista(String nombre,String rut,String nombreMadre,String nombrePadre,int edad,String sexo,Date fecha, String codigoCama)
    {
        //agrega al paciente con sus datos enviados por parametros
        if(rut.equals("")==true)return false;
        Paciente nuevo = new Paciente();
        nuevo.setEdad(edad);
        nuevo.setCodigoCama(codigoCama);
        nuevo.setFechaIngreso(fecha);
        if (validaString(nombre, "[^A-Za-z ]"))
            nuevo.setNombreCompleto(nombre);
        else
            return false; //nombre invalido        
        nuevo.setNombrePilaMadre(nombreMadre);
        nuevo.setNombrePilaPadre(nombrePadre);
        nuevo.setRut(rut);
        nuevo.setSexo(sexo);
        if(existePaciente(nuevo.getRut()))//verifica si existe el paciente
        {
            arrayPaciente.add(nuevo);//retorna de la lista el paciente agregado
            return true ;    
        }
        return false;//existe el paciente no se puede agregar
    }
//------------------------------------------------------------------------------   
//sobrecarga de metodo eliminar
    public boolean eliminarPacienteLista(Paciente nuevo)//retorna true o false si el paciente fue eliminado de la lista 
    {
        if(nuevo!=null)//la lista tiene pacientes
        {
            arrayPaciente.remove(nuevo);//elimina el paciente de la lista
            return true ;    
        }
        return false;//lista vacia no se encuentran pacientes
    }
//------------------------------------------------------------------------------
    public boolean eliminarPacienteLista(String rut)//retorna true o false si el paciente fue eliminado de la lista 
    {
        if(arrayPaciente!=null)//la lista tiene pacientes
        {
            for(int i=0;i<arrayPaciente.size();i++)
            {  
                if(arrayPaciente.get(i).getRut().equals(rut))//compara si el rut del paciente de la lista es el mismo enviado por parametro
                {
                    if(sec.eliminarArchivo("Archivos\\Paciente\\",rut)==true)
                    {
                        arrayPaciente.remove(i);// elimina el paciente de la lista
                        return true ;
                    }
                }
            } 
        }   
        return false;//lista vacia no se encuentran pacientes
    }
//------------------------------------------------------------------------------
    public Paciente buscarPaciente(String rut )//busca el paciente por el rut
    {
        if(arrayPaciente!=null)//la lista tiene pacientes
        {
            for(int i=0;i<arrayPaciente.size();i++)//recorre la lista pacientes
            {
                if(rut.equals(arrayPaciente.get(i).getRut()))//compara si el rut del paciente de la lista es el mismo enviado por parametro
                {
                    return arrayPaciente.get(i);//retorna el paciente
                }
            }
        }
        return null;//lista vacia no se encuentran pacientes
   
    }
//------------------------------------------------------------------------------
    public boolean modificarPaciente(String nombre,String rut,String nombreMadre,String nombrePadre,String edad,String sexo)
    {    
        if(rut!=null && buscarPaciente(rut)!=null)//el paciente tiene rut y lo busca dentro de la lista 
        {
            Paciente seleccionado=buscarPaciente(rut);
            if(nombre.equals("")==true&& nombreMadre.equals("")==true &&nombrePadre.equals("")==true &&edad.equals("")==true &&sexo.equals("")==true)return false;
            if(nombre.equals("")==false)seleccionado.setNombreCompleto(nombre);
            if(nombreMadre.equals("")==false)seleccionado.setNombrePilaMadre(nombreMadre);
            if(nombrePadre.equals("")==false)seleccionado.setNombrePilaPadre(nombrePadre);
            if(edad.equals("")==false)seleccionado.setEdad(Integer.parseInt(edad));
            if(sexo.equals("")==false)seleccionado.setSexo(sexo);
            return true;//retorna true si el paciente se pudo modificar
        }
        return false;//el paciente no existe en la lista 
    }
//------------------------------------------------------------------------------
    public boolean agregarCodigoCamaPaciente(String codigoCama,String rutPaciente)
    {
        Paciente seleccionado = buscarPaciente(rutPaciente);
        seleccionado.setCodigoCama(codigoCama);
        return true;
    }
    
    private boolean validaString(String entrada, String expRegular){
    
        //String entrada = " No para mi que triste yeah";
        //Pattern patron = Pattern.compile("[^A-Za-z ]");
        Pattern patron = Pattern.compile(expRegular);
        Matcher encaja = patron.matcher(entrada);
        
        if(!encaja.find())
            return true;
        else
            return false;
    }
}// fin clase ListaPaciente