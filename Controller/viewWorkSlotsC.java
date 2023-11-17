import java.util.ArrayList;

public class viewWorkSlotsC {
    private ArrayList<String> workSlots;
    public ArrayList<String> retrieveWorkSlots()
    {
        Slots s = new Slots();
        workSlots = s.retrieveWorkSlots();
        return workSlots;
    }

    public ArrayList<String> retrieveWorkSlot()
    {
        Slots s = new Slots();
        workSlots = s.retrieveWorkSlot();
        return workSlots;
    }

}
