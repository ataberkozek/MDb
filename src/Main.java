public class Main {
    public static void main(String[] args) {
        Actor Ege = new Actor("Ege", 21, "28.08.1997");
        Actor Ataberk = new Actor("Ataberk", 21, "28.08.1997");
        Director Ali = new Director("Ali", 60, "23.23.1889");

        Movie Venom = new Movie("Venom", 120, 4.3, Ali);

        Venom.getActors().add(Ege);
        Venom.getActors().add(Ataberk);

        Venom.getComments().add("Vay be film superdi");
        Venom.getComments().add("Berbattı");

        Venom.printMovie();


        // Senin yaptığın yer printMovies() i değiştirdim.
        System.out.print("\n" + "\n");

        Ege.getMovies().add(Venom);
        Ege.printMovies(); //filmin ozelliklerini gimedigim icin printlerken degisik seyler basiyor filmin ozelliklerini girince duzelecek.
    }
}
