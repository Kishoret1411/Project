package hra;


import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dbconnection.DbConnection;


public class ViewAllEmployee  {
	JFrame fr;
	JTable t;
	JButton b1;
	
		public ViewAllEmployee() throws ClassNotFoundException, SQLException {
			DbConnection  c1 = new DbConnection();
		
			fr=new JFrame("EmployeeData");   
			t=new JTable();
			DefaultTableModel model = new DefaultTableModel(new String[]{"Employee ID", "First Name", "Last Name", "Role","Gender","Mail ID","Job", "Status"}, 0);
			ResultSet rst=c1.s.executeQuery("select * from project1.employee where Role='Emp'");
			model.addRow(new Object[]{"Employee ID", "First Name", "Last Name", "Role","Gender","Mail ID","Job", "Status"});
			while(rst.next())
			{
			    int a = rst.getInt("EmployeeID");
			    String b = rst.getString("FirstName");
			    String c = rst.getString("LastName");
			    String d = rst.getString("Role");
			    String e = rst.getString("Gender");
			    String f = rst.getString("MailId");
			    String g = rst.getString("Job");
			    String h = rst.getString("Status");
			  
			    model.addRow(new Object[]{a,b,c,d,e,f,g,h});
			    t.setModel(model);
			 
			    JScrollPane sp=new JScrollPane(t);   
			    
			    b1 = new JButton("CLOSE");
			    b1.setBounds(560, 620, 80, 30);
			    b1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
						new ViewEmployeeFrame().f.setVisible(true);
						fr.setVisible(false);
					}
				});
			    fr.add(b1);
			    
			    fr.add(sp);
			    fr.add(t);
			    
			    fr.setLayout(null);
			    t.setBounds(20,20,1140,580);
			    fr.setVisible(true);
			    fr.setSize(1200, 700);
			    fr.setLocationRelativeTo(null);
			    fr.setResizable(false);
			    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    
			    
			    
			}
			
			
	}
		
		

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		new ViewAllEmployee();

	}
	
    
	
}


