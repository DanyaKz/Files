package Task2;

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static BookComparator bookComparator = new BookComparator();
    static SortedSet<Book> books = new TreeSet<Book>(bookComparator.reversed());
    static StringBuilder combinedData = new StringBuilder();



    static private class BookComparator implements Comparator<Book>, Serializable {
        public static final long serialVersionUID = 2L;
        @Override
        public int compare(Book b1, Book b2) {
            return Integer.compare(b1.getPrice(), b2.getPrice());
        }

    }

    public static void main(String[] args) {
        inputFile();
        writeFile();
        printData();
    }

    static void inputFile() {
        try (FileInputStream fis = new FileInputStream("src/Task2/input.txt");
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            for (byte b : bis.readAllBytes()) {
                combinedData.append((char) b);
            }
            System.out.println(combinedData);
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
        booksResearchStream();
    }

    static void booksResearchStream(){
        books.stream().filter(book -> book.getYear() < 2022 - 30).forEach(Book::decreasePrice);
        books.stream().filter(book -> book.getYear() > 2022 - 5).forEach(Book::increasePrice);
        books.removeIf(book -> book.getGenre().equals("fantasy"));

    }


    static void writeFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream("src/Task2/output.txt"))) {
//            ArrayList<Book> write = new ArrayList<Book>(Arrays.<Book>asList((Book[]) books.toArray()));
            TreeSet<Book> writeBooks = (TreeSet<Book>) books;
            oos.writeObject(writeBooks);
            System.out.println("Hi!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void printData(){
        SortedSet<Book> readBooks;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Task2/output.txt"))){

            readBooks = (TreeSet<Book>) ois.readObject();

        }catch (ClassNotFoundException | ClassCastException | IOException e){
            throw new RuntimeException(e);
        }

        System.out.println(readBooks);

    }


}
