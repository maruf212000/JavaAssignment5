import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.*;

class student implements ActionListener
{
    JFrame jf = new JFrame("Student Details");
    JTextField name = new JTextField();
    JTextField rollno = new JTextField();
    JTextField marks = new JTextField();
    JLabel l1 = new JLabel("Name");
    JLabel l2 = new JLabel("Rollno");
    JLabel l3 = new JLabel("Marks");
    JButton b1 = new JButton("Submit");
    JButton b2 = new JButton("Update");
    JButton b3 = new JButton("Delete");
    student()
    {
        jf.setVisible(true);
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(3);
        jf.setLayout(null);
        jf.add(name);
        jf.add(rollno);
        jf.add(marks);
        jf.add(l1);
        jf.add(l2);
        jf.add(l3);
        jf.add(b1);
        jf.add(b2);
        jf.add(b3);
        l1.setBounds(30,30,50,20);
        name.setBounds(70,30,200,20);
        l2.setBounds(30,60,50,20);
        rollno.setBounds(70,60,200,20);
        l3.setBounds(30,90,50,20);
        marks.setBounds(70,90,200,20);
        b1.setBounds(30,120,100,20);
        b1.addActionListener(this);
        b2.setBounds(150,120,100,20);
        b2.addActionListener(this);
        b3.setBounds(270,120,100,20);
        b3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
        
            if(e.getSource() == b1)
            {
                /*String str = "CREATE TABLE Student ( Name varchar(20), Rollno int(6), Marks int(3));";*/
                String str = "INSERT INTO Student(Name,Rollno,Marks) values('" + name.getText() + "'," + rollno.getText() + "," + marks.getText() + ");";
                PreparedStatement sql = con.prepareStatement(str);
                sql.executeUpdate();
            }
            if(e.getSource() == b2)
            {
                String str = "UPDATE Student SET marks = " + 96 + " where rollno = 28";
                PreparedStatement sql = con.prepareStatement(str);
                sql.executeUpdate();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public static void main(String[] args) throws Exception{
        new student();
    }
}