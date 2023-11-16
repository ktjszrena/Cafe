import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Slots
{
    private boolean slotsCreated;
    private String sqlStatement;
    private String message;
    private boolean exist;
    private boolean slotUpdated;
    private boolean slotsDeleted;
    private int slotsFound;
    private String role;
    private int id;
    private String days;
    private boolean declareSuccess;
    private int pt;
    private int ft;
    private String date;
    private boolean ptSuccess;
    private String dayFound;
    private boolean isUpdated;
    private ArrayList<String> staffDetails = new ArrayList<>();
    private ArrayList<String> workSlots = new ArrayList<>();
    private ArrayList<String> summary = new ArrayList<>();
    private ArrayList<String> bidsList = new ArrayList<>();
    public void setSqlStatement(String sqlStatement)
    {
        this.sqlStatement = sqlStatement;
    }


    public Slots()
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
            slotsCreated = true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
        }
    }
    private void connQuerySearch(String sql)
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
                exist = false;
            }
            else {
                exist = true;
                rset.next();
                slotsFound = Integer.parseInt(rset.getString("slots"));
            }
            //this.message = "Success!";
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
        }
    }
    private void connQueryStaffAvail(String sql)
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
                String sql2 = "insert into staffavail values ('" + role + "', " + id + ", '" + days + "');";
                connEx(sql2);
                declareSuccess = true;
            }
            else {
                declareSuccess = true;
                String sql2 = "update staffavail set days = '" + days + "' where id = " + id + ";";
                connEx(sql2);
            }
            //this.message = "Success!";
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
            declareSuccess = false;
        }
    }

    private void connQueryViewStaff(String sql)
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
                exist = false;
            }
            else {
                exist = true;
                while (rset.next()) {
                    staffDetails.add("ID: " + rset.getString("id") + "\nRole: " + rset.getString("role") + "\nDays: "
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
                exist = false;
            }
            else {
                exist = true;
                while (rset.next()) {
                    staffDetails.add(rset.getString("id") + " " + rset.getString("role") + " "
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
                exist = false;
            }
            else {
                exist = true;
                while (rset.next()) {
                    workSlots.add("Role: " + rset.getString("role") + "\nSlots: " + rset.getString("slots") + "\nDate: "
                            + rset.getString("date") + "\n\n");
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
    private void connQueryViewWorkS(String sql)
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
                exist = false;
            }
            else {
                exist = true;
                while (rset.next()) {
                    workSlots.add(rset.getString("role") + ", " + rset.getString("slots") + ", "
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
    private void connQueryPT(String sql)
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
                String sql2 = "insert into pftable values (STR_TO_DATE('" + date + "','%Y-%m-%d'), " + pt + ", '" + ft + "');";
                connEx(sql2);
                ptSuccess = true;
            }
            else {
                ptSuccess = true;
                String sql2 = "update pftable set pt = " + pt + ", ft = " + ft + " where date = (STR_TO_DATE('" + date + "','%Y-%m-%d'));";
                connEx(sql2);
            }
            //this.message = "Success!";
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
            ptSuccess = false;
        }
    }
    private void connQueryViewWorkSlot(String sql)
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
                exist = false;
            }
            else {
                rset.next();
                exist = true;
                dayFound =  "Number of Slots: " + rset.getString("slots");
            }
            //this.message = "Success!";
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
        }
    }
    private void connQueryViewStaffSlot(String sql)
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
                exist = false;
            }
            else {
                exist = true;
                while (rset.next()) {
                    if (Integer.parseInt(rset.getString("slots")) > 0) {
                        summary.add("Role: " + rset.getString("role") + "\nSlots: " + rset.getString("slots") + "\n\n");
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

    public Date dateConverter(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date utilDate = sdf.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            return sqlDate;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createSlots(String role, int slots, String date) {

        String Day = date.split("-")[0];
        String Month = date.split("-")[1];
        String Year = date.split("-")[2];
        String dateString = Year + "-" + Month + "-" + Day;
        //System.out.println(Year + "-" + Month + "-" + Day);
        String sql = "select * from workslots where role = '" + role + "' and date = STR_TO_DATE('" + dateString + "','%Y-%m-%d');" ;
        connQuerySearch(sql);
        if (!exist) {
            sql = "insert into workslots values ('" + role + "', " + slots + ", STR_TO_DATE('" + dateString + "','%Y-%m-%d'));";
            connEx(sql);
        }
        else
        {
            slotsCreated = false;
        }
        return slotsCreated;
    }
    public boolean updateSlot(String role, int slots, String date) {
        String Day = date.split("-")[0];
        String Month = date.split("-")[1];
        String Year = date.split("-")[2];
        String dateString = Year + "-" + Month + "-" + Day;
        //System.out.println(Year + "-" + Month + "-" + Day);
        String sql = "select * from workslots where role = '" + role + "' and date = STR_TO_DATE('" + dateString + "','%Y-%m-%d');" ;
        connQuerySearch(sql);
        if (!exist) {
            slotUpdated = false;
        }
        else
        {
            sql = "update workslots set slots = " + slots + " where role = '" + role + "' and date = STR_TO_DATE('" + dateString + "','%Y-%m-%d');";
            connEx(sql);
            slotUpdated = true;
        }
        return slotUpdated;
    }
    public boolean deleteSlotS(String role, String date) {
        String Day = date.split("-")[0];
        String Month = date.split("-")[1];
        String Year = date.split("-")[2];
        String dateString = Year + "-" + Month + "-" + Day;
        //System.out.println(Year + "-" + Month + "-" + Day);
        String sql = "select * from workslots where role = '" + role + "' and date = STR_TO_DATE('" + dateString + "','%Y-%m-%d');" ;
        connQuerySearch(sql);
        if (!exist) {
            slotsDeleted = false;
        }
        else
        {
            sql = "delete from workslots where role = '" + role + "' and date = STR_TO_DATE('" + dateString + "','%Y-%m-%d');";
            connEx(sql);
            slotsDeleted = true;
        }
        return slotsDeleted;
    }
    public int searchSlots(String role, String date)
    {
        String Day = date.split("-")[0];
        String Month = date.split("-")[1];
        String Year = date.split("-")[2];
        String dateString = Year + "-" + Month + "-" + Day;
        //System.out.println(Year + "-" + Month + "-" + Day);
        String sql = "select * from workslots where role = '" + role + "' and date = STR_TO_DATE('" + dateString + "','%Y-%m-%d');" ;
        connQuerySearch(sql);
        return slotsFound;
    }

    public boolean declareSlots(String role, int id, String days)
    {
        String sql = "select * from staffavail where id = " + id;
        this.id = id;
        this.role = role;
        this.days = days;
        connQueryStaffAvail(sql);
        return declareSuccess;
    }
    public ArrayList<String> viewStaff()
    {
        String sql = "select * from staffavail;";
        connQueryViewStaff(sql);
        return staffDetails;
    }
    public ArrayList<String> viewStaffS()
    {
        String sql = "select * from staffavail;";
        connQueryViewStaffS(sql);
        return staffDetails;
    }
    public ArrayList<String> retrieveWorkSlots()
    {
        String sql = "select * from workslots;";
        connQueryViewWork(sql);
        return workSlots;
    }
    public ArrayList<String> retrieveWorkSlot()
    {
        String sql = "select * from workslots;";
        connQueryViewWorkS(sql);
        return workSlots;
    }

    public int assignCafeStaff(String date, String role, int id)
    {
        String Day = date.split("-")[0];
        String Month = date.split("-")[1];
        String Year = date.split("-")[2];
        String dateString = Year + "-" + Month + "-" + Day;
        String sql = "insert into staffshift values (STR_TO_DATE('" + dateString + "','%Y-%m-%d'), '" + role + "', " + id + ", 1);";
        connEx(sql);
        if (slotsCreated) {
            sql = "update workslots set slots = slots - 1 where role = '" + role + "' and date = STR_TO_DATE('" + dateString + "','%Y-%m-%d');";
            connEx(sql);
            return 1;
        }
            else{
        return 0;}
    }
    public boolean ptSlots(int ft, int pt, String date)
    {
        String Day = date.split("-")[0];
        String Month = date.split("-")[1];
        String Year = date.split("-")[2];
        String dateString = Year + "-" + Month + "-" + Day;
        String sql = "select * from pftable where date = STR_TO_DATE('" + dateString + "','%Y-%m-%d');";
        this.ft = ft;
        this.pt = pt;
        this.date = dateString;
        connQueryPT(sql);
        return ptSuccess;
    }
    public String searchDay(String date, String role)
    {
        String Day = date.split("-")[0];
        String Month = date.split("-")[1];
        String Year = date.split("-")[2];
        String dateString = Year + "-" + Month + "-" + Day;
        String sql = "select * from workslots where date = STR_TO_DATE('" + dateString + "','%Y-%m-%d') and role = '" + role + "';";
        connQueryViewWorkSlot(sql);
        return dayFound;
    }
    public ArrayList<String> viewWorkSlotDetails(String date)
    {
        String Day = date.split("-")[0];
        String Month = date.split("-")[1];
        String Year = date.split("-")[2];
        String dateString = Year + "-" + Month + "-" + Day;
        String sql = "select * from workslots where date = STR_TO_DATE('" + dateString + "','%Y-%m-%d');";
        connQueryViewStaffSlot(sql);
        return summary;
    }


}
