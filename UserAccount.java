import java.sql.*;
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

    public UserAccount(int userID){
        this.userID = userID;
    }
    
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
                    setUserInfo(getName() + ", " + getUserID() + ", " + getUserProfileS());
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


        return getUserInfo();
    }

    public boolean suspendAcc(int testID) {
        testID = getUserID();
        boolean x;
        
        
        if (testID == 1)
            x = true;
        else
            x = false;
        
        return x;
    }
}
