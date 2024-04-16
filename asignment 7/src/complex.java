import java.util.InputMismatchException;
import java.util.Scanner;

class Complex implements Comparable<Complex> {
    private double real;
    private double imaginary;

    // Constructors
    public Complex() {
        this(0, 0);
    }

    public Complex(double real) {
        this(real, 0);
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(Complex other) {
        this.real = other.real;
        this.imaginary = other.imaginary;
    }

    // Getters
    public double getRealPart() {
        return real;
    }

    public double getImaginaryPart() {
        return imaginary;
    }

    // Operations
    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }

    public Complex multiply(Complex other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.imaginary * other.real + this.real * other.imaginary;
        return new Complex(newReal, newImaginary);
    }

    public Complex divide(Complex other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new Complex(newReal, newImaginary);
    }

    public double abs() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    // Override toString method
    @Override
    public String toString() {
        if (imaginary == 0) {
            return String.format("%.1f", real);
        } else {
            return String.format("%.1f + %.1fi", real, imaginary);
        }
    }

    // Implement Comparable interface based on absolute value
    @Override
    public int compareTo(Complex other) {
        double thisAbs = this.abs();
        double otherAbs = other.abs();
        if (thisAbs < otherAbs) {
            return -1;
        } else if (thisAbs > otherAbs) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first complex number: ");
            double a1 = scanner.nextDouble();
            double b1 = scanner.nextDouble();
            Complex complex1 = new Complex(a1, b1);

            System.out.print("Enter the second complex number: ");
            double a2 = scanner.nextDouble();
            double b2 = scanner.nextDouble();
            Complex complex2 = new Complex(a2, b2);

            // Perform operations and display results
            System.out.println(complex1 + " + " + complex2 + " = " + complex1.add(complex2));
            System.out.println(complex1 + " - " + complex2 + " = " + complex1.subtract(complex2));
            System.out.println(complex1 + " * " + complex2 + " = " + complex1.multiply(complex2));
            System.out.println(complex1 + " / " + complex2 + " = " + complex1.divide(complex2));
            System.out.println("|" + complex1 + "| = " + complex1.abs());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter two valid double values separated by space.");
        } finally {
            scanner.close();
        }
    }
}


