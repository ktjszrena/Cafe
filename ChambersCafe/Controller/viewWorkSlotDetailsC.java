import java.util.ArrayList;

public class viewWorkSlotDetailsC
{
    private ArrayList<String> summary;
    public ArrayList<String> viewWorkSlotDetails(String date)
    {
        Slots s = new Slots();
        summary = s.viewWorkSlotDetails(date);
        return summary;
    }
}
