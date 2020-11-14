package st1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class EventListenerPracticePanel extends JPanel{
	
//	private class MyButtonAction implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			System.out.println("Button Clicked!");
//		}	
//	}
	
	EventListenerPracticePanel(){
		
		setLayout(null);
		//this.setLayout(new BorderLayout());
		// 동서남북, 센터 기준으로 나뉨
		JLabel label = new JLabel("Sejong");
		label.setSize(100,50);
		label.setLocation(0,0);
		add(label);
		
		//MyButtonAction act = new MyButtonAction();
		
		
		JButton button1 = new JButton("button");
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Button Clicked!");
			}
		});
		
		button1.setBounds(0, 50, 100, 50);
		add(button1);
		//Frame 디폴트 세팅이 화면 가득 붙임
		JButton button2 = new JButton("button");
		button2.setBounds(0, 100, 100, 50);
		add(button2);
		
		
		JButton button3 = new JButton("B3");
		button3.setBounds(0,150,100,50);
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(label.getText() == "SW") {
					label.setText("Sejong");
					
				}
				else {
					label.setText("SW");
				}
				
			}
		});
		add(button3);
	}
}

public class a16 extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a16 f = new a16();
		
		
		//new a16( );
		
		//리턴해도 멀티스레딩이라서 GUI는 다른 작업이라 안끝남
		//return;
	}
	
	a16(){
		setTitle("Event Practice");
	    setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		EventListenerPracticePanel panel = new EventListenerPracticePanel();
		
		
		add(panel);
		
		setVisible(true);
		//setVisible(true);
	}
}

//setLayout함수로 원하는 배치 관리자클래스를 넣으면 바뀜
//디폴드는 플로우