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
    
    public Hospital() throws IOException, ParseException, SQLException
    {
       listaPersona = new ListaPersona() ;
       listaHabitacion = new ListaHabitacion();
       
        //cargarDatos();       
    }
    
    /** carga los datos desde alguna base de datos 
     * @param tipoBD
     */
    public void cargarDatos(String tipoBD, String url,  String bd, String user, String pass) throws SQLException {

        String[] querys = new String[]{
            "select * from Enfermeros;",
            "select * from Medicos;",
            "select * from Pacientes;",
            "select * from ListaPacientes;"
        };
        if ("com.mysql.jdbc.Driver".equals(tipoBD))
        {
            System.out.println("-------MYsql------------");
            if (!select(tipoBD, "jdbc:mysql://"+url+"/"+bd, user, pass, querys)) {
                select(tipoBD, "jdbc:mysql://localhost/"+bd, user, pass, querys);
            }
        }
        
        System.out.println("-------SQLite-----------");
        select("com.sqlite.jdbc.Driver", "jdbc:sqlite:bd.db", null, null, querys);
    }

    /** 
     * Realiza las querys al JDBC especificado
     * @param 
     */
    public static boolean select(String tipoBD, String url, String user, String pass, String[] querys) throws SQLException {
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
                    //<editor-fold defaultstate="collapsed" desc="agregar Objetos">
                    if ("Medicos".equals(rs.getMetaData().getTableName(1))) {
                        Rut ru = new Rut(rs.getInt("rut"), rs.getString("dv").charAt(0));
                        Medico p = new Medico(
                                rs.getString("nombres"),
                                rs.getString("apellidos"),
                                ru,
                                java.sql.Date.valueOf(rs.getString("fechaNac")),
                                rs.getString("telefono"),
                                rs.getString("email"),
                                rs.getString("especialidad")
                        );
                        //hospi.agregarMedico(p);  
                        System.out.println(p.toString());
                    };
                    if ("Enfermeros".equals(rs.getMetaData().getTableName(1))) {
                        Rut ru = new Rut(rs.getInt("rut"), rs.getString("dv").charAt(0));
                        Enfermero p = new Enfermero(
                                rs.getString("nombres"),
                                rs.getString("apellidos"),
                                ru,
                                java.sql.Date.valueOf(rs.getString("fechaNac")),
                                rs.getString("telefono"),
                                rs.getString("email")
                        );             
                        //hospi.agregarEnfermero(p);           
                        System.out.println(p.toString());
                    };
                    if ("Pacientes".equals(rs.getMetaData().getTableName(1))) {
                        Rut ru = new Rut(rs.getInt("rut"), rs.getString("dv").charAt(0));

                        Paciente p = new Paciente(
                                rs.getString("nombres"),
                                rs.getString("apellidos"),
                                ru,
                                java.sql.Date.valueOf(rs.getString("fechaNac")),
                                rs.getString("telefono"),
                                rs.getString("nombreContacto"),
                                rs.getInt("telefonoContacto"),
                                rs.getString("sexo").charAt(0)
                        );
                        //hospi.agregarPaciente(p);
                        System.out.println(p.toString());
                    };
                    if ("ListaPacientes".equals(rs.getMetaData().getTableName(1))) {
                        System.out.println(rs.getInt("RutPaciente")+"\t"+rs.getInt("RutMedico"));
                        //hospi.ListaPersona.agregarPacienteaMedico(rs.getInt("RutPaciente"), rs.getInt("RutMedico"));
                    };
                    //</editor-fold>
                }
            }
            conexion.cerrarConexion();
            return true;

        }
        return false;
    }

}
