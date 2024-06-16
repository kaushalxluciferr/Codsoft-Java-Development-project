import java.util.Random;
import java.util.Scanner;

public class randomnum {
public static void main(String[] args) {
    Random com=new Random();
    int comnum=com.nextInt(100);
    Scanner sc=new Scanner(System.in);
    int count =0;
   
    System.out.println("\n Guess Number Between 1 to 100");
    while(true)
    {
        System.out.printf("Enter Your Number:");
        int n=sc.nextInt();
        if(n==comnum)
        {
            System.out.println("Congratulations. You Guessed Correctly....");
            System.out.println("Your total attempt was:"+count);
            count=0;
            break;
        }
        else if(n<comnum)
        {
            System.out.println("Please Enter Big Number");
count++;
        }
        else if(n>comnum)
        {
            System.out.println("Please Enter Small Number");
            count++;
        }

    }
}
    
}