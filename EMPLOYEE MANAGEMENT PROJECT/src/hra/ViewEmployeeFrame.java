package hra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class ViewEmployeeFrame implements ActionListener  {
	
	JFrame f;
	JButton b1,b2,b3;
	
	public ViewEmployeeFrame()  {
		
		b1 = new JButton("VIEW EMPLOYEE BY ID");
		b1.setBounds(50, 80, 165, 40);
		b1.addActionListener(this);
		b2 = new JButton("VIEW ALL EMPLOYEE");
		b2.setBounds(280, 80, 165, 40);
		b2.addActionListener(this);
		b3 = new JButton("CLOSE");
		b3.setBounds(190, 190, 100, 30);
		b3.addActionListener(this);
		
		
		f = new JFrame("VIEW EMPLOYEE");
		f.setVisible(true);
		f.setLayout(null);
		f.setSize(500, 300);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			f.setVisible(false);
			new SearchEmployeeId();
		}
		
		if(e.getSource()==b2) {
			f.setVisible(false);
			try {
				new ViewAllEmployee();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==b3) {
			f.setVisible(false);
			new HraLogin();
		}
	}
	

	public static void main(String[] args) {
		new ViewEmployeeFrame();

	}


}

