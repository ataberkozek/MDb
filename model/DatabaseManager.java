import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.io.FileReader;

public class DatabaseManager {
    public static Movie parseCountryFrom(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            JSONObject jsonObject = (JSONObject) JSONValue.parse(fileReader);
            Movie.Builder movie = new Movie.Builder((String) jsonObject.get("release_date"), (String) jsonObject.get("name"));
            movie.withRuntime((double) jsonObject.get("runtime"));
            movie.withGenre(genreConverter((String)jsonObject.get("genre")) );
            movie.withRating(ratingConverter((String) jsonObject.get("rating")));

            return movie.build();
        } catch (Exception e) {
            System.err.println("Problem occurred while parsing " + fileName + ":");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static Genre genreConverter(String genre) {
        if (genre.equals("Sci-Fi")) {
            return Genre.SCIFI;
        } else if (genre.equals("Romantic")) {
            return Genre.ROMANTIC;
        } else if (genre.equals("Action")) {
            return Genre.ACTION;
        } else if (genre.equals("Comedy")) {
            return Genre.COMEDY;
        } else if (genre.equals("Drama")) {
            return Genre.DRAMA;
        } else if (genre.equals("Horror")) {
            return Genre.HORROR;
        } else if (genre.equals("Western")) {
            return Genre.WESTERN;
        }
        return null;
    }

    public static Rating ratingConverter(String rating){
        if (rating.equals("0"))
            return Rating.ZERO;
        else if (rating.equals("1"))
            return Rating.ONE;
        else if (rating.equals("2"))
            return Rating.TWO;
        else if (rating.equals("3"))
            return Rating.THREE;
        else if (rating.equals("4"))
            return Rating.FOUR;
        else if (rating.equals("5"))
            return Rating.FIVE;
        else if (rating.equals("6"))
            return Rating.SIX;
        else if (rating.equals("7"))
            return Rating.SEVEN;
        else if (rating.equals("8"))
            return Rating.EIGHT;
        else if (rating.equals("9"))
            return Rating.NINE;
        else if (rating.equals("10"))
            return  Rating.TEN;
        return null;
    }
}

