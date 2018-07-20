package main.java.sgh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * Contiene los metodos para poder trabajar con distintos tipos de base de datos Mysql o SQlite
 * @author Rurikk
 */
public class Conexion {

    private Conectar conector;

    private Connection conexion;

    public Conexion(Conectar conector) throws SQLException {
        this.conector = conector;
        this.conexion = conector.hacerConexion();
    }

    public Conectar getConector() {
        return conector;
    }

    public Connection getConexion() {
        return conexion;
    }
    public void cerrarConexion() throws SQLException{
        conector.cerrarConexion();
    }

    ResultSet ejecutarSelect(String query) throws SQLException {
        //conexion = conector.hacerConexion();

        if (conexion != null) {
            //cargarDatos
            //System.out.println(querys.length);
//            System.out.println("\n");
//            System.out.println(query);
//            System.out.println("\n");

                ResultSet rs = conector.consulta(query);
                
                
                return rs;

            }
            conector.cerrarConexion();

        
        return null;
    }
    
    Integer ejecutarUpdate(String query) throws SQLException {
    if (conexion != null) {
            //cargarDatos
            //System.out.println(querys.length);
//            System.out.println("\n");
//            System.out.println(query);
//            System.out.println("\n");

                Integer rs = conector.actualizacion(query);
                
                return rs;

            }
            conector.cerrarConexion();

        
        return null;
    }

}
