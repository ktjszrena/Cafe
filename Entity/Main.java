// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)
    {
        Controller c = new Controller();
        //UserProfile ptest = new UserProfile("Staff","Normal Employee","Able to bid for slots");

        //UserAccount atest = new UserAccount("John",10, "pass","27 Aug 1990","123 Main St", ptest, "Cashier");
        //System.out.println(c.createUserAccountC("John",10, "pass","27 Aug 1990","123 Main St", ptest, "Cashier"));
        //System.out.println(c.createUserProfileC("Cleaner", "Ensure area is clean", "CafeStaff"));
        System.out.println(c.loginUserAccountC(21, "pass"));
    }
}