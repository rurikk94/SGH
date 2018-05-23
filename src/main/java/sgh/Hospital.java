package main.java.sgh;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

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
    
    
    public void cargarDatos() throws SQLException
    {
        cargarProductos();
    }
/**
 * Ejecuta un Select desde la BD. Muestra lo leido
 */    
    public void cargarProductos() throws SQLException {
        String query = "select nombre from Personas;";
        Conexion conexion = new Conexion();
        conexion.hacerConexion();

        System.out.println("Se lee: ");
        //cargarDatos
        ResultSet rs = conexion.consulta(query);
        while (rs.next())
        {
            //Producto p = new Producto(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3));
            System.out.println(rs.getString(1));
            //productos.agregarProducto(rs.getString(2),Integer.parseInt(rs.getString(1)),Integer.parseInt(rs.getString(3)));
        }
        conexion.cerrarConexion();        
    }
}
