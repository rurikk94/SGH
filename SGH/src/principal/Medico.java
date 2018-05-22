
package principal;

import java.util.ArrayList;

public class Medico extends Funcionario
{
   
    //private String especialidad;
    private Paciente arrPaciente[]; //Arreglo que referencia a los pacientes del medico que estan en el ArraList ListaPersona
    
    
    //contructores 
    public Medico(String nombres, String apellidos, String rut, String fechaNac, String telefono, String email, String especialidad)
    {
        super(nombres, apellidos, rut, fechaNac, telefono, email, especialidad);
        arrPaciente = new Paciente[10]; //Verificar la cantidad de pacientes por medico
      
    }
 ------------------------------------------------------------
//metodos getter y setter  
//------------------------------------------------------------------------------
  
    
 
//------------------------------------------------------------------------------      
}//fin clase Médico