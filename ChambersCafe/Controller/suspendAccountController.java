/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author yuanc
 */
public class suspendAccountController {
    private boolean isSuspended;
    
    public suspendAccountController(){
        
    }
    
    boolean suspendAcc(int userID){
        UserAccount uc = new UserAccount(userID);
        isSuspended = uc.suspendAcc(userID);
        System.out.println(userID);
        System.out.print(isSuspended);
        return isSuspended;
    }
    
}
