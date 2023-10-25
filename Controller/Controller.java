public class Controller
{
    public String createUserAccountC(String name, int userID, String password, String dob, String address, UserProfile userProfile, String scope)
    {
        UserAccount a = new UserAccount(name, userID, password, dob, address, userProfile, scope);
        a.createUserAccount(name, userID, password, dob, address, userProfile.getName(), scope);
        return a.getMessage();
        //return a.createUserAccount(name, userID, password, dob, address, userProfile.getName(), scope);
    }
    public String createUserProfileC(String name, String description, String permissions)
    {
        UserProfile b = new UserProfile(name, description, permissions);
        b.createUserProfile(name, description, permissions);
        return b.getMessage();
        //return b.createUserProfile(name, description, permissions);
    }
    public boolean loginUserAccountC(int userID, String password)
    {
        UserAccount c = new UserAccount(userID, password);
        return c.loginUserAccount(userID, password);
    }
}
