public class Main {
    public static void main(String[] args)
    {
        UserProfile ptest = new UserProfile("Staff","Normal Employee","Able to bid for slots");
        UserAccount atest = new UserAccount("John",10, "pass","27 Aug 1990","123 Main St");
        atest.setUserProfile(ptest);
        System.out.println("User Profile Role: " + atest.getUserProfile().getName());
        System.out.println(atest.createUserAccount(atest.getName(), atest.getUserID(), atest.getPassword(), atest.getAddress(), atest.getDob()));
    }

}
