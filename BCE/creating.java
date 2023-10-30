import java.sql.*;

public class creating
{
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/staff","Admin","abcd"
                );
                Statement stmt = conn.createStatement();
        )
        {
            String strCreate = "insert into useraccount values ('John', 11, ";
            System.out.println("The SQL statement is " + strCreate + "\n");

            ResultSet rset = stmt.executeQuery(strCreate);

            System.out.println("The records selected are: ");
            int rowCount = 0;

            while(rset.next())
            {
                String role = rset.getString("role");
                String desc = rset.getString("description");
                System.out.println(role + ", " + desc);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
