
package principal;

import java.util.Date;

public class Paciente 
{ 
    private String nombreCompleto;
    private String rut;
    private String nombrePilaMadre;// el nombre pila es el primer nombre de la madre 
    private String nombrePilaPadre;
    private int edad;
    private String sexo;
    private Date fechaIngreso; 
    private String codigoCama;
    // contructores
    public Paciente()
    {
        nombreCompleto=null;
        rut=null;
        nombrePilaMadre=null;
        nombrePilaPadre=null;
        fechaIngreso=null;
        edad=0;
        sexo=null;
        codigoCama=null;
    }
   
    public Paciente(String nombreCompleto,String rut,String nombrePilaMadre,String nombrePilaPadre,int edad,String sexo,Date fechaIngreso, String codigoCama)
    {
       
        this.nombreCompleto=nombreCompleto;
        this.rut=rut;
        this.nombrePilaMadre=nombrePilaMadre;
        this.nombrePilaPadre=nombrePilaPadre;
        this.edad=edad;
        this.sexo=sexo;
        this.fechaIngreso=fechaIngreso;
        this.codigoCama=codigoCama;
    }
//------------------------------------------------------------------------------
//metodos getter y setter
//------------------------------------------------------------------------------
    public void setNombreCompleto(String nombre)
    {
        this.nombreCompleto=nombre;
    }
   
    public void setRut(String rut)
    {
        this.rut=rut;
    }
   
    public void setNombrePilaMadre(String nombrePilaMadre)
    {
        this.nombrePilaMadre=nombrePilaMadre;
    }
   
    public void setNombrePilaPadre(String nombrePilaPadre)
    {
        this.nombrePilaPadre=nombrePilaPadre;
    }
   
    public void setEdad(int edad)
    {
        this.edad=edad;
    }
   
    public void setSexo(String sexo)
    {
        this.sexo=sexo;
    }
   
    public void setFechaIngreso(Date fechaIngreso)
    {
        this.fechaIngreso=fechaIngreso;
    }
    
    public String getNombreCompleto()
    {
        return nombreCompleto;
    }
   
    public String getRut()
    {
        return rut;
    }
   
    public String getNombrePilaMadre()
    {
        return nombrePilaMadre;
    }
   
    public String getNombrePilaPadre()
    {
        return nombrePilaPadre;
    }
    
    public int getEdad()
    {
        return edad;
    }
   
    public String getSexo()
    {
        return sexo;
    }

    public Date getFechaIngreso()
    {
        return fechaIngreso;
    }
    
    public String getCodigoCama() 
    {
        return codigoCama;
    }
    
    public void setCodigoCama(String codigoCama) 
    {
        this.codigoCama = codigoCama;
    }
//------------------------------------------------------------------------------
}//fin clase Paciente