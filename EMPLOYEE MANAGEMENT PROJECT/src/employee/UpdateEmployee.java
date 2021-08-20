package employee;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

import dbconnection.DbConnection;

import java.awt.event.*;

 class UpdateEmployee implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id11,id12,lab,lab1;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t10,t11;
    JButton b,b1,b2,b3; 
    String id_emp;

     UpdateEmployee(String idaa){
        
        f=new JFrame("UPDATE");
        
        f.setLayout(null);
       
        id_emp = idaa;

        id8 = new JLabel("UPDATE EMPLOYEE DETAILS");
        id8.setBounds(200,10,700,50);
        id8.setFont(new Font("serif",Font.ITALIC,40));
        id8.setForeground(Color.black);
        
        f.add(id8);


        id1 = new JLabel("EMPLOYEE ID:");  
        id1.setBounds(50,100,150,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        f.add(id1);

        t1=new JTextField();
        t1.setBounds(200,100,150,30);
        f.add(t1);

        id2 = new JLabel("FIRST NAME:");
        id2.setBounds(400,100,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        f.add(id2);

        t2=new JTextField();
        t2.setBounds(600,100,150,30);
        f.add(t2);

        id3= new JLabel("LAST NAME:");
        id3.setBounds(50,150,130,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        f.add(id3);

        t3=new JTextField();
        t3.setBounds(200,150,150,30);
        f.add(t3);

        id4= new JLabel("PASSWORD:");
        id4.setBounds(400,150,120,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        f.add(id4);

        t4=new JTextField();
        t4.setBounds(600,150,150,30);   
        f.add(t4);

        id5= new JLabel("GENDER:");
        id5.setBounds(50,200,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        f.add(id5);

        t5=new JTextField();
        t5.setBounds(200,200,150,30);
        f.add(t5);

        id6= new JLabel("DOB:");
        id6.setBounds(400,200,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));    
        f.add(id6);

        t6=new JTextField();
        t6.setBounds(600,200,150,30);
        f.add(t6);

        id7= new JLabel("SKILL:");
        id7.setBounds(50,250,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        f.add(id7);

        t7=new JTextField();
        t7.setBounds(200,250,150,30);
        f.add(t7);

        id11= new JLabel("MAIL ID:");
        id11.setBounds(400,250,100,30);
        id11.setFont(new Font("serif",Font.BOLD,20));
        f.add(id11);

        t10=new JTextField();
        t10.setBounds(600,250,150,30);
        f.add(t10);
        
        b=new JButton("UPDATE");
        b.setBounds(250,400,100,30);
        b.addActionListener(this);
        f.add(b);

        b1=new JButton("CANCEL");
        b1.setBounds(450,400,100,30);
        b1.addActionListener(this);
        f.add(b1);
        
        f.setVisible(true);
        f.setSize(900,500);
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
            String str = "select EmployeeID,FirstName,LastName,Password,Gender,Dob,Skill,MailId from project1.employee where EmployeeID = '"+s+"'";
            ResultSet rs = con.s.executeQuery(str);

            if(rs.next()){

            	i=1;

                t1.setText(rs.getString(1));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(3));
                t4.setText(rs.getString(4));
                t5.setText(rs.getString(5));
                t6.setText(rs.getString(6));
                t7.setText(rs.getString(7));
                t10.setText(rs.getString(8));
     
            }
            if(i==0) {
            	f.setVisible(false);
            	JOptionPane.showMessageDialog(null, "Id Not Found");
            	new EmployeeLogin(id_emp);
            	
            }
            
        }catch(Exception ex){
        	JOptionPane.showMessageDialog(null, "Id  Found");
        }
       
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b && i==1){
            try{
                DbConnection con = new DbConnection();
                String str = "update project1.employee set EmployeeID ='"+t1.getText()+"',FirstName='"+t2.getText()+"',LastName='"+t3.getText()+"',Password='"+t4.getText()+"',Gender='"+t5.getText()+"',Dob='"+t6.getText()+"',Skill='"+t7.getText()+"',MailId='"+t10.getText()+"' where EmployeeID='"+id_emp+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Successfully Updated");
                f.setVisible(false);
                new EmployeeLogin(id_emp);
            }catch(Exception e){
            	JOptionPane.showMessageDialog(null, "Cannot Be Updated");
            }
        }
        if(ae.getSource()==b1){
            f.setVisible(false);
            new EmployeeLogin(id_emp);
        }
    }

    public static void main(String[] arg){
        new UpdateEmployee("Update Employee");
    }
}