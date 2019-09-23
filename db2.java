import java.sql.*;

class Demo2
{
    public static void main(String[] args) {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
        String s1 = "Maruf Memon";
        String mysql = ("DELETE FROM Registration WHERE Name like '" + s1 + "'");
        PreparedStatement p1 = con.prepareStatement(mysql);
        p1.executeUpdate();
        //System.out.println(t);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}