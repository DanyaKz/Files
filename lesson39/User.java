package lesson39;

//import Library.Book;

import java.io.Serializable;

public class User implements Serializable {
    long id;
    String fullname;
    double balance;
    transient Boolean gender;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", balance=" + balance +
                ", gender=" + gender +
                '}';
    }
}
