package dataStructures.javaPriorityQueue.exercise01;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-priority-queue/problem?isFullScreen=false
 *
 * Input:
12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED
 *
 *
 * Output:
Dan
Ashley
Shafaet
Maria
 */

class Student {
    private final int id;
    private final String name;
    private final double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", cgpa=").append(cgpa);
        sb.append('}');
        return sb.toString();
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> studentPriorityQueue = new PriorityQueue(
                Comparator.comparing(Student::getCgpa).reversed().
                        thenComparing(Student::getName)
                        .thenComparing(Student::getId));
        final List<Student> students = new ArrayList<>();
        for (String e : events) {
            final String[] row = e.split(" ");
            if (row[0].equals("ENTER")) {
                final int id = Integer.parseInt(row[3]);
                final String name = row[1];
                final double cgpa = Double.parseDouble(row[2]);

                final Student student = new Student(id, name, cgpa);
                studentPriorityQueue.add(student);
            } else if (row[0].equals("SERVED")) {
                studentPriorityQueue.poll();
            }
        }
        Student first = studentPriorityQueue.poll();
        while (first != null) {
            students.add(first);
            first = studentPriorityQueue.poll();
        }
        return students;
    }
}

public class Solution {
    private static final Scanner scan = new Scanner(System.in);
    private static final Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
