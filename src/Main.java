/* controls the logic of reading the user's input and calling the methods in the Game class*/


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //generate a movieList from a provided document
        MovieList movieList = new MovieList("movies.txt");

        //  System.out.println(movieList.movieListLength);
        int ListLength = movieList.getMovieLength();
        System.out.println("The imported movielist has " + ListLength + " items" + "\n");

        //get random movie from the list
        String randomMovie = movieList.getRandomMovie();


        //set up a game
        Game game = new Game();
        System.out.println(game);

        //Without this line , it occurs NullPointerException
        //game class will not know the value got from movieList
        //String default setting: null
        game.movieToGuess = randomMovie;

        //set up that random movie as encrypted one
        game.setEncryptedMovie(randomMovie);

//        set up the requirement to let game begin
//        game.setWrongAttempt(0);
//        game.setWrongLetters("");
//        game.setRightLetters("");
//        game.setGameWon(false);


        //display rules to player
        System.out.println("Games started!");
        System.out.println("The rules are simple " + "\n" +
                "The computer randomly picks a movie title, " + "\n" +
                "and shows you how many letters the movie title is made up of with underscores" + "\n");
        System.out.println("If a letter matches with the title, " + "\n"
                + "it will reveal its correct position in the word. " + "\n"
                + "If not, you lose a point." + "\n");
        System.out.println("If you lose 10 points, game over!");
        System.out.println("Let's start!");
        //System.out.println(game.rightLetters);

        /*while(not gameEnded){
              display current hidden movie title , hint:getHiddenMovieTitle()
              display current wrong times and wrong letter ,hint: getWrongLetters()
              ask user to guess again
         }
          if(win game){
              display you win
              display the movie title
          }
          else{
           display Game over!you lost
           display right movie title
          }

        */

        //set up the condition to continue the game or suspend the game
        while (!game.gameEnded()) {
            //display current encryptedMovie
            System.out.println("You are guessing " + game.getHiddenMovieTitle());

            //ask player to input letter
            //-verify"not a letter", "letter repeated", or "not guessed yet"
            String input = game.inputLetter();

            //the input was not tried before, add letter to either rightLetter or wrongLetter

            game.verifyGuessLetter(input);

            //display failure times and display incorrect letter that has been tried
            System.out.println("You have guessed (" + game.getWrongAttempt() + ") " + "wrong letter : " + game.getWrongLetters()+"\n");

        }

        if(game.getGameWon()) {
            System.out.println("Congratulation, you win the game!");
            System.out.println("The movie is " + game.getHiddenMovieTitle());
        } else {
            System.out.println("Game Over!, you lost the game");
            System.out.println("The movie name is " + randomMovie);
        }

    }

}



