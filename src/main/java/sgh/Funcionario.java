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
public class Funcionario extends Persona {

    private String email;
    private String especialidad;

    public Funcionario(String nombres, String apellidos, Rut rut, Date fechaNac, String telefono, String email, String especialidad) {
        super(nombres, apellidos, rut, fechaNac, telefono);
        this.email = email;
        this.especialidad = especialidad;
    }
//<editor-fold defaultstate="collapsed" desc="getter-setter">

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspecialidad() {
        return this.especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

//</editor-fold>
}
