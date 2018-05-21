
package principal;

public class Cama 
{
    private int numeroCama;
    private boolean camaDisponible;
    private String especialidad;
    private String rutPaciente;
    
    public Cama()
    {
        numeroCama=0;
        camaDisponible=true;
        rutPaciente=null;
        especialidad=null;
    }
    
    public Cama(int numeroCama, boolean camaDisponible, String rutPaciente, String especialidad)
    {
        this.numeroCama=numeroCama;
        this.camaDisponible=camaDisponible;
        this.especialidad=especialidad;
        this.rutPaciente=rutPaciente;
        
    }
    
    public void setNumeroCama(int numeroCama)
    {
        this.numeroCama=numeroCama;
    }
    
    public void setCamaDisponible(boolean camaDisponible)
    {
    	this.camaDisponible=camaDisponible;
    }
    
    public void setEspecialidad(String especialidad)
    {
        this.especialidad=especialidad;
    }
    
    public void setRutPaciente(String rutPaciente)
    {
        this.rutPaciente=rutPaciente;
    }
    
    public int getNumeroCama()
    {
        return numeroCama;
    }
    
    public String getEspecialidad()
    {
        return especialidad;
    }
    
    public String getRutPaciente()
    {
        return rutPaciente;
    }
    
    public boolean getCamaDisponible()
    {
        return camaDisponible;//retorna true si esta disponible, de lo contrario false
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public void ocuparCama(String rutPaciente)//ocupa una cama
    {
    	if(this.camaDisponible == true)
    	{
    		this.rutPaciente=rutPaciente;//se le asigna un paciente a la cama
    	    this.camaDisponible=false;//la cama deja de estar disponible        		
    	}
           
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public void vaciarCama()//desocupar cama
    {
    	if(this.camaDisponible == false)
    	{
    		this.rutPaciente=null;//se elimina el paciente
            this.camaDisponible=true;//cama queda disponible
    		
    	}
    }
    //---------------------------------------------------------------------------------------------------------------------//   
}