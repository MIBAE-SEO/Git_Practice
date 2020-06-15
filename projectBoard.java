package memo;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class projectBoard {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					projectBoard window = new projectBoard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public projectBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		frame = new JFrame();
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:/Users/MIBAE/eclipse-workspace/JavaEx/image/welcome.jpg").getImage());
		frame.getContentPane().add(welcomePanel);
		
		
		
		JTextField textField_2 = new JTextField(10);
		textField_2.setFont(new Font("굴림", Font.PLAIN, 20));
		textField_2.setBackground(SystemColor.controlHighlight);
		textField_2.setBounds(387, 122, 203, 33);
		welcomePanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("WELCOME!");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 65));
		lblNewLabel.setBounds(286, 39, 375, 71);
		welcomePanel.add(lblNewLabel);
		
		JPasswordField textField_3 = new JPasswordField(10);
		textField_3.setFont(new Font("굴림", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.controlHighlight);
		textField_3.setBounds(387, 167, 203, 33);
		welcomePanel.add(textField_3);
		
		
		
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("ID : ");
		lblNewLabel_1.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(330, 124, 62, 26);
		welcomePanel.add(lblNewLabel_1);
		
		
		
		JLabel lblPw = new JLabel("PW : ");
		lblPw.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		lblPw.setBounds(330, 174, 62, 26);
		welcomePanel.add(lblPw);
		
		
		
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = "seo";
				String pass = "1234";
				
				if(id.equals(textField_2.getText())&&pass.equals(textField_3.getText())) {
					JOptionPane.showMessageDialog(null, "success!");
				}else {
					JOptionPane.showMessageDialog(null, "failed!");
				}
			}
			
		});
		

		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\MIBAE\\Desktop\\btn5.jpg"));
		btnNewButton_1.setBounds(426, 212, 105, 27);
		welcomePanel.add(btnNewButton_1);
		frame.setSize(welcomePanel.getWidth(),welcomePanel.getHeight());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		
		
		
		
		
		class ImagePanel extends JPanel{
			private Image img; //
			
			public ImagePanel(Image img) {
				this.img = img;
				setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
				setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
				setLayout(null); 
				
			}
			
			public int getWidth() {
				return img.getWidth(null);
			}
			
			public int getHeight() {
				return img.getHeight(null);
			}
		
			public void paintComponent(Graphics g) { 
				g.drawImage(img, 0, 0, null); 
			}
		}
		
	}
}


