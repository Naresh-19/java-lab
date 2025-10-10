import java.util.*;

class Student {
    public static int credits(int score) {
        if (score >= 90) return 10;
        else if (score >= 80) return 9;
        else if (score >= 70) return 8;
        else if (score >= 60) return 7;
        else if (score >= 50) return 6;
        else return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int credSum = 0;
        int pointSum = 0;
        float SGPA;

        System.out.println("Enter name and USN:");
        String name = sc.nextLine();
        String USN = sc.nextLine();

        System.out.println("Enter number of subjects:");
        int a = sc.nextInt();
        int[] cred = new int[a];
        int[] marks = new int[a];

        for (int i = 0; i < a; i++) {
            System.out.println("Enter subject " + (i + 1) + " credits:");
            cred[i] = sc.nextInt();
            credSum += cred[i];

            System.out.println("Enter marks obtained:");
            marks[i] = sc.nextInt();
            pointSum += Student.credits(marks[i]) * cred[i];
        }

        SGPA = (float) pointSum / credSum;
        System.out.printf("SGPA = %.2f\n", SGPA); // formatted to 2 decimal places
    }
}
