package lab1;

import java.util.Scanner;

public class bai2_6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose the type of equation to solve:");
        System.out.println("1. First-degree equation with one variable (ax + b = 0)");
        System.out.println("2. System of first-degree equations with two variables (a11x1 + a12x2 = b1, a21x1 + a22x2 = b2)");
        System.out.println("3. The second-degree equation with one variable (ax^2+bx+c=0)");

        int choice = input.nextInt();

        if (choice == 1) {
            solveLinearEquation();
        } else if (choice == 2) {
            solveLinearSystem();
        } else if(choice ==3) {
            solveLinearDegree();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static void solveLinearEquation() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the coefficient 'a' (a ≠ 0): ");
        double a = input.nextDouble();
        while (a == 0) {
            System.out.println("The coefficient 'a' must be non-zero.");
            System.out.print("Enter the coefficient 'a' (a ≠ 0): ");
            a = input.nextDouble();
        }

        System.out.print("Enter the constant 'b': ");
        double b = input.nextDouble();

        double x = -b / a;
        System.out.println("Solution: x = " + x);
    }

    public static void solveLinearSystem() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter coefficients for the system of equations:");

        System.out.print("a11: ");
        double a11 = input.nextDouble();
        System.out.print("a12: ");
        double a12 = input.nextDouble();
        System.out.print("b1: ");
        double b1 = input.nextDouble();
        System.out.print("a21: ");
        double a21 = input.nextDouble();
        System.out.print("a22: ");
        double a22 = input.nextDouble();
        System.out.print("b2: ");
        double b2 = input.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("Solution: x1 = " + x1 + ", x2 = " + x2);
        } else {
            if (D1 == 0 && D2 == 0) {
                System.out.println("Infinite solutions.");
            } else {
                System.out.println("No solution.");
            }
        }
    }

    public  static void solveLinearDegree(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the coefficient 'a' (a ≠ 0): ");
        double a = input.nextDouble();

        while (a == 0) {
            System.out.println("The coefficient 'a' must be non-zero.");
            System.out.print("Enter the coefficient 'a' (a ≠ 0): ");
            a = input.nextDouble();
        }

        System.out.print("Enter the coefficient 'b': ");
        double b = input.nextDouble();

        System.out.print("Enter the coefficient 'c': ");
        double c = input.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Two distinct real roots:");
            System.out.println("x1= " + root1);
            System.out.println("x2= " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("One real double root:");
            System.out.println("x= " + root);
        } else {
            System.out.println("No real roots.");
        }
    }
}

