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

import java.sql.Date;
import main.java.utiles.Rut;

/**
 *
 * @author pablocabelloalvarez
 */
public class Enfermero extends Funcionario {

    //contructores 
    public Enfermero(String nombres, String apellidos, Rut rut, Date fechaNac, int telefono, String email) {
        super(nombres, apellidos, rut, fechaNac, telefono, email);
    }
    @Override
    /**
     * Retorna datos como String
     * @author Rurikk
     * @return String
     */
    public String toString() {
        return "Enfermero{" 
                + "nombres=" + this.getNombres()
                + ",apellidos=" + this.getApellidos()
                + ", rut=" + this.getRut()
                + ",fechaNac=" + this.getFechaNac()
                + ", telefono=" + this.getTelefono()
                + ", email=" + this.getEmail()
                + '}';
    }
}
