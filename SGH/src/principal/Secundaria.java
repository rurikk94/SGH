/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author PatricioMSI
 */
public class Secundaria {
    public boolean validarNumeros(String cadena)
    {
        if(cadena==null || cadena.equals("")==true) return false;
        int num;
        try
        {
            num =Integer.parseInt(cadena);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
    
    public boolean eliminarArchivo(String ruta, String cadena)
    {
        if(cadena==null || cadena.equals("")==true) return false;
        try{
            File archivo = new File(ruta+cadena+".txt");
            boolean estatus = archivo.delete();
            return estatus;
        }catch(Exception e)
        {
            return false;
        }
    }
    public boolean validarRut(String rut)
    {
        if(rut.equals("")==true) return false;
        int ult= rut.length();
        int largo = rut.length() -3;
        int constante = 2;
        int suma = 0;
        int digito;
            for (int i= largo; i >=0; i--)
            {
                if(validarNumeros(rut.substring(i,i+1))==true)
                {
                    suma= suma + Integer.parseInt(rut.substring(i,i+1)) * constante;
                    constante = constante + 1 ;
                    if(constante == 8)
                    {
                        constante =2; 
                    }
                }
            }
        String ultimo = rut.substring(ult-1).toUpperCase();
        digito =11 - (suma % 11);
        if (digito==10 && ultimo.equals("K")==true)
        {
            return true;
        }else 
        { 
            if(digito == 11 && ultimo.equals("0")){
               return true;    
            } 
            else
            {   if(validarNumeros(ultimo)==true)
                {
                    if(digito == Integer.parseInt(ultimo))
                    {
                        return true;
                    }
                }
            }     
        }
         return false;
    }
    public boolean validarFecha(String fecha)
    {
        int cont=0;
        if(fecha.length()!=9)return false;
        if(fecha.substring(1,4).equals("/")==true && fecha.substring(5,7).equals("/")==true)
        {
            for(int i=0;i<fecha.length();i++)
            {
                if(fecha.substring(i, i+1).equals("/"))
                {
                    cont++;
                }
            }
        }
        return cont==2;
    }
    public String dateToString(Date date)
    {
        DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        String convertido = fecha.format(date);
        return convertido;
    }
}
