import java.util.ArrayList;

public class Director {

    private String name, bio, born_date;
    private int age;
    private ArrayList<Movie> movies;
    private boolean hasWonOscar; // String olarak mı tutsak varsa kazandığı oscarları ?

    public Director(String name, int age, String born_date) {
        this.name = name;
        this.age = age;
        this.born_date = born_date;
        movies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBio() { return bio; }

    public String getBorn_date() {
        return born_date;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    // Changed.
    public void printMovies() {
        for (Movie movie : movies) {
            System.out.println(movie.getName());
        }
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}