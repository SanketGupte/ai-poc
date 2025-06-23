import java.util.Scanner;

public class AddFibSeqApproach1 {

    static int Fib_Even_Sum(int n){
        if(n <= 0){
            return 0;
        }

        int fib[] = new int[2 * n + 1];
        fib[0] = 0;
        fib[1] = 1;

        int sum = 0;

        for(int j = 2; j <= 2 * n; j++){
            fib[j] = fib[j - 1] + fib[j - 2];

            if(j % 2 == 0){
                sum+=fib[j];
            }
        }

        return sum;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        System.out.println("Even sum of fibonacci series till number " + n + " is: "
        + +Fib_Even_Sum(n));

    }
}
