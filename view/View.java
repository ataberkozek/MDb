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

    public View() {
        super();
        this.setLayout(null);

        JLabel mdbLabel = new JLabel("MDb");
        mdbLabel.setForeground(Color.RED);
        mdbLabel.setFont(new Font("Serif", Font.BOLD, 40));
        mdbLabel.setBounds(0, 0, 100, 50);

        searchField = new JTextField("F");
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

        public handler(JPanel panel) {
            this.panel = panel;
        }

        public void actionPerformed(ActionEvent e) {
            // Database den gelecek datalar...
            ArrayList<String> movieList = new ArrayList<>();
            movieList.add("Fast and the Furious 1");
            movieList.add("Fast and the Furious 2");
            movieList.add("Fast and the Furious 3");

            String[] columns = {"Search Results"};
            DefaultTableModel model1 = new DefaultTableModel(columns, 0);
            JTable searchTable = new JTable(model1);
            searchTable.addMouseListener(new handler2(searchTable, panel));

            JScrollPane scrollPane = new JScrollPane(searchTable);
            scrollPane.setBounds(0, 100, 800, 400);

            String stringToSearch = searchField.getText();

            // Search Operation...
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
            }


            panel.add(scrollPane);
        }
    }

    // searchden sonra filmlerden birine tıklanınca o filmin ismini alıyor ve simdilik o isim ile movie objesi olusturuyor
    public class handler2 implements MouseListener {
        private JTable table;
        private JPanel panel;

        public handler2(JTable table, JPanel panel) {
            this.table = table;
            this.panel = panel;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int column = 0;
            int row = table.getSelectedRow();
            String selectedMovieName = table.getModel().getValueAt(row, column).toString();

            // gecici film objesi...
            Actor Ege = new Actor("Ege", 21, "28.08.1997");
            Actor Ataberk = new Actor("Ataberk", 21, "28.08.1997");
            Director Ali = new Director("Ali", 60, "23.23.1889");
            Movie movie = new Movie.Builder("12.08.2018", selectedMovieName).withDirector(Ali).withRating(Rating.SEVEN).withGenre(Genre.SCIFI).withRuntime(120.0).build();
            Comment a = new Comment("egowic");
            Comment b = new Comment("atosberk");
            Comment c = new Comment("Barkın");
            a.setComment("Guzel film");
            b.setComment("Berbat bir film");
            c.setComment("vay be inanılmaz bir film");
            Ali.addMovie(movie);
            movie.addActor(Ege);
            movie.addActor(Ataberk);
            movie.addComment(a);
            movie.addComment(b);
            movie.addComment(c);

            panel.removeAll();
            panel.updateUI();

            JLabel mdbLabel = new JLabel("MDb");
            mdbLabel.setForeground(Color.RED);
            mdbLabel.setFont(new Font("Serif", Font.BOLD, 40));
            mdbLabel.setBounds(0, 0, 100, 50);

            JLabel ratingLabel = new JLabel("Rating: " + movie.getRating());
            ratingLabel.setForeground(Color.RED);
            ratingLabel.setFont(new Font("Serif", Font.ITALIC, 20));
            ratingLabel.setBounds(650, 10, 100, 50);

            JLabel movieNameLabel = new JLabel(movie.getName());
            movieNameLabel.setForeground(Color.blue);
            movieNameLabel.setFont(new Font("Serif", Font.PLAIN, 25));
            movieNameLabel.setBounds(250, 60, 800, 50);

            JLabel basicInfoLabel = new JLabel(movie.getRuntime() + "min" + " | " + movie.getGenre() + " | " +
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
            seeMoreButton.addActionListener(new handler3(panel, seeMoreButton, movie, model));

            JButton newSearchButton = new JButton("New Search");
            newSearchButton.setFont(new Font("Serif", Font.PLAIN, 15));
            newSearchButton.setBounds(600, 420, 180, 30);
            newSearchButton.addActionListener(new handler4());

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

    public class handler3 implements ActionListener {
        private JPanel panel;
        private JButton button;
        private Movie movie;
        private DefaultTableModel model;

        public handler3(JPanel panel, JButton button, Movie movie, DefaultTableModel model) {
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

    public class handler4 implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            mainPanel.setLayout(null);
            mainPanel.removeAll();
            mainPanel.updateUI();

            JLabel mdbLabel = new JLabel("MDb");
            mdbLabel.setForeground(Color.RED);
            mdbLabel.setFont(new Font("Serif", Font.BOLD, 40));
            mdbLabel.setBounds(0, 0, 100, 50);

            searchField = new JTextField("F");
            searchField.setBounds(150, 70, 500, 20);

            // Search button una action handler koycaz o an searchField ın içinde yazan filmi bulup yeni bir Movie Panel açıp
            // Movie panel a o isimdeki movie yi vererek kullanıcak.
            JButton searchButton = new JButton("Search");
            searchButton.setBounds(655, 70, 75, 20);
            searchButton.addActionListener(new handler(mainPanel));

            mainPanel.add(searchButton);
            mainPanel.add(mdbLabel);
            mainPanel.add(searchField);

        }
    }
}




