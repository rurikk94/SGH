
package principal;

import java.util.ArrayList;

public class Medico extends Funcionario
{
   
    //private String especialidad;
    private ArrayList<Paciente> listaPacientes;
    
    
    //contructores 
    public Medico(String nombres, String apellidos, String rut, String fechaNac, String telefono, String email, String especialidad)
    {
        super(nombres, apellidos, rut, fechaNac, telefono, email, especialidad);
        listaPacientes = new ArrayList<Paciente>();
      
    }
 ------------------------------------------------------------
//metodos getter y setter  
//------------------------------------------------------------------------------
  
    
 
//------------------------------------------------------------------------------      
}//fin clase Médico