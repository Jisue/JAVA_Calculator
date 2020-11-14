package st1;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MultiThreadTimerPanel extends JPanel implements Runnable{
	int time = 0;
	JLabel label = null;
	public MultiThreadTimerPanel() {
		// TODO Auto-generated constructor stub
		label = new JLabel(""+time);
		
		label.setFont(new Font("Arial",Font.BOLD,200));
		add(label);
		
//		Thread t = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					while (true) {
//						time++;
//						label.setText(""+time);
//						Thread.sleep(1000);
//					}
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						return;
//					}
//				}
//		});
//		t.start();
		
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				time++;
				label.setText(""+time);
				Thread.sleep(1000);
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
		}
}

public class a201 extends JFrame{
	
	a201(){
		setTitle("Timer");
		setSize(500,500);
		//모든 쓰레드 중단하고 나간다.
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(new MultiThreadTimerPanel());
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a201 a = new a201();
	}

}
