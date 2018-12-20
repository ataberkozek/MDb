public class Main {
    public static void main(String[] args) {
        Movie mov = DatabaseManager.parseDataFrom("movies.json");
        mov.printMovie();
    }
}
