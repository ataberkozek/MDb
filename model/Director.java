import java.util.ArrayList;

public class Director {

    private String name, bio, born_date;
    private double age;
    private ArrayList<Movie> movies;

    public Director(String name, double age, String born_date) {
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

    public void printMovies() {
        for (Movie movie : movies) {
            System.out.println(movie.getName());
        }
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void printDirector(){
        System.out.println("Name: "+ name + " age: "+age+" born date: "+born_date);
    }
}
