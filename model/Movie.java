import java.util.ArrayList;

public class Movie {
    private String name, releaseDate, genre;
    private double runtime, rating;
    private ArrayList<Comment> comments;
    private ArrayList<Actor> actors;
    private Director director;
    //aaaaaaaaaaaaaaaaa

    public Movie(String name, double runtime, double rating, Director director, String releaseDate, String genre) {
        this.name = name;
        this.runtime = runtime;
        this.rating = rating;
        this.director = director;
        this.releaseDate = releaseDate;
        this.genre = genre;
        actors = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public String getName() { return name; }

    public double getRuntime() { return runtime; }

    public double getRating() { return rating; }

    public ArrayList<Comment> getComments() { return comments; }

    public ArrayList<Actor> getActors() { return actors; }

    public Director getDirector() { return director; }

    public String getReleaseDate() { return releaseDate; }

    public String getGenre() { return genre; }

    public void addActor(Actor actor){
        actors.add(actor);
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void printMovie() {
        System.out.println("Name Of The Movie: " + name + "\n" + "Runtime Of The Movie: " + runtime + "\n" + "Director Of The Movie: " +
                director.getName() + "\n" + "Rating Of The Movie: " + rating + "\n" + "Release Date Of The Movie: " + releaseDate +
        "\n" + "Genre Of The Movie: " + genre);
        printActors();
        System.out.print("\n");
        printComments();
    }

    public void printActors() {
        System.out.print("Actors Of The Movie: ");
        for (int i = 0; i < actors.size(); i++) {
            if (i == actors.size() - 1)
                System.out.print(actors.get(i).getName());
            else
                System.out.print(actors.get(i).getName() + ", ");
        }
    }

    public void printComments() {
        System.out.print("Comments Of The Movie: ");
        for (int i = 0; i < comments.size(); i++) {
            if (i == comments.size() - 1)
                System.out.print(comments.get(i).getComment());
            else
                System.out.print(comments.get(i).getComment() + ", ");
        }
    }
}


