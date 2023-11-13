import java.sql.SQLException;

public class Controller
{


    public boolean loginUserAccountC(int userID, String password) throws SQLException {
        UserAccount c = new UserAccount(userID, password);
        return c.loginUserAccount(userID, password);
    }
}
