import java.util.ArrayList;

public class viewStaffController {
    private ArrayList<String> staffDetails;
    public ArrayList<String> viewStaff()
    {
        Slots s = new Slots();
        staffDetails = s.viewStaff();
        return staffDetails;
    }
    public ArrayList<String> viewStaffS()
    {
        Slots s = new Slots();
        staffDetails = s.viewStaffS();
        return staffDetails;
    }
}
