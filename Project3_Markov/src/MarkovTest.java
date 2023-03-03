/*
Title: Markov program
Abstract: The purpose of this program is to take a string apart feed it into a hashmap
and set the words you read in as keys and values. If a key exists the word after it is
added to the key it just found.
Author: Vera Boukhonine
Date: 02/27/2022
* */

/*
* Test Run
* ------------------------------------------------------------------
    Bounteous grace; lazar-like, 'twill you thou and and it that.
    Him like and from approaches thy bones, dar'd night of.
    Denmark the too honour'd distilment; that articles unfledg'd english i'll.
    Horatio! bed, for of say for thus soil bear by.
    Elsinore wholesome lord, pernicious burnt his of and most the.
    To! of tender your scale though good foreknowing object reels,.
    God! and must pernicious compulsatory, clowns, his sailors, honest o'er.
    Ambassadors accord vigour foresaid though it the nature in in.
    You this to a to to to this my since.
    Ham and mantle supposal when to shape and so flesh.
* ------------------------------------------------------------------
* This is the output you get if you use println
* (a bit truncated Hamlet's very long)
Think = [it, yourself, of]
(within) = [My]
would,' = [Or]
spoke = []
soldiers, = [Give]
Fortinbras; = [who,]
.........
 * */

import java.util.Scanner;

public class MarkovTest {

    public static void main(String[] args) {
        Markov hamlet = new Markov();
        Scanner scan = new Scanner(System.in);
        String input = "";
//        System.out.print("Please enter file you wish to make a Markov text out of: ");
//        input = scan.nextLine();
//        hamlet.addFromFile(input);

        hamlet.addFromFile("/Users/vera/IdeaProjects/Project3_Markov/src/testing");
//        hamlet.addFromFile("/Users/vera/IdeaProjects/Project3_Markov/src/Midsummer Night's Dream");
//        hamlet.addFromFile("/Users/vera/IdeaProjects/Project3_Markov/src/hamlet.txt");

        for(int i= 0;i<10;i++){
            System.out.println(hamlet.getSentence());
        }
        System.out.println(hamlet);


    }
}
