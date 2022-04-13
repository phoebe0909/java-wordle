package com.company;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {

    //defining background colors.
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[43m";
    public static final String ANSI_GREEN = "\u001B[42m";
    public static final String ANSI_RED = "\u001B[41m";

    public static void main(String[] args) {

        System.out.println(ANSI_GREEN + "Welcome to Java-Wordle!" + ANSI_RESET);
        System.out.println("The purpose of the game is to guess a 5-letter word.");
        System.out.println("If a letter in your guess is correct, it will appear green.");
        System.out.println("If it is incorrect, it will appear red.");
        System.out.println("If the letter is in the word but not in the right place, it will appear yellow.");
        System.out.println("");

        //create an array of possible answers:
        String [] answerBlock  = {"CYBER", "BYTES", "ARRAY", "SWITCH", "WHILE", "LOOPS", "SCOPE", "FILES", "CODES",
                "ERROR", "MODEM", "MOUSE", "BASIC", "BLOCK", "CACHE", "CLICK", "CLOSE", "CRASH", "DEBUG",
                "EMAIL", "ERASE", "TABLE", "VIRUS", "RESET", "WRITE", "LOOPS"};

        //randomly assign an answer word
        Random random = new Random();
        int number = random.nextInt(25);
        String answer = answerBlock[number];


        //Defining some variables for game play. "count" tracks number of attempts. "flag" marks whether it is a win or loss.
        int count = 6;
        int flag = 0;


        do {
            char[] answerArray = answer.toCharArray();

            Scanner scanner = new Scanner(System.in);
            System.out.println("You have " + count + " tries. Enter your 5-letter guess: ");
            String guess = scanner.nextLine();
            guess = guess.toUpperCase();

            // Convert the guess into an array with each letter represented as a char variable.
            // DecoyArray will allow us to cross letters off as they are used later in the game.
            char[] guessArray = guess.toCharArray();
            char[] decoyArray = guess.toCharArray();

            // check if the number of characters is 5. This is where I would like to add a dictionary to also check if words are valid.
            if (guessArray.length != 5){
                System.out.println("Invalid. Enter your 5-letter guess: ");
                guess = scanner.nextLine();
                guess = guess.toUpperCase();
                guessArray = guess.toCharArray();
            }

            count-=1;

            //Check whether the guess is equal to the answer. Correct answers win immediately without going through
            // the letter by letter verification process.
            if (answer.equalsIgnoreCase(guess)) {
                count=0;
                flag=1;
            }else {

                //Find correct/green letters
                for (int x = 0; x < 5; x++) {
                    if (answerArray[x] == guessArray[x]) {
                        decoyArray[x] = '#';
                        answerArray[x] = '$';
                    }
                }

                //Find misplaced/yellow letters. 
                for (int x = 0; x < 5; x++) {
                    for (int y = 4; y > -1; y--) {
                        if (decoyArray[y] == answerArray[x]) {
                            decoyArray[y] = '@';
                            answerArray[x] = '$';
                        }
                    }
                }

                //Print letters with correct color backgrounds. 
                for (int x = 0; x < 5; x++) {
                    if (decoyArray[x] == '#') {
                        System.out.print(ANSI_GREEN + " " + guessArray[x] + " " + ANSI_RESET + " ");
                    } else if (decoyArray[x] == '@') {
                        System.out.print(ANSI_YELLOW + " " + guessArray[x] + " " + ANSI_RESET + " ");
                    } else {
                        System.out.print(ANSI_RED + " " + guessArray[x] + " " + ANSI_RESET + " ");
                    }

                }
            }

        }while (count>0);
        if (flag == 0){
            System.out.println("You are out of tries. The answer was " + answer + ".");
        }
        else if (flag>0) {
            System.out.println(ANSI_GREEN + " " + answer + " " + ANSI_RESET + " ");
            System.out.println("Congratulations! You win.");
        }

    }
}
