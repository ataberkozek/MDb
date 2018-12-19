import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchPanel extends JPanel {
    private JTextField searchField;

    public SearchPanel() {
        super();
        this.setLayout(null);

        JLabel mdbLabel = new JLabel("MDb");
        mdbLabel.setFont(new Font("Serif", Font.BOLD, 40));
        mdbLabel.setBounds(0, 0, 100, 50);

        searchField = new JTextField("Find Movies...");
        searchField.setBounds(150, 70, 500, 20);

        // Search button una action handler koycaz o an searchField ın içinde yazan filmi bulup yeni bir Movie Panel açıp
        // Movie panel a o isimdeki movie yi vererek kullanıcak.
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(655, 70, 75, 20);
        searchButton.addActionListener(new handler(this));

        this.add(searchButton);
        this.add(mdbLabel);
        this.add(searchField);

    }

    public class handler implements ActionListener {

        private JPanel panel;

        public handler(JPanel OrderPanel) {
            this.panel = OrderPanel;
        }

        public void actionPerformed(ActionEvent e) {
            // Database den gelecek datalar...
            ArrayList<String> movieList = new ArrayList<>();
            movieList.add("Fast and the Furious 1");
            movieList.add("Fast and the Furious 2");
            movieList.add("Fast and the Furious 3");


            String[] columns = { "Search Results"};
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            JTable searchTable = new JTable(model);

            JScrollPane scrollPane = new JScrollPane(searchTable);
            scrollPane.setBounds(0, 100, 800, 300);

            String stringToSearch = searchField.getText();

            // Search Operation...
            for(int i = 0; i < movieList.size(); i++) {
                if(stringToSearch.length() < movieList.get(i).length()) {
                    if(stringToSearch.equalsIgnoreCase(movieList.get(i).substring(0, stringToSearch.length()))) {
                        Object[] a = {movieList.get(i)};
                        model.addRow(a);
                    }
                }
            }

            panel.add(scrollPane);
        }
    }

}
