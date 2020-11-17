import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class JavaHW4 extends JFrame implements ActionListener{
	
	private JButton[] buttons; 
    private String[] labels = {"7", "8", "9", "C", "4", "5", "6", "+", "1", "2", "3", "-", "0", " ", " ", "="};
    private JLabel tField; 
    private JPanel bp;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private String tempName; 
    private String tempString;
    private int tempNum1 = 0; 
    private String tempW1;
    private String tempNum2 = ""; 
    private boolean is_ready = false; 
    private String who = ""; 
    private String onText = "";
    
    JavaHW4() {
		//setLayout(new BorderLayout());
		setSize(800,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bp = new JPanel();
		bp.setBackground(Color.black);
		p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.setBackground(Color.black);
		//p1.setPreferredSize(new Dimension(400,750));
		
		p2 = new JPanel(){
	        @Override
	        protected void paintComponent(Graphics g) {
	           super.paintComponent(g);
	           Graphics2D g2 = (Graphics2D) g;
	           Color c = new Color(104, 97, 214);
	           GradientPaint gp = new GradientPaint
						(0, 0, c, 0,getHeight(),Color.white);
	           g2.setPaint(gp);
	           g2.fillRect(0, 0, getWidth(), getHeight());
	           setBorder(new TitledBorder(new LineBorder(new Color(123, 123, 179),getHeight()/9)));
	        }
	     };
		p2.setLayout(new GridLayout());
		tField = new JLabel("0",JLabel.RIGHT);
		//tField2 = new JLabel("0",JLabel.RIGHT);
		//Dimension size = tField.getPreferredSize();
		tField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, p2.getHeight()/5*2));
		tField.setHorizontalAlignment(SwingConstants.RIGHT);
		//p2.setBorder(new TitledBorder(new LineBorder(new Color(96, 91, 105),10)));
		p2.add(tField);
		
		
		p3 = new JPanel();
		p3.setBackground(Color.DARK_GRAY);
		p3.setLayout(new GridLayout(0, 4, 2, 2));
		buttons = new JButton[16];  
        int index = 0; 
        for (int rows = 0; rows < 4; rows++) { 
            for (int cols = 0; cols < 4; cols++) {
                buttons[index] = new JButton(labels[index]);
                buttons[index].addActionListener(this); 
                if (cols >= 3)
                    buttons[index].setForeground(new Color(102,051,102)); 
                else 
                    buttons[index].setForeground(Color.white);
                buttons[index].setBackground(new Color(204, 204, 255));
                buttons[index].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, buttons[index].getHeight()/2));
                buttons[index].setBorder(BorderFactory.createLineBorder(new Color(151, 193, 242)));
                p3.add(buttons[index]); 
                index++; 
            } 
        } 

        this.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {}
			
			@Override
			public void componentResized(ComponentEvent e) {
				Dimension di = e.getComponent().getSize();
				int wx = di.width-20;
				int wy = di.height-50;
				if(wx/2 > wy/3) {
					p1.setPreferredSize(new Dimension((wy/3)*2,wy));
					p2.setPreferredSize(new Dimension((wy/3)*2,wy/3));
					tField.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,p2.getHeight()/5*2));
					p3.setPreferredSize(new Dimension((wy/3)*2,(wy/3)*2));
					for(int i = 0; i < 16; i++) {
						buttons[i].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, buttons[i].getHeight()/2));
					}
				}
				else {
					p1.setPreferredSize(new Dimension(wx,(wx/2)*3));
					p2.setPreferredSize(new Dimension(wx,(wx/2)));
					tField.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,p2.getHeight()/5*2));
					p3.setPreferredSize(new Dimension(wx,wx));
					for(int i = 0; i < 16; i++) {
						buttons[i].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, buttons[i].getHeight()/2));
					}
				}
				
			}
			@Override
			public void componentMoved(ComponentEvent e) {}
			@Override
			public void componentHidden(ComponentEvent e) {}
		});

		int wx = this.getWidth()-20;
		int wy = this.getHeight()-50;
		p1.setPreferredSize(new Dimension((wy/3)*2,wy));
		p2.setPreferredSize(new Dimension((wy/3)*2,wy/3));
		tField.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,wy/3-50));
		p3.setPreferredSize(new Dimension((wy/3)*2,(wy/3)*2));
		
		p1.add(p2,BorderLayout.NORTH);
		p1.add(p3,BorderLayout.CENTER);
		
		bp.add(p1);
		add(bp);
		
		setVisible(true);
	}
    
    public static boolean isNumeric(String str) 
    { 
        try 
        { 
            double d = Double.parseDouble(str); 
        } 
        catch(NumberFormatException nfe) 
        { 
            return false; 
        } 
        return true; 
    }
    
    protected int Calculate(int a, int b, String s) {
        if(s == "+") {
        	return a+b;
        }
        else if(s == "-") {
        	return a-b;
        }
        else {
        	return -1;
        }
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        tempName = e.getActionCommand();
        if (tempName.equals("C")) { 
        	onText = "";
            tField.setText("");
            return; 
        } 
        tempString = tField.getText(); 

        if (tempString.equals("0"))
            tempString = "";

        if ((tempName.equals("+") || tempName.equals("-"))) { 
        	onText = "";
            if(!is_ready) {
            tempW1 = tempString;
            tempNum1 = Integer.parseInt(tempString);
            is_ready = true; 

            who = tempName;
            //tField.setText(tempW1 + tempName);
            //tField.setText(tempW1);
            }
            else {
            	int temp = Integer.parseInt(tempNum2); 
            	tField.setText(Integer.toString(Calculate(tempNum1, temp, who)));
                tempNum1 = Calculate(tempNum1, temp, who);
                who = tempName;
                tempNum2 = "";
                tempW1 = Integer.toString(tempNum1);
                //tField.setText(tempW1 + tempName); 
            }
        } else if (tempName.equals("=") && is_ready && !tempNum2.equals("")) { 
        	
        	onText = "";
            int temp = Integer.parseInt(tempNum2); 
            tField.setText(Integer.toString(Calculate(tempNum1, temp, who))); 
       
            tempName = ""; 
            tempString = ""; 
            tempNum1 = 0; 
            tempNum2 = ""; 
            is_ready = false; 
            who = ""; 
        } 
        else if(tempName.equals("=") && (!is_ready || tempNum2.equals(""))) { 
         
        } 
        else {
        	onText = onText+tempName;
        	tField.setText(onText); 
        } 

        if(is_ready && isNumeric(tempName)) { 
      
            tempNum2 += tempName; 

         
        } 
	}
	
	public static void main(String[] args) {
		new JavaHW4();
	}
	
}