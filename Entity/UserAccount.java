public class UserAccount
{
    private String name;
    private int userID;
    private String password;
    private String dob;
    private String address;
    private UserProfile userProfile;

    public UserAccount(String name, int userID, String password, String dob, String address)
    {
        this.name = name;
        this.userID = userID;
        this.password = password;
        this.dob = dob;
        this.address = address;
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

    public String createUserAccount(String name, int userID, String password, String dob, String address)
    {
        return "Sql Statement is: insert into useraccount values (" + userID + ", '" + name + "', '" + password + "', '" + address + "', '" + dob + "');";
    }
}
