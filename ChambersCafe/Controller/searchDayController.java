import java.util.ArrayList;

public class searchDayController {
    private String dayFound;
    public String searchDay(String date, String role)
    {
        Slots s = new Slots();
        dayFound = s.searchDay(date, role);
        return dayFound;
    }
}
