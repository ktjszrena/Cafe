import java.util.ArrayList;

public class assignCafeStaffC {
    private int check;
    public int assignCafeStaff(String date, String role, int id)
    {
        Slots s = new Slots();
        check = s.assignCafeStaff(date, role, id);
        return check;
    }
}
