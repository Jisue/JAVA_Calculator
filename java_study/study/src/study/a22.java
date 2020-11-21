package study;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class WaitNotifyButton extends JButton{
	int value = 0;							// percent : 0~100
	Color cc;
	Thread th = null;
	WaitNotifyButton(String name, Color in){
		super(name);
		cc = in;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(cc);
		g.fillRect(0, 0, (int)(getWidth()*(value/100.0f)), getHeight());
	}
}

class WaitNotifyPracticePanel extends JPanel implements ActionListener{
	
	WaitNotifyButton [] butts = new WaitNotifyButton[4];
	JButton wakeButton;
	
	WaitNotifyPracticePanel(){
		setLayout(null);
		
		for(int i=0; i<4; i++) {
			butts[i] = new WaitNotifyButton("button"+(i+1), Color.red);
			butts[i].setBounds(0,50*i,480, 50);
			butts[i].addActionListener(this);
			add(butts[i]);
		}
		wakeButton = new JButton("Wake!");
		wakeButton.setBounds(0, 250, 480,50);
		wakeButton.addActionListener(this);
		add(wakeButton);
	
	
	}
	synchronized public void addValue(WaitNotifyButton butt) {
		try {
			if(butt.value == 0) wait();
			butt.value ++;
			butt.repaint();
		}
		catch(InterruptedException e) {
		}
	}
	synchronized public void resetValue(WaitNotifyButton butt) {
		butt.value = 0;
		butt.repaint();
		notify();
	}

	class WaitNotifyButtonThread extends Thread{
		WaitNotifyButton butt;
		WaitNotifyButtonThread(WaitNotifyButton in){
			butt = in;
		}
		@Override
		public void run() {
			try {
				//wait();
				butt.value = 0;
				while(butt.value<100) {
					addValue(butt);
					Thread.sleep(10);
				}
				resetValue(butt);
		
			}
			catch(InterruptedException e) {
			}
		}		
	}
	
	
	@Override
	synchronized public void actionPerformed(ActionEvent e) {
		if(e.getSource() == wakeButton) {
			notifyAll();
		}
		else {
			WaitNotifyButton but = (WaitNotifyButton)e.getSource();
			if(but.th != null && but.th.isAlive()) return;
			but.th = new Thread(new WaitNotifyButtonThread(but));
			but.th.start();
		}
	}
	


}

public class a22 extends JFrame{

	public static void main(String[] args) {
		new a22();
	}
	
	a22(){
		setSize(500,500);
		setTitle("Wait and Notify");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new WaitNotifyPracticePanel());
		setVisible(true);
	}

}