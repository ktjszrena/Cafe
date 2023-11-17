public class deleteSlotController {
    private boolean slotsDeleted;
    public boolean deleteSlots(String role, String slotDate)
    {
        Slots s = new Slots();
        slotsDeleted = s.deleteSlotS(role, slotDate);
        return slotsDeleted;
    }

}
