import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class project4 {



    public static int getNoLines(String filename) throws FileNotFoundException {
        int count = 0;
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
        }
        return count;
    }


    /*
     * param filename source file
     * return two dim array  where each row in the array contains the
     *         values in one line of the file, the length of each row depends on the
     *         number of values in each line of the file.
     * throws FileNotFoundException
     */
    public static int[][] create2DArray(String filename) throws FileNotFoundException {
        int numLines = getNoLines(filename);
        int[][] result = new int[numLines][];
        try (Scanner scanner = new Scanner(new File(filename))) {
            for (int i = 0; i < numLines; i++) {
                String[] parts = scanner.nextLine().trim().split("\\s+");
                int[] row = new int[parts.length];
                for (int j = 0; j < parts.length; j++) {
                    row[j] = Integer.parseInt(parts[j]);
                }
                result[i] = row;
            }
        }
        return result;
    }


    /*
     * return index of the longest row in the given two-dim array.
     */
    public static int findLongestRow(int[][] array) {
        int longestRow = 0;
        int maxLength = array[0].length;
        for (int i = 1; i < array.length; i++) {
            if (array[i].length > maxLength) {
                maxLength = array[i].length;
                longestRow = i;
            }
        }
        return longestRow;
    }


    /*
     * return max value in the given row of the given two-dim array.
     */
    public static int findMaxInRow(int[][] array, int rowIndex) {
        int max = array[rowIndex][0];
        for (int i = 1; i < array[rowIndex].length; i++) {
            if (array[rowIndex][i] > max) {
                max = array[rowIndex][i];
            }
        }
        return max;
    }


    /*
     * return max value in the given two-dim array.
     */
    public static int findMax(int[][] array) {
        int max = array[0][0];
        for (int[] row : array) {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        String filename = "C:\\Users\\wade3\\Desktop/assignment4Data (1).txt"; // Your file path
        int arr[][] = null;


        try {
            System.out.println("Number of lines in the file =" + getNoLines(filename));
            arr = create2DArray(filename);
            int longestRow = findLongestRow(arr);
            System.out.println("Longest row in the file is: " + (longestRow + 1) + " ,with length of: "
                    + arr[longestRow].length);
            System.out.println("Max value in first row = " + findMaxInRow(arr, 0));
            System.out.println("Max value in file = " + findMax(arr));
        } catch (FileNotFoundException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in the file: " + e.getMessage());
        }
    }
}

