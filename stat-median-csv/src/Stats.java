import java.util.Arrays;

public class Stats extends StatsCsv {
	private int rows; 
	private int columns; 
	private String[][] data; 
	
	public Stats(int rows, int columns, String[][] data) {
		this.rows = rows; 
		this.columns = columns; 
		this.data = data; 
		
		computeMedians(); 
	}

	private void computeMedians() {
		data[rows][0] = "";
		data[rows][1] = "Median";
		
		for (int c = 2; c < columns; c++) {
			int[] values = new int[rows - 1];
			
			for (int r = 1; r < rows; r++) {
				values[r - 1] = Integer.parseInt(data[r][c]);
			}
			Arrays.sort(values);
			
			if (values.length % 2 == 1) { // odd
				data[rows][c] = values[values.length / 2] + "";
			} else { // even
				int middle = values.length / 2;
				
				data[rows][c] = 
					(int) Math.ceil(
					(double) (values[middle] + values[middle - 1]) / 2) + "";
			}
		}
	}
}
