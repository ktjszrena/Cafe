import java.util.ArrayList;

public class updateBidsC {
    boolean isUpdated;
    public boolean updateBids(String date, String role, int id, int approve)
    {
        Bids s = new Bids();
        isUpdated = s.updateBids(date, role, id, approve);
        return isUpdated;
    }
}
