import java.util.*;

class Student {
    String name;
    int[] marks;
    double average;
    char grade;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        calculateAverage();
        assignGrade();
    }

    void calculateAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        average = sum / (double) marks.length;
    }

    void assignGrade() {
        if (average >= 90) grade = 'A';
        else if (average >= 80) grade = 'B';
        else if (average >= 70) grade = 'C';
        else if (average >= 60) grade = 'D';
        else grade = 'F';
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("----------------------------");
    }
}

public class StudentGradeManager {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Grade Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter student name: ");
        sc.nextLine();
        String name = sc.nextLine();

        int[] marks = new int[5];
        System.out.println("Enter marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        students.add(new Student(name, marks));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- All Students ---");
        for (Student s : students) {
            s.display();
        }
    }
}
