import java.util.Scanner;
/*
* Name: Vera Boukhonine
* Date: January 26th, 2022
* Description: This is the most fun I've ever had Dr. C deserves a medals. Two medals and a pizza.
* No he deserves a Nobel Prize for the best program ever!
* -----------------
* This program allows a user to enter an integer input.
* It also prints:I don't know what to do with (number you entered)
* */
public class Menu {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.readUserInput();
    }

    public static void message() {
        System.out.println("Hello there!");
    }

    private int readUserInput() {
        int userValue = 0;

        Scanner scan = new Scanner(System.in);

        while (userValue > -1) {
            System.out.print("Enter a number: ");
            String value = scan.nextLine();
            System.out.println("You entered: " + value);
            try {
                userValue = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                userValue = 0;
            }
            if (userValue == 1) {
                message();
            } else {
                System.out.println("I don't know what to do with " + userValue);
            }

        }

        return userValue;
    }
}
