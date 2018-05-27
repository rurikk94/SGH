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
import java.util.ArrayList;

import main.java.utiles.Rut;

/**
 *
 * @author Rurikk
 */
public class ListaPaciente {
    
    private ArrayList<Paciente> listaPacientes;

    public ListaPaciente() {
        this.listaPacientes = new ArrayList<Paciente>();
    }

    public boolean agregarPaciente(Paciente paciente) 
    {
        if (listaPacientes.isEmpty())
        {
            listaPacientes.add(paciente);
            return true;
        } else 
        	{
            for (int i = 0; i < listaPacientes.size(); i++) 
            {
                if (listaPacientes.get(i).getRut().equals(paciente.getRut())) 
                {
                    return false;
                }
            }
            listaPacientes.add(paciente);
            return true;
        	}
    }
    public boolean eliminarPaciente(Rut rut)
	{
		for (int i = 0; i < listaPacientes.size(); i++)
		{
			if (listaPacientes.get(i) != null) 
			{ 
				if (listaPacientes.get(i).getRut().equals(rut.toString())) 
				{
					listaPacientes.remove(listaPacientes.get(i));
					return true;
				}
			}
		}
		return false;
	}
    
    public void editarPaciente(Rut rut, String nombres, String apellidos, Date fechaNac, String telefono, String nombreContacto, Integer telefonoContacto, char sexo)
	{
		for (int i=0;i<listaPacientes.size();i++) 
		{
			if (listaPacientes.get(i).getRut().equals(rut.toString())) 
			{
				listaPacientes.get(i).setNombres(nombres);
				listaPacientes.get(i).setApellidos(apellidos);
				listaPacientes.get(i).setFechaNac(fechaNac);
				listaPacientes.get(i).setTelefono(telefono);
				listaPacientes.get(i).setNombreContacto(nombreContacto);
				listaPacientes.get(i).setTelefonoContacto(telefonoContacto);
				listaPacientes.get(i).setSexo(sexo);
				
			}
		}
	}

    public String buscarPaciente(Rut rut)
	{
		for(int i=0; i<listaPacientes.size();i++) 
		{
			if (listaPacientes.get(i).getRut().equals(rut.toString()))
			{
				return listaPacientes.get(i).getRut();
			}
		}
		System.out.println("No se encontro el paciente con el Rut "+ rut +".\n");
		return null;
	}
	//hola2
}
