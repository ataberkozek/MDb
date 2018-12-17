import javax.swing.*;
import java.awt.*;

// Onemli not: src deki movie ye falan ulasmak icin herhangi bir import vs gerekmiyor.
public class Gui {
    public static void main(String args[]) {

        JFrame frame = new JFrame("Project");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setMinimumSize(new Dimension(800, 500));

        JPanel SearchPanel = new SearchPanel();
        frame.add(SearchPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
