package st1;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// SWING : GUI Framework ( ���� ) 

class MyFirstFrame extends JFrame{
	MyFirstFrame() {
		// TODO Auto-generated constructor stub
		//super(); ĸ��ȭ �Ǿ��־ �Ⱥ������� �̰� ����ȴ�.
	
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

// GUI OS Window�� ��Ƽ�׽�ŷ�� ������.
// GUI�� ���ο� �������� ���μ����� ���ܳ��°Ŷ� ���Ḧ ���� �������.