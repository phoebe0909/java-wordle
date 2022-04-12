# java-wordle
I made wordle! Getting the yellows to appear the correct number of times was a bear of a challenge, but I did it. I haven’t learned how to work with arrays yet in my Udemy course, so I had to do a lot of googling to get through this project. 

My toughest challenge was figuring out how to mark the yellow (right letter, wrong placement) letters. 
It was important to go through the green answers first and remove them from the array so they wouldn't cause false positives. Then I made nested for loops to search through the correct answer array and compare it to the decoyArray (which contained the user's guess but had the green letters already removed). One of the keys to making this work was redefining the answerArray every time the user started a new turn, so it would be filled with fresh letters and not a bunch of dollar signs.

for (int x = 0; x < 5; x++) {
    for (int y = 4; y > -1; y--) {
        if (decoyArray[y] == answerArray[x]) {
            decoyArray[y] = '@';
            answerArray[x] = '$';
        }
    }
}

I also learned: 

How to name an array: 
String [] answerBlock  = {"RESET", "WRITE", "LOOPS"};

How to generate random numbers:
Random random = new Random();
int number = random.nextInt(25);

How to take a string and turn it into an array of characters:
char[] answerArray = answer.toCharArray();


How to take user input:
Scanner scanner = new Scanner(System.in);
System.out.println("You have " + count + " tries. Enter your 5-letter guess: ");
String guess = scanner.nextLine();


How to check whether two strings are matching (ignoring case)
answer.equalsIgnoreCase(guess)


I learned that IntelliJ will suggest and download helpful packages. For this round, I needed:
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

I didn’t exactly learn how to control the background colors of the console, but I did learn how to cut and paste this code that did the job for me:)
public static final String ANSI_YELLOW = "\u001B[43m";
