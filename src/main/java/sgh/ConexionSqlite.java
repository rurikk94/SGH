/*
 * Copyright (C) 2018 Rurikk
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
 * Contiene los metodos para ejecutar conexion, ejecutar la query y cerrar conexion en SQlite
 * @author Rurikk
 */
public class ConexionSqlite implements Conectar {

    private String driver;
    private String ruta;
    Connection conexion;

    public ConexionSqlite(String ruta) throws SQLException {
        this.driver = "com.sqlite.jdbc.Driver";
        this.ruta = "bd.db";

    }

    @Override
    public void cerrarConexion() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

    @Override
    public ResultSet consulta(String query) throws SQLException {
        try {

            Statement s = (Statement) conexion.createStatement();
            ResultSet rs = s.executeQuery(query);
            return rs;
        } catch (Exception e) {

            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int actualizacion(String query) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement(query);
            return consulta.executeUpdate();

        } catch (Exception e) {

            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            return 0;
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    @Override
    public Connection hacerConexion() throws SQLException {
        //Connection conexion = null;

        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + ruta);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conexion;
    }
}
