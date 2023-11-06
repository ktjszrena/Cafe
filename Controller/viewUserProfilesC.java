import java.util.ArrayList;

public class viewUserProfilesC
{
    UserProfile up = new UserProfile();
    private ArrayList<String> profiles = new ArrayList<>();
    public ArrayList<String> viewUserProfile()
    {
        profiles = up.viewUserProfile();
        return profiles;
    }
}
