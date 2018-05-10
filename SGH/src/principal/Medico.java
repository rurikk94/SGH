
package principal;

public class Medico extends Funcionario
{
   
    private String especialidad;
    
    //contructores 
    public Medico()
    {
        super("","","");
        especialidad=null;
        
        
    }
    
    public Medico(String nombre,String rut,String especialidad,String sexo )
    {
        
        super (nombre,rut,sexo);
        this.especialidad=especialidad;
        
    }
//------------------------------------------------------------------------------
//metodos getter y setter  
//------------------------------------------------------------------------------
  
    
    public void setEspecialidad(String especialidad)
    {
        this.especialidad=especialidad;
    }
    
    public String getEspecialidad()
    {
        return especialidad;
    }
    
//------------------------------------------------------------------------------      
}//fin clase Médico