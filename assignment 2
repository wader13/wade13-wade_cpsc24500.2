import java.util.Scanner;

public class JavaLand {
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);

        //employee name and salary
        System.out.print("Enter employee name");
        String employeeName = scanner.nextLine();

        System.out.print("Enter employee name:");

        System.out.print("Enter employee salary in J$: ");
        double salary = scanner.nextDouble();

        // Validate input
        if (salary < 0) {
            System.out.println("Invalid input, income should be zero or more");
            System.exit(0);
        }

        // Calculate income tax
        double incomeTax = calculateIncomeTax(salary);

        // Display results
        System.out.println("\nName: " + employeeName);
        System.out.println("Income: J$" + salary);
        System.out.println("Income Tax: J$" + incomeTax);
    }

    public static double calculateIncomeTax(double salary) {
        double tax = 0;

        // Tax-free portion
        if (salary > 4000) {
            double taxableAmount = salary - 4000;

            // Tax at 10%
            if (taxableAmount > 1500) {
                tax += 150 * 0.10;
                taxableAmount -= 1500;

                // Tax at 20%
                if (taxableAmount > 0 && taxableAmount <= 28000) {
                    tax += taxableAmount * 0.20;
                } else if (taxableAmount > 28000) {
                    tax += 28000 * 0.20;
                    taxableAmount -= 28000;

                    // Tax at 40%
                    tax += taxableAmount * 0.40;
                }
            } else {
                tax += taxableAmount * 0.10;
            }
        }

        return tax;
    }
}







