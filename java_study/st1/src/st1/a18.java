package st1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Draw extends JPanel implements KeyListener,
									MouseListener,
									MouseMotionListener{
	
	class MyLine {
		int x1,y1,x2,y2;
	}

	ArrayList<MyLine> lines = new ArrayList<MyLine>();
	
	boolean leftButton = false;
	
	int rectW = 100;
	int rectH = 100;
	
//	int [] x1 = new int[100];
//	int [] x2 = new int[100];
//	int [] y1 = new int[100];
//	int [] y2 = new int[100];
	
	int numLines = 0;
	
	Draw(){
		setBackground(new Color(155,130,250));
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setFocusable(true);
		requestFocus();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		MyLine line = new MyLine();
		line.x1 = e.getX();
		line.y1 = e.getY();
		
		line.x2 = e.getX();
		line.y2= e.getY();
		lines.add(line);
		leftButton = true;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		leftButton = false;
		
		MyLine line = lines.get(lines.size()-1);
		line.x2 = e.getX();
		line.y2= e.getY();
		//numLines++;
		repaint();
		
		
	}
	@Override 
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			if(rectW == 200) {
				break;
			}
			rectW +=10;
			repaint();
			break;
			default:
				break;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(leftButton == true) {
			MyLine line = lines.get(lines.size()-1);
			line.x2 = e.getX();
			line.y2= e.getY();
			//numLines++;
			repaint();
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawRect(100, 100, 200, 100);
		g.drawOval(100, 100, 100, 100);
		
		Font font = new Font("궁서체", Font.ITALIC, 30);
		g.setFont(font);
		g.setColor(Color.BLUE);
		g.drawString("세종대학교", 100, 100);
		g.fillRect(100, 100, rectW, rectH);
		
		g.setColor(Color.GREEN);
		int [] x = {400,400,500};
		int [] y = {100,200,100};
		
		g.drawPolygon(x, y, 3);
		 
		for(MyLine e:lines) {
			g.drawLine(e.x1, e.y1, e.x2, e.y2 );
		}
	}
}

public class a18 extends JFrame{
	a18(){
		
		setTitle("Mouse&KeyB");
		setSize(600,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new Draw());
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new a18();
	}

}
