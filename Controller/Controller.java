public class Controller
{
    public String createUserAccountC(String name, int userID, String password, String dob, String address, UserProfile userProfile, String scope)
    {
        UserAccount a = new UserAccount(name, userID, password, dob, address, userProfile, scope);
        return a.getMessage();
    }
}
