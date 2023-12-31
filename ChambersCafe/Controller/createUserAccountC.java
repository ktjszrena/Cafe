public class createUserAccountC
{
    private String name;
    private int userId;
    private String dob;
    private String address;
    private String message;

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public String createUserAccountC(String name, int userID, String password, String dob, String address, UserProfile userProfile, String scope)
    {
        UserAccount a = new UserAccount(name, userID, password, dob, address, userProfile, scope);
        a.createUserAccount(name, userID, password, dob, address, userProfile.getName(), scope);
        return a.getMessage();
        //return a.createUserAccount(name, userID, password, dob, address, userProfile.getName(), scope);
    }

    public String createUserAccountC(String name, int userID, String password, String dob, String address, String userProfile, String scope)
    {
        UserAccount a = new UserAccount(name, userID, password, dob, address, userProfile, scope);
        a.createUserAccount(name, userID, password, dob, address, userProfile, scope);
        setMessage(a.getMessage());
        return message;
        //return a.createUserAccount(name, userID, password, dob, address, userProfile.getName(), scope);
    }
}
