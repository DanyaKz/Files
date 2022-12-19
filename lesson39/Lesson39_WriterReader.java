package lesson39;

import java.io.*;

public class Lesson39_WriterReader {
    public static void main(String[] args) throws IOException {

//        try (FileWriter writer = new FileWriter("src/lesson39/write-read.txt")) {
//
//            writer.write("this file has been written by FileWriter class!");
//            writer.append('\n');
//            writer.write("=========================");
//
//            writer.flush();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        String str = "";
        try (FileReader reader = new FileReader("src/lesson39/write-read.txt")) {

            int i;
            while ((i = reader.read()) != -1) {
                str += (char) i;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(str);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        BufferedReader reader1 = new BufferedReader(new FileReader("input.txt"));

        StringBuilder strs = new StringBuilder();

        strs.append("dskfjasdf");

//        strs.append();

        System.out.println(strs);

        String st = "asdasd";
        String st2 = "asdasd";

        st += "asdf";

        //System.out.println(st.);

        int s = Integer.parseInt(reader.readLine());

        System.out.println(s);
    }
}
