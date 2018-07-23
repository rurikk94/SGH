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
import java.util.Objects;
import main.java.utiles.Rut;

/**
 *
 * @author Rurikk
 */
public class ListaPersona {

    private ArrayList<Persona> arrayPersonas;

    public ListaPersona() {
        arrayPersonas = new ArrayList<Persona>();
    }
    /**
     * Busca una Persona por el Rut
     * @author Rurikk
     * @version 1.0x.xxx 2018-05-26
     * @param rutNum int, solo el numero sin puntos.
     */
    public Persona buscarPersona(int rutNum) {
        if (arrayPersonas.isEmpty()) {  //Si el array está vacio: Null
            return null;
        } else {
            for (int i = 0; i < arrayPersonas.size(); i++) {    //Recorre Array
                //if (arrayPersonas.get(i).getRutNum()==rutNum) { //busca persona con mismo Rut
                if (arrayPersonas.get(i).esIgualRut(rutNum)) { //busca persona con mismo Rut
                    if (arrayPersonas.get(i) instanceof Paciente) { //sies Paciente, lo retorna
                        return (Paciente) arrayPersonas.get(i);
                    }
                    if (arrayPersonas.get(i) instanceof Medico) {   //Si es Medico, lo retorna
                        return (Medico) arrayPersonas.get(i);
                    }
                    if (arrayPersonas.get(i) instanceof Enfermero) {   //Si es Enfermero, lo retorna
                        return (Enfermero) arrayPersonas.get(i);
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
     * @version 1.0x.xxx 2018-05-25
     *
     */
    public boolean agregarPacienteaMedico(int rutPaciente, int rutMedico) {
        if (buscarPersona(rutPaciente) != null && buscarPersona(rutMedico) != null) //Si existe el Paciente, y tambien existe el Medico
        {
            return ((Medico) buscarPersona(rutMedico)).agregarAListaPacientes(((Paciente) buscarPersona(rutPaciente)));    //agregara el Paciente a la listaPacientes del Madico
        };
        return false;
    }

    /**
     * Agrega una Persona
     *
     * @author Rurikk
     * @param persona Persona, Paciente, Medico, Enfermero, etc
     * @version 1.0x.xxx 2018-05-26
     *
     */
    public boolean agregarPersona(Persona persona) {
        if (buscarPersona(persona.getRutNum()) == null) //Si no existe la persona segun Rut
        {
            return arrayPersonas.add(persona);   //agrega la Persona al arrayList
        };
        return false;
    }

    /**
     * Elimina una Persona
     *
     * @author Rurikk
     * @param persona Persona, Paciente, Medico, Enfermero, etc
     * @version 1.0x.xxx 2018-05-26
     *
     */
    public boolean eliminarPersona(int rutNum) {
        if (buscarPersona(rutNum) != null) //Si existe la persona segun Rut
        {
            //if instanceof Paciente
                //eliminarPacienteAMedico(rutNum);
                //eliminarPacienteDeCama
                //eliminarPacienteDeConsulta
            //if instanceof Medico
                //eliminarMedicoDeConsulta
            //if instanceof Enfermero
                //eliminarEnfermeroDeHospitalizados
            return arrayPersonas.remove(buscarPersona(rutNum));   //elimina la Persona del arrayList
        };
        return false;
    }

    /**
     * Modifica la Persona
     * @author Rurikk
     * @param rutNum int parte numerica del rut de la persona a modificar
     * @param atributoModificar Object, cualquier tipo de objeto que se debe modificar
     * @param nombreAtributo String, si se modifica Nombres o Apellidos, enviar "Nombres" o "Apellidos"
     * @return boolean
     * @version 1.0x.xxx 2018-05-26
     * 
     */
    @SuppressWarnings("nombreAtributo")
    public boolean modificarPersona(int rutNum, Object atributoModificar, String nombreAtributo) {
        int i = arrayPersonas.indexOf(buscarPersona(rutNum));   //indice de la Persona en el arrayList
        if (i != -1) //Si existe la persona segun Rut
        {
            if ("Nombres".equals(nombreAtributo)) { //Si ingresa Nombre
                return ((Persona) arrayPersonas.get(i)).setNombres((String) atributoModificar);    //modifica el nombre
            };
            if ("Apellidos".equals(nombreAtributo)) {   //Si ingresa Apellido
                return ((Persona) arrayPersonas.get(i)).setApellidos((String) atributoModificar);    //modifica el apellidos
            };
            if (atributoModificar instanceof Date) {
                return ((Persona) arrayPersonas.get(i)).setFechaNac((Date) atributoModificar);    //modifica la fecha
            };
            if (atributoModificar instanceof Rut) {
                return ((Persona) arrayPersonas.get(i)).setRut((Rut) atributoModificar);    //modifica el Rut
            };
            if (atributoModificar instanceof Integer) {
                return ((Persona) arrayPersonas.get(i)).setTelefono((Integer) atributoModificar);    //modifica el telefono
            };
            if (buscarPersona(rutNum) instanceof Funcionario) {
                return ((Funcionario) arrayPersonas.get(i)).setEmail((String) atributoModificar);    //modifica el Email
            };
            if (buscarPersona(rutNum) instanceof Paciente) { //si la persona es Paciente
                if (atributoModificar instanceof Integer) {
                    return ((Paciente) arrayPersonas.get(i)).setTelefonoContacto((Integer) atributoModificar); //modifica el telefono
                };
                if (atributoModificar instanceof String) {
                    return ((Paciente) arrayPersonas.get(i)).setNombreContacto((String) atributoModificar);//modifica el nombreContacto
                };
                if (atributoModificar instanceof char[]) {
                    return ((Paciente) arrayPersonas.get(i)).setSexo((char) atributoModificar);//modifica el sexo
                };
            }
            if (buscarPersona(rutNum) instanceof Medico) {   //si la persona  es Medico
                if (atributoModificar instanceof String) {
                    return ((Medico) arrayPersonas.get(i)).setEspecialidad((String) atributoModificar);//modifica la especialidad
                };
            }
            if (buscarPersona(rutNum) instanceof Enfermero) {   //si la persona  es Enfermero

                //return ((Medico)arrayPersonas.get(i)).setEspecialidad((String)atributoModificar);//modifica el algo
            }
        };
        return false;
    }
    
    /**
     * Muestra Array como String
     *
     * @author Rurikk
     * @version 1.0x.xxx 2018-05-26
     *
     */
    public String toString(){
        String string="";
        if (!arrayPersonas.isEmpty()) {  //Si el array no está vacio
            for (int i = 0; i < arrayPersonas.size(); i++) {    //Recorre Array                
                string += arrayPersonas.get(i).toString() + "\n";                
            }
        }
        else{
            string+="No hay personas";
        }
        return string;
    }
    
    /**
     * Retorna cantidad de Personas
     * @author Rurikk
     * @version 1.0x.xxx 2018-05-26
     * @return cantidadPersonas Int
     *
     */
    public int cantidadPersonas(){
        return arrayPersonas.size();
    }
    
    public boolean eliminarPacienteaMedico(Rut rutPaciente, int rutMedico) {
        if (buscarPersona(rutMedico) != null) //Si existe el Paciente, y tambien existe el Medico
        {
            return ((Medico) buscarPersona(rutMedico)).eliminarPaciente(rutPaciente);    //agregara el Paciente a la listaPacientes del Madico
        };
        return false;
    }
    
    public String buscarPacienteMedico(Rut rutPaciente, int rutMedico) {
        if (buscarPersona(rutMedico) != null) //Si existe el Paciente, y tambien existe el Medico
        {
            return ((Medico) buscarPersona(rutMedico)).buscarPaciente(rutPaciente);    //agregara el Paciente a la listaPacientes del Madico
        };
        return "No existe el medico";
    }
    
    public boolean remplazarPacienteMedico(int rutMedico,Paciente pacienteNuevo, Rut pacienteARemplazar) {
        if (buscarPersona(rutMedico) != null) //Si existe el Paciente, y tambien existe el Medico
        {
            return ((Medico) buscarPersona(rutMedico)).remplazarPaciente(pacienteNuevo,pacienteARemplazar);    //agregara el Paciente a la listaPacientes del Madico
        };
        return false;
    }
}
