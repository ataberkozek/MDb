import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.io.FileReader;

public class DatabaseManager {
    public static Movie parseDataFrom(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            JSONObject jsonObject = (JSONObject) JSONValue.parse(fileReader);
            JSONArray arr = (JSONArray) jsonObject.get("director");
            Director dir = new Director((String) arr.get(0),(double) arr.get(1), (String) arr.get(2));
            Movie movie = new Movie.Builder((String) jsonObject.get("release_date"), (String) jsonObject.get("name")).withGenre(genreConverter((String)jsonObject.get("genre"))).withRating(ratingConverter((String) jsonObject.get("rating"))).withRuntime((double) jsonObject.get("runtime")).withDirector(dir).build();
            dir.addMovie(movie);
            JSONArray actorArr = (JSONArray) jsonObject.get("actors");
            loadActors(actorArr, movie);
            return movie;
        } catch (Exception e) {
            System.err.println("Problem occurred while parsing " + fileName + ":");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    public static void loadActors(JSONArray arr, Movie movie){
        for(int i = 0; i< arr.size(); ++i){
            JSONObject obj = (JSONObject) arr.get(i);
            Actor actor = new Actor((String) obj.get("name"), (double) obj.get("age"), (String) obj.get("born_date"));
            movie.addActor(actor);
            actor.addMovie(movie);
        }
    }



    private static Genre genreConverter(String genre) {
        switch (genre) {
            case "Sci-Fi":
                return Genre.SCIFI;
            case "Romantic":
                return Genre.ROMANTIC;
            case "Action":
                return Genre.ACTION;
            case "Comedy":
                return Genre.COMEDY;
            case "Drama":
                return Genre.DRAMA;
            case "Horror":
                return Genre.HORROR;
            case "Western":
                return Genre.WESTERN;
        }
        return null;
    }

    private static Rating ratingConverter(String rating){
        switch (rating) {
            case "0":
                return Rating.ZERO;
            case "1":
                return Rating.ONE;
            case "2":
                return Rating.TWO;
            case "3":
                return Rating.THREE;
            case "4":
                return Rating.FOUR;
            case "5":
                return Rating.FIVE;
            case "6":
                return Rating.SIX;
            case "7":
                return Rating.SEVEN;
            case "8":
                return Rating.EIGHT;
            case "9":
                return Rating.NINE;
            case "10":
                return Rating.TEN;
        }
        return null;
    }
}

