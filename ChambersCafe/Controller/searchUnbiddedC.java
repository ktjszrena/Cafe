import java.util.ArrayList;

public class searchUnbiddedC
{
    ArrayList<String> info;
    public ArrayList<String> searchUnbidded(int variant)
    {
        Bids s = new Bids();
        info = s.searchUnbidded(variant);
        return info;
    }
}
