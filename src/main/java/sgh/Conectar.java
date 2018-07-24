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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * Contiene los metodos para ejecutar conexion, ejecutar la query y cerrar conexion
 * @author Rurikk
 */
public interface Conectar {
    public void cerrarConexion() throws SQLException;
    public ResultSet consulta(String query) throws SQLException;
    public int actualizacion(String query) throws SQLException;
    public Connection hacerConexion() throws SQLException;
}
