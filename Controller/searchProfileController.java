public class searchProfileController {
    private String profileFound;
    public String searchProfile(String role)
    {
        UserProfile UP = new UserProfile();
        profileFound = UP.searchProfile(role);
        return profileFound;
    }
}
