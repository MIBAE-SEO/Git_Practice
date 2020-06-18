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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

class ImagePanel extends JPanel{
	private Image img; 
	
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


public class projectBoard {

	JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	/**
	 * Launch the application.
	 */
	

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
		
		
		
		JPanel mainpanel = new JPanel();
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-14, -12, 801, 447);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(14, 12, 801, 447);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		ImagePanel mainpanel1 = new ImagePanel(new ImageIcon("C:/Users/MIBAE/eclipse-workspace/JavaEx/image/mainPanel.jpg").getImage());
		mainpanel1.setBounds(0, 0, 840, 560);
		panel_1.add(mainpanel1);
		mainpanel1.setLayout(null);
	
		
		

		
		JLabel lblNewLabel_2 = new JLabel("Join Us ! ");
		lblNewLabel_2.setBounds(111, 68, 206, 70);
		lblNewLabel_2.setBackground(new Color(245, 222, 179));
		lblNewLabel_2.setForeground(new Color(245, 222, 179));
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 40));
		mainpanel1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setBounds(111, 150, 100, 50);
		lblNewLabel_3.setForeground(new Color(204, 204, 204));
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.PLAIN, 21));
		mainpanel1.add(lblNewLabel_3);
		
		JLabel lblBirth = new JLabel("Birth");
		lblBirth.setBounds(111, 212, 100, 50);
		lblBirth.setForeground(new Color(204, 204, 204));
		lblBirth.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		mainpanel1.add(lblBirth);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(111, 271, 100, 50);
		lblPhone.setForeground(new Color(204, 204, 204));
		lblPhone.setFont(new Font("Segoe Print", Font.PLAIN, 21));
		mainpanel1.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(111, 333, 100, 50);
		lblAddress.setForeground(new Color(204, 204, 204));
		lblAddress.setFont(new Font("Segoe Print", Font.PLAIN, 21));
		mainpanel1.add(lblAddress);
		
		textField_1 = new JTextField();
		textField_1.setBounds(215, 164, 206, 29);
		textField_1.setBackground(new Color(189, 183, 107));
		mainpanel1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(215, 228, 206, 29);
		textField_2.setBackground(new Color(222, 184, 135));
		textField_2.setColumns(10);
		mainpanel1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(215, 287, 206, 29);
		textField_3.setBackground(new Color(211, 211, 211));
		textField_3.setColumns(10);
		mainpanel1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(215, 349, 206, 29);
		textField_4.setBackground(new Color(188, 143, 143));
		textField_4.setColumns(10);
		mainpanel1.add(textField_4);
		
		JButton btnNewButton = new JButton("New button");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_1.getText();
				String birth = textField_2.getText();
				String phone =textField_3.getText();
				String address = textField_4.getText();
				if(name.equals(textField_1.getText()) && birth.equals(textField_2.getText()) && 
						phone.equals(textField_3.getText()) && address.equals(textField_4.getText())) {
					mainpanel1.setVisible(true);
					//모든 항목이 채워지면 넘어가도록 
				}else {
					JOptionPane.showMessageDialog(null, "모든 항목을 입력하셔야 합니다.");
				}	
			}
		});
		
		btnNewButton.setBounds(450, 346, 110, 41);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\MIBAE\\Desktop\\signin.jpg"));
		mainpanel1.add(btnNewButton);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		
		

		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:/Users/MIBAE/eclipse-workspace/JavaEx/image/welcome.jpg").getImage());
		welcomePanel.setBounds(-4, 417, 801, 447);
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(null);
		
	
		
		
		
		
		
		
		
		
		JTextField textField_2_1 = new JTextField(10);
		textField_2_1.setBounds(387, 122, 203, 33);
		textField_2_1.setFont(new Font("굴림", Font.PLAIN, 20));
		textField_2_1.setBackground(SystemColor.controlHighlight);
		welcomePanel.add(textField_2_1);
		textField_2_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("WELCOME!");
		lblNewLabel.setBounds(286, 39, 375, 71);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 65));
		welcomePanel.add(lblNewLabel);
		
		JPasswordField textField_3_1 = new JPasswordField(10);
		textField_3_1.setBounds(387, 167, 203, 33);
		textField_3_1.setFont(new Font("굴림", Font.PLAIN, 20));
		textField_3_1.setColumns(10);
		textField_3_1.setBackground(SystemColor.controlHighlight);
		welcomePanel.add(textField_3_1);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("ID : ");
		lblNewLabel_1.setBounds(330, 124, 62, 26);
		lblNewLabel_1.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		welcomePanel.add(lblNewLabel_1);
		
		JLabel lblPw = new JLabel("PW : ");
		lblPw.setBounds(330, 174, 62, 26);
		lblPw.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		welcomePanel.add(lblPw);
		
		
		
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(426, 212, 105, 27);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = "admin";
				String pass = "0000";
				
				if(id.equals(textField_2_1.getText())&&pass.equals(textField_3_1.getText())) {
					JOptionPane.showMessageDialog(null, "success!");
					welcomePanel.setVisible(false);
					mainpanel1.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "failed!");
				}
			}
			
			
		});
		
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\MIBAE\\Desktop\\btn5.jpg"));
		welcomePanel.add(btnNewButton_1);
		
	
		
		
	
		
		frame.setSize(819,494);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
	}


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
}
