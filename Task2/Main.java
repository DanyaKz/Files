package Task2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    static BookComparator bookComparator = new BookComparator();
    static SortedSet<Book> books = new TreeSet<Book>(bookComparator.reversed());
    static StringBuilder combinedData = new StringBuilder();

    static private class BookComparator implements Comparator<Book> {

        @Override
        public int compare(Book b1, Book b2) {
            return Integer.compare(b1.getPrice(), b2.getPrice());
        }

    }

    public static void main(String[] args) {
        inputFile();
        writeFile();
    }

    static void inputFile() {
        try {
            FileInputStream fis = new FileInputStream("src/Task2/input.txt");
            byte[] bytes = fis.readAllBytes();
            for (byte b : bytes) {
                combinedData.append((char) b);
            }
            fis.close();
            addBooks();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void addBooks() {
        String[] booksData = combinedData.toString().split("\r\n");
        for (String book : booksData) {
            String[] bookArr = book.split("( )");
            books.add(new Book(bookArr[0], bookArr[1], Integer.parseInt(bookArr[2]), Integer.parseInt(bookArr[3])));
        }
        booksResearch();
    }

    static void booksResearch() {
        Iterator<Book> iterBooks = books.iterator();
        while (iterBooks.hasNext()) {
            Book book = iterBooks.next();

            if (book.getGenre().equals("fantasy")) {
                iterBooks.remove();
                continue;
            }

            if (book.getYear() < 2022 - 30) {
                book.decreasePrice();
            } else if (book.getYear() > 2022 - 5) {
                book.increasePrice();
            }

        }
    }

    static void writeFile() {
        try {
            FileOutputStream fos = new FileOutputStream("src/Task2/output.txt");
            for (Book book : books) {
                String prepareData = String.format("%s %d%n",
                        book.getName(), book.getPrice());
                fos.write(prepareData.getBytes());
            }

            fos.close();
            System.out.println("Hi!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
