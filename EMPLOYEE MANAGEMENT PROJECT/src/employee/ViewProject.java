package employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import dbconnection.DbConnection;

 public class ViewProject implements ActionListener {
	JFrame f;
	JLabel l1,l16,l17;
	String status,aa;
	JButton b1;
	
	public ViewProject(String e_id){
		try {
			DbConnection con = new DbConnection();
			String str = "select * from employee where EmployeeID='"+e_id+"' ";
			ResultSet rs = con.s.executeQuery(str);
			aa=e_id;
			while(rs.next()) {
				
				status = rs.getString("Project");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		f=new JFrame("PROJECT");
		f.setVisible(true);
		f.setSize(500, 300);
		f.setBackground(Color.white);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		
		
		
		l1 = new JLabel("PROJECT");
		l1.setBounds(190, 10, 250, 30);
		l1.setFont(new Font("serif",Font.BOLD,25));
		f.add(l1);
		
		l16 = new JLabel("ASSIGNED PROJECT:");
		l16.setBounds(30, 85, 210, 30);
		l16.setFont(new Font("serif",Font.BOLD,20));
		f.add(l16);
		
		
		
		l17 = new JLabel(status);
		l17.setBounds(260, 85, 300, 30);
		l17.setFont(new Font("serif",Font.BOLD,20));
		f.add(l17);
		
		b1 = new JButton("CLOSE");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(190, 200, 100, 30);
		b1.addActionListener(this);
		f.add(b1);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
			
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			f.setVisible(false);
			new EmployeeLogin(aa);
		}
	
		
	}

	public static void main(String[] args) {
		 new ViewProject("aa");

	}

	

}
