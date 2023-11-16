import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class UserAccount
{
    private String name;
    private int userID;
    private String password;
    private String dob;
    private String address;
    private UserProfile userProfile;
    private String userProfileS;
    private ResultSet rset;

    private String sqlStatement;

    private String scope;
    private String message;
    private boolean checkexist;
    private String userInfo;
    private String checkpass;
    private ArrayList<String> accounts = new ArrayList<>();

    private String accountFound;

    private int sUserId;

    private boolean isSuspended;
    private String aName;
    private String aPassword;
    private String aAddress;
    private String aProfile;
    private String aScope;
    private boolean success;

    public UserAccount(String name, int userID, String password, String dob, String address, UserProfile userProfile, String scope)
    {
        this.name = name;
        this.userID = userID;
        this.password = password;
        this.dob = dob;
        this.address = address;
        this.userProfile = userProfile;
        this.scope = scope;
        //createUserAccount(name, userID, password, dob, address, userProfile.getName(), scope);
    }
    public UserAccount(String name, int userID, String password, String dob, String address, String userProfileS, String scope)
    {
        this.name = name;
        this.userID = userID;
        this.password = password;
        this.dob = dob;
        this.address = address;
        this.userProfileS = userProfileS;
        this.scope = scope;
        //createUserAccount(name, userID, password, dob, address, userProfile.getName(), scope);
    }

    public UserAccount()
    {

    }

    public UserAccount(int userID)
    {
        this.sUserId = userID;
    }

    public UserAccount(int userID, String password)
    {
        this.userID = userID;
        this.password = password;
    }
    public String getName()
    {
        return name;
    }

    public int getUserID()
    {
        return userID;
    }

    public String getPassword()
    {
        return password;
    }
    public String getDob()
    {
        return dob;
    }

    public String getAddress()
    {
        return address;
    }

    public UserProfile getUserProfile()
    {
        return userProfile;
    }
    public String getScope()
    {
        return scope;
    }
    public ResultSet getRset()
    {
        return rset;
    }

    public String getSqlStatement()
    {
        return sqlStatement;
    }
    public String getMessage()
    {
        return message;
    }
    public boolean getCheckexist()
    {
        return checkexist;
    }

    public String getUserProfileS()
    {
        return userProfileS;
    }
    public String getUserInfo()
    {
        return userInfo;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setDob(String dob)
    {
        this.dob = dob;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setUserProfile(UserProfile userProfile)
    {
        this.userProfile = userProfile;
    }
    public void setScope(String scope)
    {
        this.scope = scope;
    }

    public void setSqlStatement(String sqlStatement)
    {
        this.sqlStatement = sqlStatement;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
    public void setRset(ResultSet rset)
    {
        this.rset = rset;
    }
    public void setUserProfileS(String userProfileS)
    {
        this.userProfileS = userProfileS;
    }
    public void setUserInfo(String userInfo)
    {
        this.userInfo = userInfo;
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
            success = true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
        }
    }

    private void connQueryPass(String sql)
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
            setRset(stmt.executeQuery(sql));

            //System.out.println("Rset is = " + rset.next());
            checkexist = rset.next();
            System.out.println("check is = " + checkexist);
            //this.message = "Success!";
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            this.message = "Operation Failed!";
        }
    }

    private void connQueryLogin(String sql)
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
            setRset(stmt.executeQuery(sql));
            if (!rset.isBeforeFirst()) {
                setUserInfo("Invalid");
            }
            else
            {
                rset.next();
                checkpass = rset.getString("password");
                if (Objects.equals(password, checkpass)) {
                    setName(rset.getString("name"));
                    setUserID(rset.getInt("id"));
                    setUserProfileS(rset.getString("profile"));
                    setScope(rset.getString("scope"));
                    setUserInfo(getName() + ", " + getUserID() + ", " + getUserProfileS() + ", " + getScope());
                    //setMessage("Welcome back " + getName() + " " + getUserID() + " " + getUserProfileS());
                } else {
                    setUserInfo("Invalid");
                    //setMessage("Login failed, please try again");
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

    private void connQueryView(String sql)
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
            setRset(stmt.executeQuery(sql));

            while (rset.next()) {
                accounts.add("Name: " + rset.getString("name") + "\nID: " + rset.getString("id")
                + "\nDate of birth: " + rset.getString("dob") + "\nAddress: " + rset.getString("address")
                + "\nProfile: " + rset.getString("profile") + "\nScope: " + rset.getString("scope") + "\n\n");
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
        setSqlStatement(sql);
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
                accountFound = "Invalid";
            }
            else {
                rset.next();
                accountFound = "Name: " + rset.getString("name") + "\nID: " + rset.getString("id")
                        + "\nDate of birth: " + rset.getString("dob") + "\nAddress: " + rset.getString("address")
                        + "\nProfile: " + rset.getString("profile") + "\nScope: " + rset.getString("scope") + "\n\n";
                aName = rset.getString("name");
                aPassword = rset.getString("password");
                aAddress = rset.getString("address");
                aProfile = rset.getString("profile");
                aScope = rset.getString("scope");
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
        setSqlStatement(sql);
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

    private void connQuerySuspendAcc(String sql)
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
            setRset(stmt.executeQuery(sql));
            if (!rset.isBeforeFirst()) {
                String sql2 = "insert into suspendacc values (" + sUserId + ");";
                int r = stmt.executeUpdate(sql2);
                System.out.println("Total number of records Inserted = " + r);
                isSuspended = true;
            }
            else {
                String sql2 = "delete from suspendacc where id = " + sUserId + ";";
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

    public String createUserAccount(String name, int userID, String password, String dob, String address, String userProfileName, String scope) {
        String sql = "insert into useraccount values ('" + name + "', " + userID + ", '" + password + "', '" + dob + "', '" + address + "', '" + userProfileName + "', '" + scope + "');";
        String check = "select 1 from useraccount where id = " + userID + ";";
        connQueryPass(check);
        if (checkexist == true)
        {
            setMessage("UserID has already been used, try another");
        }
        else
        {
            setSqlStatement(sql);
            connEx(sql);
            this.message = "Success! User " + name + " is successfully created!";
        }
        //this.message = "Success!";
        return getMessage();
    }

    public String loginUserAccount(int userID, String password) {
        String sql = "select * from useraccount where id = " + userID + " and password = '" + password + "';";
        setSqlStatement(sql);
        connQueryLogin(sql);
        sql = "select * from suspendacc where id = " + userID + ";";
        connQuerySuspend(sql);
        UserProfile up = new UserProfile();
        isSuspended = up.checkSuspendedProfile(getUserProfileS());
        if (isSuspended)
        {
            setUserInfo("Suspended");
        }
        return getUserInfo();
    }

    public ArrayList<String> viewUserAccounts()
    {
        String sql = "select * from useraccount;";
        connQueryView(sql);
        return accounts;
    }

    public boolean suspendAcc(int userID)
    {
        String sql = "select * from suspendacc where id = " + userID + ";";
        //connQuerySuspend(sql);
        connQuerySuspendAcc(sql);
        return isSuspended;
    }

    public String searchAccount(int userID)
    {
        String sql = "select * from useraccount where id = " + userID + ";";
        sUserId = userID;
        connQuerySearch(sql);
        return accountFound;
    }

    public boolean updateAcc(String name, int userID, String password, String address, String profile, String scope)
    {
        String sql = "select * from useraccount where id = " + userID + ";";
        sUserId = userID;
        connQuerySearch(sql);
        //System.out.println(aName + " " + aPassword + " " + aAddress + " " + aProfile + " " + aScope);
        if (name.isEmpty())
        {
            name = aName;
        }
        if (password.isEmpty())
        {
            password = aPassword;
        }
        if (address.isEmpty())
        {
            address = aAddress;
        }
        if (profile.isEmpty())
        {
            profile = aProfile;
        }
        if (scope.isEmpty())
        {
            scope = aScope;
        }
        sql = "update useraccount set name = '" + name + "', password = '" + password + "', address = '" + address
        + "', profile = '" + profile + "', scope = '" + scope + "' where id = " + userID + ";";
        connEx(sql);
        return success;
    }
}
