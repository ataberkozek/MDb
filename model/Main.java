public class Main {
    public static void main(String[] args) {
        Movie mov = DatabaseManager.parseCountryFrom("movies.json");
        System.out.println(mov.getName());
        System.out.println(mov.getReleaseDate());
        System.out.println(mov.getRuntime());
        System.out.println(mov.getGenre());
        System.out.println(mov.getRating());
    }
}
