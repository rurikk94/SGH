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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 *
 * @author Rurikk
 */
public class Informe {
    private String nombreHoja;
    private String nombreArchivo;
    private String tituloPlanilla;
    private String[] encabezados;
    private Object[][] tabla;

    public Informe(String nombreHoja, String nombreArchivo, String tituloPlanilla, String[] encabezados, Object[][] tabla) {
        this.nombreHoja = nombreHoja;
        this.nombreArchivo = nombreArchivo;
        this.tituloPlanilla = tituloPlanilla;
        this.encabezados = encabezados;
        this.tabla = tabla;
    }

    public String getNombreHoja() {
        return nombreHoja;
    }

    public void setNombreHoja(String nombreHoja) {
        this.nombreHoja = nombreHoja;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getTituloPlanilla() {
        return tituloPlanilla;
    }

    public void setTituloPlanilla(String tituloPlanilla) {
        this.tituloPlanilla = tituloPlanilla;
    }

    public String[] getEncabezados() {
        return encabezados;
    }

    public void setEncabezados(String[] encabezados) {
        this.encabezados = encabezados;
    }

    public Object[][] getTabla() {
        return tabla;
    }

    public void setTabla(Object[][] tabla) {
        this.tabla = tabla;
    }
    
    public boolean informeExcel() throws FileNotFoundException, IOException{
        try {
            
        java.util.Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Integer tituloPos=0,encabezadoPos=1,tablaPos,totalTablaPos,piePos;
        
        
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, nombreHoja); //nombre Hoja
        
        Object[][] pie = new Object[][] {
            new Object[] { "Sistema Gestión de Hospital"},
            new Object[] { "Hoja de Calculo creada por SGH"},
            new Object[] { "https://rurikk94.github.io/SGH/"}
        };
        //Titulo
        CellStyle tituloStyle = workbook.createCellStyle();
        Font tituloFont = workbook.createFont();
        tituloFont.setBold(true);
	tituloFont.setFontHeightInPoints((short) 18);
        tituloStyle.setFont(tituloFont);
        HSSFRow tituloRow = sheet.createRow(tituloPos);
        HSSFCell tituloCell = tituloRow.createCell(0);
        tituloCell.setCellStyle(tituloStyle);
        tituloCell.setCellValue(tituloPlanilla);
        

        //Encabezado
        CellStyle encabezadoStyle = workbook.createCellStyle();
        encabezadoStyle.setAlignment(HorizontalAlignment.CENTER);
        Font encabezadoFont = workbook.createFont();
        //font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        encabezadoStyle.setFont(encabezadoFont);
        encabezadoFont.setBold(true);

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        //style.setFillPattern(CellStyle.SOLID_FOREGROUND);

        HSSFRow encabezadoRow = sheet.createRow(encabezadoPos);
        for (int i = 0; i < encabezados.length; ++i) {
            String encabezado = encabezados[i].toUpperCase();
            HSSFCell encabezadoCell = encabezadoRow.createCell(i);
            encabezadoCell.setCellStyle(encabezadoStyle);
            encabezadoCell.setCellValue(encabezado);
        }
        
        //Tabla
        tablaPos=encabezadoPos + 1;
        for (int i = 0; i < tabla.length; ++i) {
            HSSFRow tablaRow = sheet.createRow(i + tablaPos);

            Object[] d = tabla[i];
            
            for (int j = 0; j < tabla[i].length; j++) {
                tablaRow.createCell(j).setCellValue((String) String.valueOf(d[j]));                
            }
        }
        
        //Acomoda el ancho de las columnas
        for (int x = 0; x < sheet.getRow(1).getPhysicalNumberOfCells(); x++) {
            sheet.autoSizeColumn(x);
        }
        
        piePos=tablaPos + tabla.length+2;
        
        for (int i = 0; i < pie.length; ++i) {
            HSSFRow pieRow = sheet.createRow(piePos + i);

            Object[] d = pie[i];
            String informacion = (String) d[0];

            pieRow.createCell(0).setCellValue(informacion);
        }
        
        //Inserta fecha actual
        HSSFCell fechaCell = tituloRow.createCell(8);
        fechaCell.setCellStyle(encabezadoStyle);
        fechaCell.setCellValue(hourdateFormat.format(date));
        
        
        FileOutputStream file = new FileOutputStream(nombreArchivo+".xls");
        workbook.write(file);
        file.close();
        return true;
        } catch (Exception e) {
            return false;
        }
    }
}
