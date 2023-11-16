import java.sql.SQLException;
import java.util.ArrayList;

public class loginUserAccountC
{
    private String userinfo;

    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo;
    }

    public String getUserinfo()
    {
        return userinfo;
    }

    public String loginUserAccountC(int userID, String password) {
        UserAccount c = new UserAccount(userID, password);
        c.loginUserAccount(userID, password);
        setUserinfo(c.getUserInfo());
        return getUserinfo();
    }
}
