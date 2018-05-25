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
public class ListaPaciente {
    
    private ArrayList<Paciente> listaPacientes;

    public ListaPaciente() {
        this.listaPacientes = new ArrayList<Paciente>();
    }

    public boolean agregarPaciente(Paciente paciente) {
        if (listaPacientes.isEmpty()) {
            listaPacientes.add(paciente);
            return true;
        } else {
            for (int i = 0; i < listaPacientes.size(); i++) {
                if (listaPacientes.get(i).getRut().equals(paciente.getRut())) {
                    return false;
                }
            }
            listaPacientes.add(paciente);
            return true;
        }
    }
    
}
