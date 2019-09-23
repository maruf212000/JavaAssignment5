import java.sql.*;

class Demo3
{
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
            Statement st = con.createStatement();
            String s1 = "UPDATE Registration SET Email='asd@qwerty.com' WHERE Name LIKE 'asd'";
            st.executeUpdate(s1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}