package pme;

import javax.swing.*;

import portal.LoginPage;

import java.awt.*;
import java.awt.event.*;

public class PmeLogin implements ActionListener {
    JFrame f;
    JButton b1,b3,b4,b7,b8;
    JLabel l1,l2;
    
    public PmeLogin(){
        f = new JFrame("PME PORTAL");
        l1 = new JLabel("WELCOME TO PME PORTAL");
        b1 = new JButton("VIEW EMPLOYEE BY ID");
        b3 = new JButton("ASSIGN PROJECTS");
        b4 = new JButton("ACTIVATE JOB");
        b7 = new JButton("DEACTIVATE JOB");
        b8 = new JButton("LOGOUT");
        
        l1.setBounds(250,20,300,40);
        l1.setFont(new Font("serif",Font.BOLD,20));
        l1.setForeground(Color.black);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("employee/photos/p13.png"));
      		Image i2 = i1.getImage().getScaledInstance(800,500,Image.SCALE_DEFAULT);
      		ImageIcon i3 = new ImageIcon(i2);
      		JLabel l2 = new JLabel(i3);
      		l2.setBounds(0, 0, 800, 500);
      		f.add(l2);
        
        b1.setBounds(100,150,200,50); 
        b1.addActionListener(this);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b3.setBounds(450,150,200,50);
        b3.addActionListener(this);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b4.setBounds(100,300,200,50);
        b4.addActionListener(this);
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b7.setBounds(450,300,200,50);
        b7.addActionListener(this);
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        b8.setBounds(660,410,100,30);
        b8.setBackground(Color.white);
        b8.setForeground(Color.black);
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
		if(e.getSource()==b1) {
			f.setVisible(false);
			new SearchEmployeeId();
		}
		
		if(e.getSource()==b3) {
			f.setVisible(false);
			new SearchEmployeeForProjects();
		}
		
		if(e.getSource()==b4) {
			f.setVisible(false);
			new ActivateJob();
		}
		
		if(e.getSource()==b7) {
			f.setVisible(false);
			new DeactivateJob();
		}
		
		
		
		
		
	}
    
    public static void main(String[] args) {
        new PmeLogin();
    }



	
    
}
