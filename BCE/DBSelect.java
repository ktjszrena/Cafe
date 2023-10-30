import java.sql.*; // Used to access SQL classes

public class DBSelect {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/staff","Admin","abcd"
                );
                Statement stmt = conn.createStatement();
                )
        {
            String strSelect = "select role, description from userprofile";
            System.out.println("The SQL statement is " + strSelect + "\n");

            ResultSet rset = stmt.executeQuery(strSelect);

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
