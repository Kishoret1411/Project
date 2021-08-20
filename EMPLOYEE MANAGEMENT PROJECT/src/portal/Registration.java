package portal;

import javax.swing.*;
import dbconnection.DbConnection;

import java.awt.Font;

import java.awt.event.*;


public class Registration implements ActionListener{
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JPasswordField p1;
    JButton b1,b2;
    
       public Registration(){
        	f = new JFrame("FORM");
            l1 = new JLabel("REGISTRATION  FORM");
            l2 = new JLabel("FIRST NAME");
            l3 = new JLabel("LAST NAME");
            l4 = new JLabel("USER ID");
            l5 = new JLabel("DOB (YYYY-MM-DD)");
            l6 = new JLabel("PASSWORD");
            l7 = new JLabel("MAIL ID");
            l8 = new JLabel("GENDER");
            l9 = new JLabel("SKILL");
            
            b1 = new JButton("REGISTER");
            b2 = new JButton("BACK");
            
           
            
            l1.setBounds(220,20,250,40);
            l1.setFont(new Font("serif",Font.BOLD,20));
            l2.setBounds(50,100,100,40);
            l3.setBounds(50,150,100,40);
            l4.setBounds(50,200,100,40);
            l5.setBounds(50,250,150,40);
            l6.setBounds(50,300,200,40);
            l7.setBounds(50,350,200,40);
            l8.setBounds(50,400,200,40);
            l9.setBounds(50,450,200,40);
            
            t1 = new JTextField();
            t2 = new JTextField();
            t3 = new JTextField();
            t4 = new JTextField();
            t5 = new JTextField();
            t6= new JTextField();
            t7 = new JTextField();
            
            t1.setBounds(200,100,250,35);
            t2.setBounds(200,150,250,35);
            t3.setBounds(200,200,250,35);
            t4.setBounds(200,250,250,35);
            t5.setBounds(200,400,250,35);
            t6.setBounds(200,450,250,35);
            t7.setBounds(200,350,250,35);
            
            p1 = new JPasswordField();
           
            
            p1.setBounds(200,300,250,35);
            
            b1.setBounds(350,530,100,40);
            b1.addActionListener(this);
            b2.setBounds(500,530,100,40);
            b2.addActionListener(this);
            
            f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);
            f.add(l6);f.add(l7);f.add(l8);f.add(l9);
            
            f.add(t1);f.add(t2);f.add(t3);f.add(t4);
            f.add(t5);f.add(t6);
            f.add(t7);
      
            
            f.add(p1);
            
            f.add(b1);f.add(b2);
           
            f.setLayout(null);
            f.setSize(700,650);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            f.setResizable(false);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
       public void actionPerformed(ActionEvent e) {
    		String a = t1.getText();
    		String b = t2.getText();
    		String c = t3.getText();
    		String h = t4.getText();
    		String i = t5.getText();
    		String j = t6.getText();
    		String z = t7.getText();
    		@SuppressWarnings("deprecation")
			String d = p1.getText();
 
    		
    		if(e.getSource()==b1) {
    			try {
    				
    				DbConnection c2 = new DbConnection();
					String q ="insert into employee(EmployeeID,FirstName,LastName,Password,Gender,Dob,Skill,MailId) values('"+c+"','"+a+"','"+b+"','"+d+"','"+i+"','"+h+"','"+j+"','"+z+"')";
    				c2.s.executeUpdate(q);
    				JOptionPane.showMessageDialog(null, "Registration Successful");
    				f.setVisible(false);
    				new LoginPage();
    			}catch(Exception ee) {
    				JOptionPane.showMessageDialog(null,"Please Enter The Valid Details");
    			}
    		}
    			else if(e.getSource()==b2) {
    				f.setVisible(false);
    				new LoginPage();
    			}
    		}
    		
    	
    
    
    public static void main(String[] args) {
        new Registration();
    }




	
	
    
}


