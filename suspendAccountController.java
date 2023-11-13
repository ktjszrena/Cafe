/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author yuanc
 */
public class suspendAccountController {
    private boolean suspended;
    
    public suspendAccountController(){
        
    }
    
    boolean suspendAcc(int ID){
        
        UserAccount uc = new UserAccount(ID);
        
        suspended = uc.suspendAcc(ID);
        System.out.println(ID);
        System.out.print(suspended);
        return suspended;
    }
    
}
