public class UserAccount
{
    private String name;
    private int userID;
    private String password;
    private String dob;
    private String address;
    private UserProfile userProfile;

    private String sqlStatement;

    private String scope;
    private String message;

    public UserAccount(String name, int userID, String password, String dob, String address, UserProfile userProfile, String scope)
    {
        this.name = name;
        this.userID = userID;
        this.password = password;
        this.dob = dob;
        this.address = address;
        this.userProfile = userProfile;
        this.scope = scope;
        createUserAccount(name, userID, password, dob, address, userProfile.getName(), scope);
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

    public String getSqlStatement()
    {
        return sqlStatement;
    }
    public String getMessage()
    {
        return message;
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

    public String createUserAccount(String name, int userID, String password, String dob, String address, String userProfileName, String scope)
    {
        String sql = "insert into useraccount values (" + userID + ", '" + name + "', '" + password + "', '" + address + "', '" + dob + "', '" + userProfileName + "', '" + scope + "');";
        setSqlStatement(sql);
        setMessage("Success");
        return sqlStatement;
    }
}
