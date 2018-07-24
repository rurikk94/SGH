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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import main.java.utiles.Rut;

/**
 *
 * @author pablocabelloalvarez
 */
public abstract class Persona {

    private String nombres;
    private String apellidos;
    private Rut rut;
    private Date fechaNac;
    private int telefono;

    public Persona(String nombres, String apellidos, Rut rut, Date fechaNac, int telefono) {

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rut = rut;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
    }
    //<editor-fold defaultstate="collapsed" desc="getter-setter">
    public String getNombres() {
        return this.nombres;
    }

    public boolean setNombres(String nombres) {
        this.nombres = nombres;
        return true;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public boolean setApellidos(String apellidos) {
        this.apellidos = apellidos;
        return true;
    }

    public String getRut() {
        return this.rut.toString();
    }
    
    public int getRutNum() {
        return this.rut.getNum();
    }
    
    public char getDV(){
        return this.rut.getDv();
    }

    public boolean setRut(Rut rut) {
        this.rut = rut;
        return true;
    }

    public Date getFechaNac() {
        return this.fechaNac;
    }

    public boolean setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
        return true;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public boolean setTelefono(int telefono) {
        this.telefono = telefono;
        return true;
    }    
//</editor-fold>
    
    /** valida el string ingresado, utilizar en nombres, apellidos, etc */
    private boolean validaString(String entrada, String expRegular){
        //adaptarlo para que sirva para numeros
    
        //String entrada = " No para mi que triste yeah";
        //Pattern patron = Pattern.compile("[^A-Za-z ]"); //expRegular valida que solo ingresen letras
        Pattern patron = Pattern.compile(expRegular);
        Matcher encaja = patron.matcher(entrada);
        
        if(!encaja.find())
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombres=" + this.nombres + ", apellidos=" + this.apellidos + ", rut=" + this.rut.toString() + ", fechaNac=" + this.fechaNac + ", telefono=" + this.telefono + '}';
    }
    public boolean esIgualRut(int rut){
        return this.rut.esIgual(rut);
    }
}
