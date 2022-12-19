package lesson39;

import java.io.*;

public class Lesson39 {
    public static void main(String[] args) {

        String str = "good evening";

        /*byte[] bytes = new byte[]{48, 65, 44, 97, 58};
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes, 1, 2);
        int i;
        while ((i = bais.read()) != -1) {
            System.out.println((char) i);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (FileOutputStream fos = new FileOutputStream("src/lesson39/output.txt")) {
            baos.write(str.getBytes());
            baos.writeTo(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        byte[] b = baos.toByteArray();*/

        /*InputStream bin = new ByteArrayInputStream(str.getBytes());
        try (BufferedInputStream bis = new BufferedInputStream(bin)) {
            int i;
            while ((i = bis.read()) != -1) {
                System.out.println((char) i);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }*/

//        User u = new User();
//        u.id = 1;
//        u.fullname = "no name";
//        u.balance = 2345.5;
//        u.gender = false;

//        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/lesson39/data.txt"))) {
//            dos.writeLong(u.id);
//            dos.writeUTF(u.fullname);
//            dos.writeDouble(u.balance);
//            dos.writeBoolean(u.gender);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        System.out.println("BEFORE :: " + u);
//
//        try (DataInputStream dis = new DataInputStream(new FileInputStream("src/lesson39/data.txt"))) {
//            u.id = dis.readLong();
//            u.fullname = dis.readUTF();
//            u.balance = dis.readDouble();
//            u.gender = dis.readBoolean();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("AFTER :: " + u);

//        User u = new User();
//        u.id = 1;
//        u.fullname = "no name";
//        u.balance = 2345.5;
//        u.gender = true;
//
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/lesson39/object.txt"))) {
//
//            oos.writeObject(u);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        User u = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/lesson39/object.txt"))) {

            u = (User) ois.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(u);
    }
}
