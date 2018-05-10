
package principal;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Date;

public class Archivos 
{
    private Date fechaIngreso;
    private SimpleDateFormat formatter;
    
    public Archivos()
    {
        formatter = new SimpleDateFormat("DD/MM/YYYY");
    }
//metodos cargar archivos
//------------------------------------------------------------------------------
    public void cargaTextoPaciente(Hospital hosp) throws ParseException
    {	
        File raiz = new File("Archivos\\Paciente");//Se crea el archivo raiz donde se encuentran los pacientes
        if(raiz.exists() && raiz.list()!=null)//metodos de la clase file existe el archivo creado y si devuelve un array de String 
        {
            String [] carpeta = raiz.list();//Se crea un Arreglo "carpeta" para recorer los archivos
            for (String carpeta1 : carpeta) {
                try {
                    FileReader archivoLectura = new FileReader("Archivos\\Paciente\\" + carpeta1);//Se instancia un "archivoLectura" de la clase FileReader
                    BufferedReader buffer = new BufferedReader(archivoLectura);		
                    if(buffer.ready())
                    {
                        String cadena = buffer.readLine();
                        if(cadena != null) 
                        {
                            StringTokenizer st = new StringTokenizer(cadena, "|");// el caracter | divide los datos del txt				
                            String nombreCompleto = st.nextToken();//La clase StringTokenizer separa la cadena de texto en tokens 
                            String rut = st.nextToken();
                            String nombrePilaMadre = st.nextToken();
                            String nombrePilaPadre = st.nextToken();                    
                            int edad = Integer.parseInt(st.nextToken());//Se cambia a int 
                            String sexo = st.nextToken();
                            fechaIngreso = formatter.parse(st.nextToken());
                            String codigoCama = st.nextToken();
                            hosp.agregarPaciente(nombreCompleto, rut, nombrePilaMadre, nombrePilaPadre, edad, sexo, fechaIngreso, codigoCama);
                        }
                        buffer.close();
                        archivoLectura.close();
                    }
                }catch(IOException x)
                {
                    System.out.println("Error E/S: "+x);
                }
            }
        }	
    }
;
         
//------------------------------------------------------------------------------
    public void cargaTextoFuncionario(Hospital hosp)
    {
        File raiz = new File("Archivos\\Enfermeria");
        if(raiz.exists() && raiz.list()!=null)
        {
            String [] carpeta = raiz.list();
            for (String carpeta1 : carpeta) {
                try {
                    FileReader archivoLectura = new FileReader("Archivos\\Enfermeria\\" + carpeta1);
                    BufferedReader buffer = new BufferedReader(archivoLectura);			
                    if(buffer.ready())
                    {
                        String cadena = buffer.readLine();
                        if(cadena != null) 
                        {
                            StringTokenizer st = new StringTokenizer(cadena, "|");				
                            String nombre = st.nextToken();
                            String rut = st.nextToken();
                            String sexo = st.nextToken();
                            hosp.agregarLista(nombre, rut, sexo);
                        }						
                        buffer.close();
                        archivoLectura.close();
                    }
                }catch(IOException x)
                {
                    System.out.println("Error E/S: "+x);
                }
            }
        }
    }

//------------------------------------------------------------------------------
    public void cargaTextoSala(Hospital hosp)
    {
        File raiz = new File("Archivos\\Sala");
        if(raiz.exists() && raiz.list()!=null)
        {
            String [] carpeta = raiz.list();
            for (String carpeta1 : carpeta) {
                try {
                    FileReader archivoLectura = new FileReader("Archivos\\Sala\\" + carpeta1);
                    BufferedReader buffer = new BufferedReader(archivoLectura);			
                    if(buffer.ready())
                    {
                        String cadena = buffer.readLine();
                        if(cadena != null) 
                        {
                            StringTokenizer st = new StringTokenizer(cadena, "|");
                            String nombreSala = st.nextToken();
                            int capacidadDeCamas = Integer.parseInt(st.nextToken());
                            int numeroSala = Integer.parseInt(st.nextToken());
                            String rutDoctor = st.nextToken();
                            String especialidad = st.nextToken();
                            int piso = Integer.parseInt(st.nextToken());
                            hosp.agregarSala(nombreSala, capacidadDeCamas, numeroSala, rutDoctor,especialidad, piso);
                        }										
                        buffer.close();
                        archivoLectura.close();
                    }
                }catch(IOException x)
                {
                    System.out.println("Error E/S: "+x);
                }
            }
        }	
    }
//------------------------------------------------------------------------------
    public void cargaTextoCama(Hospital hosp)
    {	
        File raiz = new File("Archivos\\Cama");
        if(raiz.exists() && raiz.list()!=null)
        {
            String [] carpeta = raiz.list();
            for (String carpeta1 : carpeta) {
                try {
                    FileReader archivoLectura = new FileReader("Archivos\\Cama\\" + carpeta1);
                    BufferedReader buffer = new BufferedReader(archivoLectura);			
                    if(buffer.ready())
                    {
                        String cadena = buffer.readLine();
                        if(cadena != null) 
                        {
                            StringTokenizer st = new StringTokenizer(cadena, "|");
                            int numeroSala=Integer.parseInt(st.nextToken());
                            int numeroCama= Integer.parseInt(st.nextToken());
                            String codigoCama = st.nextToken();
                            String rutPaciente = st.nextToken();
                            String especialidad = st.nextToken();
                            hosp.agregarCama(numeroSala,numeroCama, codigoCama, rutPaciente, especialidad);
                        }									
                        buffer.close();
                        archivoLectura.close();
                    }
                }catch(IOException x)
                {
                    System.out.println("Error E/S: "+x);
                }
            }
        }
    }
//------------------------------------------------------------------------------
}// fin clase Archivos