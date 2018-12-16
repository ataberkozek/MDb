public class Main {
    public static void main(String[] args) {
        Actor aff = new Actor();
        Movie Venom = new Movie();
        aff.getMovies().add(Venom);
        aff.printMovies(); //filmin ozelliklerini gimedigim icin printlerken degisik seyler basiyor filmin ozelliklerini girince duzelecek.
    }
}
