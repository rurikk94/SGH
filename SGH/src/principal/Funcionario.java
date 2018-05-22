
package principal;

public class Funcionario extends Persona 
{
	
    private String email;
    private String especialidad;
    
    public Funcionario(String nombres, String apellidos, String rut, String fechaNac, String telefono, String email, String especialidad)
    {
    	super(nombres, apellidos, rut, fechaNac, telefono);
        this.email = email;
        this.especialidad = especialidad;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }
    
    public String getEspecialidad() 
    {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) 
    {
        this.especialidad = especialidad;
    }
    
    
    
}
