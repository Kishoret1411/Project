package portal;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;

public class FrontPage implements ActionListener {
	JFrame f;
	JLabel l1,l2;
	JButton b;
	
	public FrontPage(){
		f = new JFrame("NIIT");
		f.setForeground(Color.red);
		f.setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("employee/photos/p3.png"));
		Image i2 = i1.getImage().getScaledInstance(681,382,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(265, 120, 650, 430);
		f.add(l1);
		
		
		b = new JButton("PROCEED TO LOGIN PAGE");
		b.setBackground(Color.black);
		b.setForeground(Color.white);
		b.setBounds(480, 550, 200, 50);
		b.addActionListener(this);
		
		l2 = new JLabel();
		l2.setBounds(0, 0, 1360, 750);
		l2.setLayout(null);
		
		JLabel lid = new JLabel("EMPLOYEE MANAGEMENT PORTAL");
		lid.setBounds(80, 30, 1500, 100);
		lid.setFont(new Font("serif",Font.PLAIN,60));
		lid.setForeground(Color.black);
		l2.add(lid);
		l2.add(b);
		f.add(l2);
		
		f.setVisible(true);
		f.setSize(1200, 700);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true) {
			lid.setVisible(false);
			try {
				Thread.sleep(500);
			    }
			catch(Exception e) {}
			lid.setVisible(true);
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				
			}
		}
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b) {
			f.setVisible(false);
			 new LoginPage();
		}
		}
	public static void main(String[] args) {
		 new FrontPage();
	}
}

