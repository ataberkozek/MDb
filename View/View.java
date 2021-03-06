import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JPanel {
    private JTextField searchField;
    private JPanel mainPanel = this;
    Movie movie = DatabaseManager.parseDataFrom("movies.json");

    public View() {
        super();
        this.setLayout(null);

        JLabel mdbLabel = new JLabel("MDb");
        mdbLabel.setForeground(Color.RED);
        mdbLabel.setFont(new Font("Serif", Font.BOLD, 40));
        mdbLabel.setBounds(0, 0, 100, 50);

        searchField = new JTextField("Find Movies...");
        searchField.setBounds(150, 70, 500, 20);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(655, 70, 75, 20);
        searchButton.addActionListener(new searchHandler(this));

        this.add(searchButton);
        this.add(mdbLabel);
        this.add(searchField);

    }

    public class searchHandler implements ActionListener {
        private JPanel panel;

        public searchHandler(JPanel panel) {
            this.panel = panel;
        }

        public void actionPerformed(ActionEvent e) {

            ArrayList<String> movieList = new ArrayList<>();
            movieList.add(movie.getName());

            String[] columns = {"Search Results"};
            DefaultTableModel model1 = new DefaultTableModel(columns, 0);
            JTable searchTable = new JTable(model1);
            searchTable.addMouseListener(new selectMovieHandler(panel));

            JScrollPane scrollPane = new JScrollPane(searchTable);
            scrollPane.setBounds(0, 100, 800, 400);

            String stringToSearch = searchField.getText();

            int matchedMovieCount = 0;
            for (int i = 0; i < movieList.size(); i++) {
                if (stringToSearch.length() < movieList.get(i).length()) {
                    if (stringToSearch.equalsIgnoreCase(movieList.get(i).substring(0, stringToSearch.length()))) {
                        matchedMovieCount++;
                        Object[] a = {movieList.get(i)};
                        model1.addRow(a);
                    }
                }
            }
            if (matchedMovieCount == 0) {
                JOptionPane.showMessageDialog(panel, "No Movie Found As: " + stringToSearch, "Alert", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
            panel.add(scrollPane);
        }
    }

    public class selectMovieHandler implements MouseListener {
        private JPanel panel;

        public selectMovieHandler(JPanel panel) {
            this.panel = panel;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            Comment a = new Comment("egowic");
            Comment b = new Comment("atosberk");
            Comment c = new Comment("Barkın");
            a.setComment("Guzel film");
            b.setComment("Berbat bir film");
            c.setComment("vay be inanılmaz bir film");
            movie.addComment(a);
            movie.addComment(b);
            movie.addComment(c);
            panel.removeAll();
            panel.updateUI();

            JLabel mdbLabel = new JLabel("MDb");
            mdbLabel.setForeground(Color.RED);
            mdbLabel.setFont(new Font("Serif", Font.BOLD, 40));
            mdbLabel.setBounds(0, 0, 100, 50);

            JLabel ratingLabel = new JLabel("Rating: " +  movie.getRating().toString());
            ratingLabel.setForeground(Color.RED);
            ratingLabel.setFont(new Font("Serif", Font.ITALIC, 20));
            ratingLabel.setBounds(650, 10, 100, 50);

            JLabel movieNameLabel = new JLabel(movie.getName());
            movieNameLabel.setForeground(Color.blue);
            movieNameLabel.setFont(new Font("Serif", Font.PLAIN, 25));
            movieNameLabel.setBounds(250, 60, 800, 50);

            JLabel basicInfoLabel = new JLabel(movie.getRuntime() + "min" + " | " + movie.getGenre().toString() + " | " +
                    movie.getReleaseDate());
            basicInfoLabel.setFont(new Font("Serif", Font.PLAIN, 20));
            basicInfoLabel.setBounds(250, 110, 800, 50);

            JLabel directorLabel = new JLabel("Director: " + movie.getDirector().getName());
            directorLabel.setFont(new Font("Serif", Font.PLAIN, 20));
            directorLabel.setBounds(0, 160, 800, 50);

            JLabel actorsLabel = new JLabel("Cast: ");
            fillActorsLabel(actorsLabel, movie);
            actorsLabel.setFont(new Font("Serif", Font.PLAIN, 20));
            actorsLabel.setBounds(0, 200, 800, 50);

            String[] columns = {"Comments"};
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            JTable searchTable = new JTable(model);

            JScrollPane scrollPane = new JScrollPane(searchTable);
            scrollPane.setBounds(0, 260, 800, 150);

            Object[] comment = {movie.getComments().get(0).getNickname() + ": "
                    + movie.getComments().get(0).getComment()};
            model.addRow(comment);

            JButton seeMoreButton = new JButton("See More Comments...");
            seeMoreButton.setFont(new Font("Serif", Font.PLAIN, 15));
            seeMoreButton.setBounds(0, 420, 180, 30);
            seeMoreButton.addActionListener(new seeMoreCommentsHandler(panel, seeMoreButton, movie, model));

            JButton newSearchButton = new JButton("New Search");
            newSearchButton.setFont(new Font("Serif", Font.PLAIN, 15));
            newSearchButton.setBounds(600, 420, 180, 30);
            newSearchButton.addActionListener(new newSearchHandler());

            panel.add(mdbLabel);
            panel.add(ratingLabel);
            panel.add(movieNameLabel);
            panel.add(basicInfoLabel);
            panel.add(directorLabel);
            panel.add(actorsLabel);
            panel.add(scrollPane);
            panel.add(seeMoreButton);
            panel.add(newSearchButton);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public void fillActorsLabel(JLabel actorsLabel, Movie movie) {
        for (int i = 0; i < movie.getActors().size(); i++) {
            if (i == movie.getActors().size() - 1) {
                actorsLabel.setText(actorsLabel.getText() + movie.getActors().get(i).getName());
            } else
                actorsLabel.setText(actorsLabel.getText() + movie.getActors().get(i).getName() + ", ");
        }
    }

    public class seeMoreCommentsHandler implements ActionListener {
        private JPanel panel;
        private JButton button;
        private Movie movie;
        private DefaultTableModel model;

        public seeMoreCommentsHandler(JPanel panel, JButton button, Movie movie, DefaultTableModel model) {
            this.panel = panel;
            this.button = button;
            this.movie = movie;
            this.model = model;
        }

        public void actionPerformed(ActionEvent e) {
            panel.remove(button);
            panel.updateUI();

            for (int i = 1; i < movie.getComments().size(); i++) {
                Object[] comment = {movie.getComments().get(i).getNickname() + ": "
                        + movie.getComments().get(i).getComment()};
                model.addRow(comment);
            }
        }
    }

    public class newSearchHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            mainPanel.setLayout(null);
            mainPanel.removeAll();
            mainPanel.updateUI();

            JLabel mdbLabel = new JLabel("MDb");
            mdbLabel.setForeground(Color.RED);
            mdbLabel.setFont(new Font("Serif", Font.BOLD, 40));
            mdbLabel.setBounds(0, 0, 100, 50);

            searchField = new JTextField("Find Movies...");
            searchField.setBounds(150, 70, 500, 20);

            JButton searchButton = new JButton("Search");
            searchButton.setBounds(655, 70, 75, 20);
            searchButton.addActionListener(new searchHandler(mainPanel));

            mainPanel.add(searchButton);
            mainPanel.add(mdbLabel);
            mainPanel.add(searchField);
        }
    }
}




