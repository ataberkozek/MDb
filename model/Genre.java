public enum Genre {
    SCIFI("Sci-Fi"), ROMANTIC("Romantic"), ACTION("Action"), COMEDY("Comedy"), DRAMA("Drama"), HORROR("Horror"), WESTERN("Western");

    private String title;

    Genre(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

