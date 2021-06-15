/* controls the logic of reading the user's input and calling the methods in the Game class*/


 public class Main {
     public static void main(String[] args) {
         //generate a movieList from a provided document
         MovieList movieList = new MovieList("movies.txt");

         //get random movie from the list
         String randomMovie = movieList.getRandomMovie();


         //set up a game
         Game game = new Game();

         //set up that random movie as encrypted one
         game.setEncryptedMovie(randomMovie);
         game.setWrongAttempt(0);
         game.setGameWon(false);


         System.out.println("Games started!");
         System.out.println("The rules are simple " + "\n" +
                 "The computer randomly picks a movie title, " + "\n" +
                 "and shows you how many letters the movie title is made up of with underscores" +"\n");
         System.out.println("If a letter matches with the title, " + "\n"
                 + "it will reveal its correct position in the word. " + "\n"
                 +"If not, you lose a point." + "\n");
         System.out.println("If you lose 10 points, game over!");
         System.out.println("Let's start!");


        /*while(not gameEnded){
              display current hidden movie title , hint:getHiddenMovieTitle()
              display current wrong times and wrong letter ,hint: getWrongLetters()
              ask user to guess again
            if(win game){
              display you win
              display the movie title
            }
          }
          display Game over!you lost
          display right movie title

        */

         while(!game.gameEnded()) {
             //display current encryptedMovie
             System.out.println("You are guessing" + game.getHiddenMovieTitle());

             //display failure times and display incorrect letter that has been tried
             System.out.println("You have guessed (" + game.getWrongAttempt() + ")" + "wrong letter : " + game.getWrongLetters());

             //ask player to input letter
             game.inputLetter();

             //the input is not tried before, verify whether this input is rightLetter or wrongLetter
             game.verifyGuessLetter();
             if (game.getGameWon()) {
                 System.out.println("Congratulation, you win the game!");
                 System.out.println("The movie is " + game.getHiddenMovieTitle());
             }
         }
         System.out.println("Game Over!, you lost the game");
         System.out.println("The movie name is "+game.getRandomMovie());

  }

}


