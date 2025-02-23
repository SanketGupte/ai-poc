/*
*
* Simple Program to read data from the user
*
* @Author - Sanket Gupte
*
* Source - GeekForGeeks
*
*/

import java.util.Scanner;

public class Program1 {

    public static void main(String[] args) {
        //Variable Declaration
        int num;
        //Prompt for Input
        System.out.println("Enter a number: ");
        //Scanner Object to read the data
        Scanner sc = new Scanner(System.in);
        //Read the next Integer from the screen
        num = sc.nextInt();
        //Display the Integer
        System.out.println("Entered Integer is: " + num);
        //Close the scanner
        sc.close();
    }
}
