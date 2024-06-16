import java.util.Scanner;

interface user{
    void withdraw(int amount);
    void deposit(int amount);
    void checkbalance();
}
class useracnt implements user{
  public   int balance;
    useracnt(int balance)
    {
        this.balance=balance;
    }
    public void withdraw(int amount){
if(amount>balance)
{
    System.out.println("Sorry You Cannot Withdraw.Insufficient Balance");
}
else{
balance=balance-amount;
System.out.println("You sucessfully withdrawed RS: "+amount+"\n");
}
    }
    public void deposit(int amount){
balance=balance+amount;
System.out.println("Your account credited Rs: "+amount+"\n");
    }
    public void checkbalance(){
System.out.println("Your current Balnace Is: "+balance+"\n");
    }
}


public class ATM extends useracnt {
    

    ATM(int balance) {
        super(balance);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.printf("Enter Your Current Balance: ");
        int ba=sc.nextInt();
        ATM ob=new ATM(ba);
        while (true) {
            
        
        System.out.println("press 1 to withdraw");
        System.out.println("press 2 to Deposit");
        System.out.println("press 3 to Checkbalance");
        System.out.printf("Enter Your Choice:");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:System.out.printf("Enter Amount To Withdraw:");
            int am=sc.nextInt();
            ob.withdraw(am);
                break;
            
                case 2:System.out.printf("Enter Amount To Deposit:");
                int de=sc.nextInt();
                ob.deposit(de);
                    break;
            
                    case 3:ob.checkbalance();
                   
                        break;
        
            default:
                break;
        }
    }
    }
}
