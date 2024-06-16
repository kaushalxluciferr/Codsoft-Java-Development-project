import java.util.Scanner;
import java.util.concurrent.*;

public class quiz {
    private Scanner sc = new Scanner(System.in);
    private int sum = 0;

    private CountDownLatch latch1 = new CountDownLatch(1);
    private CountDownLatch latch2 = new CountDownLatch(1);
    private CountDownLatch latch3 = new CountDownLatch(1);

    public void quiz1() {
        System.out.println("A) Which of the following option leads to the portability and security of Java?");
        System.out.println("1. Bytecode is executed by JVM");
        System.out.println("2. The applet makes the Java code secure and portable");
        System.out.println("3. Use of exception handling");
        System.out.println("4. Dynamic binding between objects");
        System.out.printf("Enter Your Choice: ");
        int n1 = sc.nextInt();
        if (n1 == 1) {
            sum++;
            System.out.println("Congrats Your Answer Is correct!!\n\n");
        } else {
            System.out.println("Sorry. Your Answer is Wrong!!\n\n");
        }
        latch1.countDown(); // Signal that the user has given an answer
    }

    public void quiz2() {
        System.out.println("B. Which of the following is not a Java feature?");
        System.out.println("1. Dynamic\n" + 
                        "2. Architecture Neutral\n" + 
                        "3. Use of pointers\n" + 
                        "4. Object-oriented");
        System.out.printf("Enter Your Choice: ");
        int n2 = sc.nextInt();
        if (n2 == 3) {
            sum++;
            System.out.println("Congrats Your Answer Is correct!!\n\n");
        } else {
            System.out.println("Sorry. Your Answer is Wrong!!\n\n");
        }
        latch2.countDown();
    }

    public void quiz3() {
        System.out.println("C. _____ is used to find and fix bugs in the Java programs.");
        System.out.println("1. JVM\n" + 
                        "2. JRE\n" + 
                        "3. JDK\n" + 
                        "4. JDB");
        System.out.printf("Enter Your Choice: ");
        int n3 = sc.nextInt();
        if (n3 == 4) {
            sum++;
            System.out.println("Congrats Your Answer Is correct!!\n\n");
        } else {
            System.out.println("Sorry. Your Answer is Wrong!!\n\n");
        }
        latch3.countDown();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        quiz ob = new quiz();
        System.out.println("YOU HAVE 10 SECONDS TO ANSWER EACH QUESTION!\n\n");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Future<?> future1 = executor.submit(ob::quiz1);

        scheduler.schedule(() -> {
            if (!future1.isDone()) {
                future1.cancel(true);
                System.out.println("Question 1 timed out and was cancelled.\n\n");
            }
            ob.latch1.countDown(); 
        }, 10, TimeUnit.SECONDS);

        
        ob.latch1.await();
        Future<?> future2 = executor.submit(ob::quiz2);

        
        scheduler.schedule(() -> {
            if (!future2.isDone()) {
                future2.cancel(true);
                System.out.println("Question 2 timed out and was cancelled.\n\n");
            }
            ob.latch2.countDown(); 
        }, 10, TimeUnit.SECONDS);

                ob.latch2.await();

        
        Future<?> future3 = executor.submit(ob::quiz3);

        
        scheduler.schedule(() -> {
            if (!future3.isDone()) {
                future3.cancel(true);
                System.out.println("Question 3 timed out and was cancelled.\n\n");
            }
            ob.latch3.countDown(); 
        }, 10, TimeUnit.SECONDS);

        
        ob.latch3.await();

        System.out.println("Congrats..You finished the test.");
        System.out.println("Your Score is: " + ob.sum);

        executor.shutdown();
        scheduler.shutdown();
    }
}
