public class UserProfile
{
    public String name;
    public String description;
    public String permissions;

    public UserProfile(String name, String description, String permissions)
    {
        this.name = name;
        this.description = description;
        this.permissions = permissions;
    }
    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String getPermissions()
    {
        return permissions;
    }

    public void setName(String uName)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setPermissions(String permissions)
    {
        this.permissions = permissions;
    }
}
