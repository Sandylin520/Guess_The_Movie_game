
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;


//Build up a MovieList class to store movie data and also create
//a method to get a random movie title from the list

public class MovieList{
    //declare an array to store movie 宣告變數
    private ArrayList <String> movies;
    protected String movieToGuess;
    protected String encryptedMovie;
    private int movieListLength;


    MovieList(){}

    //initiate the movielist 將電影資料初始化 並在初始化中預防文件不存在的狀況
    public MovieList(String filePath){

        //create an empty array and assign it to movies 配置記憶體空間
        movies  = new ArrayList();
        //use File to read imported file 用File讀取file資料
        File file = new File(filePath);


        //prevent exception of file doesn't exist
        try{
            Scanner scanner = new Scanner(file);//read file
            while(scanner.hasNextLine()) {//check if there is a next line
                movies.add(scanner.nextLine());//if yes,add content of nextLine() as an element to the list
            }
            movieListLength = movies.size();
        }catch(FileNotFoundException e){//if the file doesn't exit, throw exception
            System.out.println("File does not exist");
        }


    }


    public void  getMovieLength(int movieListLength){
        this.movieListLength = movieListLength;
    }

    public int getMovieLength(){
        return movieListLength;
    }

    /*use Math.random method to get a random number,
    here movies.size() need not to add 1, because you store in an index*/

    //generate a random movie from a movie list through index
    public String getRandomMovie() {

        int movieIndex = (int)(Math.random() * movieListLength);
        movieToGuess = movies.get(movieIndex).trim();//get the item from array,remove additional space
        return movieToGuess;
    }



    //set up encryptedMovie   將前面取得的任意電影名字設定為要被加密的電影
    void setEncryptedMovie(String movieToGuess) {
        this.encryptedMovie = movieToGuess;
    }

    String getEncryptedMovie() {
        return encryptedMovie;
    }

    //encrpt the title of movieToGuess 將電影名字所有字串用_加密
    String encryptMovie(String movieToGuess) {
        return movieToGuess.replaceAll("[a-zA-Z]", "_");
    }

}


/*
 * Java.util.ArrayList.add() method: add elements in the list
 * Java.util.ArrayList.size() method: check the size of this list
 * java.util.ArrayList.get() method : return retrieves element at specific position
 */


/*

while(scanner.hasNextLine()) {movies.add(scanner.nextLine())}
將movie.txt 的每一行加入至陣列元素中，最後會變成如下
[the shawshank redemption, the godfather, the dark knight, schindler's list,
 pulp fiction, the lord of the rings, the good the bad and the ugly]

 */