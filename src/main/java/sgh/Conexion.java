package main.java.sgh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 *
 * @author Rurikk
 */
class Conexion {
    Connection conexion = null;
    
/**
 * Hace la conexion con la base de datos
 *
 * @author Rurikk
 * @return      conexion
 * @deprecated se actualiza a nuevo metodo de conexion @link
 */
    public Connection hacerConexion() throws SQLException{
        if (conexion == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Importar / Instalar MySQL JDBC Driver");
                return null;
            }

            try {
                conexion = DriverManager.getConnection("jdbc:mysql://209.222.103.210/rurikkcl_SGH","rurikkcl_user","rurikkUser");
                

            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());            
            }
               
            if (conexion==null)
            {
                try {   
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/rurikkcl_zakaz","root","");
                } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                }
            } 
            
        }
        return conexion;
    }
    public void cerrarConexion() throws SQLException{
        if (conexion != null) {
         conexion.close();
      }
    }
    public ResultSet consulta(String query) throws SQLException{
        Statement s = (Statement) conexion.createStatement();
        ResultSet rs = s.executeQuery (query);
        return rs;
    
    }
    int updating(String query) throws SQLException{
        PreparedStatement consulta = conexion.prepareStatement(query);
        return consulta.executeUpdate();
    }
    /** 
     * executa la conexion, comprueba si existe driver y procede a hacer la conexion
 * @author Rurikk 
 * @version 1.0x.xxx 2018-05-25
 * 
 */
    public Connection hacerConexion(String tipoBD, String url, String user, String pass) throws SQLException {
//        if (!existeDriver(tipoBD)) { //no es necesario en version JDK
//            return null;
//        }
        return conexion = intentarConexion(url, user, pass);
    }

/** Hace la conxion con la base de datos indicada en parametros
 * @param url String
 * @param user String
 * @param url String
 * @author Rurikk 
 * @version 1.0x.xxx 2018-05-25
 * 
 */
    private Connection intentarConexion(String url, String user, String pass) {
        Connection conexion = null;
        Properties conexionPropiedades = new Properties();
            if (user!= null) conexionPropiedades.put("user", user);
            if (pass!= null) conexionPropiedades.put("password", pass);
        
        try {
            conexion = DriverManager.getConnection(url,conexionPropiedades);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conexion;
    }

/** 
 * @author Rurikk 
 * @version 1.0x.xxx 2018-05-25
 * @deprecated No usar en versiones nuevas de JSK
 */
    private boolean existeDriver(String tipoBD) {
        try {
            Class.forName(tipoBD);
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("Importar / Instalar " + tipoBD);
            return false;
        }
    }
    
}
