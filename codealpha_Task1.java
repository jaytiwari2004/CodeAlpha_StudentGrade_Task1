import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class codealpha_Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("Enter student grades one by one. Type 'done' when finished:");

        // Input loop
        while (true) {
            String input = scanner.nextLine();

            // Exit condition
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                // Convert input to double and add to the list
                double grade = Double.parseDouble(input);

                // Check for valid grade range (0 to 100)
                if (grade < 0 || grade > 100) {
                    System.out.println("Grade must be between 0 and 100. Please enter a valid grade.");
                } else {
                    grades.add(grade);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Check if any grades were entered
        if (grades.isEmpty()) {
            System.out.println("No grades were entered.");
            scanner.close();
            return;
        }

        // Compute statistics
        double average = computeAverage(grades);
        double highest = Collections.max(grades);
        double lowest = Collections.min(grades);

        // Output results
        System.out.printf("Average grade: %.2f%n", average);
        System.out.printf("Highest grade: %.2f%n", highest);
        System.out.printf("Lowest grade: %.2f%n", lowest);

        scanner.close();
    }

    // Method to compute the average grade
    private static double computeAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
