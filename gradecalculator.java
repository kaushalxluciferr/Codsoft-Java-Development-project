import java.util.Scanner;

public class gradecalculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.printf("Enter total Subjects:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        int sum=0;
        System.out.println("Enter mark out of 100:");
        for(int i=0;i<n;i++)
        {
            System.out.printf("Enter Student "+(i+1)+" mark:");
            arr[i]=sc.nextInt();
            sum=sum+arr[i];
        }
        
        double avgperc=sum/n;
       if(avgperc>=90&&avgperc<=100)
       {
        System.out.println("Your total mark is: "+sum);
        System.out.println("Your Average Percentage: "+avgperc);
        System.out.println("Your Grade is O");
       }
       if(avgperc>=80&&avgperc<90)
       {
        System.out.println("Your total mark is: "+sum);
        System.out.println("Your Average Percentage: "+avgperc);
        System.out.println("Your Grade is E");
       }
       if(avgperc>=70&&avgperc<80)
       {
        System.out.println("Your total mark is: "+sum);
        System.out.println("Your Average Percentage: "+avgperc);
        System.out.println("Your Grade is A");
       }
       if(avgperc>=60&&avgperc<70)
       {
        System.out.println("Your total mark is: "+sum);
        System.out.println("Your Average Percentage: "+avgperc);
        System.out.println("Your Grade is B");
       }
       if(avgperc>=50&&avgperc<60)
       {
        System.out.println("Your total mark is: "+sum);
        System.out.println("Your Average Percentage: "+avgperc);
        System.out.println("Your Grade is C");
       }
       if(avgperc>=40&&avgperc<50)
       {
        System.out.println("Your total mark is: "+sum);
        System.out.println("Your Average Percentage: "+avgperc);
        System.out.println("Your Grade is D");
       }
       if(avgperc>=30&&avgperc<40)
       {
        System.out.println("Your total mark is: "+sum);
        System.out.println("Your Average Percentage: "+avgperc);
        System.out.println("Your Grade is E");
       }
       if(avgperc<30)
       {
        System.out.println("Your total mark is: "+sum);
        System.out.println("Your Average Percentage: "+avgperc);
        System.out.println("Your Grade is F");
       }
    }
}
