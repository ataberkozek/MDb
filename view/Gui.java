import javax.swing.*;
import java.awt.*;

// Onemli not: src deki movie ye falan ulasmak icin herhangi bir import vs gerekmiyor.
public class Gui {
    public static void main(String args[]) {

        JFrame frame = new JFrame("Project");
        Director Ali = new Director("Ali", 60, "23.23.1889");
        Movie Venom = new Movie.Builder("12.08.2018", "Venom").withDirector(Ali).withRating(Rating.SEVEN).withGenre(Genre.SCIFI).withRuntime(120.0).build();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setMinimumSize(new Dimension(800, 500));

        JPanel SearchPanel = new View();
        frame.add(SearchPanel);
        frame.setVisible(true);
    }
}
