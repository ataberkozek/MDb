import java.util.ArrayList;

public class Actor {

    private String name;
    private int age;
    private String bio;
    private String born_date;
    private ArrayList<Movie> movies;
    private boolean hasWonOscar;


    public Actor(String name, int age, String born_date) {
        this.name = name;
        this.age = age;
        this.born_date = born_date;
        movies = new ArrayList<>();
    }

    public Actor() {movies = new ArrayList<>();}

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBio() {
        return bio;
    }

    public String getBorn_date() {
        return born_date;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public boolean HasWonOscar() {
        return hasWonOscar;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setHasWonOscar(boolean hasWonOscar) {
        this.hasWonOscar = hasWonOscar;
    }

    public void printMovies(){
        System.out.println(movies.toString());
    }
}
