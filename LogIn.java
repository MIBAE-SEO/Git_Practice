package memo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn extends JFrame {

		public LogIn() {
			JPanel panel = new JPanel();
			JLabel label = new JLabel("ID : ");
			JLabel pawrd = new JLabel("Password : ");
			JButton logBtn = new JButton("Log In");
			
			JTextField txtID = new JTextField(10);
			JPasswordField txtPass = new JPasswordField(10); //text필드지만 암호화됨.
			
			panel.add(label);
			panel.add(txtID);
			panel.add(pawrd);
			panel.add(txtPass);
			panel.add(logBtn);
			
			logBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = "Seo";
					String pass = "1234";
					
					if(id.equals(txtID.getText())&&pass.equals(txtPass.getText())) {
						JOptionPane.showMessageDialog(null, "success!");
					}else {
						JOptionPane.showMessageDialog(null, "failed!");
					}
				}
				
			});
			add(panel);
			
			
			setVisible(true);
			setSize(600,400);
			setLocationRelativeTo(null);
			setResizable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		
		
	
public static void main(String args[]) {
	new LogIn();
}
}
