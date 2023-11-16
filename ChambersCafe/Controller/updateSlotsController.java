public class updateSlotsController
{
    private boolean slotUpdated;
    public boolean updateSlot(String role, int slots, String slotDate)
    {
        Slots s = new Slots();
        slotUpdated = s.updateSlot(role, slots, slotDate);
        return slotUpdated;
    }
}
