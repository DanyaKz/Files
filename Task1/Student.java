package Task1;


public class Student implements Comparable<Student> {
    private String name;
    private double mark;
    private int scholarship;

    public Student(String name, double mark, int scholarship) {
        this.name = name;
        this.mark = mark;
        this.scholarship = scholarship;
    }

    public String getName() {
        return name;
    }

    public double getMark() {
        return mark;
    }

    public int getScholarship() {
        return scholarship;
    }

    public void increaseScholarship() {
        this.scholarship *= 1.3;
    }


    @Override
    public int compareTo(Student s) {
        return Double.compare(mark, s.getMark());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", mark=" + mark +
                ", scholarship=" + scholarship +
                '}';
    }
}
