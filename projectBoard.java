package memo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;




//패널에 이미지 넣는 class

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
	private JTextField name;
	private JTextField birth;
	private JTextField phone;
	private JTextField email;
	private JTable table;
	
	
	
	public projectBoard() {
		initialize();
	}

	
	private void initialize() {
		
		//DB연결 
		MemberDAO dao = new MemberDAO();
		
		//기본 프레임 틀 				
		frame = new JFrame();
		frame.setSize(819,494);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.getContentPane().setLayout(null);
		


			
					
		//웰컴패널(첫번째패널)
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:/Users/MIBAE/eclipse-workspace/JavaEx/image/welcome.jpg").getImage());
		welcomePanel.setBounds(0, 0, 840, 560);
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME!");
		lblNewLabel.setBounds(286, 39, 375, 71);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 65));
		welcomePanel.add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("ID : ");
		lblNewLabel_1.setBounds(330, 124, 62, 26);
		lblNewLabel_1.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		welcomePanel.add(lblNewLabel_1);
		
		JTextField textField_2_1 = new JTextField(10);
		textField_2_1.setBounds(387, 122, 203, 33);
		textField_2_1.setFont(new Font("굴림", Font.PLAIN, 20));
		textField_2_1.setBackground(SystemColor.controlHighlight);
		welcomePanel.add(textField_2_1);
		textField_2_1.setColumns(10);
		
		JLabel lblPw = new JLabel("PW : ");
		lblPw.setBounds(330, 174, 62, 26);
		lblPw.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		welcomePanel.add(lblPw);
		
		JPasswordField textField_3_1 = new JPasswordField(10);
		textField_3_1.setBounds(387, 167, 203, 33);
		textField_3_1.setFont(new Font("굴림", Font.PLAIN, 20));
		textField_3_1.setColumns(10);
		textField_3_1.setBackground(SystemColor.controlHighlight);
		welcomePanel.add(textField_3_1);
		
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(426, 212, 105, 27);
		btnNewButton_1.setIcon(new ImageIcon("C:/Users/MIBAE/eclipse-workspace/JavaEx/image/btn5.jpg"));
		welcomePanel.add(btnNewButton_1);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFocusPainted(false);
		
		
		
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String id = "admin";
				String pass = "0000";
				
				if(id.equals(textField_2_1.getText())&&pass.equals(textField_3_1.getText())) {
					JOptionPane.showMessageDialog(null, 
							"<html><font face='serif' size='4' color='green'> 관리자 페이지로 이동합니다 !");
					welcomePanel.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null,
							"<html><font face='serif' size='4' color='red'> 비밀번호가 틀렸습니다 ! ");
					 
				}
			}
			
		
		});				
		
				
		// 회원가입패널(두번째패널)
		ImagePanel mainpanel1 = new ImagePanel(new ImageIcon("C:/Users/MIBAE/eclipse-workspace/JavaEx/image/mainPanel.jpg").getImage());
		mainpanel1.setBounds(-13, 570, 840, 560);
		frame.getContentPane().add(mainpanel1);
		mainpanel1.setLayout(null);
		//mainpanel1.setLayout(null);
			
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
		
		JTextField name_1 = new JTextField();
		name_1.setBounds(215, 164, 206, 29);
		name_1.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 20));
		name_1.setBackground(new Color(189, 183, 107));
		name_1.setColumns(10);
		mainpanel1.add(name_1);
		
		JLabel lblBirth = new JLabel("Birth");
		lblBirth.setBounds(111, 212, 100, 50);
		lblBirth.setForeground(new Color(204, 204, 204));
		lblBirth.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		mainpanel1.add(lblBirth);
		
		JTextField birth_1 = new JTextField();
		birth_1.setBounds(215, 228, 206, 29);
		birth_1.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 20));
		birth_1.setBackground(new Color(222, 184, 135));
		birth_1.setColumns(10);
		mainpanel1.add(birth_1);
		
		
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(111, 271, 100, 50);
		lblPhone.setForeground(new Color(204, 204, 204));
		lblPhone.setFont(new Font("Segoe Print", Font.PLAIN, 21));
		mainpanel1.add(lblPhone);
		
		
				
		JTextField phone_1 = new JTextField();
		phone_1.setBounds(215, 287, 206, 29);
		phone_1.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 20));
		phone_1.setBackground(new Color(211, 211, 211));
		phone_1.setColumns(10);
		mainpanel1.add(phone_1);
		
		
		JLabel lblEamail = new JLabel("Email");
		lblEamail.setBounds(111, 333, 100, 50);
		lblEamail.setForeground(new Color(204, 204, 204));
		lblEamail.setFont(new Font("Segoe Print", Font.PLAIN, 21));
		mainpanel1.add(lblEamail);
		
		JTextField email_1 = new JTextField();
		email_1.setBounds(215, 349, 206, 29);
		email_1.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 20));
		email_1.setBackground(new Color(188, 143, 143));
		email_1.setColumns(10);
		mainpanel1.add(email_1);
		
		
		
		

		JButton btnNewButton = new JButton("submit");
		btnNewButton.setBounds(460, 339, 110, 50);
		
		btnNewButton.addActionListener(new ActionListener() {
		
		
			//데이터 입력받아 DB로 ! 
		public void actionPerformed(ActionEvent e) {
			String nameTxt = name_1.getText();
			String birthTxt = birth_1.getText();
			String phoneTxt = phone_1.getText();
			String emailTxt = email_1.getText();
			dao.insertMember(nameTxt,birthTxt,phoneTxt,emailTxt);
			mainpanel1.setVisible(false);
			}
		});
		
			
		
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\MIBAE\\Desktop\\swing\\signin.jpg"));
			mainpanel1.add(btnNewButton);
			btnNewButton.setBorderPainted(false);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setFocusPainted(false);
		
		
		
		
		//마지막패널 				
		JPanel mainpanel2 = new ImagePanel(new ImageIcon("C:/Users/MIBAE/eclipse-workspace/JavaEx/image/mainPanel02.jpg").getImage());
		mainpanel2.setBounds(-13, 1135, 840, 560);
		frame.getContentPane().add(mainpanel2);
		mainpanel2.setLayout(null);
		//mainpanel2.setLayout(null);
		
		
		JLabel lblNewLabel_4 = new JLabel("Member List ");
		lblNewLabel_4.setBounds(40, 43, 214, 41);
		mainpanel2.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Segoe Script", Font.PLAIN, 24));
					
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
