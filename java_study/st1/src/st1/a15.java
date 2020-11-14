package st1;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// SWING : GUI Framework ( 골조 ) 

class MyFirstFrame extends JFrame{
	MyFirstFrame() {
		// TODO Auto-generated constructor stub
		//super(); 캡슐화 되어있어서 안보이지만 이게 진행된다.
	
		setTitle("Hello Swing");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Frame : Title bar + Menu Bar + Content Pane
		
		Container c = getContentPane();
		
		JPanel panel = new JPanel();
		JButton button = new JButton("Button");
		button.setBackground(Color.MAGENTA);
		JLabel label = new JLabel("sejong Univ.");
		
		panel.add(button);
		panel.add(label);
		
		//c.add(panel);
		add(panel);
		
		setVisible(true);
		
	}
}
public class a15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFirstFrame f = new MyFirstFrame();
		
	}

}

// GUI OS Window는 멀티테스킹을 지원함.
// GUI는 새로운 독립적인 프로세스가 생겨나는거라 종료를 따로 해줘야함.