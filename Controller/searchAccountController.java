public class searchAccountController {
    private String accountFound;
    public String searchAccount(int userId)
    {
        UserAccount UA = new UserAccount(userId);
        accountFound = UA.searchAccount(userId);
        return accountFound;
    }
}
