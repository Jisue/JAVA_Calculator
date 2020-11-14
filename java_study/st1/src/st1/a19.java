package st1;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class newPanel extends JPanel{
	ArrayList<Shape> shapes;
	Image img;
	
	newPanel(){
		shapes = new ArrayList<>();
		shapes.add(new Rectangle2D.Float(100,100,200,100));
		shapes.add(new Ellipse2D.Float(150,150,200,100));
		
		//요새 인터넷 보안은 sandbox안에서 돌아가게 한다.
//		ImageIcon icon = new ImageIcon("src/st1/죠르디2.png");
//		img = icon.getImage();
		//add(new JLabel(icon));
		
		URL url = getClass().getResource("죠르디2.png");
		try {
			img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//draw라는 함수로 통일 가능, Shape받아서 도형 사용
		Graphics2D g2 = (Graphics2D) g;
		
		// 클리핑 해서 원하는 영역만 그리기.
		//g2.setClip(50,50,300,300);
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));
		g2.drawImage(img, 0, 0,this.getWidth(),this.getHeight(),this);

		
		//g.drawRect(100, 100, 200, 100);
		//g.drawOval(150, 150, 200, 100);
		//g.fillRect(100,100,200,100);
		
		//Shape s = new Rectangle2D.Float(100,100,200,100);
		//Rectangle2D.Double
		//g2.draw(s);
		//g2.draw(new Ellipse2D.Float(150,150,200,100));
		
		Stroke st = new BasicStroke(4.0f, 
				BasicStroke.CAP_SQUARE, // End cap
				BasicStroke.JOIN_MITER, // Join style
				10.0f, 
				new float[] {20,10,5,10}, 		// Dash pattern 
				0.0f); 					// Dash phase
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
		for(Shape s:shapes) {
			int rr = (int)(Math.random()*255);
			int gg = (int)(Math.random()*255);
			int bb = (int)(Math.random()*255);
			Color c = new Color(rr,gg,bb);
			
			Rectangle r = s.getBounds();
			GradientPaint gp = new GradientPaint
					(r.x, 0, c, r.x+r.width,0,Color.white);
			
			g2.setPaint(gp);
			g2.fill(s);
			
			Color c2 = new Color
					((int)(c.getRed()*0.9), (int)(c.getGreen()*0.9), (int)(c.getBlue()*0.9));
			
			g2.setStroke(st);
			g2.setColor(c2);
			g2.draw(s);
			
//			Font font = new Font("궁서체", Font.ITALIC, 50);
//			g2.setFont(font);
//			g2.setColor(c2);
//			g2.drawString("죠르디!!!!", 100, 100);
		}
	}
}

public class a19 extends JFrame{
	public static void main(String[] args) {
		new a19();
	}
	a19(){
		setTitle("Graphics");
		setSize(600,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(new newPanel());
		
		setVisible(true);
	}
}