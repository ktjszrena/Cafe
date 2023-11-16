import java.util.ArrayList;

public class viewBidsC
{
    ArrayList<String> bidsList;
    public ArrayList<String> viewBids()
    {
        Bids s = new Bids();
        bidsList = s.viewBids();
        return bidsList;
    }
}
