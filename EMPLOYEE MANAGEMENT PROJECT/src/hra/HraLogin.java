package hra;

import javax.swing.*;

import portal.LoginPage;

import java.awt.*;
import java.awt.event.*;

public class HraLogin implements ActionListener {
    JFrame f;
    JButton b1,b3,b4,b7,b8;
    JLabel l1,l2;
    
   public HraLogin(){
        f = new JFrame("HRA PORTAL");
        l1 = new JLabel("WELCOME TO HRA PORTAL");
        b1 = new JButton("VIEW EMPLOYEE");
        b3 = new JButton("ACTIVATE EMPLOYEE");
        b4 = new JButton("DEACTIVATE EMPLOYEE");
        b7 = new JButton("REMOVE EMPLOYEE");
        b8 = new JButton("LOGOUT");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("employee/photos/p7.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,506,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l2 = new JLabel(i3);
		l2.setBounds(0, 0, 900, 506);
	
		f.add(l2);
        
        l1.setBounds(250,20,300,40);
        l1.setFont(new Font("serif",Font.BOLD,20));
     
        l1.setForeground(Color.WHITE);
        
        b1.setBounds(100,150,200,50);  
        b1.addActionListener(this);
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b3.setBounds(450,150,200,50);
        b3.addActionListener(this);
        b3.setBackground(Color.white);
        b3.setForeground(Color.black);
        b4.setBounds(100,300,200,50);
        b4.addActionListener(this);
        b4.setBackground(Color.white);
        b4.setForeground(Color.black);
        b7.setBounds(450,300,200,50);
        b7.addActionListener(this);
        b7.setBackground(Color.white);
        b7.setForeground(Color.black);
        b8.setBounds(660,410,100,30);
        b8.setBackground(Color.black);
        b8.setForeground(Color.white);
        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				new LoginPage().f.setVisible(true);
				f.setVisible(false);
			}
		});
        
        l2.add(l1);
        
        l2.add(b1);l2.add(b3);l2.add(b4);l2.add(b7);l2.add(b8);
        
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(800,500);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b7) {
			f.setVisible(false);
			 new RemoveEmployee();
		}
		
		if(e.getSource()==b4) {
			f.setVisible(false);
			 new StatusDeactivate();
		}
		
		if(e.getSource()==b3) {
			f.setVisible(false);
			new StatusActivate();
		}
		
		if(e.getSource()==b1) {
			f.setVisible(false);
			new ViewEmployeeFrame();
		}
		
	}
    

    
    public static void main(String[] args) {
         new HraLogin();
    }



	
    
}
