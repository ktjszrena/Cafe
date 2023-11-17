public class updateUserAccountC {
    private boolean isUpdated;

    public updateUserAccountC(){

    }

    boolean updateUserAccount(String name, int userID, String password, String address, String profile, String scope){
        UserAccount uc = new UserAccount();
       isUpdated = uc.updateAcc(name, userID, password, address, profile, scope);
        System.out.print(isUpdated);
        return isUpdated;
    }
}
