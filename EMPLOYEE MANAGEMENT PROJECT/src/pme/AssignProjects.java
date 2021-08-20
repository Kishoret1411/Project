package pme;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

import dbconnection.DbConnection;

import java.awt.event.*;

 class AssignProjects implements ActionListener{

    JFrame f;
    JLabel id1,id8;
    JTextField t1;
    JButton b,b1; 
    String id_emp;

     AssignProjects(String idaa){
        
        f=new JFrame("ADD JOB");
        
        f.setLayout(null);
       
        id_emp = idaa;

        id8 = new JLabel("ASSIGN EMPLOYEE PROJECTS");
        id8.setBounds(100,0,300,40);
        id8.setFont(new Font("serif",Font.ITALIC,20));
        id8.setForeground(Color.black);
        
        f.add(id8);


        id1 = new JLabel("PROJECT");  
        id1.setBounds(60,50,100,40);
        id1.setFont(new Font("serif",Font.BOLD,20));
        f.add(id1);

        t1=new JTextField();
        t1.setBounds(170,59,170,30);
        f.add(t1);

        b=new JButton("UPDATE");
        b.setBounds(130,110,95,30);
        b.addActionListener(this);
        f.add(b);

        b1=new JButton("CANCEL");
        b1.setBounds(260,110,95,30);
        b1.addActionListener(this);
        f.add(b1);
        
        f.setVisible(true);
        f.setSize(500,200);
        f.setBackground(Color.white);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showData(idaa);
    }
    
    int i=0;
    void showData(String s){
        try{
            DbConnection con = new DbConnection();
            String str = "select Project from project1.employee where EmployeeID = '"+s+"'AND Role in ('Emp','Pme')";
            ResultSet rs = con.s.executeQuery(str);

            if(rs.next()){

            	i=1;

                t1.setText(rs.getString(1));
     
            }
            if(i==0) {
            	f.setVisible(false);
            	JOptionPane.showMessageDialog(null, "Id Not Found");
            	new SearchEmployeeForProjects();
            	
            }
            
        }catch(Exception ex){
        	JOptionPane.showMessageDialog(null, "Id Not Found");
        }
      
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b && i==1){
            try{
                DbConnection con = new DbConnection();
                String str = "update project1.employee set Project ='"+t1.getText()+"' where EmployeeID='"+id_emp+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Successfully Updated");
                f.setVisible(false);
                new SearchEmployeeForProjects();
            }catch(Exception e){
            	JOptionPane.showMessageDialog(null, "Cannot Be Updated");
            }
        }
        if(ae.getSource()==b1){
            f.setVisible(false);
            new SearchEmployeeForProjects();
        }
    }

    public static void main(String[] arg){
        new AssignProjects("Add Job");
    }
}