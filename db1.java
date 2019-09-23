import java.sql.*;

class Demo1
{
    public static void main(String[] args) {
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from registration");
            while(rs.next())
            {
                System.out.println(rs.getString("name"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}