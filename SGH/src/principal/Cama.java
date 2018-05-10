
package principal;

public class Cama 
{
    private int numeroCama;
    private boolean camaDisponible;
    private String codigoCama;
    private String especialidad;
    private String rutPaciente;
    
    public Cama()
    {
        numeroCama=0;
        codigoCama=null;
        camaDisponible=true;
        rutPaciente=null;
        especialidad=null;
    }
    
    public Cama(int numeroCama, String codigoCama, String rutPaciente, String especialidad)
    {
        this.numeroCama=numeroCama;
        this.codigoCama=codigoCama;
        this.especialidad=especialidad;
        this.rutPaciente=rutPaciente;
        
    }
    
    public void setNumeroCama(int numeroCama)
    {
        this.numeroCama=numeroCama;
    }
    
    public void setEspecialidad(String especialidad)
    {
        this.especialidad=especialidad;
    }
    
    public void setCodigoCama(String codigoCama)
    {
        this.codigoCama=codigoCama;
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
    
    public String getCodigoCama()
    {
        return codigoCama;
    }
    
    public boolean getCamaDisponible()
    {
        return getRutPaciente() == null;//retorna true si esta disponible, de lo contrario false
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public String ocuparCama(String rutPaciente)//ocupa una cama
    {
        if(getCamaDisponible()==true)//si la cama esta disponible
        {
            this.rutPaciente=rutPaciente;//se le asigna un paciente
            camaDisponible=false;//la cama deja de estar disponible
            return getCodigoCama();//retorna verdadero
        }
        return null;//la cama ya esta ocupada
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean vaciarCama()//desopucar cama
    {
        rutPaciente=null;//se elimina el paciente
        camaDisponible=true;//cama queda disponible
        return true;
    }
    //---------------------------------------------------------------------------------------------------------------------//   
}