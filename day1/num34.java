import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawPoly extends JFrame{
	private Mypanel panel = new Mypanel();
	public DrawPoly() {
		setTitle("폐다각형 그리기");
		setContentPane(panel);
		setSize(500,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DrawPoly();

	}
	
	class Mypanel extends JPanel{
		private Vector<Integer> x = new Vector<Integer>(); //x위치
		private Vector<Integer> y = new Vector<Integer>(); //y위치
		
		public Mypanel() {
			this.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					x.add(e.getX()); //위치 알아내기
					y.add(e.getY());
					repaint();
				}
			});
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
			
			int xs[] = new int[x.size()];
			int ys[] = new int[y.size()];
			
			for(int i=0; i<x.size(); i++) {
				xs[i] = x.get(i); //x의 i번째 요소 가져오기
				ys[i] = y.get(i);
			}	
				g.drawPolygon(xs,ys,xs.length);
			
		}
	}
}
