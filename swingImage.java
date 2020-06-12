package memo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ImagePanel extends JPanel{
	
	private Image img; //
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		//자동으로 이미지 사이즈에 맞게 조정이 됨
		setLayout(null); //레이아웃을 자유롭게 할 수 있음.
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		
	}
	public void paintComponent(Graphics g) { //img를 자동으로 비쳐지게 함.
		g.drawImage(img, 0, 0, null); 
	}
}

public class swingImage {
		public static void main(String[] args) {
			
			JFrame frame = new JFrame("swingImage");
			frame.setVisible(true);
			frame.setSize(940,780);
			frame.setLocationRelativeTo(null);
			
			
			ImagePanel panel = new ImagePanel(new ImageIcon("./image/Galaxy.jpg").getImage());
			frame.add(panel);
			frame.pack(); //panel 이미지 사이즈에 맞게 frame이 자동으로 살정됨.
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	
	
}
