/*
 * Class Name: CD
 * 
 * Class Description: This class extends AbstractMedia.It has the following methods: CD(), getArtist(), setArtist(), getYear(), and setYear().
 */

public class CD extends AbstractMedia {
    private String artist;
    private int year;

    // Defining the constructor for CD
    public CD(String title, double price, String artist, int year) {
        this.title = title;
        this.price = price;
        this.artist = artist;
        this.year = year;
    }
    
    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}
