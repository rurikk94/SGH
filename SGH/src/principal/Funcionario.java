
package principal;

public abstract class Funcionario {
    
    private String nombre;
    private String rut;
    private String sexo;
    
    public Funcionario (String nombre, String rut, String sexo)
    {
        this.nombre = nombre;
        this.rut = rut;
        this.sexo = sexo;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getRut() 
    {
        return rut;
    }

    public void setRut(String rut) 
    {
        this.rut = rut;
    }

    public String getSexo() 
    {
        return sexo;
    }

    public void setSexo(String sexo) 
    {
        this.sexo = sexo;
    }
    
}
