
import java.util.Scanner;

public class Game extends MovieList{
    /**
     * wrongAttempt = number of times user guesses incorrectly. user has limited 10 times
     * rightLetters = letters guessed that are in the movie title (in upper and lower case);
     * wrongLetters = letters guessed that are not in the movie title;
     */
    private int wrongAttempt;
    private String wrongLetters;
    private String rightLetters;
    //private String guessedLetter; no need to set, let it remain as local variable
    private boolean gameWon;


    public Game() {
        wrongAttempt = 0;
        wrongLetters = "";
        rightLetters = "";
        //guessedLetter = "";
        gameWon = false;
    }

    @Override //checking whether initialized object is properly set or not
    public String toString(){
         return "{ wrongAttempt = " + " " + wrongAttempt + "; wrongLetters = " + wrongLetters +
                "; rightLetters = " + " " + rightLetters  + ";  + gameWon = " + gameWon +"}" + "\n";
    }



    public void setWrongAttempt(int wrongAttempt){
        this.wrongAttempt = wrongAttempt;
    }
    public int getWrongAttempt(){
        return wrongAttempt;
    }

    public void setWrongLetters(String wrongLetters){
        this.wrongLetters = wrongLetters;
    }//
    public String getWrongLetters(){
        return  wrongLetters;
    }


    public void setRightLetters(String rightLetters){
        this.rightLetters = rightLetters;
    }
    public String getRightLetters() {
        return rightLetters;
    }

    public void setGameWon(boolean gameWon){ this.gameWon = false;}
    public boolean getGameWon(){return gameWon;}


    // method: end of the game to determine game to continue or not
    public boolean gameEnded() {
        //guessed incorrect letter for 10 times,
        if (wrongAttempt == 10) {
          //gameWon= false , no need to write, this is default setting
            return true;
        }
        //underscores are not covered at all in title, all characters are guessed correctly
        else if(!getHiddenMovieTitle().contains("_")) {
            gameWon = true;
            return true;
        }else{
        //games continue, not end yet
        return false;}
    }


    /**
     * inputLetter() Method:
     * asks the player to input a letter;
     * <p>
     * (1) converts input letter to lower case;
     * (2)determine whether it's a valid letter or not
     * (a) if the input String is not a letter, ask player to input letter again
     * (b) if the letter was already guessed, it should exist either in the string object of
     * rightLetters or wrongletters, ask the player input letter again
     * (c) if the input String is a letter not guessed yet, returns the letter.
     */


//verify input letter is  "not a letter", "letter repeated", or "not guessed yet"
    public String inputLetter() {
        System.out.print("Guess a letter : ");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.next().toLowerCase();
        //if enter detail is not a letter
        if (!letter.matches("[a-z]")) {
            System.out.println("That is not a letter");
            //ask player to input again
            return inputLetter();
        }
        //the letter was guessed before
        else if (wrongLetters.contains(letter) || rightLetters.contains(letter)) {
            System.out.println("you already guessed that letter.");
            return inputLetter();
        }
        //the letter is not tried yet
        else {
            return letter;
        }
    }


    /**
     * verifyGuessLetter() method :
     * It categorizes the first-tried letter belongs to either rightLetter or wrongLetter
     * the letter is not guessed yet, verify whether it belongs to either rightLetter or wrongLetter
     *
     * if: regardless of capital or small letter, check whether movie title matches guessedLetter,
     * add it to rightLetters object, and auto includes capital and small letter of the right letter
     * so that if user inputs same letter, it gets detected in inputLetter() method
     *
     * else: otherwise, add it to wrong Letters object
     */

    public void verifyGuessLetter(String input) {
        String guessedLetter = input;
        //movie title matched with the guessedletter
        if (movieToGuess.toLowerCase().contains(guessedLetter)) {
            rightLetters += guessedLetter + guessedLetter.toUpperCase();
          //System.out.println("rightLetters " + rightLetters);
        }
        //no match, print out the incorrect letter
        else {
            wrongAttempt++;
            wrongLetters += guessedLetter;//add guessedletter to wrongLetters
          // System.out.println("wrongLetters " + wrongLetters);
        }
    }




    /**
     * method report latest guessed result of movie title
     * if no rightletters are guessed yet, return  string object with "_"
     * 尚未猜中任何字母 回傳用_代替
     *
     * if part of rightletters are guessed,return right letters and unrevealed letters with "_"
     * 已猜中字母 將除了猜中字母以外的位置換成_後回傳string
     */

    //method report latest guessed result of movie title
    public String getHiddenMovieTitle() {
        if (rightLetters.equals("")) {
            return encryptedMovie.replaceAll("[a-zA-Z]", "_");
        } else {
            return encryptedMovie.replaceAll("[a-zA-Z&&[^" + rightLetters + "]]", "_");
        }
    }


}

/*java.lang.String  trim() method: remove space
  java.lang.String  matches() Method : public boolean matches(String regex)
  java.lang.String  replaceAll(String regex, String replacement)
  java.lang.String  contains(CharSequence s)

  scanner.next()
 */