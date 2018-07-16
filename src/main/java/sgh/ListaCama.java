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

import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class ListaCama {

    private ArrayList<Cama> arrayCama; 

    public ListaCama() {
        arrayCama = new ArrayList<Cama>();
    }

    public int getTotalCama() {
        return arrayCama.size();
    }

    /**
     * busca la cama por el numero de esta y retorna un booleano
     *
     * @param numero Integer
     * @return boolean
     */
    public boolean existeCama(int numero) {
        for (int i = 0; i < arrayCama.size(); i++) {
            if (arrayCama.get(i) != null) //si existe
            {
                if (numero == arrayCama.get(i).getNumeroCama()) //si los numeros son iguales
                {
                    return true;
                }
            }
        }
        return false;//no existe cama con ese numero
    }

    public boolean agregarCama(int numeroCama, String rutPaciente, String especialidad) {
        if (existeCama(numeroCama) == false)//no se encontro la cama
        {
            Cama nuevaCama = new Cama();//se crea el objeto cama
            nuevaCama.setEspecialidad(especialidad);
            nuevaCama.setNumeroCama(numeroCama);
            nuevaCama.setRutPaciente(rutPaciente);
            arrayCama.add(nuevaCama);//se agrega la cama
            return true;//se agrego
        }
        return false;//no se agrego
    }

    /**
     * busca la cama por codigo y retorna su indice
     *
     * @param numeroCama Integer
     */
    public Cama buscarCamaEspecifica(int numeroCama) {
        if (existeCama(numeroCama) == true) {
            for (int i = 0; i < arrayCama.size(); i++) {
                if (arrayCama.get(i) != null)//si existe
                {
                    if (arrayCama.get(i).getNumeroCama() == numeroCama) {
                        return (Cama) arrayCama.get(i);//retorna la cama
                    }
                }
            }
        }

        return null;//no existe cama con ese numero
    }

    /**
     * vacia la cama
     *
     * @param numeroCama
     */
    public boolean vaciarCama(int numeroCama) {
        if (existeCama(numeroCama) == true) {
            for (int i = 0; i < arrayCama.size(); i++) {
                if (arrayCama.get(i) != null && arrayCama.get(i).getNumeroCama() == numeroCama) {
                    arrayCama.get(i).vaciarCama();
                    return true;
                }
            }
        }

        return false;
    }
    
    public boolean vaciarCama(String rutPaciente)
    {
    	if(!(arrayCama.isEmpty()))
    	{
    		for(int i=0; i<arrayCama.size();i++)
    		{
    			if((arrayCama.get(i) != null) && (arrayCama.get(i).getRutPaciente().equalsIgnoreCase(rutPaciente)))
    			{
    				arrayCama.get(i).vaciarCama();
    				return true;
    			}
    		}
    	}
    	return false;
    }

    /**
     * ocupa la cama
     */
    public boolean ocuparCama(int numeroCama, String rutPaciente)//ocupa la cama
    {
        if (existeCama(numeroCama) == true) {
            for (int i = 0; i < arrayCama.size(); i++) {
                if (arrayCama.get(i) != null && arrayCama.get(i).getNumeroCama() == numeroCama) {
                    arrayCama.get(i).ocuparCama(rutPaciente);
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * retorna la primera cama disponible
     *
     * @return cama
     */
    public Cama buscarCamaDisponible() {
        if (arrayCama.isEmpty()) {
            return null;
        }

        for (int i = 0; i < arrayCama.size(); i++) {
            if (arrayCama.get(i) != null)//si es distinto de null
            {
                if (arrayCama.get(i).getCamaDisponible() == true)//si la disponibilidad de la cama es true
                {
                    return (Cama) arrayCama.get(i);//retorna la cama
                }
            }
        }
        return null;//no existen camas disponibles
    }

    /**
     * retorna la cantidad de camas disponibles para ser ocupadas
     *
     * @return cantidadCamasDisponibles
     */
    public int getNumeroCamasDisponibles()//
    {
        int cont = 0;
        for (int i = 0; i < arrayCama.size(); i++) {
            if (arrayCama.get(i) != null)//si el iterador es distinto de null 
            {
                if (arrayCama.get(i).getCamaDisponible() == true)//si la cama esta disponible
                {
                    cont++;//contador aumenta en 1
                }
            }
        }
        return cont;//retorna la cantidad de camas disponibles
    }

    /**
     * elimina una cama
     *
     * @param numeroCama
     */
    public boolean eliminarCama(int numeroCama)//
    {
        if (arrayCama.isEmpty()) {
            return false;
        }

        if (existeCama(numeroCama) == true) {
            for (int i = 0; i < arrayCama.size(); i++) {
                if (arrayCama.get(i).getNumeroCama() == numeroCama && arrayCama.get(i).getCamaDisponible() == true) //Se encuentra la cama buscada y está vacía
                {
                    arrayCama.remove(i);
                    return true;
                }
            }
        }

        return false;
    }

    public Cama eliminarObjetoCama(int numeroCama) {
        Cama camaEliminada = new Cama();
        if (arrayCama.isEmpty()) {
            return null;
        }

        if (existeCama(numeroCama) == true) {
            for (int i = 0; i < arrayCama.size(); i++) {
                if (arrayCama.get(i).getNumeroCama() == numeroCama && arrayCama.get(i).getCamaDisponible() == true) //Se encuentra la cama y está vacía
                {
                    camaEliminada = (Cama) arrayCama.get(i);
                    arrayCama.remove(i);
                    return camaEliminada;
                }
            }
        }

        return null;
    }

}
