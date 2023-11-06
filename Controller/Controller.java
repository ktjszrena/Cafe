public class Controller
{

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
