import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBStatementExecutor {
    public void executeSQL() {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            System.out.println("Connection Successful!");

            String strSelect = "select role, description from userprofile";
            System.out.println("The SQL statement is " + strSelect + "\n");

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are: ");
            int rowCount = 0;

            while (rset.next()) {
                String role = rset.getString("role");
                String desc = rset.getString("description");
                System.out.println(role + ", " + desc);
                rowCount++;
            }
            System.out.println("Total number of records = " + rowCount);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //Error checking
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        DBStatementExecutor a = new DBStatementExecutor();
	a.executeSQL();
    }
}