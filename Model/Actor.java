import java.util.ArrayList;

public class Actor {

    private String name, bio, born_date;
    private double age;
    private ArrayList<Movie> movies;
    private boolean hasWonOscar;


    public Actor(String name, double age, String born_date) {
        this.name = name;
        this.age = age;
        this.born_date = born_date;
        movies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getAge() {
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

    public void printMovies() {
        for (Movie movie : movies) {
            System.out.println(movie.getName());
        }
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}
