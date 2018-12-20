import java.util.ArrayList;

public final class Movie {
    private final String name, releaseDate;
    private final Genre genre;
    private final Rating rating;
    private final double runtime;
    private ArrayList<Comment> comments;
    private ArrayList<Actor> actors;
    private final Director director;

    public Movie(Builder builder) {
        this.name = builder.name;
        this.runtime = builder.runtime;
        this.director = builder.director;
        this.releaseDate = builder.releaseDate;
        this.genre = builder.genre;
        this.rating = builder.rating;
        actors = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getRuntime() {
        return runtime;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public Director getDirector() {
        return director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public Rating getRating() {
        return rating;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void addComment(Comment comment) {
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


    public static class Builder {

        private final String name;
        private final String releaseDate;
        private  Genre genre;
        private Rating rating;
        private double runtime;
        private Director director;

        public Builder(String releaseDate, String name) {
            if (releaseDate == null || name == null) {
                throw new IllegalArgumentException("Name or release date cannot be empty");
            }
            this.releaseDate = releaseDate;
            this.name = name;
        }

        public Builder withGenre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public Builder withRating(Rating rating) {
            this.rating = rating;
            return this;
        }

        public Builder withRuntime(double runtime) {
            this.runtime = runtime;
            return this;
        }

        public Builder withDirector(Director director) {
            this.director = director;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }

}
