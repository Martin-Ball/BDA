package com.martin.myapplication;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class exportXLS {

    public void guardar(String nombreCliente, Context context, View v) {
        Workbook wb = new HSSFWorkbook();

        Cell cell = null;
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());


        Sheet sheet = null;
        sheet = wb.createSheet("PRODUCTOS RECOMENDADOS");

        Row row = null;

        row = sheet.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue("CLIENTE");
        cell.setCellStyle(cellStyle);
        cell = row.createCell(1);
        cell.setCellValue(nombreCliente);
        cell.setCellStyle(cellStyle);

        row = sheet.createRow(3);
        cell = row.createCell(0);
        cell.setCellValue("PRODUCTOS RECOMENDADOS");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(1);
        cell.setCellValue("CATEGORIA");
        cell.setCellStyle(cellStyle);

        infoCliente listaProductosRec = new infoCliente();

        List<String> prodRecom = listaProductosRec.prodRec(nombreCliente, v);

        int k = 0;
        for (int i=4; i <= prodRecom.size(); i++) {
            for (int j=0; j<1; j++)
            {
                row = sheet.createRow(i);
                //CATEGORIA
                cell = row.createCell(j+1);
                cell.setCellValue(prodRecom.get(k));

                //PRODUCTO
                cell = row.createCell(j);
                cell.setCellValue(prodRecom.get(k+1));
                k = k+2;

                if (k >= prodRecom.size())
                {
                    k=0;
                }
            }
        }

        String stringLargo = getLongestString(prodRecom);
        sheet.setColumnWidth(0, stringLargo.length()*300);
        sheet.setColumnWidth(1, stringLargo.length()*300);

        File file = new File(context.getExternalFilesDir(null),"Informacion del Cliente.xls");
        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            wb.write(outputStream);
            Toast.makeText(context,"OK",Toast.LENGTH_LONG).show();
        } catch (java.io.IOException e) {
            e.printStackTrace();

            Toast.makeText(context,"NO OK",Toast.LENGTH_LONG).show();
            try {
                outputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String getLongestString(List<String> prodRec) {
        int maxLength = 0;
        String longestString = null;
        for (String s : prodRec) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                longestString = s;
            }
        }
        return longestString;
    }

}
