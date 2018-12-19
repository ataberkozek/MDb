public class Main {
    public static void main(String[] args) {
        Actor Ege = new Actor("Ege", 21, "28.08.1997");
        Actor Ataberk = new Actor("Ataberk", 21, "28.08.1997");
        Director Ali = new Director("Ali", 60, "23.23.1889");
        Movie Venom = new Movie.Builder(Genre.SCIFI, "Venom").withDirector(Ali).withRating(Rating.SEVEN).withReleaseDate("12.08.2018").withRuntime(120.0).build();

        Comment a = new Comment("egowic");
        Comment b = new Comment("atosberk");

        a.setComment("Guzel film");
        b.setComment("Berbat bir film");

        Ali.addMovie(Venom);

        Venom.addActor(Ege);
        Venom.addActor(Ataberk);

        Venom.addComment(a);
        Venom.addComment(b);

        Venom.printMovie();

        System.out.print("\n" + "\n");

        Ege.addMovie(Venom);
        Ege.printMovies();
    }
}
