import java.util.ArrayList;

public class viewSlotsStatusC {
    private ArrayList<String> workSlots;

    public ArrayList<String> retrieveSlots(int userID)
    {
        Bids b = new Bids();
        workSlots = b.retrieveSlots(userID);
        return workSlots;
    }
    public ArrayList<String> retrieveSlotsA(int userID)
    {
        Bids b = new Bids();
        workSlots = b.retrieveSlotsA(userID);
        return workSlots;
    }
}
