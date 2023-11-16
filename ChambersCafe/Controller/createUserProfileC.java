public class createUserProfileC
{
    String message;
    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
    public String createUserProfileC(String name, String description, String permissions)
    {
        UserProfile b = new UserProfile(name, description, permissions);
        b.createUserProfile(name, description, permissions);
        setMessage(b.getMessage());
        return getMessage();
        //return b.createUserProfile(name, description, permissions);
    }
}
