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
		// ��������, ���� �������� ����
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
		//Frame ����Ʈ ������ ȭ�� ���� ����
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
		
		//�����ص� ��Ƽ�������̶� GUI�� �ٸ� �۾��̶� �ȳ���
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

//setLayout�Լ��� ���ϴ� ��ġ ������Ŭ������ ������ �ٲ�
//������� �÷ο�