import java.util.Scanner;

abstract class Shape {
    int a, b;
    abstract void printArea();
}

class Rectangle extends Shape {
    Rectangle(int length, int breadth) {
        this.a = length;
        this.b = breadth;
    }
    void printArea() {
        System.out.println("Area of Rectangle: " + (a * b));
    }
}

class Triangle extends Shape {
    Triangle(int base, int height) {
        this.a = base;
        this.b = height;
    }
    void printArea() {
        System.out.println("Area of Triangle: " + (0.5 * a * b));
    }
}

class Circle extends Shape {
    Circle(int radius) {
        this.a = radius;
    }
    void printArea() {
        System.out.println("Area of Circle: " + (3.14 * a * a));
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Rectangle");
        System.out.println("2. Triangle");
        System.out.println("3. Circle");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        Shape s;

        switch (choice) {
            case 1:
                System.out.print("Enter length: ");
                int l = sc.nextInt();
                System.out.print("Enter breadth: ");
                int b = sc.nextInt();
                s = new Rectangle(l, b);
                s.printArea();
                break;

            case 2:
                System.out.print("Enter base: ");
                int base = sc.nextInt();
                System.out.print("Enter height: ");
                int h = sc.nextInt();
                s = new Triangle(base, h);
                s.printArea();
                break;

            case 3:
                System.out.print("Enter radius: ");
                int r = sc.nextInt();
                s = new Circle(r);
                s.printArea();
                break;

            default:
                System.out.println("Invalid Choice!");
        }

    }
}
