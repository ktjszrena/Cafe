public class swapShiftC {
    boolean isSuccessful;
    public boolean swapShift(int userID, String date)
    {
        Bids s = new Bids();
        isSuccessful = s.swapShift(userID, date);
        return isSuccessful;
    }
}
