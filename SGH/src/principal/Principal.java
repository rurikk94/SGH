/**********************************************************
 * Parte B 2018-05
 *  @author Pablo Cabello
 *  @author Fernando Carvajal
 *  @author Javier Fernandez
 *  @author Sergio Mora
 * 
 * Parte A 2018-04
 *  @author Max Casanova
 *  @author Patricio Torres
 *  @author Dante Vallegos
 *  @author Constanza Zamora
 *  @author Carla Hidalgo
 *  @author Sergio Flores
 
 *********************************************************/

package principal;

import Ventanas.VentanaPrincipal;
import java.io.IOException;
import java.text.ParseException;

public class Principal 
{
    public static void main(String[] args) throws IOException, ParseException
    {
        Hospital  hospi = new Hospital();// invoca a la clase hospital que contiene todos los metodos de las listas
        VentanaPrincipal v1 = new VentanaPrincipal(hospi); 
        v1.setVisible(true);//se invoca a metodo setVisible para conectar con interfaz grafica
        v1.setLocationRelativeTo(null);
    }
}