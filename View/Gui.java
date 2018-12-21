import javax.swing.*;
import java.awt.*;

public class Gui {
    public static void main(String args[]) {

        JFrame frame = new JFrame("Project");
        Movie mov = DatabaseManager.parseDataFrom("movies.json");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setMinimumSize(new Dimension(800, 500));

        JPanel SearchPanel = new View();
        frame.add(SearchPanel);
        frame.setVisible(true);
    }
}
