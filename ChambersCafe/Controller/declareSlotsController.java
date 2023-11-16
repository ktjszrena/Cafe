public class declareSlotsController
{
    private boolean declaredSuccess;
    public boolean declareSlots(String role, int id, String days)
    {
        Slots s = new Slots();
        declaredSuccess = s.declareSlots(role, id, days);
        return declaredSuccess;
    }
}
