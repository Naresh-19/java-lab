import java.util.*;
class quadraticroots{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the coefficient a:");
        double a= sc.nextDouble();
        System.out.println("enter the coefficient b:");
        double b= sc.nextDouble();
        System.out.println("enter the coefficient c:");
        double c= sc.nextDouble();
        double d = b*b - 4*a*c;
        if(d==0){
            System.out.println("print roots are equal");
            double r1 = -b /(2*a);
            System.out.println( "roots are "+r1);
        }
        else if(d>0){
            System.out.println("print roots are unequal equal");
            double r1 = (-b + Math.sqrt(d))/(2*a);
            double r2 = (-b - Math.sqrt(d))/(2*a);
            System.out.println( "roots are "+r1);
            System.out.println( "roots are "+r2);
        }
        else{
            System.out.println("print roots are imaginary");
            double realpart = -b/(2*a);
            double imaginarypart = Math.sqrt(-d)/(2*a);
            System.out.println("real part: "+ realpart +"imaginarypart: "+imaginarypart);
        }

    }
}

