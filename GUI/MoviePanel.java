import java.awt.*;
import javax.swing.*;

// spesifik bir film ile ilgili bilgileri göstereceği için constructorı search panel da bir filme basıldıgında,
// o movie objesini almalı ve CIZDIGIM seyi bu bilgileri kullanarak oluşturmalı...

public class MoviePanel {

    private Movie movie;

    public MoviePanel(Movie movie) {
        super();
        this.movie = movie;

    }
}
