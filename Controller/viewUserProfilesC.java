import java.util.ArrayList;

public class viewUserProfilesC
{
    private ArrayList<String> profiles = new ArrayList<>();
    public ArrayList<String> viewUserProfile()
    {
        UserProfile up = new UserProfile();
        profiles = up.viewUserProfile();
        return profiles;
    }
}
