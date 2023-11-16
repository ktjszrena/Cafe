import java.util.ArrayList;

public class bidForWorkSlotC
{
    private boolean validateBid;
    private ArrayList<String> workslots;
    public boolean bid(String date, int ID, String role)
    {
        Bids b = new Bids();
        validateBid = b.bid(date, ID, role);
        return validateBid;
    }
    public ArrayList<String> getSlots()
    {
        Bids b = new Bids();
        workslots = b.viewSlots();
        return workslots;
    }
}
