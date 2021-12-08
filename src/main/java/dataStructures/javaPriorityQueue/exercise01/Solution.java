package dataStructures.javaPriorityQueue.exercise01;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-priority-queue/problem?isFullScreen=false
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
}

class Priorities {

    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> studentPriorityQueue = new PriorityQueue(
                Comparator.comparing(Student::getCgpa).reversed().
                        thenComparing(Student::getName)
                        .thenComparing(Student::getId));
        List<Student> students = new ArrayList<>();
        for (String e : events) {
            Scanner in = new Scanner(e);
            String event = in.next();
            if (event.equals("ENTER")) {
                String name = in.next();
                float cgpa = in.nextFloat();
                int token = in.nextInt();

                final Student student = new Student(token, name, cgpa);
                studentPriorityQueue.add(student);
            } else if (event.equals("SERVED")) {
                studentPriorityQueue.poll();
            }
            in.close();
        }
        Student first = studentPriorityQueue.poll();
        if (first != null) {
            while (first != null) {
                students.add(first);
                first = studentPriorityQueue.poll();
            }
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
