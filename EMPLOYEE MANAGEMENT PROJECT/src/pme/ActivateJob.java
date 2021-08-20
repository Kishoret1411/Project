package pme;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import dbconnection.DbConnection;

public class ActivateJob implements ActionListener{
    JFrame f;
    JTextField t;
    JLabel l1,l2,l3,l4,l6,l7,l8;
    JButton b,b1,b2,b3;

    ActivateJob(){
        f=new JFrame("ACTIVATE JOB");
        f.setBackground(Color.white);   
        f.setLayout(null);


        
        l1=new JLabel("EMPLOYEE ID");
        l1.setBounds(50,50,250,30);
        l1.setForeground(Color.black);
        Font f2 = new Font("serif",Font.BOLD,25); 
        l1.setFont(f2);
        f.add(l1);

        t=new JTextField();
        t.setBounds(250,50,150,30);
        f.add(t);


        b=new JButton("SEARCH");
        b.setBounds(200,100,100,30);
        b.addActionListener(this);
        f.add(b);

        b3=new JButton("BACK");
        b3.setBounds(360,100,100,30);   
        b3.addActionListener(this);
        f.add(b3);


        l2=new JLabel("EMPLOYEE ID:"); 
        l2.setBounds(50,150,250,30);
        l2.setForeground(Color.black);
        Font f3 = new Font("serif",Font.BOLD,20); 
        l2.setFont(f3);
        f.add(l2);

        l6=new JLabel();    
        l6.setBounds(200,150,350,30);
        l6.setForeground(Color.black);
        Font F6=new Font("serif",Font.BOLD,20); 
        l6.setFont(F6);
        f.add(l6);

        l3=new JLabel("NAME:");
        l3.setBounds(50,200,250,30);
        l3.setForeground(Color.black);
        Font f4 = new Font("serif",Font.BOLD,20); 
        l3.setFont(f4);
        f.add(l3);


        l7=new JLabel();
        l7.setBounds(200,200,350,30);
        l7.setForeground(Color.black);
        Font F7=new Font("serif",Font.BOLD,20); 
        l7.setFont(F7);
        f.add(l7);



        l4=new JLabel("JOB STATUS:");
        l4.setBounds(50,250,250,30);
        l4.setForeground(Color.black);
        Font F5=new Font("serif",Font.BOLD,20); 
        l4.setFont(F5);
        f.add(l4);

        l8=new JLabel();
        l8.setBounds(200,250,350,30);
        l8.setForeground(Color.black);
        Font f8=new Font("serif",Font.BOLD,20); 
        l8.setFont(f8);
        f.add(l8);

        b1=new JButton("ACTIVATE");
        b1.setBounds(120,300,100,30);
        b1.addActionListener(this);
        f.add(b1);


        b2=new JButton("CANCEL");
        b2.setBounds(300,300,100,30);
        b2.addActionListener(this);
        f.add(b2);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);

        f.setSize(500,500); 
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            try{
                DbConnection  con = new DbConnection();
                String str = "select EmployeeID,FirstName,JobStatus from project1.employee where EmployeeID ='"+t.getText()+"' ";
                ResultSet rs = con.s.executeQuery(str);

                int i=0;
                if(rs.next()){
                    String id = rs.getString(1);
                    String name = rs.getString(2);
                    String status=rs.getString(3);

                    l2.setVisible(true);
                    l3.setVisible(true);
                    l4.setVisible(true);
                    b1.setVisible(true);
                    b2.setVisible(true);    
                    i=1;
                    l6.setText(id);
                    l7.setText(name);
                    l8.setText(status);
                }
                if(i==0)
                    JOptionPane.showMessageDialog(null,"Id Not Found");
            }catch(Exception ex){}
        }
        if(ae.getSource()==b1){
            try{
                DbConnection con = new DbConnection();
                String str = "UPDATE  project1.employee SET JobStatus = 'Active' where EmployeeID = '"+t.getText()+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Status Activated");
             
                f.setVisible(false);
                new PmeLogin();

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Exception Occured While Activating Record "+ex);
            }
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
           new PmeLogin();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
           new PmeLogin();
        }
    }

    public static void main(String[]ar){
        new ActivateJob();
    }
}