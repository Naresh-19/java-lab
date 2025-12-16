
import java.util.Scanner;

class Student {
    private String usn;
    private String name;
    private int[] credits;
    private int[] marks;
    private int numSubjects;
    private double sgpa;

    public Student(int numSubjects) {
        this.numSubjects = numSubjects;
        credits = new int[numSubjects];
        marks = new int[numSubjects];
    }

    public void acceptDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter USN: ");
        usn = sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = sc.nextInt();
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
        sgpa = calculateSGPA();
    }

    private double calculateSGPA() {
        int totalCredits = 0;
        double totalPoints = 0;
        for (int i = 0; i < numSubjects; i++) {
            totalCredits += credits[i];
            totalPoints += credits[i] * gradePoint(marks[i]);
        }
        return totalPoints / totalCredits;
    }
    private double gradePoint(int marks) {
        if (marks >= 90) return 10;
        else if (marks >= 80) return 9;
        else if (marks >= 70) return 8;
        else if (marks >= 60) return 7;
        else if (marks >= 50) return 6;
        else if (marks >= 40) return 5;
        else return 0;
    }

    public void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Subject\tCredits\tMarks");
        for (int i = 0; i < numSubjects; i++) {
            System.out.println((i + 1) + "\t" + credits[i] + "\t" + marks[i]);
        }
        System.out.printf("SGPA: %.2f\n", sgpa);
    }
}

public class SGPACalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        Student student = new Student(n);
        student.acceptDetails();
        student.displayDetails();
    }
}
