public class ptSlotsC
{
    private boolean ptSuccess;
    public boolean ptSlots(int ft, int pt, String date)
    {
        Slots s = new Slots();
        ptSuccess = s.ptSlots(ft, pt, date);
        return ptSuccess;
    }
}
