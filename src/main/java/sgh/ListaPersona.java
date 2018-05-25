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
 * @author Rurikk
 */
public class ListaPersona {
    
    private ArrayList<Persona> arrayPersonas;
    
    public ListaPersona()
    {
        arrayPersonas = new ArrayList<Persona>();
    }
    /**
     * busca una Persona por el Rut     *
     * @author Rurikk
     * @version 1.0x.xxx 2018-05-25
     * @param rutNum Integer, solo el numero sin puntos.
     */
    public Persona buscarPersona(Integer rutNum) {
        if (arrayPersonas.isEmpty()) {
            return null;
        } else {
            for (int i = 0; i < arrayPersonas.size(); i++) {
                if (arrayPersonas.get(i).getRutNum() == (rutNum)) {
                    if (arrayPersonas.get(i) instanceof Paciente) {
                        return (Paciente) arrayPersonas.get(i);
                    }
                    if (arrayPersonas.get(i) instanceof Medico) {
                        return (Paciente) arrayPersonas.get(i);
                    }
                }
            }
            return null;
        }
    }

    /**
     * Agrega un Paciente a un Medico
     *
     * @author Rurikk
     * @param rutPaciente Int
     * @param rutMedico Int
     *
     */
    public boolean agregarPacienteaMedico(Integer rutPaciente, Integer rutMedico) {
        if (buscarPersona(rutPaciente) != null && buscarPersona(rutMedico) != null) //Si existe el Paciente, y tambien existe el Medico
        {
            return ((Medico) buscarPersona(rutMedico)).agregarAListaPacientes(((Paciente) buscarPersona(rutPaciente)));    //agregara el Paciente a la listaPacientes del Madico
        };
        return false;
    }
}
