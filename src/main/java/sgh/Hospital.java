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

//        cargarDatos("com.mysql.jdbc.Driver", "209.222.103.210", "rurikkcl_SGH", "rurikkcl_user", "rurikkUser");
//        System.out.println(PersonasToString());
//        eliminarPersona(1461946);
//        eliminarPersona(4567852);
//        System.out.println(PersonasToString());
//        modificarPersona(12545656,"asdasdasd","Nombres");
//        modificarPersona(12545656,12545656,"");
//        modificarPersona(12545656,"LACTM","");
//        System.out.println(PersonasToString());
    }

    /**
     * carga los datos desde alguna base de datos
     *
     * @param tipoBD
     */
    public void cargarDatos(String tipoBD, String url, String bd, String user, String pass) throws SQLException {

        String[] querys = new String[]{
            "select * from Enfermeros;",
            "select * from Medicos;",
            "select * from Pacientes;",
            "select * from ListaPacientes;"
        };
        if ("com.mysql.jdbc.Driver".equals(tipoBD)) {
            //System.out.println("-------MYsql------------");
            if (!select(tipoBD, "jdbc:mysql://" + url + "/" + bd, user, pass, querys)) {
                if (!select(tipoBD, "jdbc:mysql://localhost/" + bd, user, pass, querys)) {
                    System.out.println("-------SQLite-----------");
                    select("com.sqlite.jdbc.Driver", "jdbc:sqlite:bd.db", null, null, querys);
                }
            }
        }

    }

    /**
     * Realiza las querys al JDBC especificado     *
     * @param
     */
    public boolean select(String tipoBD, String url, String user, String pass, String[] querys) throws SQLException {
        Conexion conexion = new Conexion();
        conexion.hacerConexion(tipoBD, url, user, pass);
        if (conexion.conexion != null) {
            //cargarDatos
            //System.out.println(querys.length);
            for (int i = 0; i < querys.length; i++) {
                String query = querys[i];

                ResultSet rs = conexion.consulta(query);
                ResultS r = new ResultS(conexion.consulta(query));
                //System.out.println(r.toStringTitulo()); //muestra el ResultSet
                while (rs.next()) {
                    //<editor-fold defaultstate="collapsed" desc="agregar Persona">
                    if ("Medicos".equals(rs.getMetaData().getTableName(1))) {
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
                    if ("Enfermeros".equals(rs.getMetaData().getTableName(1))) {
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
                    if ("Pacientes".equals(rs.getMetaData().getTableName(1))) {
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
                    if ("ListaPacientes".equals(rs.getMetaData().getTableName(1))) {
                        //System.out.println(rs.getInt("RutPaciente")+"\t"+rs.getInt("RutMedico"));
                        listaPersona.agregarPacienteaMedico(rs.getInt("RutPaciente"), rs.getInt("RutMedico"));
                    };
                    //</editor-fold>
                }
            }
            conexion.cerrarConexion();
            return true;

        }
        return false;
    }

    /**
     * Agrega la Persona; Medico,Paciente o Enfermero
     */
    public boolean agregarPersona(Persona p) {
        return listaPersona.agregarPersona(p);
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
    public boolean modificarPersona(Integer rutNum, Object atributoAModificar, String nombreAtributo) {
        return listaPersona.modificarPersona(rutNum, atributoAModificar, nombreAtributo);
    }

    /**
     * Elimina la Persona segun numero de Rut
     * @author Rurikk
     * @param rutNum Integer, enviar parte Numerica del Rut
     */
    public boolean eliminarPersona(Integer rutNum) {
        return listaPersona.eliminarPersona(rutNum);
    }

    /** Muestra todas las personas, ejecutar con un SoutPtrint
     * @author Rurikk
     */
    public String PersonasToString() {
        return listaPersona.toString();
    }
}
