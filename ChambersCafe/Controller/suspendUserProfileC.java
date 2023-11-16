public class suspendUserProfileC {
    private boolean isSuspended;

    public suspendUserProfileC(){

    }

    boolean suspendProfile(String userProfile){
        UserProfile up = new UserProfile();
        isSuspended = up.suspendProfile(userProfile);
        System.out.println(userProfile);
        System.out.print(isSuspended);
        return isSuspended;
    }
}
