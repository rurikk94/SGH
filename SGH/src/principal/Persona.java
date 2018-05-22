package principal;

public abstract class Persona 
{
	private String nombres;
	private String apellidos;
	private String rut;
	private String fechaNac;
	private String telefono;
	
	public Persona(String nombres, String apellidos, String rut, String fechaNac, String telefono) 
	{

		this.nombres = nombres;
		this.apellidos = apellidos;
		this.rut = rut;
		this.fechaNac = fechaNac;
		this.telefono = telefono;
	}

	public String getNombres() 
	{
		return nombres;
	}

	public void setNombres(String nombres) 
	{
		this.nombres = nombres;
	}

	public String getApellidos() 
	{
		return apellidos;
	}

	public void setApellidos(String apellidos) 
	{
		this.apellidos = apellidos;
	}

	public String getRut() 
	{
		return rut;
	}

	public void setRut(String rut) 
	{
		this.rut = rut;
	}

	public String getFechaNac() 
	{
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) 
	{
		this.fechaNac = fechaNac;
	}

	public String getTelefono() 
	{
		return telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
	
	
	
	

}
