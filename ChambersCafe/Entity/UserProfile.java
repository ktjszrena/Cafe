import java.sql.*;
import java.util.ArrayList;

public class UserProfile
{
    private String name;
    private String description;
    private String permissions;
    private String message;
    private String sqlstatement;
    private ArrayList<String> userProfileDetails = new ArrayList<>();
    private ResultSet rset;
    private boolean isSuspended;
    private String sRole;
    private String profileFound;
    private boolean isUpdated;
    private String aDesc;
    private String aPerm;

    public UserProfile(String name, String description, String permissions)
    {
        this.name = name;
        this.description = description;
        this.permissions = permissions;
    }

    public UserProfile()
    {

    }
    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String getPermissions()
    {
        return permissions;
    }
    public String getMessage()
    {
        return message;
    }
    public String getSqlstatement()
    {
        return sqlstatement;
    }

    public void setName(String uName)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setPermissions(String permissions)
    {
        this.permissions = permissions;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }

    public void setSqlstatement(String sqlstatement)
    {
        this.sqlstatement = sqlstatement;
    }
    public void setRset(ResultSet rset)
    {
        this.rset = rset;
    }
    private void connEx(String sql)
    {
        setSqlstatement(sql);
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
            isUpdated = true;
            this.message = "Success!";
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
        }
    }
    private void connQueryView(String sql)
    {
        setSqlstatement(sql);
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/staff","Admin","abcd"
                );
                Statement stmt = conn.createStatement();
        )
        {
            System.out.println("The SQL statement is " + sql + "\n");
            setRset(stmt.executeQuery(sql));

            while (rset.next()) {
                userProfileDetails.add("Role: " + rset.getString("Role") + "\nDescription: " + rset.getString("description")
                        + "\nPermission: " + rset.getString("permission") + "\n\n");
            }
            //this.message = "Success!";
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
        }
    }
    public String createUserProfile(String name, String description, String permissions)
    {
        String sql = "insert into userprofile values ('" + name + "', '" + description + "', '" + permissions + "');";

        //setSqlstatement(sql);
        if (name != null && !name.trim().isEmpty() && description != null && !description.trim().isEmpty()) {
            connEx(sql);
            setMessage("User profile " + name + " has been added.");
        }
        else
        {
            setMessage("Invalid input, try again");
        }
        //this.message = "Success";
        return getSqlstatement();
    }
    private void connQuerySuspendPro(String sql)
    {
        setSqlstatement(sql);
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/staff","Admin","abcd"
                );
                Statement stmt = conn.createStatement();
        )
        {
            System.out.println("The SQL statement is " + sql + "\n");
            setRset(stmt.executeQuery(sql));
            if (!rset.isBeforeFirst()) {
                String sql2 = "insert into suspendpro values ('" + sRole + "');";
                int r = stmt.executeUpdate(sql2);
                System.out.println("Total number of records Inserted = " + r);
                isSuspended = true;
            }
            else {
                String sql2 = "delete from suspendpro where role = '" + sRole + "';";
                int r = stmt.executeUpdate(sql2);
                System.out.println("Total number of records Inserted = " + r);
                isSuspended = false;
            }
            //this.message = "Success!";
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
        }
    }
    private void connQuerySuspend(String sql)
    {
        setSqlstatement(sql);
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/staff","Admin","abcd"
                );
                Statement stmt = conn.createStatement();
        )
        {
            System.out.println("The SQL statement is " + sql + "\n");
            setRset(stmt.executeQuery(sql));
            if (!rset.isBeforeFirst()) {
                isSuspended = false;
            }
            else {
                isSuspended = true;
            }
            //this.message = "Success!";
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
        }
    }
    private void connQuerySearch(String sql)
    {
        setSqlstatement(sql);
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/staff","Admin","abcd"
                );
                Statement stmt = conn.createStatement();
        )
        {
            System.out.println("The SQL statement is " + sql + "\n");
            setRset(stmt.executeQuery(sql));
            if (!rset.isBeforeFirst()) {
                profileFound = "Invalid";
            }
            else {
                rset.next();
                profileFound = "Role: " + rset.getString("role") + "\nDescription: " + rset.getString("description")
                        + "\nPermissions: " + rset.getString("permission") + "\n\n";
                aDesc = rset.getString("description");
                aPerm = rset.getString("permission");
            }
            //this.message = "Success!";
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
        }
    }

    public ArrayList<String> viewUserProfile()
    {
        String sql = "select * from userprofile";
        connQueryView(sql);
        return userProfileDetails;
    }

    //public ArrayList<String> viewUserProfiles() //Should be getting from the SQL, not here
    //{
    //    profiles.add("System Admin, Manage all user accounts, sysadm");
    //    profiles.add("Cafe Manager, Handles bids for slots, manager");
    //    profiles.add("Cafe Owner, Manage work slots, owner");
    //    profiles.add("Cafe Staff, Bids for work slots, staff");
    //    return profiles;
    //}

    public boolean suspendProfile(String role)
    {
        sRole = role;
        String sql = "select * from suspendpro where role = '" + role + "';";
        connQuerySuspendPro(sql);
        return isSuspended;
    }

    public boolean checkSuspendedProfile(String profile)
    {
        String sql = "select * from suspendpro where role = '" + profile + "';";
        connQuerySuspend(sql);
        return isSuspended;
    }
    public String searchProfile(String role)
    {
        String sql = "select * from userprofile where role = '" + role + "';";
        sRole = role;
        connQuerySearch(sql);
        return profileFound;
    }

    public boolean updatePro(String role, String description, String permissions)
    {
        String sql = "select * from userprofile where role = '" + role + "';";
        sRole = role;
        connQuerySearch(sql);
        if (description.isEmpty())
        {
            description = aDesc;
        }
        if (permissions.isEmpty())
        {
            permissions = aPerm;
        }
        sql = "update userprofile set description = '" + description + "', permission = '" + permissions
                + "' where role = '" + role + "';";
        connEx(sql);
        return isUpdated;
    }
}
