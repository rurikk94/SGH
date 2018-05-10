
package principal;

import java.util.ArrayList;


public class ListaFuncionario implements AccionesFuncionario {
    
    
    ArrayList<Funcionario> listaFuncionario;
    
    public ListaFuncionario(){
        
        
        listaFuncionario = new ArrayList();
            
    }
    
    @Override
    public boolean existe(String rut)
    {   
        if(listaFuncionario!=null)
        {
            for(int i =0; i<listaFuncionario.size();i++)
            {
                if(listaFuncionario.get(i).getRut().equals(rut))
                {
                    return false ;// existe el medico en la lista 
                }
            }
        }    
        return true;//no existe el medico en la lista 
    }
//------------------------------------------------------------------------------    
    @Override
    public boolean agregarLista(String nombre,String rut,String sexo)
    { 
        if(rut.equals("")==true)return false;
        Medico nuevo = new Medico();
        nuevo.setNombre(nombre);
        nuevo.setRut(rut);
        nuevo.setSexo(sexo);
        if(existe(nuevo.getRut()))
        {
            listaFuncionario.add(nuevo);
            return true ;    
        }
        return false;
    }

//------------------------------------------------------------------------------
    @Override
    public boolean eliminarLista(String rut)
    {
        if(listaFuncionario!=null)
        {
            for(int i=0;i<listaFuncionario.size();i++)
            {  
                if(listaFuncionario.get(i).getRut().equals(rut))
                {
                     listaFuncionario.remove(i);//elimina el medico de la lista 
                     return true ;
                
                } 
            }   
        }
        return false;
    }
//------------------------------------------------------------------------------
    @Override
    public Funcionario buscar(String rut )
    {
        if(rut.equals("")==true)return null;
        if(listaFuncionario!=null)
        {
            for(int i=0;i<listaFuncionario.size();i++)
            {
                if(rut.equals(listaFuncionario.get(i).getRut()))
                {
                    return listaFuncionario.get(i);
                }
            }
        }
        return null;   
    }
//------------------------------------------------------------------------------
    @Override
    public boolean modificar(String nombre, String rut, String sexo)
    {    
        if(rut.equals("")==true)return false;
        if(buscar(rut)!=null)
        {
            Funcionario seleccionado = buscar(rut);
            if(nombre.equals("")==true && sexo.equals("")==true)return false;
            if(nombre.equals("")==false)seleccionado.setNombre(nombre);
            if(sexo.equals("")==false)seleccionado.setSexo(sexo);
            return true;
        }
        return false;
    }
    
}
