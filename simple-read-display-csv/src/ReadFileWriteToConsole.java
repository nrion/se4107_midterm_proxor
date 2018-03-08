import java.io.FileNotFoundException;
import java.io.IOException;
import com.csvreader.CsvReader;

public class ReadFileWriteToConsole {
	
	private static final int MAXROW = 3;
	private static final int MAXCOL = 3;
    private static final String inFile = "in.csv";
	   
    public String[][] sheet = new String[MAXROW][MAXCOL];
	   
    public static void main(String args[]) throws IOException {
    	// create a ReadWriteToConsole object
    	//  Do not change the signature of this method.
    	// ... insert code here ...
    	// invoke readSheet()
    	// ... insert code here ...
    	// invoke writeSheet()
    	// ... insert code here ...
    	ReadFileWriteToConsole rfw = new ReadFileWriteToConsole();
    	rfw.readSheet();
    	rfw.writeSheet();
    }		
	   
    public void readSheet() throws IOException {
    	// ... insert code here ...
    	//  Do not change the signature of this method.
    	CsvReader reader = new CsvReader(inFile);
    	for (int r = 0; r < MAXROW; r++) {
    		reader.readRecord();
    		for (int c = 0; c < MAXCOL; c++) {
				sheet[r][c] = reader.get(c);
			}
		}
    	
    	reader.close(); 
	}
	   
	public void writeSheet(){
		// ... insert code here ...
    	//  Do not change the signature of this method.
		for (int r = 0; r < MAXROW; r++) {
			for (int c = 0; c < MAXCOL; c++) {
				System.out.print("[" + sheet[r][c] + "]");
			}
			System.out.println();
		}
	}
}
