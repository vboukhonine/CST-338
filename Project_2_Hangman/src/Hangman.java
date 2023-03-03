import java.util.*;
import java.util.stream.Collectors;


/*
 * Author: Vera Boukhonine
 * Title: Hangman game
 * Date: February 20th, 2022
 * Abstract: This is my hangman program you give it a word and you either guess a letter or get a hint.
 * I take the user inputed word use my createString function to make an new string called myNewString
 * which looks like this  _ _ _ _ _ # _ _ _. Then the game starts you can enter 1 for guess or 2 for a hint
 * you get 4 incorrect guesses, hints also subtract from the incorrectGuess variable. If you have 4 incorrect
 * guesses then you lose. My program's not quite perfect, but it'll work for any word you input or multiple words.
 * For the specific use of a function I have comments below explaining each one.
 * Anyway that's all folks have a nice, day.
 *
 * */


/*
--------- Welcome to Hangman ---------

Enter a word: hello you
So far, the word is: _ _ _ _ _ # _ _ _
You have 4 incorrect guesses left

Enter either 1 for guessing or 2 for hint: 1
Enter your guess: z
Sorry, Z isn't in the word.

So far, the word is: _ _ _ _ _ # _ _ _
You have 3 incorrect guesses left
Enter either 1 for guessing or 2 for hint: 1
Enter your guess: z
Sorry, Z isn't in the word.

So far, the word is: _ _ _ _ _ # _ _ _
You have 2 incorrect guesses left
Enter either 1 for guessing or 2 for hint: 1
Enter your guess: z
Sorry, Z isn't in the word.

So far, the word is: _ _ _ _ _ # _ _ _
You have 1 incorrect guesses left
Enter either 1 for guessing or 2 for hint: 1
Enter your guess: z
Sorry, Z isn't in the word.

Sorry. You lost.
The word was HELLO YOU
//----------------------------------------------------
* */
public class Hangman {
    // removes duplicate letters from string so hello you ---> heloyu
    static char[] removeDuplicates(char[] array) {
        String arr = "";
        for (int i = 0; i < array.length; i++) {
            if (arr.indexOf(array[i]) == -1) // check if a char already exist, if not exist then return -1
                arr = arr + array[i];      // add new char
        }
        return arr.toCharArray();
    }

    //generates base string from user input ex. HELLO YOU to _ _ _ _ _ # _ _ _
    static String createString(String userWord) {
        userWord = userWord.replace(' ', '#');
        userWord = userWord.replaceAll("[a-zA-Z]", "_");
        userWord = addSpace(userWord);
        return userWord;
    }

    //gets rid of spaces ex. _ _ _ _ _ # _ _ _ to _____#___
    static String removeSpace(String userWord) {
        String removeSpace = " ";
        userWord = userWord.replaceAll(removeSpace, "");
        return userWord;
    }

    //adds spaces ex. _ _ _ _ _ # _ _ _
    static String addSpace(String userWord) {
        String addSpace = "";
        userWord = userWord.replaceAll(addSpace, " ");
        return userWord;
    }

    // looks through my string to find the char user input and replace _ with said char
    static String lookThroughString(String userWord, String myNewString, char userGuess) {
        myNewString = removeSpace(myNewString);

        for (int index = userWord.indexOf(userGuess);
             index >= 0;
             index = userWord.indexOf(userGuess, index + 1)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(myNewString, 0, index).append(userGuess);
            stringBuilder.append(myNewString.substring(index + 1));
            myNewString = stringBuilder.toString();

        }
        myNewString = addSpace(myNewString);
        return myNewString;
    }

    // checks if char user entered exist in userWord
    static public boolean checkString(String userWord, char userGuess) {
        char[] chars = userWord.toCharArray();
        for (int i = 0; i < userWord.length(); i++) {
            if ((chars[i] == userGuess)) {
                return true;   // Char exists in array
            }
        }
        return false;  // Char does not exist in  array
    }

//----------------------------------------------------------------------------
// Main
//----------------------------------------------------------------------------
    public static void main(String[] args) {
        int space = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("--------- Welcome to Hangman ---------\n");
        System.out.print("Enter a word: ");
        String userWord = scan.nextLine();
        userWord = userWord.toUpperCase();
        String myNewString = createString(userWord);

//        System.out.println(userWord);

        System.out.println("So far, the word is:" + myNewString);
        int incorrectGuess = 4;
        System.out.println("You have " + incorrectGuess + " incorrect guesses left\n");


        int userChoice = 0;
        ArrayList<Character> myGuess = new ArrayList<Character>();

        char[] testWord = userWord.replaceAll("\\s", "").toCharArray();
//        System.out.println(removeDuplicates(testWord));
        testWord = removeDuplicates(testWord);
        List<Character> al = new ArrayList<Character>();
        for (int i = 0; i < testWord.length; i++) {
            al.add(testWord[i]);
        }


        while (myNewString.contains("_")) {


            while(incorrectGuess!=0){
                System.out.print("Enter either 1 for guessing or 2 for hint: ");
                break;
            }

            if (incorrectGuess == 0) {
//                userWord = userWord.replaceAll(" ", "#");
//                userWord = addSpace(userWord);
                System.out.println("Sorry. You lost.");
                System.out.println("The word was " + userWord + "\n");
                System.out.println("Thanks for playing.  Good bye.");
                break;
            }
            while (!scan.hasNextInt()) {
                System.out.println("Incorrect input.");
                scan.next();
                System.out.print("Enter either 1 for guessing or 2 for hint: ");
            }
            userChoice = scan.nextInt();

            char userGuess;

            switch (userChoice) {
                case 1:
                    System.out.print("Enter your guess: ");

                    while (!scan.hasNext("[A-Za-z]+")) {
                        System.out.println("Incorrect input.");
                        scan.next(".");
                        System.out.print("Enter your guess: ");
                    }
                    userGuess = scan.next().charAt(0);
                    userGuess = Character.toUpperCase(userGuess);
                    boolean tryIt = checkString(userWord, userGuess);
                    if (tryIt) {
                        if (!myGuess.contains(userGuess)) {
                            myNewString = lookThroughString(userWord, myNewString, userGuess);
                            myGuess.add(userGuess);
                            al.removeAll(Collections.singleton(userGuess));
                            System.out.println("That's right! " + userGuess + " is in the word.");
                            System.out.println(myNewString + "\n");
                        } else if (myGuess.contains(userGuess)) {
                            System.out.println("Not valid input. You already guessed " + userGuess + ".\n");
                        }
                    } else {
                        System.out.println("Sorry, " + userGuess + " isn't in the word.\n");
//                        myGuess.add(userGuess);
                        incorrectGuess--;
                    }
                    break;
                case 2:

                    if (incorrectGuess > 0) {
                        char c = al.get(0);
                        System.out.println("OK! The hint is " + c + "\n");
                        incorrectGuess--;
                        while(incorrectGuess !=0){
                            System.out.println("But since you used the hint, you can guess " + incorrectGuess + " more times.");
                            break;
                        }
                        myNewString = lookThroughString(userWord, myNewString, c);
                        myGuess.add(c);
                        al.removeAll(Collections.singleton(c));
                    }

                    break;
                default:
                    System.out.println("Incorrect input.\n");
                    break;
            }

            if (!myNewString.contains("_")) {
                myNewString = removeSpace(myNewString);
                myNewString = myNewString.replaceAll("#"," ");
                System.out.println("Congratulations! The word was " + myNewString);
                System.out.println("Thanks for playing.  Good bye.");
                break;
            }

            while(incorrectGuess !=0){
                System.out.println("So far, the word is:" + myNewString);
                System.out.println("You have " + incorrectGuess + " incorrect guesses left");
                break;
            }


//            System.out.println("So far, the word is:" + myNewString);
//            System.out.println("You have " + incorrectGuess + " incorrect guesses left");


        }

    }
}