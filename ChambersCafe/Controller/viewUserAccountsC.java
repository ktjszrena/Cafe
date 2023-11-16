import com.kitfox.svg.Use;

import java.util.ArrayList;

public class viewUserAccountsC
{
    private ArrayList<String> userAccountDetails;

    public ArrayList<String> getUserAccountDetails()
    {
        return userAccountDetails;
    }

    public ArrayList<String> viewUserAccounts()
    {
        UserAccount UA = new UserAccount();
        this.userAccountDetails = UA.viewUserAccounts();
        return userAccountDetails;
    }
}
