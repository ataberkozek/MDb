import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SearchPanel extends JPanel {

    public SearchPanel() {
        super();
        this.setLayout(null);

        JLabel mdbLabel = new JLabel("MDb");
        mdbLabel.setFont(new Font("Serif", Font.BOLD, 40));
        mdbLabel.setBounds(0, 0, 100, 50);

        JTextField searchField = new JTextField("Find Movies...");
        searchField.setBounds(150, 70, 500, 20);

        // Search button una action handler koycaz o an searchField ın içinde yazan filmi bulup yeni bir Movie Panel açıp
        // Movie panel a o isimdeki movie yi vererek kullanıcak.
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(655, 70, 75, 20);
        searchButton.addActionListener(new handler());

        this.add(searchButton);
        this.add(mdbLabel);
        this.add(searchField);

    }

    class handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Search button worked !!");
        }
    }

}
