import java.util.*;
import CIE.*;
import SEE.*;

class FinalMarks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student s[] = new Student[n];
        Internals in[] = new Internals[n];
        External ex[] = new External[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("USN: ");
            String usn = sc.next();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Semester: ");
            int sem = sc.nextInt();

            int im[] = new int[5];
            System.out.println("Enter 5 Internal Marks:");
            for (int j = 0; j < 5; j++) im[j] = sc.nextInt();

            int em[] = new int[5];
            System.out.println("Enter 5 SEE Marks:");
            for (int j = 0; j < 5; j++) em[j] = sc.nextInt();

            s[i] = new Student(usn, name, sem);
            in[i] = new Internals(im);
            ex[i] = new External(usn, name, sem, em);
        }

        System.out.println("\n===== FINAL MARKS OF STUDENTS =====");

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent: " + s[i].name + " (" + s[i].usn + ")");
            for (int j = 0; j < 5; j++) {
                int finalMarks = in[i].internalMarks[j] + (ex[i].externalMarks[j] / 2);
                System.out.println("Course " + (j + 1) + ": " + finalMarks);
            }
        }

        sc.close();
    }
}
