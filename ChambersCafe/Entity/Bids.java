import java.sql.*;
import java.util.ArrayList;

public class Bids {

    private String sqlStatement;
    private String message;
    private boolean isUpdated;
    private boolean validateBid;
    private boolean isSuccessful;
    private ArrayList<String> bidsList = new ArrayList<>();
    private ArrayList<String> info = new ArrayList<>();
    private ArrayList<String> slot = new ArrayList<>();
    private ArrayList<String> workSlots = new ArrayList<>();
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
            validateBid = true;
            isUpdated = true;
            isSuccessful = true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
            isUpdated = false;
            validateBid = false;
            isSuccessful = false;
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
                    if (Integer.parseInt(rset.getString("approve")) == 1) {
                        workSlots.add("Date: " + rset.getString("date") + " Role: " + rset.getString("role")
                                + " ID: " + rset.getString("id") + " Status: Approved");

                    }
                    else if (Integer.parseInt(rset.getString("approve")) == 2) {
                        workSlots.add("Date: " + rset.getString("date") + " Role: " + rset.getString("role")
                                + " ID: " + rset.getString("id") + " Status: Rejected");
                    }

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
    public boolean bid(String date, int ID, String role)
    {
        String Day = date.split("-")[0];
        String Month = date.split("-")[1];
        String Year = date.split("-")[2];
        String dateString = Year + "-" + Month + "-" + Day;
        String sql = "insert into staffshift values (STR_TO_DATE('" + date + "','%Y-%m-%d'), '" + role + "', "
                + ID + ", 0);";
        connEx(sql);
        if (validateBid)
        {
            sql = "update workslots set slots = slots - 1 where role = '" + role + "' and date = STR_TO_DATE('" +
                    date + "','%Y-%m-%d');";
            connEx(sql);
        }
        return validateBid;
    }

    public ArrayList<String> viewSlots()
    {
        String sql = "select * from workslots where slots > 0";
        connQueryViewWork(sql);
        return info;
    }
    public ArrayList<String> retrieveSlots(int userID)
    {
        String sql = "select * from staffshift where id = " + userID + " and approve != 0 ;";
        connQueryViewBids(sql);
        return workSlots;
    }
    public ArrayList<String> retrieveSlotsA(int userID)
    {
        String sql = "select * from staffshift where id = " + userID + " and approve = 1 ;";
        connQueryViewBids(sql);
        return workSlots;
    }

    public boolean swapShift(int userID, String date)
    {
        String sql = "update staffshift set approve = 3 where id = " + userID + " and date = (STR_TO_DATE('" +
                date + "','%Y-%m-%d'));";
        connEx(sql);
        return isSuccessful;
    }

}
