import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Threecolors extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public Threecolors() {
		setTitle("도형 그리기");
		setContentPane(panel);
		setSize(300,300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillArc(10,100,100,100,90,120);
			g.setColor(Color.YELLOW);
			g.fillArc(10,100,100,100,330,120);//90,-120
			g.setColor(Color.BLUE);
			g.fillArc(10,100,100,100,210,120);
		}
	}
	public static void main(String[] args) {
		new Threecolors();
	}
}
