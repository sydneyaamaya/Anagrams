import java.io.*;

/*
I included all my comments and pseudocode at the beginning of my program to keep it organized

Preconditions:
-Files need to be created containing each level
-The lines in each file need to be stored in an array

Post conditions:
-Tell the user if their guess was right
-Add a point if the user was rights
-Show the user the amount of points they have

Anagrams Pseudocode:

Main Method:
Explain the game to the user and then prompt them for their desired difficulty
   Create scanner
   readInstructions();
   Sop(What difficulty?)
   Store answer in a string
   whichDifficulty(answer)

readInstructions method:
This method will read and print out the instructions so that I am not using a significant amount of strings
   Create a scanner
   Use a while loop to read the file
   while (scannerTwo.hasNextLine()){
      store next line in a variable and sop
   }

whichDifficulty method:
this method will determine which difficulty the user wants and then access the levels corresponding to that difficulty
Use if statement
    if (variable.equals(easy){
       call method that reads files with easy levels
    }
    else if (variable.equals(medium){
      call method that reads files from medium levels
    }

 readLinesEasy method:
 this method accesses the files containing the easy levels and stores the group of letters as well as the possible words in an array
 this method will also print out the first line of each method which shows the user the letters they need to rearrange
 this method will also call the user input method
      Create a scanner connected to the file
      Create a string array
      using a for loop to traverse through the file and add each line to the string array
         each line is an element in the array
      Sop element 0 of the array because it is the first line containing the letters the user needs to see
      call userInput method
      Repeat this for all levels

readLinesMedium method:
this method does the excat same thing as the readLinesMethod but uses files containing the levels of medium difficulty

userInput method:
this method will require two parameters: an array containing all the lines from the file and the int count containing
it will return an int
the amount of points the user has accumulated
this method will take the user's input and compare it to all possible answers
    Create a scanner and prompt user for input
    Create a while loop that will keep looping until the user etners "done"
      while (myScanner.hasNext())
        create variables: string to store user input and a boolean to use in method calls
        String word = myScanner.nextLine()
        boolean myBoolean = false;
        use a for loop to traverse through the array containing the correct answers starting at element 1
           for (int i = 1; i < correctAnswers.length;i++)
              use an if statement to compare user's input to element i
                 if (word equals to i ) {
                 1.call the method that checks input and store return value (boolean)
                 2.call method that tells the user if their input is correct and store return value (int)
                 3.tell the user how many points they have
                    myBoolean = checkInput(word, correctAnswers)
                    count = tellUserIfCorrect(myBoolean, count)
                    Sop ("Points" + count);
                }
         Use an if statement (not in for loop) to check if user's input equals to "done" and end loop if it does
              if (word equals to "done"){
                 sop ("end of level"
                 return count
              }
        If the user's input is not equal tp any possible answer or done then tell the user the word is not correct
             if (myBoolean == false){
             sop ("not a possibe word")
             }


checkInput method:
this method will check the user's input and see if it matches any of the possible correct words
it requires two parameters: a string storing the user's input and an array storing the correct words
it will return a boolean
    create a boolean variable
        boolean variable = false;
    use a for loop to traverse through the array containing the correct answers and
    compare the user's answer to each element
    if any of the elements is equal to the user's input return true
       for ( i < correctAnswers.length){
          if ( input.equals (correctAnswers[i]){
             boolean variable is true
          }
       }
      return boolean variable at the end

tellUserIfcorrect method:
this method will sop true or false so the user knows
this method needs two parameters: the boolean variable from the checkInput method as well as int count
    use an if statement, if boolean is true sop true and add one to count and if boolean is false sop false
    return count
       if (myBoolean == true){
       sop ("correct")
       count++
       }
       else if (myBoolean == false){
        sop ("false")
       }

 */
public class Anagrams {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner170 myScanner = new Scanner170(System.in);
        readInstructions();
        System.out.print("\nWhat difficulty do you want to play? (choose easy or medium): ");
        String difficulty = myScanner.nextLine();
        whichDifficulty(difficulty);
    }

    public static void readInstructions() throws FileNotFoundException {
        Scanner170 scannerTwo = new Scanner170(new File("anagramsInstructions.txt"));
        String instructions = " ";
        while (scannerTwo.hasNextLine()) {
            instructions = scannerTwo.nextLine();
            System.out.println(instructions);
        }
    }

    public static void whichDifficulty(String difficulty) throws FileNotFoundException {
        if (difficulty.equalsIgnoreCase("easy")) {
            readLinesEasy();
        } else if (difficulty.equalsIgnoreCase("medium")) {
            readLinesMedium();
        }
    }

    public static void readLinesEasy() throws FileNotFoundException {
        Scanner170 myScanner = new Scanner170(new File("LevelOne.txt"));
        String[] first = new String[6];
        for (int i = 0; i < first.length; i++) {
            first[i] = myScanner.nextLine();
        }
        System.out.println(first[0]);
        int count = 0;
        count = userInput(first, count);
        Scanner170 scannerTwo = new Scanner170(new File("EasyLevelTwo.txt"));
        String[] second = new String[5];
        for (int i = 0; i < second.length; i++) {
            second[i] = scannerTwo.nextLine();
        }
        System.out.println(second[0]);
        count = userInput(second, count);
        Scanner170 scannerThree = new Scanner170(new File("easyLevelThree.txt"));
        String[] third = new String[5];
        for (int i = 0; i < third.length; i++) {
            third[i] = scannerThree.nextLine();
        }
        System.out.println(third[0]);
        count = userInput(third, count);
        System.out.println("Your total points: " + count);
    }

    public static void readLinesMedium() throws FileNotFoundException {
        Scanner170 myScanner = new Scanner170(new File("mediumLevelOne.txt"));
        String[] first = new String[7];
        for (int i = 0; i < first.length; i++) {
            first[i] = myScanner.nextLine();
        }
        int count = 0;
        System.out.println(first[0]);
        count = userInput(first, count);
        Scanner170 scannerTwo = new Scanner170(new File("mediumLevelTwo.txt"));
        String[] second = new String[7];
        for (int i = 0; i < second.length; i++) {
            second[i] = scannerTwo.nextLine();
        }
        System.out.println(second[0]);
        count = userInput(second, count);
        Scanner170 scannerThree = new Scanner170(new File("mediumLevelThree.txt"));
        String[] third = new String[7];
        for (int i = 0; i < third.length; i++) {
            third[i] = scannerThree.nextLine();
        }
        System.out.println(third[0]);
        count = userInput(third, count);
        System.out.println("Your total points: " + count);
    }

    public static int userInput(String[] correctAnswers, int count) {
        System.out.println("Enter a word: ");
        Scanner170 myScanner = new Scanner170(System.in);
        while (myScanner.hasNext()) {
            String word = myScanner.nextLine();
            boolean myBoolean = false;
            for (int i = 1; i < correctAnswers.length; i++) {
                if (word.equals(correctAnswers[i])) {
                    myBoolean = checkInput(word, correctAnswers);
                    count = tellUserIfCorrect(myBoolean, count);
                    System.out.print("Points: " + count);
                    System.out.println();
                }
            }
            if (word.equals("done")) {
                System.out.println();
                System.out.println("End of this level");
                System.out.println();
                return count;
            }
            if (myBoolean == false) {
                System.out.println("Not a possible word.");
            }
        }
        return count;
    }

    public static boolean checkInput(String word, String[] correct) {
        boolean myBoolean = false;
        for (int i = 1; i < correct.length; i++) {
            if (word.equals(correct[i])) {
                myBoolean = true;
            }
        }
        return myBoolean;
    }

    public static int tellUserIfCorrect(boolean myBoolean, int count) {
        if (myBoolean == true) {
            System.out.println("correct");
            count = count + 1;
        } else if (myBoolean == false) {
            System.out.println("False");
        }
        return count;
    }
}

