public class searchSlotsController {
    private int slotsFound;
    public int searchSlots(String role, String slotDate)
    {
        Slots s = new Slots();
        slotsFound = s.searchSlots(role, slotDate);
        return slotsFound;
    }
}
