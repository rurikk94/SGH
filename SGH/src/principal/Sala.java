
package principal;

public class Sala 
{
    private String nombreSala;
    private String especialidad;
    private int numeroSala;
    private int capacidadDeCamas;
    private int piso;
    private String rutDoctor;
    private ListaCama listaCama;
    
    public Sala()
    {
        nombreSala=null;
        numeroSala=0;
        capacidadDeCamas=0;
        piso=0;
        rutDoctor= null;
        listaCama= new ListaCama();
        especialidad=null;
    }
    
    public Sala(String nombreSala, int capacidadDeCamas, int numeroSala, String rutDoctor, String especialidad,int piso)
    {
        this.nombreSala=nombreSala;
        this.piso=piso;
        this.capacidadDeCamas=capacidadDeCamas;
        this.numeroSala=numeroSala;
        this.rutDoctor=rutDoctor;
        this.especialidad=especialidad;
        listaCama = new ListaCama();
    }
    
    public void setPiso(int piso)
    {
        this.piso=piso;
    }
    
    public void setNombreSala(String nombreSala)
    {
        this.nombreSala=nombreSala;
    }
    
    public void setEspecialidad(String especialidad)
    {
        this.especialidad=especialidad;
    }
    
    public void setNumeroSala(int numeroSala)
    {
        this.numeroSala=numeroSala;
    }
    
    public void setRutDoctor(String rutDoctor) //obtengo el rut del doctor asignado a la sala
    { 
        this.rutDoctor=rutDoctor;
    }
    
    public void setTotalCamas(int capacidadDeCamas)
    {
        this.capacidadDeCamas=capacidadDeCamas;
    }
    
    public int getPiso()
    {
        return piso;
    }
    
    public String getNombreSala()
    {
        return nombreSala;
    }
    
    public int getNumeroSala()
    {
        return numeroSala;
    }
    
    public String getEspecialidad()
    {
        return especialidad;
    }
    
    public String getRutDoctor()//envía el rut
    { 
        return rutDoctor;
    }
    
    public int getCapacidadMaxima()
    {
        return capacidadDeCamas;
    }
    
    public int getCantidadActual()
    {
        return listaCama.getTotalCama();
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean agregarCama(int numeroCama,String codigoVerificador,String rutPaciente,String especialidad) //retorna verdadero si agrega la cama, sino false
    {
        if(getCantidadActual()<getCapacidadMaxima())//si existe espacio en la sala
        {
            if(listaCama.agregarCama(numeroCama,codigoVerificador,rutPaciente,especialidad)==true)
                return true; //retorna verdadero si se agrego, si no, false
        }
        return false;//no se agrego
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean vaciarCama(String codigoCama)//retorna verdero o falso, si es que se vacia o no una cama
    {
        return listaCama.vaciarCama(codigoCama);//vacia la cama
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public String agregarPacienteACama(String rutPaciente)//retornara true/false si se pudo agregar o no el paciente a la cama
    {
        return listaCama.agregarPacienteACama(rutPaciente);//agrega un paciente a la primera cama disponible
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public int getNumeroCamasDisponibles()//retorna el numero de camas disponibles 
    {
        return listaCama.getNumeroCamasDisponibles();//obtiene el numero de camas disponibles para ser ocupadas
    }
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean buscarCamaRepetida(String codigoCama)//retorna true/false si es que la cama existe o no
    {
        return listaCama.buscarCamaRepetida(codigoCama);//llama al metodo buscarCamaRepetida
    }
     //---------------------------------------------------------------------------------------------------------------------//
    public boolean eliminarCama(String codigoCama)//retorna true/false si es que la camma llego a ser eliminada
    {
        return listaCama.eliminarCama(codigoCama);//llama al metodo eliminarCama
    }
    public Cama buscarCamaEspecifica(String codigoCama)
    {
        return listaCama.buscarCamaEspecifica(codigoCama);//retorna null o la cama buscada
    }
}