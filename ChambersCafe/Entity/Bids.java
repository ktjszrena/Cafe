import java.sql.*;
import java.util.ArrayList;

public class Bids {

    private String sqlStatement;
    private String message;
    private boolean isUpdated;
    private ArrayList<String> bidsList = new ArrayList<>();
    private ArrayList<String> info = new ArrayList<>();
    public void setSqlStatement(String sqlStatement)
    {
        this.sqlStatement = sqlStatement;
    }

    public Bids()
    {

    }
    private void connEx(String sql)
    {
        setSqlStatement(sql);
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/staff","Admin","abcd"
                );
                Statement stmt = conn.createStatement();
        )
        {
            System.out.println("The SQL statement is " + sql + "\n");
            int r = stmt.executeUpdate(sql);
            System.out.println("Total number of records Inserted = " + r);
            this.message = "Success!";
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
            isUpdated = false;
        }
    }
    private void connQueryViewBids(String sql)
    {
        setSqlStatement(sql);
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/staff","Admin","abcd"
                );
                Statement stmt = conn.createStatement();
        )
        {
            System.out.println("The SQL statement is " + sql + "\n");
            ResultSet rset = stmt.executeQuery(sql);
            if (!rset.isBeforeFirst()) {

            }
            else {

                while (rset.next()) {
                    bidsList.add("Date: " + rset.getString("date") + " Role: " + rset.getString("role")
                            + " ID: " + rset.getString("id"));

                }
            }
            //this.message = "Success!";
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
        }
    }
    private void connQueryViewWork(String sql)
    {
        setSqlStatement(sql);
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/staff","Admin","abcd"
                );
                Statement stmt = conn.createStatement();
        )
        {
            System.out.println("The SQL statement is " + sql + "\n");
            ResultSet rset = stmt.executeQuery(sql);
            if (!rset.isBeforeFirst()) {
            }
            else {
                while (rset.next()) {
                    info.add(rset.getString("role") + ", " + rset.getString("slots") + ", "
                            + rset.getString("date"));
                }
            }
            //this.message = "Success!";
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
        }
    }
    private void connQueryViewStaffS(String sql)
    {
        setSqlStatement(sql);
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/staff","Admin","abcd"
                );
                Statement stmt = conn.createStatement();
        )
        {
            System.out.println("The SQL statement is " + sql + "\n");
            ResultSet rset = stmt.executeQuery(sql);
            if (!rset.isBeforeFirst()) {
            }
            else {
                while (rset.next()) {
                    info.add(rset.getString("id") + " " + rset.getString("role") + " "
                            + rset.getString("days") + "\n");
                }
            }
            //this.message = "Success!";
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
        }
    }
    public ArrayList<String> viewBids()
    {
        String sql = "select * from staffshift where approve = 0;";
        connQueryViewBids(sql);
        return bidsList;
    }
    public boolean updateBids(String date, String role, int id, int approve)
    {
        String Day = date.split("-")[0];
        String Month = date.split("-")[1];
        String Year = date.split("-")[2];
        String dateString = Year + "-" + Month + "-" + Day;
        String sql;
        if (approve == 1)
        {
            sql = "update staffshift set approve = 1 where date = STR_TO_DATE('" + date+ "','%Y-%m-%d') and role = '"
                    + role + "' and id = " + id + ";";
            connEx(sql);
            isUpdated = true;
        }
        else if (approve == 2)
        {
            sql = "update staffshift set approve = 2 where date = STR_TO_DATE('" + date+ "','%Y-%m-%d') and role = '"
                    + role + "' and id = " + id + ";";
            connEx(sql);
            isUpdated = true;
        }
        return isUpdated;
    }
    public ArrayList<String> searchUnbidded (int variant)
    {
        if (variant == 1)
        {
            String sql = "select * from workslots where slots > 0;";
            connQueryViewWork(sql);
        }
        else if (variant == 2)
        {
            String sql = "select * from staffavail;";
            connQueryViewStaffS(sql);
        }
        return info;
    }

}
