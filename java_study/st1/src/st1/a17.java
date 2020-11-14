package st1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

class MouseKey extends JPanel {
	MouseKey(){
		JButton button = new JButton("button");
		button.setBounds(100,100,100,100);
		JLabel label = new JLabel("Sejong Univ.");
		label.setBounds(100,200,200,100);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = label.getText();
				str = str + "!";
				label.setText(str);
			}
		});
		
		
		add(button);
		add(label);
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) { // 떼면
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) { //누름
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) { //나가면
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) { //들어가면
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) { //그냥 클릭
				// TODO Auto-generated method stub
				
			}
		});
	}
}

public class a17 extends JFrame{

	a17(){
		setTitle("Mouse&KeyB");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MouseKey p = new MouseKey();
		add(p);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new a17();
	}
}