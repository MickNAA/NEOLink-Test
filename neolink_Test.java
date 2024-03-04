import java.util.HashMap;
import java.util.Scanner;

public class neolink_Test {
    public static int convert(String str) {
        // Define a HashMap to store the mapping number
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('B', 5);
        map.put('Z', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('R', 1000);

        int num = 0;
        int prevValue = Integer.MAX_VALUE;
        int checkDuplicate = 1;

        // Iterate over each character in the input string
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            // Validate if the current character is a capital English letter and exists in the mapping
            if (!Character.isUpperCase(currentChar) || !map.containsKey(currentChar)) {
                System.out.println("Invalid input: Please enter only capital English letters.");
                return -1; // Return -1 to indicate invalid input
            }

            // Check for consecutive identical characters
            if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                checkDuplicate++;
                if (checkDuplicate > 3) {
                    System.out.println("Invalid input: Duplicate identical characters cannot appear more than three times.");
                    return -1; // Return -1 to indicate invalid input
                }
            } else {
                checkDuplicate = 1;
            }

            // Retrieve the value of the current character from the mapping
            int value = map.get(currentChar);

            // Convert Alien numeral to integer based on the given rules
            if (value > prevValue) {
                // Subtraction rule applies
                num += value - 2 * prevValue;
            } else {
                // Addition rule applies
                num += value;
            }
            System.out.println(prevValue);
            prevValue = value; // Update prevValue for the next iteration
        }

        return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an Alien numeral:");
        String input = scanner.nextLine();

        // Check if the input string is empty
        if (input.isEmpty()) {
            System.out.println("Invalid input: Input string cannot be empty.");
        } else {
            int output = convert(input);
            if (output != -1) {
                System.out.println("Input: " + input);
                System.out.println("Output: " + output);
            }
        }

        scanner.close();
    }
}
