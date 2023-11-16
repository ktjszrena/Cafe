public class createSlotsController {

    private boolean slotsCreated;
    public boolean createSlots(String role, int slots, String slotDate)
    {
        Slots s = new Slots();
        slotsCreated = s.createSlots(role, slots, slotDate);
        return slotsCreated;
    }
}
