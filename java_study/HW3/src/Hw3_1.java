import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class Hw3_1 extends JFrame{
	
	Hw3_1(){
		setTitle("Hello Swing");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JButton button1 = new JButton("Button");
		panel.add(button1,BorderLayout.CENTER);
		button1.setBackground(Color.MAGENTA);
		
		JButton button2 = new JButton("Button");
		panel.add(button2,BorderLayout.WEST);
		button2.setBackground(Color.BLUE);

		add(panel);
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hw3_1 h = new Hw3_1();
	}

}
