package main.java.sgh;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import main.java.utiles.ResultS;
import main.java.utiles.Rut;
import java.util.*;

/**
 *
 * @author Rurikk
 */
public class Hospital {

    private ListaPersona listaPersona;
    private ListaHabitacion listaHabitacion;

    public Hospital() throws IOException, ParseException, SQLException {
        listaPersona = new ListaPersona();
        listaHabitacion = new ListaHabitacion();

//        cargarDatosBD("localhost", "3306", "rurikkcl_SGH", "root", "");
//        System.out.println(PersonasToString());
//        eliminarPersona(1461946);
//        //eliminarPersona(4567852);
//        System.out.println(PersonasToString());
//        modificarPersona(12545656, "asdasdasd", "Nombres");
//        modificarPersona(12545656, 12545656, "telefono");
//        modificarPersona(12545656, "LACTM", "email");
//        Rut ru = new Rut(16337396, '3');
//        Paciente p = new Paciente(
//                "Hombrecito",
//                "Gigante",
//                ru,
//                java.sql.Date.valueOf("1965-11-11"),
//                12312212,
//                "Hermanita",
//                44357343,
//                'F'
//        );
//        agregarPersona(p);
//        modificarPersona(16337396, "Juanitopereza", "Nombres");
//        eliminarPersona(16337396);
        //modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "","INSERT INTO `pacientes` (`rut`, `dv`, `nombres`, `apellidos`, `fechaNac`, `telefono`, `nombreContacto`, `telefonoContacto`, `sexo`) VALUES ('20958806', '4', 'Anastacia', 'Nyaa', '1975-06-14', '524587', 'Gato', '231221', 'M')");
//        System.out.println(PersonasToString());
    }

    /**
     *
     * Carga los datos desde la BD, los carga a la estructura
     *
     * @author Rurikk
     */
    public boolean cargarDatosBD(String url, String puerto, String bd, String user, String pass) throws SQLException {

        ConexionMySql mysql;
        ConexionSqlite sqlite;
        Conexion conect;

        String[] querys = new String[]{
            "select * from enfermeros;",
            "select * from medicos;",
            "select * from pacientes;",
            "select * from listapacientes;"
        };

        //Inicializa los objetos para conexion con los datos de los parametros
        mysql = new ConexionMySql(url, puerto, bd, user, pass);
        sqlite = new ConexionSqlite(url);

        //Inicializa el objecto conect con los datos de mysql y revisa si conecta
        conect = new Conexion(mysql);
        if (conect.getConexion() != null)
        {
            System.out.println("Conectado a MySql");
        } else { //Si no resulta, inicializa con sqlite  y revisa si conecta
            //conect.cerrarConexion();
            conect = new Conexion(sqlite);
            if (conect.getConexion() != null) {
                System.out.println("Conectado a SQlite");
            } else {
                //conect.cerrarConexion();
                return false;
            }
        }
        //conect.cerrarConexion();

        for (int i = 0; i < querys.length; i++) {
            String query = querys[i];

            //intenta ejecutar la query
            ResultSet rs = conect.ejecutarSelect(query);
            if (!agregarDatosAEstructura(rs)) {
                //Si tampoco resulta, retorna false
                //return false;
            }

        }
        return true;
    }

    /**
     *
     * Recorre un RS y los datos los agrega a donde corresponga
     *
     * @author Rurikk
     */
    private boolean agregarDatosAEstructura(ResultSet rs) throws SQLException {
        while (rs.next()) {
            //<editor-fold defaultstate="collapsed" desc="agregar Persona">
            if ("medicos".equalsIgnoreCase(rs.getMetaData().getTableName(1))) {
                Rut ru = new Rut(rs.getInt("rut"), rs.getString("dv").charAt(0));
                Medico p = new Medico(
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        ru,
                        java.sql.Date.valueOf(rs.getString("fechaNac")),
                        rs.getInt("telefono"),
                        rs.getString("email"),
                        rs.getString("especialidad")
                );
                listaPersona.agregarPersona(p);
                //System.out.println(p.toString());
            };
            if ("enfermeros".equalsIgnoreCase(rs.getMetaData().getTableName(1))) {
                Rut ru = new Rut(rs.getInt("rut"), rs.getString("dv").charAt(0));
                Enfermero p = new Enfermero(
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        ru,
                        java.sql.Date.valueOf(rs.getString("fechaNac")),
                        rs.getInt("telefono"),
                        rs.getString("email")
                );
                listaPersona.agregarPersona(p);
                //System.out.println(p.toString());
            };
            if ("pacientes".equalsIgnoreCase(rs.getMetaData().getTableName(1))) {
                Rut ru = new Rut(rs.getInt("rut"), rs.getString("dv").charAt(0));

                Paciente p = new Paciente(
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        ru,
                        java.sql.Date.valueOf(rs.getString("fechaNac")),
                        rs.getInt("telefono"),
                        rs.getString("nombreContacto"),
                        rs.getInt("telefonoContacto"),
                        rs.getString("sexo").charAt(0)
                );
                listaPersona.agregarPersona(p);
                //System.out.println(p.toString());
            };
            if ("listapacientes".equalsIgnoreCase(rs.getMetaData().getTableName(1))) {
                //System.out.println(rs.getInt("RutPaciente")+"\t"+rs.getInt("RutMedico"));
                listaPersona.agregarPacienteaMedico(rs.getInt("RutPaciente"), rs.getInt("RutMedico"));
            };
            //</editor-fold>
        }
        return false;

    }

    /**
     *
     * Intenta ejecutar la query de modificacion en la BD conexion en MySql
     *
     * @author Rurikk
     */
    public boolean modificarBD(String url, String puerto, String bd, String user, String pass, String query) throws SQLException {

        ConexionMySql mysql;
        ConexionSqlite sqlite;
        Conexion conect;

        //Inicializa los objetos para conexion con los datos de los parametros
        mysql = new ConexionMySql(url, puerto, bd, user, pass);
        sqlite = new ConexionSqlite(url);

        //Inicializa el objecto conect con los datos de mysql y revisa si conecta
        conect = new Conexion(mysql);
        if (conect.getConexion() == null) //Si no resulta, inicializa con sqlite  y revisa si conecta
        {
            //conect.cerrarConexion();
            conect = new Conexion(sqlite);
            if (conect.getConexion() == null) {
                //conect.cerrarConexion();
                return false;
            }
        }
        //conect.cerrarConexion();

        //intenta ejecutar la query
        Integer rs = conect.ejecutarUpdate(query);
        if (rs > 0) {
            //Si tampoco resulta, retorna false
            return true;
        }
        return false;
    }

    /**
     * Agrega la Persona; Medico,Paciente o Enfermero y realiza el cambio en la BD
     */
    public boolean agregarPersona(Persona p) throws SQLException {
        if (listaPersona.agregarPersona(p)) {

            if (p instanceof Paciente) {
                return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Insert into pacientes values ("
                        + p.getRutNum() + ",'"
                        + p.getDV() + "','"
                        + p.getNombres() + "','"
                        + p.getApellidos() + "','"
                        + p.getFechaNac() + "',"
                        + p.getTelefono() + ",'"
                        + ((Paciente) p).getNombreContacto() + "',"
                        + ((Paciente) p).getTelefonoContacto() + ",'"
                        + ((Paciente) p).getSexo() + "'"
                        + ");");
            }
            if (p instanceof Enfermero) {
                return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Insert into pacientes values ("
                        + p.getRutNum() + ",'"
                        + p.getDV() + "','"
                        + p.getNombres() + "','"
                        + p.getApellidos() + "','"
                        + p.getFechaNac() + "',"
                        + p.getTelefono() + ",'"
                        + ((Enfermero) p).getEmail() + "'"
                        + ");");
            }
            if (p instanceof Medico) {
                return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Insert into pacientes  values ("
                        + p.getRutNum() + ",'"
                        + p.getDV() + "','"
                        + p.getNombres() + "','"
                        + p.getApellidos() + "','"
                        + p.getFechaNac() + "',"
                        + p.getTelefono() + ",'"
                        + ((Medico) p).getEmail() + "','"
                        + ((Medico) p).getEspecialidad() + "'"
                        + ");");
            }
        }
        return false;
    }

    /**
     * Modifica la Persona y realiza el cambio en la BD
     *
     * @param rutNum Integer parte numerica del rut de la persona a modificar
     * @param atributoAModificar Object, cualquier tipo de objeto que se debe
     * modificar
     * @param nombreAtributo String, si se modifica Nombres o Apellidos, enviar
     * "Nombres" o "Apellidos"
     * @return boolean
     *
     */
    public boolean modificarPersona(Integer rutNum, Object atributoAModificar, String nombreAtributo) throws SQLException {

        if (listaPersona.modificarPersona(rutNum, atributoAModificar, nombreAtributo)) {

            if (atributoAModificar instanceof String) {
                atributoAModificar = "'" + atributoAModificar + "'";
            }

            if (listaPersona.buscarPersona(rutNum) instanceof Enfermero) {
                return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Update enfermeros  SET " + nombreAtributo + "= " + atributoAModificar + " where rut=" + rutNum);
            }

            if (listaPersona.buscarPersona(rutNum) instanceof Paciente) {
                return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Update pacientes  SET " + nombreAtributo + "= " + atributoAModificar + " where rut=" + rutNum);
            }

            if (listaPersona.buscarPersona(rutNum) instanceof Medico) {
                return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Update medicos  SET " + nombreAtributo + "= " + atributoAModificar + " where rut=" + rutNum);
            }
        }
        return false;
    }

    /**
     * Elimina la Persona segun numero de Rut y realiza el cambio en la BD
     *
     * @author Rurikk
     * @param rutNum Integer, enviar parte Numerica del Rut
     */
    public boolean eliminarPersona(Integer rutNum) throws SQLException {
        Persona n = listaPersona.buscarPersona(rutNum);
        if (listaPersona.eliminarPersona(rutNum)) {

            if (n instanceof Enfermero) {
                return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Delete from enfermeros where rut=" + rutNum);
            }

            if (n instanceof Paciente) {
                return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Delete from pacientes where rut=" + rutNum);
            }

            if (n instanceof Medico) {
                return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Delete from medicos where rut=" + rutNum);
            }
        }
        return false;
    }

    /**
     * Muestra todas las personas, ejecutar con un SoutPtrint
     *
     * @author Rurikk
     */
    public String PersonasToString() {
        return listaPersona.toString();
    }
    
    /*
     * Métodos que trabajan con la lista de habitaciones 
     * 
     */
    
    public boolean agregarHabitacionConsulta(String id, String especialidad, String rutMedico)
    {
    	listaHabitacion.agregarHabitacionConsulta(id, especialidad, rutMedico);
    	return (listaHabitacion.agregarHabitacionConsulta(id, especialidad, rutMedico));
    }
    
    public boolean agregarHabitacionHospitalizados(String id, String especialidad, String rutEnfermero, int capacidad)
    {
    	listaHabitacion.agregarHabitacionHospitalizados(id, especialidad, rutEnfermero, capacidad);
    	return(listaHabitacion.agregarHabitacionHospitalizados(id, especialidad, rutEnfermero, capacidad));
    }
    
    public boolean eliminarHabitacion(String id)
    {
    	listaHabitacion.eliminarHabitación(id);
    	return(listaHabitacion.eliminarHabitación(id));
    }
    
    public Habitacion mostrarHabitacionPorPosicion(int posicion) //Muestra una habitación en la posición de la lista deseada
    {
    	return listaHabitacion.mostrarHabitacion(posicion);
    }
    
    public Habitacion mostrarHabitacionPorId(String idHabitacion) //Muestra una habitación por la id indicada
    {
    	return listaHabitacion.mostrarHabitacion(idHabitacion);
    }
    
    public int cantidadHabitacionesHospitalizados()
    {
    	return listaHabitacion.contarHabitacionesHospitalizados();
    }
    
    public int cantidadHabitacionesConsulta()
    {
    	return listaHabitacion.contarHabitacionesConsulta();
    }
    
    public boolean darDeAltaPaciente(String rutPaciente)
    {
    	listaHabitacion.darDeAlta(rutPaciente);
    	return (listaHabitacion.darDeAlta(rutPaciente));
    }
    
    public boolean darDeAltaCama(int numeroCama)
    {
    	listaHabitacion.darDeAlta(numeroCama);
    	return (listaHabitacion.darDeAlta(numeroCama));
    }
    
    public boolean agregarCamaHospitalizados(String idHabitacion, int numeroCama, String especialidad, String rutPaciente)
    {
    	listaHabitacion.agregarCamaHospitalizados(idHabitacion, numeroCama, especialidad, rutPaciente);
    	return(listaHabitacion.agregarCamaHospitalizados(idHabitacion, numeroCama, especialidad, rutPaciente));
    }
    
    public Cama buscarCamaEspecifica(int numeroCama)
    {
    	return(listaHabitacion.buscarCamaEspecifica(numeroCama));
    }
    
    public Cama buscarCamaDisponible()
    {
    	return(listaHabitacion.buscarCamaDisponible());
    }
    
    public boolean ocuparCama(int numeroCama, String rutPaciente)
    {
    	listaHabitacion.ocuparCama(numeroCama, rutPaciente);
    	return(listaHabitacion.ocuparCama(numeroCama, rutPaciente));
    }
    
    public boolean eliminarCamaHospitalizados(int numeroCama)
    {
    	listaHabitacion.eliminarCamaHospitalizados(numeroCama);
    	return(listaHabitacion.eliminarCamaHospitalizados(numeroCama));
    }
    
    public Cama eliminarObjetoCamaHospitalizados(int numeroCama)
    {
    	listaHabitacion.eliminarObjetocamaHospitalizados(numeroCama);
    	return(listaHabitacion.eliminarObjetocamaHospitalizados(numeroCama));
    }
    
    public void modificarCamillaConsulta(int numeroCama, boolean disponibilidad, String especialidad)
    {
    	listaHabitacion.modificarCamillaConsulta(numeroCama, disponibilidad, especialidad);
    }
    
    public boolean ocuparCamillaConsulta(String idHabitacion, String rutPaciente)
    {
    	listaHabitacion.ocuparCamillaConsulta(idHabitacion, rutPaciente);
    	return(listaHabitacion.ocuparCamillaConsulta(idHabitacion, rutPaciente));
    }
    
    
    
    
    
    
    
}
