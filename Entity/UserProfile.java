import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserProfile
{
    public String name;
    public String description;
    public String permissions;
    public String message;
    public String sqlstatement;
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
            this.message = "Success!";
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

    public ArrayList<String> viewUserProfile() //Should be getting from the SQL, not here
    {
        ArrayList<String> profiles = new ArrayList<>();
        profiles.add("System Admin, Manage all user accounts, sysadm");
        profiles.add("Cafe Manager, Handles bids for slots, manager");
        profiles.add("Cafe Owner, Manage work slots, owner");
        profiles.add("Cafe Staff, Bids for work slots, staff");
        return profiles;
    }
}
