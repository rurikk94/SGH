package main.java.sgh;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import main.java.utiles.Rut;
import main.java.utiles.Informe;
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
//        cargarDatosBD("","", "", "", "");        //carga los datos desde BD
//        
//        //System.out.println(hospi.PersonasToString());   //muestra los datos por consola
//        Rut r2 = new Rut("1000100");
//        agregarHabitacionConsulta("consulta1", "especialidadUno", r);//String id, String especialidad, String rutMedico
//        agregarHabitacionHospitalizados("hospitalizado1", "especialidadDos", r2, 3);//String id,  especialidad,  rutEnfermero, int capacidad
//        
//        System.out.println("cant Consultas: "+ cantidadHabitacionesConsulta());
//        System.out.println("cant hospiatales: "+ cantidadHabitacionesHospitalizados());
//        System.out.println(" hospiatales: "+ mostrarHabitacionPorId("consulta1").toString());

//        Rut r = new Rut("1234545");
//        agregarHabitacionConsulta("consulta1", "especialidadUno", r);//String id, String especialidad, String rutMedico
//
//        System.out.println(PersonasToString());
//        System.out.println("cant Consultas: "+ cantidadHabitacionesConsulta());
//        System.out.println("cant Hospitalizados: "+ cantidadHabitacionesHospitalizados());
//        System.out.println(mostrarHabitacionPorId("C1").toString());
//        System.out.println(mostrarHabitacionPorId("C2").toString());
//        System.out.println(mostrarHabitacionPorId("consulta1").toString());
        
//        String s = mostrarHabitacionPorId("H1").toString();
//        System.out.println(s);
//        
//         s = mostrarHabitacionPorId("hospitalizado1").toString();
//        System.out.println(s);
//        System.out.println("cant hospitalizados: "+ cantidadHabitacionesHospitalizados());
//        System.out.println("cant consultas: "+ cantidadHabitacionesConsulta());
//        
//        eliminarHabitacion("H1");
        
        
//        System.out.println("cant hospitalizados: "+ cantidadHabitacionesHospitalizados());
//        System.out.println("cant consultas: "+ cantidadHabitacionesConsulta());    
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
            "select * from listapacientes;",
            "select * from consulta;",
            "select * from hospitalizados;",
            "select * from cama;"                
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
            //<editor-fold defaultstate="collapsed" desc="agregar Habitacion">
            if ("consulta".equalsIgnoreCase(rs.getMetaData().getTableName(1))) {            
                String id = rs.getString("idConsulta");
                String especialidad = rs.getString("especialidad");
                Rut rut = new Rut(rs.getInt("rutMedico"), rs.getString("dv").charAt(0));    
                listaHabitacion.agregarHabitacionConsulta(id,especialidad,rut);
                //System.out.println(p.toString());
            };
            if ("hospitalizados".equalsIgnoreCase(rs.getMetaData().getTableName(1))) {            
                String id = rs.getString("idHospitalizados");
                boolean disponibilidad = true;
                if (rs.getInt("disponibilidad")!=1){
                    disponibilidad = false;
                }
                String especialidad = rs.getString("especialidad");
                int capacidad = rs.getInt("capacidad");
                Rut rutEnfermero = new Rut(rs.getInt("rutEnfermero"), rs.getString("dv").charAt(0));    
                listaHabitacion.agregarHabitacionHospitalizados(id, especialidad, rutEnfermero, capacidad);
                //System.out.println(p.toString());
            };
            if ("cama".equalsIgnoreCase(rs.getMetaData().getTableName(1))) {
                int numeroCama = (rs.getInt("numeroCama"));
                String idHabitacion = (rs.getString("idHabitacion"));
//                boolean disponibilidad = true;
//                if (rs.getInt("camaDisponible")!=1){
//                    disponibilidad = false;
//                }
                String especialidad = (rs.getString("especialidad"));
                listaHabitacion.modificarCamillaConsulta(idHabitacion,numeroCama, true, especialidad);
                Rut rut = null;
                if ((rs.getString("rutPaciente"))!=null){
                    rut = new Rut(rs.getInt("rutPaciente"), rs.getString("dv").charAt(0));
                    listaHabitacion.ocuparCamillaConsulta(idHabitacion, rut);
                }
                listaHabitacion.agregarCamaHospitalizados(idHabitacion, numeroCama, especialidad, rut);
                //System.out.println(p.toString());
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
        int rs = conect.ejecutarUpdate(query);
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
                return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Insert into enfermeros values ("
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
                return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Insert into medicos  values ("
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
     * @return boolean
     *
     */
    public boolean modificarPersona(int rutNum, String nombres, String apellidos, java.sql.Date fechaNac, int fono, String contacto, int fonoContacto, char sexo, String email, String especialidad) throws SQLException {

        if (listaPersona.modificarPersona(rutNum, nombres, apellidos, fechaNac, fono, contacto, fonoContacto, sexo, email, especialidad)) {

            String coma="";
            String query = "Update ";
            
            if (listaPersona.buscarPersona(rutNum) instanceof Enfermero) {
                query+= "enfermeros  SET ";
            }

            if (listaPersona.buscarPersona(rutNum) instanceof Paciente) {
                query+= "pacientes  SET ";
            }

            if (listaPersona.buscarPersona(rutNum) instanceof Medico) {
                query+= "medicos  SET ";
            }
            if (nombres != null){
                query+= " nombres = '" + nombres + "'"; coma=",";}
            if (apellidos != null){
                query+= coma+" apellidos = '" + apellidos + "'"; coma=",";}
            if (fechaNac != null){
                query+= coma+" fechaNac = '" + fechaNac + "'"; coma=",";}
            if (fono != 0){
                query+= coma+" telefono = " + fono; coma=",";}
            if (email != null){
                query+= coma+" email = '" + email + "'"; coma=",";}
            if (especialidad != null){
                query+= coma+" especialidad = '" + especialidad + "'"; coma=",";}
            if (contacto != null){
                query+= coma+" nombreContacto = '" + contacto + "'"; coma=",";}
            if (fonoContacto != 0){
                query+= coma+" telefonoContacto = " + fonoContacto; coma=",";}
            if (sexo !='\u0000') {
                query+= coma+" sexo = '" + sexo+"'"; coma=",";}
            
            query+=" where rut=" + rutNum;
            return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", query);
        }
        return false;
    }

    /**
     * Elimina la Persona segun numero de Rut y realiza el cambio en la BD
     *
     * @author Rurikk
     * @param rutNum int, enviar parte Numerica del Rut
     */
    public boolean eliminarPersona(int rutNum) throws SQLException {
        Persona n = listaPersona.buscarPersona(rutNum);
        if (listaPersona.eliminarPersona(rutNum)) {
            Rut rut = new Rut(rutNum);

            if (n instanceof Enfermero) {
                eliminarEnfermeroHospitalizados(rut);
                return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Delete from enfermeros where rut=" + rutNum);
            }

            if (n instanceof Paciente) {
                darDeAltaPaciente(rut);
                return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Delete from pacientes where rut=" + rutNum);
            }

            if (n instanceof Medico) {
                eliminarMedicoConsulta(rut);
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
    public String personasToString() {
        try {
            return listaPersona.toString();            
        } catch (Exception e) {
            return "";
        }
    }
    
    /*
     * Métodos que trabajan con la lista de habitaciones 
     * 
     */
    
    public boolean agregarHabitacionConsulta(String id, String especialidad, Rut rutMedico) throws SQLException
    {
    	if (listaHabitacion.agregarHabitacionConsulta(id, especialidad, rutMedico))
            {
                return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Insert into consulta values ('"
                        + id+ "',"
                        + 1 + ",'"
                        + especialidad + "',"
                        + null + ","
                        + rutMedico.getNum() + ",'"
                        + rutMedico.getDv()+ "'"
                        + ");");
            }
        
    	//return (listaHabitacion.agregarHabitacionConsulta(id, especialidad, rutMedico));
        return false;
    }
    
    public boolean agregarHabitacionHospitalizados(String id, String especialidad, Rut rutEnfermero, int capacidad) throws SQLException
    {
    	if (listaHabitacion.agregarHabitacionHospitalizados(id, especialidad, rutEnfermero, capacidad))
        {
                return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Insert into consulta values ('"
                        + id+ "',"
                        + 1 + ",'"
                        + especialidad + "',"
                        + capacidad + ","
                        + rutEnfermero.getNum() + ",'"
                        + rutEnfermero.getDv()+ "'"
                        + ");");
        }        
//    	return(listaHabitacion.agregarHabitacionHospitalizados(id, especialidad, rutEnfermero, capacidad));
        return false;
    }
    
    public boolean eliminarHabitacion(String id) throws SQLException
    {
    	if (listaHabitacion.eliminarHabitacion(id))
            {
                modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Delete from cama where idHabitacion='"
                        + id+ "'"
                        + ";");
                if (modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Delete from consulta where idConsulta='"
                        + id+ "'"
                        + ";")
                    )
                {
                    return true;
                }else{
                    return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Delete from hospitalizados where idHospitalizados='"
                        + id+ "'"
                        + ";");
                }
                               
        } 
    	//return(listaHabitacion.eliminarHabitacion(id));
    	return false;
    }
    
    public Habitacion mostrarHabitacionPorPosicion(int posicion) //Muestra una habitacion en la posicion de la lista deseada
    {
    	return listaHabitacion.mostrarHabitacion(posicion);
    }
    
    public Habitacion mostrarHabitacionPorId(String idHabitacion) //Muestra una habitacion por la id indicada
    {
    	return listaHabitacion.mostrarHabitacion(idHabitacion);
    }
    public Persona mostrarPersona(int posicion) 
    {
    	return listaPersona.mostrarPersona(posicion);
    }
    
    public int cantidadHabitacionesHospitalizados()
    {
    	return listaHabitacion.contarHabitacionesHospitalizados();
    }
    
    public int cantidadHabitacionesConsulta()
    {
    	return listaHabitacion.contarHabitacionesConsulta();
    }
    
    public boolean darDeAltaPaciente(Rut rutPaciente) throws SQLException
    {
    	if(listaHabitacion.darDeAlta(rutPaciente))            
           {
               return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Update cama set camaDisponible=1, rutPaciente=null"
                       +", dv=null"
                       +" where rutPaciente="+ rutPaciente.getNum()
                        + ";");
           }
    	return false;
//    	return (listaHabitacion.darDeAlta(rutPaciente));
    }
    
    public boolean darDeAltaCama(int numeroCama) throws SQLException
    {
    	if(listaHabitacion.darDeAlta(numeroCama))            
           {
               return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Update cama set camaDisponible=1, rutPaciente=null"
                       +", dv=null"
                       +" where numeroCama="+ numeroCama
                        + ";");
           }
    	return false;
//    	return (listaHabitacion.darDeAlta(numeroCama));
    }
    
    public boolean agregarCamaHospitalizados(String idHabitacion, int numeroCama, String especialidad, Rut rutPaciente) throws SQLException
    {
    	if (listaHabitacion.agregarCamaHospitalizados(idHabitacion, numeroCama, especialidad, rutPaciente))
        {
            return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Insert into cama values ("
                        + numeroCama + ",'"
                        + idHabitacion + "',"
                        + 1 + ",'"
                        + especialidad + "',"
                        + rutPaciente.getNum() + ","
                        + rutPaciente.getDv()
                        + ");");
        }
//    	return(listaHabitacion.agregarCamaHospitalizados(idHabitacion, numeroCama, especialidad, rutPaciente));
    	return false;
    }
    
    public Cama buscarCamaEspecifica(int numeroCama)
    {
    	return(listaHabitacion.buscarCamaEspecifica(numeroCama));
    }
    
    public Cama buscarCamaDisponible()
    {
    	return(listaHabitacion.buscarCamaDisponible());
    }
    
    public boolean ocuparCama(int numeroCama, Rut rutPaciente) throws SQLException
    {
    	if(listaHabitacion.ocuparCama(numeroCama, rutPaciente))            
           {
               return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Update cama set camaDisponible=0, rutPaciente="+rutPaciente.getNum()
                       +", dv='"+rutPaciente.getDv()
                       +"' where numeroCama="+ numeroCama
                        + ";");
           }
    	return false;
//    	return(listaHabitacion.ocuparCama(numeroCama, rutPaciente));
    }
    
    public boolean eliminarCamaHospitalizados(int numeroCama) throws SQLException
    {
    	if (listaHabitacion.eliminarCamaHospitalizados(numeroCama))
           {
               return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Delete from cama where numeroCama="
                        + numeroCama
                        + ";");
           }
//    	return(listaHabitacion.eliminarCamaHospitalizados(numeroCama));
    	return false;
    }
    
    public Cama eliminarObjetoCamaHospitalizados(int numeroCama) throws SQLException
    {
        Cama c = listaHabitacion.eliminarObjetocamaHospitalizados(numeroCama);
    	if(c!=null)
           {
               modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Delete from cama where numeroCama="
                        + numeroCama
                        + ";");
               return c;
           }
//    	return(listaHabitacion.eliminarObjetocamaHospitalizados(numeroCama));
    	return null;
    }
    
    public boolean modificarCamillaConsulta(String idHabitacion,int numeroCama, boolean disponibilidad, String especialidad) throws SQLException
    {
        int dispo = 1;
        if (disponibilidad!=true)
            dispo = 0;
    	if (listaHabitacion.modificarCamillaConsulta(idHabitacion,numeroCama, disponibilidad, especialidad))            
           {
               return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Update cama set camaDisponible="+dispo+", numeroCama="+numeroCama
                       +", especialidad='"+especialidad+"'"
                       +" where idHabitacion="+ idHabitacion
                        + ";");
           }
    	return false;
//    	listaHabitacion.modificarCamillaConsulta(idHabitacion,numeroCama, disponibilidad, especialidad);
    }
    
    public boolean ocuparCamillaConsulta(String idHabitacion, Rut rutPaciente) throws SQLException
    {
    	if(listaHabitacion.ocuparCamillaConsulta(idHabitacion, rutPaciente))            
           {
               return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Update cama set camaDisponible=0, rutPaciente="+rutPaciente.getNum()
                       +", dv='"+rutPaciente.getDv()+"'"
                       +" where idHabitacion="+ idHabitacion
                        + ";");
           }
        return false;
//    	return(listaHabitacion.ocuparCamillaConsulta(idHabitacion, rutPaciente));
    }
	
	
    public boolean eliminarMedicoConsulta(Rut rutMedico) throws SQLException
    {
    	if (listaHabitacion.eliminarMedicoConsulta(rutMedico))            
           {
               return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Update cama set rutMedico=null, dv=null"
                       +" where rutMedico="+ rutMedico.getNum()
                        + ";");
           }
    	return false;
//    	return (listaHabitacion.eliminarMedicoConsulta(rutMedico));
    }
    
    public boolean eliminarEnfermeroHospitalizados(Rut rutEnfermero) throws SQLException
    {
    	if(listaHabitacion.eliminarEnfermeroHospitalizados(rutEnfermero))            
           {
               return modificarBD("localhost", "3306", "rurikkcl_SGH", "root", "", "Update cama set rutEnfermero=null, dv=null"
                       +" where rutEnfermero="+ rutEnfermero.getNum()
                        + ";");
           }
    	return false;
//    	return(listaHabitacion.eliminarEnfermeroHospitalizados(rutEnfermero));
    }
    
    public boolean informeMedicos() throws IOException{
        //planillas;
        String[] encabezados = new String[]{
            "RUT",
            "NOMBRES",
            "APELLIDOS",
            "FECHA NAC",
            "TELEFONO",
            "EMAIL",
            "ESPECIALIDAD"
        };
        Object[][] tabla= listaPersona.tablaMedicos(encabezados.length);
        //return informeExcel(String nombreHoja,String nombreArchivo,String tituloPlanilla,String[] encabezados,Object[][] tabla);
        Informe excel = new Informe("Lista Medicos", "ListaMedicos", "Medicos", encabezados, tabla);
        
        return excel.informeExcel();
    }
    
    public boolean informePacientes() throws IOException{
        //planillas;
        String[] encabezados = new String[]{
            "RUT",
            "NOMBRES",
            "APELLIDOS",
            "FECHA NAC",
            "TELEFONO",
            "CONTACTO",
            "FONO CONTACTO",
            "SEXO"
        };
        Object[][] tabla= listaPersona.tablaPacientes(encabezados.length);
        //return informeExcel(String nombreHoja,String nombreArchivo,String tituloPlanilla,String[] encabezados,Object[][] tabla);
        Informe excel = new Informe("Lista Pacientes", "ListaPacientes", "Pacientes", encabezados, tabla);
        
        return excel.informeExcel();
    }
    
    public boolean informeEnfermeros() throws IOException{
        //planillas;
        String[] encabezados = new String[]{
            "RUT",
            "NOMBRES",
            "APELLIDOS",
            "FECHA NAC",
            "TELEFONO",
            "EMAIL"
        };
        Object[][] tabla= listaPersona.tablaEnfermeros(encabezados.length);
        //return informeExcel(String nombreHoja,String nombreArchivo,String tituloPlanilla,String[] encabezados,Object[][] tabla);
        Informe excel = new Informe("Lista Enfermeros", "ListaEnfermeros", "Enfermeros", encabezados, tabla);
        
        return excel.informeExcel();
    }
    
    public String habitacionesToString() {
        try {
            return listaHabitacion.toString();            
        } catch (Exception e) {            
        }
        return "";
    }  
    
    public String[] obtenerMedico(String medicos[])
    {
    	return listaPersona.obtenerMedico(medicos);
    }
    public int cantidadPersonas()
    {
    	return listaPersona.contarPersonas();
    }
    
}
