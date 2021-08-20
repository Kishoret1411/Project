package hra;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import dbconnection.DbConnection;

 class EmployeeProfile implements ActionListener {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,l27;
	String emp_id,f_name,l_name,dob,role,skill,job,status;
	JButton b1;
	
	 EmployeeProfile(String e_id){
		 f=new JFrame("PROFILE");
			f.setVisible(false);
		 
		 int i=0;
		 
		 if(i==0) {
		try {
			DbConnection con = new DbConnection();
			String str = "select * from employee where EmployeeID='"+e_id+"' ";
			ResultSet rs = con.s.executeQuery(str);
			
			while(rs.next()) {
				f.setVisible(true);
				emp_id = rs.getString("EmployeeID");
				f_name = rs.getString("FirstName");
				l_name = rs.getString("LastName");
				dob = rs.getString("Dob");
				role = rs.getString("Role");
				skill = rs.getString("Skill");
				job = rs.getString("Job");
				status = rs.getString("Status");
				
				i=1;
				
				
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		 }
		
		if(i==0) {
            JOptionPane.showMessageDialog(null,"Id not found");
		new SearchEmployeeId();}
	
		
		
		f.setSize(595, 642);
		f.setBackground(Color.white);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		l1 = new JLabel("EMPLOYEE DETAILS");
		l1.setBounds(170, 10, 300, 30);
		l1.setFont(new Font("serif",Font.ITALIC,25));
		f.add(l1);
		
		l2 = new JLabel("EMPLOYEE ID:");
		l2.setBounds(50, 70, 150, 30);
		l2.setFont(new Font("serif",Font.BOLD,20));
		f.add(l2);
		
		l3 = new JLabel(emp_id);
		l3.setBounds(200, 70, 200, 30);
		l3.setFont(new Font("serif",Font.BOLD,20));
		f.add(l3);
		
		l4 = new JLabel("FIRST NAME:");
		l4.setBounds(50, 120, 200, 30);
		l4.setFont(new Font("serif",Font.BOLD,20));
		f.add(l4);
		
		l5 = new JLabel(f_name);
		l5.setBounds(200, 120, 300, 30);
		l5.setFont(new Font("serif",Font.BOLD,20));
		f.add(l5);
		
		l6 = new JLabel("LAST NAME:");
		l6.setBounds(50, 170, 200, 30);
		l6.setFont(new Font("serif",Font.BOLD,20));
		f.add(l6);
		
	
		
		l7 = new JLabel(l_name);
		l7.setBounds(200, 170, 300, 30);
		l7.setFont(new Font("serif",Font.BOLD,20));
		f.add(l7);
		
		l8 = new JLabel("DOB:");
		l8.setBounds(50, 220, 100, 30);
		l8.setFont(new Font("serif",Font.BOLD,20));
		f.add(l8);
		
		l9 = new JLabel(dob);
		l9.setBounds(200, 220, 300, 30);
		l9.setFont(new Font("serif",Font.BOLD,20));
		f.add(l9);
		
		l10 = new JLabel("ROLE:");
		l10.setBounds(50, 270, 100, 30);
		l10.setFont(new Font("serif",Font.BOLD,20));
		f.add(l10);
		
		l11 = new JLabel(role);
		l11.setBounds(200, 270, 300, 30);
		l11.setFont(new Font("serif",Font.BOLD,20));
		f.add(l11);
		
		l12 = new JLabel("SKILL:");
		l12.setBounds(50, 320, 100, 30);
		l12.setFont(new Font("serif",Font.BOLD,20));
		f.add(l12);
		
		l13 = new JLabel(skill);
		l13.setBounds(200, 320, 300, 30);
		l13.setFont(new Font("serif",Font.BOLD,20));
		f.add(l13);
		
		l14 = new JLabel("JOB:");
		l14.setBounds(50, 370, 100, 30);
		l14.setFont(new Font("serif",Font.BOLD,20));
		f.add(l14);
		
		l15 = new JLabel(job);
		l15.setBounds(200, 370, 300, 30);
		l15.setFont(new Font("serif",Font.BOLD,20));
		f.add(l15);
		
		l16 = new JLabel("STATUS:");
		l16.setBounds(50, 420, 100, 30);
		l16.setFont(new Font("serif",Font.BOLD,20));
		f.add(l16);
		
		
		
		l17 = new JLabel(status);
		l17.setBounds(200, 420, 300, 30);
		l17.setFont(new Font("serif",Font.BOLD,20));
		f.add(l17);
		
		b1 = new JButton("CLOSE");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(250, 520, 100, 30);
		b1.addActionListener(this);
		f.add(b1);
	
			
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			f.setVisible(false);
			new SearchEmployeeId();
		}
	
		
	}

	public static void main(String[] args) {
		 new EmployeeProfile("Profile");

	}

	

}
