package portal;

import javax.swing.*;

import dbconnection.DbConnection;
import employee.EmployeeLogin;
import hra.HraLogin;
import pme.PmeLogin;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage implements ActionListener {
	public JFrame f;
	JLabel l1,l2,l3,l4;
	JButton b1,b2,b3;
	JTextField t1;
	JPasswordField p1;
	
	public LoginPage(){
		f = new JFrame("EMPLOYEE LOGIN");
		f.setBackground(Color.white);
		f.setLayout(null);
		

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("employee/photos/p4.png"));
		Image i2 = i1.getImage().getScaledInstance(172,172,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l4 = new JLabel(i3);
		l4.setBounds(370, 20, 172, 172);
		f.add(l4);
		
		l1 = new JLabel("LOGIN ID");
		l1.setBounds(40, 20, 100, 30);
		f.add(l1);
		
		
		l2 = new JLabel("PASSWORD");
		l2.setBounds(40, 70, 100, 30);
		f.add(l2);
		
		l3 = new JLabel("Not an Employee?");
		l3.setBounds(350, 220, 110, 20);
		f.add(l3);
		
		t1 = new JTextField();
		t1.setBounds(150, 20, 150, 30);
		f.add(t1);
		
		p1 = new JPasswordField();
		p1.setBounds(150, 70, 150, 30);
		f.add(p1);
		
		b1 = new JButton("Login");
		b1.setBounds(40, 140, 120, 30);
		b1.setFont(new Font("serif",Font.BOLD,15));
		b1.addActionListener(this);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		f.add(b1);
		
		b2 = new JButton("Clear");
		b2.setBounds(180, 140, 120, 30);
		b2.setFont(new Font("serif",Font.BOLD,15));
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				p1.setText("");
			}
		});
		f.add(b2);
		
		b3 = new JButton("Register");
		b3.setBounds(465, 223, 90, 17);
		b3.setFont(new Font("serif",Font.BOLD,13));
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				new Registration().f.setVisible(true);
				f.setVisible(false);
			}
		});
		f.add(b3);
		
			
		f.setVisible(true);
		f.setSize(600, 300);
		f.setLocation(400, 300);	
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			DbConnection  c1 = new DbConnection();
			String s1 = t1.getText();
			@SuppressWarnings("deprecation")
			String s2 = p1.getText();
			
			String s3 = "SELECT * FROM project1.employee WHERE EmployeeID='"+s1+"' AND Password='"+s2+"' AND Status ='Active' ";		
			ResultSet rs = c1.s.executeQuery(s3);
		
			if(rs.next()) {
				String aa=rs.getString(9);
				switch (aa) {
				case "Hra":
					new HraLogin();
					f.setVisible(false);
					break;
					
				case "Pme":
					new PmeLogin();
					f.setVisible(false);
					break;
					
				default:
					new EmployeeLogin(t1.getText());
					f.setVisible(false);
					break;
					
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Invalid Login / Account Not Activated");
				
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	
	

	public static void main(String[] args) {
		 new LoginPage();

	}

	

}
