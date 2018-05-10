
package principal;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class Hospital 
{   
   private ListaPaciente listaPaciente; 
   private ListaFuncionario listaFuncionario;
   private ListaSala listaSala;
   private Archivos arc; 
//------------------------------------------------------------------------------
    public Hospital() throws IOException, ParseException
    {
       listaFuncionario = new ListaFuncionario() ;
       listaPaciente = new ListaPaciente();
       listaSala = new ListaSala();
       arc= new Archivos();
       arc.cargaTextoPaciente(this);
       arc.cargaTextoSala(this);
       arc.cargaTextoCama(this);
       arc.cargaTextoFuncionario(this);
       listaSala.totalPacienteHospital();
    }
//se invocan a todos los metodos de la listaPaciente
//------------------------------------------------------------------------------
    public boolean existePaciente(String rut)
    {
        return listaPaciente.existePaciente(rut);
    }
//------------------------------------------------------------------------------
    public boolean agregarPaciente(String nombre,String rut,String nombreMadre,String nombrePadre,int edad,String sexo,Date fecha, String codigoCama)
    {
        return listaPaciente.agregarPacienteLista(nombre,rut,nombreMadre,nombrePadre,edad,sexo,fecha,codigoCama);
    }
//------------------------------------------------------------------------------
    public boolean eliminarPaciente(Paciente nuevoPaciente)
    {
        return listaPaciente.eliminarPacienteLista(nuevoPaciente);
    }
//------------------------------------------------------------------------------
    public boolean eliminarPaciente(String rut)
    {
        return listaPaciente.eliminarPacienteLista(rut);   
    }
//------------------------------------------------------------------------------
    public Paciente buscarPaciente(String rut )
    {
        return listaPaciente.buscarPaciente(rut);
    }
//------------------------------------------------------------------------------
    public boolean modificarPaciente(String nombre,String rut,String nombreMadre,String nombrePadre,String edad,String sexo)
    {    
        return listaPaciente.modificarPaciente(nombre,rut,nombreMadre,nombrePadre,edad,sexo);
    }
//------------------------------------------------------------------------------
// se invocan a todos los metodos de la lista Medico
//------------------------------------------------------------------------------
    public boolean existe(String rut)
    {
        return listaFuncionario.existe(rut);
    }   
//------------------------------------------------------------------------------    
    public boolean agregarLista(String nombre,String rut,String sexo)
    {
        return listaFuncionario.agregarLista(nombre,rut,sexo);
    }
//------------------------------------------------------------------------------
    public boolean eliminarLista(String rut)
    {    
        return listaFuncionario.eliminarLista(rut);
    }
//------------------------------------------------------------------------------
    public Funcionario buscar(String rut )
    {
        return listaFuncionario.buscar(rut);
    }    
    
    public boolean modificar(String nombre, String rut, String sexo)
    {
        return listaFuncionario.modificar(nombre,rut,sexo);
    }
//------------------------------------------------------------------------------    

  
//------------------------------------------------------------------------------
// se invocan a todos los metodos de la lista sala
//------------------------------------------------------------------------------
    public boolean buscarSalaRepetida(int numeroSala)
    {
        return listaSala.buscarSalaRepetida(numeroSala);
    }
//------------------------------------------------------------------------------
    public Sala buscarSala(int numeroSala)
    {    
        return listaSala.buscarSala(numeroSala);
    }
//------------------------------------------------------------------------------    
    public boolean agregarSala(String nombreSala,int capacidadMaxima,int numero,String rutDoctor,String sector,int nivel)
    {
        return listaSala.agregarSala(nombreSala,capacidadMaxima,numero,rutDoctor,sector,nivel);
    }
//------------------------------------------------------------------------------
    public boolean agregarCama(int numeroSala,int numeroCama, String codigoVerificador,String rutPaciente, String especialidad)
    {
        return listaSala.agregarCama(numeroSala, numeroCama, codigoVerificador, rutPaciente, especialidad);   
    }    
//-----------------------------------------------------------------------------
    public boolean asignarDoctor(String rutDoctor, int numeroSala)
    {
        return listaSala.asignarDoctor(rutDoctor, numeroSala);   
    }
//------------------------------------------------------------------------------
    public boolean asignarEspacioDeSala(int capacidad, int numeroSala)
    {
        return listaSala.asignarEspacioDeSala(capacidad, numeroSala);
    }
//------------------------------------------------------------------------------
    public boolean especialidadDeLaSala(String especialidad, int numeroSala)
    {
        return listaSala.especialidadDeLaSala(especialidad, numeroSala);
    }
//------------------------------------------------------------------------------
    public Sala buscarSalaPorDisponibilidadDeCama(String especialidad)
    {
        return listaSala.buscarSalaPorDisponibilidadDeCama(especialidad);
    }
//------------------------------------------------------------------------------
    public boolean agregarPacienteACama(String especialidad, String rutPaciente)
    {
        String codigoCama = listaSala.agregarPacienteACama(especialidad, rutPaciente);
        if(codigoCama!=null)
        {
            return agregarCodigoCamaPaciente(codigoCama,rutPaciente)==true;
        }
       return false;
    }
//------------------------------------------------------------------------------
    public boolean agregarCodigoCamaPaciente(String codigoCama,String rutPaciente)
    {
        return listaPaciente.agregarCodigoCamaPaciente(codigoCama,rutPaciente);
    }
//------------------------------------------------------------------------------
    public boolean eliminarCama(String codigoCama)
    {
        return listaSala.eliminarCama(codigoCama);
    }
//------------------------------------------------------------------------------
    public Cama buscarCamaEspecifica(String codigoCama)
    {
        return listaSala.buscarCamaEspecifica(codigoCama);
    }
}//fin clase Hospital