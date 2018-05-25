/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.utiles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rurikk
 */
public class ResultS {

    ResultSet rs;

    public ResultS(ResultSet rs) {
        this.rs = rs;
    }

    public String toStringTitulo() throws SQLException {
        String string = "\n";
        string += rs.getMetaData().getCatalogName(1) + ".";
        string += rs.getMetaData().getSchemaName(1) + ".";
        string += rs.getMetaData().getTableName(1);
        string += "\n";

        try {

            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                string += rs.getMetaData().getColumnName(i) + " ";
                string += rs.getMetaData().getColumnTypeName(i);
                string += "\t";
            }

            while (rs.next()) {
                string += "\n";
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    if (i > 1) {
                        string += "\t";
                    }
                    String columnValue = rs.getString(i);
                    string += columnValue;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultS.class.getName()).log(Level.SEVERE, null, ex);
        }
        string += "\n";
        return string;
    }
}
