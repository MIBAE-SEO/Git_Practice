package memo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class javaTable {
	
	
	
public static void main(String[] args) {
	JFrame frame = new JFrame("테이블");
	JPanel panel = new JPanel();

	String[] headings = new String[] {"Id","Name","Country"};
	Object[][] data = new Object[][] {
		{"1","Danial","Korea"},
		{"2","Sunny","France"},
		{"3","Yammy","Japan"}
		
	};
	
	
	JTable table = new JTable(data,headings);
	table.
	
	
	panel.add(table);
	
	frame.add(panel);
	
	
	frame.setVisible(true);
	frame.setSize(800, 640);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	
}
}
