
package principal;

import java.util.Date;

public class Paciente extends Persona  
{ 
	private String nombreContacto;
	private String telefonoContacto;
    private String sexo;
/*	private String nombrePilaMadre; 
    private String nombrePilaPadre;
	private Date fechaIngreso; 
    private String codigoCama;		*/
  
    public Paciente(String nombres, String apellidos, String rut, String fechaNac, String telefono, String nombreContacto, String telefonoContacto, String sexo)
    {
    	super(nombres, apellidos, rut, fechaNac, telefono);
        this.nombreContacto = nombreContacto;
        this.telefonoContacto = telefonoContacto;
        this.sexo = sexo;
    }
  //------------------------------------------------------------------------------
  //metodos getter y setter
  //------------------------------------------------------------------------------

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
   

//------------------------------------------------------------------------------
}//fin clase Paciente