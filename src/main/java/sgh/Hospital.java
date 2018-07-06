package main.java.sgh;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import main.java.utiles.ResultS;
import main.java.utiles.Rut;

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
            if ("medicos".equals(rs.getMetaData().getTableName(1).toLowerCase())) {
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
            if ("enfermeros".equals(rs.getMetaData().getTableName(1).toLowerCase())) {
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
            if ("pacientes".equals(rs.getMetaData().getTableName(1).toLowerCase())) {
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
            if ("listapacientes".equals(rs.getMetaData().getTableName(1).toLowerCase())) {
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
     * Agrega la Persona; Medico,Paciente o Enfermero
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
     * Modifica la Persona
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
     * Elimina la Persona segun numero de Rut
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
}
