package employee;

import java.awt.event.*;

import javax.swing.*;

import dbconnection.DbConnection;

public class ApplyForJob implements ActionListener {
	JFrame f;
	JComboBox<String> cb;
	JButton b1,b2;
	JLabel l1,l2,l3;
	String ad;
	
	public ApplyForJob(String i_ed){
		f=new JFrame("APPLY");
		ad=i_ed;
		l1 = new JLabel("APPLY FOR JOB");
		l1.setBounds(190, 0, 120, 50);
		f.add(l1);
		
		l2 = new JLabel("SELECT YOUR JOB");
		l2.setBounds(50, 85, 150, 50);
		f.add(l2);
		
		cb = new JComboBox<String>();
		
		cb.addItem("Web Developer");
		cb.addItem("App Developer");
		cb.addItem("Java Developer");
		cb.addItem("Full Stack Developer");
		cb.addItem("Support Engineer");
		
		cb.setBounds(170, 95, 200, 31);
		f.add(cb);
		
		b1 = new JButton("SUBMIT");
		b1.setBounds(120, 180, 80, 30);
		b1.addActionListener(this);
		f.add(b1);
		
		b2 = new JButton("CANCEL");
		b2.setBounds(250, 180, 80, 30);
		b2.addActionListener(this);
		f.add(b2);
		
		f.setSize(500, 300);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			String value =(String)cb.getSelectedItem();
			 try{
	                DbConnection con = new DbConnection();
	                String str = "update project1.employee set Job ='"+value+"' where EmployeeID='"+ad+"'";
	                con.s.executeUpdate(str);
	                JOptionPane.showMessageDialog(null,"Successfully Updated");
	                f.setVisible(false);
	                new EmployeeLogin(ad);
	                
	            }catch(Exception ae){
	            	JOptionPane.showMessageDialog(null, "Cannot Be Updated");
	            }
		
			
		}
		
		if(e.getSource()==b2) {
			f.setVisible(false);
			new EmployeeLogin(ad);
			
		}
		
	}
	
	public static void main (String [] args) {
		   new ApplyForJob("ad");
		
	   }
}

   
