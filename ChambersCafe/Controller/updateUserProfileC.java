public class updateUserProfileC
{
    private boolean isUpdated;

    public updateUserProfileC(){

    }

    boolean updateUserProfile(String role, String description, String permission){
        UserProfile up = new UserProfile();
        isUpdated = up.updatePro(role, description, permission);
        System.out.print(isUpdated);
        return isUpdated;
    }
}
