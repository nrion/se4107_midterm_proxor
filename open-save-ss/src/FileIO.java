// FileIOBase.java -- template for FileIO.java.
//
// this file should be modified to implement
// open, save, and save as... commands for SpreadSheet.java
// 
// Do not modify the signatures of these methods.

import java.io.File;
import java.io.IOException;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class FileIO {
	public static boolean open(SpreadSheet ss, File file) {
    	System.out.println("Open " + file);
    	try {
			CsvReader reader = new CsvReader(file.getPath());
			for (int r = 0; reader.readRecord(); r++) {
				for (int c = 0; c < reader.getColumnCount(); c++) {
					ss.setCell(r, c, reader.get(c));
				}
			}
			reader.close();
			ss.evaluate();
			
	    	return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
    }
	
    public static boolean saveAs(SpreadSheet ss, File file) {
    	System.out.println("SaveAs " + file);
    	try {
    		CsvWriter writer = new CsvWriter(file.getPath());
    		for (int r = 0; r < ss.maxRows; r++) {
    			for (int c = 0; c < ss.maxCols; c++) {
    				writer.write(ss.getCellFormula(r, c));
    			}
    			writer.endRecord();
    		}
    		writer.close();
    		
    		return true; 
    	} catch (IOException e) {
    		System.out.println(e.getMessage());
    		return false;
    	}
    }
}
