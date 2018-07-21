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
package main.java.utiles;

/**
 *
 * @author Rurikk
 */
public class Rut {

    private int num;
    private char dv;

    //<editor-fold defaultstate="collapsed" desc="constructores">
    /**
     *
     * @param num parte numerica
     * @param dv Char digito verificador
     *
     */
    public Rut(int num, char dv) {
        if (rutValido(num, dv)) {
            this.num = num;
            this.dv =  Character.toUpperCase(dv);
        }
    }

    /**
     * Solo ingresar parte numerica
     *
     * @param num parte numerica
     *
     */
    public Rut(int num) {
        this.num = num;
        this.dv = generarDV(num);
    }

    /**
     * Ingresar un string con el Rut y DV, con puntos o guion, o sin punto o sin
     * guion
     *
     * @param rut string entero
     *
     */
    public Rut(String rut) {
        this.dv = rut.charAt(rut.length() - 1);
        rut = rut.substring(0, rut.length() - 1);
        rut = rut.replaceAll("[^0-9]", "");
        this.num = Integer.parseInt(rut);
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="setter-getter">

    public boolean setNum(int num) {
        this.num = num;
        return true;
    }

    public boolean setDv(char dv) {
        this.dv = dv;
        return true;
    }

    public int getNum() {
        return num;
    }

    public char getDv() {
        return dv;
    }
    public String getRut(){
        return toString();
    }

//</editor-fold>
    public boolean dvValido(char dv) {
        return (((int) dv >= 48 && (int) dv <= 57) || 'k' == dv || 'K' == dv);
    }

    public boolean rutValido(int num, char dv) {
        if (dvValido(dv) == true) {
            if (dv == generarDV(num)) {
                return true;
            }
        }
        return false;
    }

    public static char generarDV(int número) {
        if (número >= 72000000 || número < 100000) {
            throw new IllegalArgumentException("Número de Rut debe estar estar en el intervalo [1.000.000,72.000.000[");
        }
        char dv;
        int suma = 0;
        int i = 2;
        for (; número != 0; número /= 10) {
            suma += (número % 10) * i;
            i = (i == 7) ? 2 : i + 1;
        }
        i = 11 - (suma % 11);

        if (i == 11) {
            dv = '0';
        } else if (i == 10) {
            dv = 'K';
        } else {
            dv = Character.forDigit(i, 10);
        }
        return dv;
    }

    @Override
    public String toString() {
        return num + "-" + dv;
    }

    public boolean esIgual(String rut) {
        Rut r = new Rut(rut);
        if (this.num == r.getNum()) {
            return true;
        }
        return false;
    }

    public boolean esIgual(int num) {
        Rut r = new Rut(num);
        if (this.num == r.getNum()) {
            return true;
        }
        return false;
    }

    public boolean esIgual(int num, char dv) {
        Rut r = new Rut(num,dv);
        if (this.num == r.getNum()) {
            return true;
        }
        return false;
    }
    
    public boolean esIgual(Rut r) {
        if (this.num == r.getNum()) {
            return true;
        }
        return false;
    }

}
