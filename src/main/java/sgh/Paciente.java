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
public class Paciente extends Persona {

    private String nombreContacto;
    private int telefonoContacto;
    private char sexo;

    public Paciente(String nombres, String apellidos, Rut rut, Date fechaNac, int telefono, String nombreContacto, int telefonoContacto, char sexo) {
        super(nombres, apellidos, rut, fechaNac, telefono);
        this.nombreContacto = nombreContacto;
        this.telefonoContacto = telefonoContacto;
        this.sexo = sexo;
    }
    // <editor-fold defaultstate="collapsed" desc="getter-setter">   
    public String getNombreContacto() {
        return this.nombreContacto;
    }

    public boolean setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
        return true;
    }

    public int getTelefonoContacto() {
        return this.telefonoContacto;
    }

    public boolean setTelefonoContacto(int telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
        return true;
    }

    public char getSexo() {
        return this.sexo;
    }

    public boolean setSexo(char sexo) {
        this.sexo = sexo;
        return true;
    }
// </editor-fold>
    
    @Override
    /**
     * Retorna datos como String
     * @author Rurikk
     * @return String
     */
    public String toString() {
        return "Paciente{" 
                + "nombres=" + this.getNombres()
                + ",apellidos=" + this.getApellidos()
                + ", rut=" + this.getRut()
                + ",fechaNac=" + this.getFechaNac()
                + ", telefono=" + this.getTelefono()
                + ", nombreContacto=" + this.getNombreContacto()
                + ", telefonoContacto=" +  this.getTelefonoContacto()
                + ", sexo=" +  this.getSexo()
                + '}';
    }
}
