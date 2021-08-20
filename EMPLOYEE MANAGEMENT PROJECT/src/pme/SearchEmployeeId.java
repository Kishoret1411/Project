package pme;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

 class SearchEmployeeId implements ActionListener {
    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JButton b1,b2;
    
         SearchEmployeeId(){
            f = new JFrame("SEARCH");
            
            l1 = new JLabel("EMPLOYEE ID");
            
            b1 = new JButton("SEARCH");
            b2 = new JButton("CANCEL");
           
            l1.setBounds(60,50,100,40);
            l1.setForeground(Color.white);
         
            t1 = new JTextField();
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("employee/photos/a3.jpg"));
      		Image i2 = i1.getImage().getScaledInstance(500,600,Image.SCALE_DEFAULT);
      		ImageIcon i3 = new ImageIcon(i2);
      		JLabel l2 = new JLabel(i3);
      		l2.setBounds(0, 0, 500, 600);
      		f.add(l2);
       
            t1.setBounds(160,55,170,30);
            
            
            b1.setBounds(130,110,95,30);
            b1.addActionListener(this);
            b2.setBounds(260,110,95,30);
            b2.addActionListener(this);
            
            l2.add(l1);
            
            l2.add(t1);
         
            l2.add(b1);l2.add(b2);
           
            f.setLayout(null);
            f.setSize(500,200);
            f.setVisible(true);
            f.setResizable(false);
            f.setLocationRelativeTo(null);    
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        }
        
        @Override
    	public void actionPerformed(ActionEvent ae) {
    		if(ae.getSource()==b1) {
    			f.setVisible(false);
    			new EmployeeProfile(t1.getText());
    		}
    		
    		
    		if(ae.getSource()==b2) {
    			f.setVisible(false);
    			new PmeLogin();
    		}
    		
    		
    		
    	}
    
    
    public static void main(String[] args) {
        new SearchEmployeeId();
    }


	
    
}