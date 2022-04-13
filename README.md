Java-Wordle
*
Welcome to my Java replica of Wordle. Wordle is a game that invites the user to guess a five-letter word. It was a viral hit in early 2022, right around when I started learning to code.
*
This idea of building a Wordle replica has been calling to me since I first played it. It’s a fun, addictive game with a simple enough premise for a coding beginner. I knew that I would need to learn how to take user input on the console and how to use arrays to store the letters of the words. I’m taking a Java course on Udemy with Tim Buchalka. He’s great, but I haven’t actually gotten to the section where we will learn about arrays. I found what I needed on google and learned a lot in the process.
*
When you make a guess, the letters that are in the correct spot light up green. The letters that are in the word, but not in the right place, light up yellow. My toughest challenge was figuring out how to mark the yellow letters. If a letter appears in the guess word more than once, it could easily cause yellow false positives. (For example, if the answer was “nutty” and the guess was “sunny,” the two “n”s in “sunny” present a problem. We would want only the first “n” to show up in yellow. How do we keep the second “n” from also lighting up yellow?)
*
My first step was to go through the user’s correct/green letters first and replace them with symbols. I created a copy of the user’s guess for this purpose and called it the decoyArray. Then I made a nested loop to search through the answer array and compare it to the decoyArray. As yellow letters appeared, I also replaced them in the decoyArray.
*
A helpful side-effect of this process was that the decoyArray had all of the yellow and green letters marked by the end of this process. I used the decoyArray to mark the colors of each letter as they printed onto the console. 
*
One problem that I haven’t attempted to solve is the dictionary. A more complete program would have a way to check the user’s guesses to determine if they are valid. I’m open to suggestions.
*
Thanks for your attention! I am very much a beginner and looking to get better at coding, so please feel free to make suggestions about ways to simplify and improve my program.
