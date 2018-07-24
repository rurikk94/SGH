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

import main.java.utiles.Rut;

/**
 *
 * @author fernando
 */
public class Cama {

    private int numeroCama;
    private boolean camaDisponible;
    private String especialidad;
    private Rut rutPaciente;

    public Cama() {
        numeroCama = 0;
        camaDisponible = true;
        rutPaciente = null;
        especialidad = "";
    }

    public Cama(int numeroCama, boolean camaDisponible, Rut rutPaciente, String especialidad) {
        this.numeroCama = numeroCama;
        this.camaDisponible = camaDisponible;
        this.especialidad = especialidad;
        this.rutPaciente = rutPaciente;

    }

    //<editor-fold defaultstate="collapsed" desc="setter-getter">
    public void setNumeroCama(int numeroCama) {
        this.numeroCama = numeroCama;
    }

    public void setCamaDisponible(boolean camaDisponible) {
        this.camaDisponible = camaDisponible;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setRutPaciente(Rut rutPaciente) {
        this.rutPaciente = rutPaciente;
    }

    public int getNumeroCama() {
        return numeroCama;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public Rut getRutPaciente() {
        return rutPaciente;
    }

    public boolean getCamaDisponible() {
        return camaDisponible;//retorna true si esta disponible, de lo contrario false
    }

//</editor-fold>
    /**
     * ocupa una cama
     */
    public boolean ocuparCama(Rut rutPaciente) {
        if (this.camaDisponible == true) {
            this.rutPaciente = rutPaciente;//se le asigna un paciente a la cama
            this.camaDisponible = false;//la cama deja de estar disponible
            return true;
        }
        return false;
    }

    /**
     * desocupar cama
     */
    public boolean vaciarCama() {
        if (this.camaDisponible == false) {
            this.rutPaciente = null;//se elimina el paciente
            this.camaDisponible = true;//cama queda disponible
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String r = " nºCama: " + numeroCama + " Especialidad: " + especialidad;
        if (rutPaciente != null) {
            r += " rutPaciente: " + rutPaciente.toString();
        }
        return r;
    }
}
