import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Vector;

import com.csvreader.*;

public class WriteHtml {
    public static final String inFileName = "input.csv";
    public static final String outFileName = "output.html";

    public static void main(String[] args) {
        // ... insert code here ...
    	//  Do not change the signature of this method.
    	try {
			CsvReader reader = new CsvReader(inFileName);
			BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));
			
			writer.write(
				"<html>" + 
					"<head>" + 
						"<title>" + inFileName + "</title>" +
					"</head>" +
					"<body>" +
						"<table style='text-align: left;' "
						+ "border='1' cellpadding='2' cellspacing='2'>" +
							"<tbody>");
			
			for (int r = 0; reader.readRecord(); r++) {
				writer.write("<tr>");
				for (int c = 0; c < reader.getColumnCount(); c++) {
					writer.write("<td>" + EscapeHTML.stringToHTMLString(reader.get(c)) + "</td>");
				}
				writer.write("</tr>");
			}
			reader.close();
			
			writer.write(
							"</tbody>" +
						"</table>" +
					"</body>" +
				"</html>");
			writer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
    }
}
