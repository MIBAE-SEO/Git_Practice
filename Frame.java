package memo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Frame {

	 	public static void main(String[] args) {
			
	 		JFrame frame = new JFrame();
	 		JPanel panel = new JPanel(); //프레임 안에 패널이 자동으로 들어가는 것이 아니기 때문에 프레임 안에 넣어야함 A-1
	 		JLabel label = new JLabel("text");
	 		JButton btn1 = new JButton("click!");
	 		JButton btn2 = new JButton("exit!");
	 		JTextArea txtArea = new JTextArea();
	 		//JTextField(한줄정도의 글을 넣을 때 )
	 		JPanel btnPanel = new JPanel();
	 		
	 		
	 		btnPanel.add(btn1);
	 		btnPanel.add(btn2);
	 		panel.setLayout(new BorderLayout()); //특정한 부분에 컴포넌트를 구성할 수 있음. 
	 		panel.add(label, BorderLayout.NORTH); 
	 		panel.add(btnPanel, BorderLayout.WEST);
	 		panel.add(txtArea, BorderLayout.CENTER);

	 		
	 		//btn1 기능 추가하기 
	 		btn1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				/* txtArea.append("You are AMAZING\n"); */ 
				//btn1을 누르면 계속해서 메세지가 출력 된다.
					label.setText(txtArea.getText());
				//btn1을 누르면 txtArea에 입력된 텍스트를 label부분으로 옮긴다.
				}
			});
	 		
	 		//btn2 기능 추가하기 --> exit 
	 		btn2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				 System.exit(0);
				}
			});
	 		
	 		frame.add(panel); //A-1
	 		
	 		
	 		
	 		frame.setVisible(true); //frame을 보이게 해라.
	 		frame.setPreferredSize(new Dimension(840, 840/12*9)); 
	 		//선호하는 size (new Dimension (값1,값2)꼭 써줘야함)
	 		frame.setSize(840,840/12*9);
	 		frame.setLocationRelativeTo(null);//GUI출력을 컴퓨터의 어떤부분에서 출력할것인가? null : 가운데
	 		frame.setResizable(true); //크기를 자유롭게 움직이게 할것인가?
	 		
	 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	 		// x를 눌렀을때 프로그램이 계속 돌아가지 않고 모두 종료되게 하라.
	 		
	 		
	 		
		}
}
