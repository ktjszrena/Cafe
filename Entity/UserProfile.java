public class UserProfile
{
    public String name;
    public String description;
    public String permissions;
    public String message;
    public String sqlstatement;
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
    public String getMessage()
    {
        return message;
    }
    public String getSqlstatement()
    {
        return sqlstatement;
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
    public void setMessage(String message)
    {
        this.message = message;
    }

    public void setSqlstatement(String sqlstatement)
    {
        this.sqlstatement = sqlstatement;
    }
    public String createUserProfile(String name, String description, String permissions)
    {
        String sql = "insert into userprofile values ('" + name + "', '" + description + "', '" + permissions + "');";
        setSqlstatement(sql);
        this.message = "Success";
        return getSqlstatement();
    }
}
