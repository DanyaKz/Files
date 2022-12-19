package Task2;

import java.io.Serializable;

public class Book implements Serializable {

    public static final long serialVersionUID = 1L;
    private String name;
    private String genre;
    private int year;
    private int price;

    public Book(String name, String genre, int year, int price) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public void decreasePrice() {
        this.price *= 0.65;
    }

    public void increasePrice() {
        this.price *= 1.15;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
