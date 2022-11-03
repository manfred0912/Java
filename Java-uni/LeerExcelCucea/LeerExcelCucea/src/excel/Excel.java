package excel;

import com.monitorjbl.xlsx.StreamingReader;
import java.io.File;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Excel {
    
    private final Workbook BOOK;        
    private Sheet SHEET;
        
    public Excel (String path) throws Exception {
        File file = new File (path);
        if (!file.exists() || !file.isFile())
            throw new Exception ("El archivo de excel no existe o no se reconoce su formato");
        
        BOOK =  StreamingReader.builder()         
                .rowCacheSize(1000)        
                .bufferSize(8192)        
                .open(file);        
    }
    
    public Object [][] get (String hoja) throws Exception {
        SHEET = BOOK.getSheet(hoja);

        Object datos [][] = null;
        
        int ren = 0, col;
        for (Row row:SHEET) {
            if (ren == 0)        
                datos = new Object [SHEET.getLastRowNum()+1][row.getLastCellNum()];
            
            col = 0;            
            for (Cell cell:row)            
                if (cell.getCellTypeEnum() == CellType.NUMERIC)                                                                                                
                    datos [ren][col++] = cell.getNumericCellValue(); 
                else if(cell.getCellTypeEnum() == CellType.FORMULA)
                     datos [ren][col++] = cell.getCellFormula();
                else                                                            
                    datos [ren][col++] = cell.getStringCellValue();
 
            ren++;
        }

        if (datos == null)
            throw new Exception ("La hoja: " + SHEET.getSheetName() + " se encuentra vacia...");
        
        return datos;
    }
            
    public void close () throws IOException {
        BOOK.close();
    }
    
    public String [] getHojas () {
        int numero_de_hojas = BOOK.getNumberOfSheets();
        
        String hojas [] = new String [numero_de_hojas];
        for (int i = 0; i < hojas.length; i++)
            hojas[i] = BOOK.getSheetName(i);
        
        return hojas;
    }
}