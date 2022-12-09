package Task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    static SortedSet<Student> students = new TreeSet<Student>();
    static StringBuilder combinedData = new StringBuilder();


    public static void main(String[] args) {
        readFile();
        researchData();
        writeFile();
    }

    static void readFile() {

        try {
            FileInputStream fis = new FileInputStream("src/Task1/input.txt");
            byte[] bytes = fis.readAllBytes();
            for (byte b : bytes) {
                combinedData.append((char) b);
            }
            fis.close();
            addStudents();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void addStudents() {
        String[] stData = combinedData.toString().split("\r\n");
        for (String st : stData) {
            String[] stArr = st.split("( )");
            students.add(new Student(stArr[0], Double.parseDouble(stArr[1]), Integer.parseInt(stArr[2])));
        }
    }

    static void researchData() {
        Iterator<Student> iterStudents = students.iterator();
        while (iterStudents.hasNext()) {
            Student student = iterStudents.next();

            if (student.getMark() < 2) {
                iterStudents.remove();
                continue;
            }

            if (student.getMark() > 4) {
                student.increaseScholarship();
            }
        }

    }

    static void writeFile() {
        try {
            FileOutputStream fos = new FileOutputStream("src/Task1/output.txt");
            for (Student s : students) {
                String prepareStData = String.format("%s will take %d(%s)%n",
                        s.getName(), s.getScholarship(), s.getMark());
                byte[] bytes = prepareStData.getBytes();
                fos.write(bytes);
            }
            fos.close();
            System.out.println("Done");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
