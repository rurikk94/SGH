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
     * @return boolean
     * @version 1.0x.xxx 2018-05-26
     * 
     */
    public boolean modificarPersona(int rutNum, String nombres, String apellidos, java.sql.Date fechaNac, int fono, String contacto, int fonoContacto, char sexo, String email, String especialidad) {
        int i = arrayPersonas.indexOf(buscarPersona(rutNum));   //indice de la Persona en el arrayList
        if (i != -1) //Si existe la persona segun Rut
        {
            if (nombres!=null) { //Si ingresa Nombre
                return ((Persona) arrayPersonas.get(i)).setNombres(nombres);    //modifica el nombre
            };
            if (apellidos!=null) {   //Si ingresa Apellido
                return ((Persona) arrayPersonas.get(i)).setApellidos(apellidos);    //modifica el apellidos
            };
            if (fechaNac!=null) {
                return ((Persona) arrayPersonas.get(i)).setFechaNac(fechaNac);    //modifica la fecha
            };
            if (fono != 0) {
                return ((Persona) arrayPersonas.get(i)).setTelefono(fono);    //modifica el Rut
            };
            
            if (buscarPersona(rutNum) instanceof Funcionario) {
                return ((Funcionario) arrayPersonas.get(i)).setEmail(email);    //modifica el Email
            };
            
            if (buscarPersona(rutNum) instanceof Paciente) { //si la persona es Paciente
                
                if (fonoContacto != 0) {
                    return ((Paciente) arrayPersonas.get(i)).setTelefonoContacto(fonoContacto); //modifica el telefono
                }
                if (contacto != null) {
                    return ((Paciente) arrayPersonas.get(i)).setNombreContacto(contacto);//modifica el nombreContacto
                };
                if (sexo != '\u0000') {
                    return ((Paciente) arrayPersonas.get(i)).setSexo(sexo);//modifica el sexo
                };
            }
            if (buscarPersona(rutNum) instanceof Medico) {   //si la persona  es Medico
                if (especialidad != null) {
                    return ((Medico) arrayPersonas.get(i)).setEspecialidad(especialidad);//modifica la especialidad
                };                
                if (email !="") {
                    return ((Medico) arrayPersonas.get(i)).setEmail(email);    //modifica el Email
                };
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
    
    public Persona retornaPersona(int pos){
        return arrayPersonas.get(pos);
    }
    
    public int cantidadMedicos(){
        int cant=0;
        for (int i = 0; i < arrayPersonas.size(); i++) {    //Recorre Array                
                if (arrayPersonas.get(i) instanceof Medico)
                    cant++;
        }
        return cant;
    }
    
    
    public int cantidadEnfermeros(){
        int cant=0;
        for (int i = 0; i < arrayPersonas.size(); i++) {    //Recorre Array                
                if (arrayPersonas.get(i) instanceof Enfermero)
                    cant++;
        }
        return cant;
    }
    
    public int cantidadPacientes(){
        int cant=0;
        for (int i = 0; i < arrayPersonas.size(); i++) {    //Recorre Array                
                if (arrayPersonas.get(i) instanceof Paciente)
                    cant++;
        }
        return cant;
    }
    
    public Object[][] tablaMedicos(int encabezados){
        Object[][] tabla= new Object[cantidadMedicos()][encabezados];
        int cont=0;
        for (int j = 0; j < cantidadPersonas(); j++) {
            if ((retornaPersona(j)!=null)&&(retornaPersona(j) instanceof Medico)){

                tabla[cont][0]=retornaPersona(j).getRut();
                tabla[cont][1]=retornaPersona(j).getNombres();
                tabla[cont][2]=retornaPersona(j).getApellidos();
                tabla[cont][3]=retornaPersona(j).getFechaNac();
                tabla[cont][4]=retornaPersona(j).getTelefono();
                tabla[cont][5]=((Medico)retornaPersona(j)).getEmail();
                tabla[cont][6]=((Medico)retornaPersona(j)).getEspecialidad();
                cont++;
            }
        };
        return tabla;
    }
    
    public Object[][] tablaEnfermeros(int encabezados){
        Object[][] tabla= new Object[cantidadEnfermeros()][encabezados];
        int cont=0;
        for (int j = 0; j < cantidadPersonas(); j++) {
            if ((retornaPersona(j)!=null)&&(retornaPersona(j) instanceof Enfermero)){

                tabla[cont][0]=retornaPersona(j).getRut();
                tabla[cont][1]=retornaPersona(j).getNombres();
                tabla[cont][2]=retornaPersona(j).getApellidos();
                tabla[cont][3]=retornaPersona(j).getFechaNac();
                tabla[cont][4]=retornaPersona(j).getTelefono();
                tabla[cont][5]=((Enfermero)retornaPersona(j)).getEmail();
                cont++;
            }
        };
        return tabla;
    }

    Object[][] tablaPacientes(int length) {
        Object[][] tabla= new Object[cantidadPacientes()][length];
        int cont=0;
        for (int j = 0; j < cantidadPersonas(); j++) {
            if ((retornaPersona(j)!=null)&&(retornaPersona(j) instanceof Paciente)){

                tabla[cont][0]=retornaPersona(j).getRut();
                tabla[cont][1]=retornaPersona(j).getNombres();
                tabla[cont][2]=retornaPersona(j).getApellidos();
                tabla[cont][3]=retornaPersona(j).getFechaNac();
                tabla[cont][4]=retornaPersona(j).getTelefono();
                tabla[cont][5]=((Paciente)retornaPersona(j)).getNombreContacto();
                tabla[cont][6]=((Paciente)retornaPersona(j)).getTelefonoContacto();
                tabla[cont][7]=((Paciente)retornaPersona(j)).getSexo();
                cont++;
            }
        };
        return tabla;
    }
    public String[] obtenerMedico(String medicos[]) 
    {
    	int contador = 0;
        if (arrayPersonas.isEmpty()) {  //Si el array está vacio: Null
            return null;
        } 
        else 
        {
        	for (int i = 0; i < arrayPersonas.size(); i++) 
        	{
        		if (arrayPersonas.get(i) instanceof Medico) 
        		{ 
        			medicos[contador] = arrayPersonas.get(i).getRut();
        			contador++;
                }
        		
              
            }
        	return medicos;
         }
 
     }
}
