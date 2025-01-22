package baseconverter_kmp;

import java.util.Scanner;

public class BaseConverter_kmp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Loop for multiple conversions
        do {
            // Prompt user for the value to convert
            System.out.print("Enter the value to convert: ");
            String number = scanner.nextLine().toUpperCase();  // Convert input to uppercase for consistency

            // Prompt user for the base of the value to convert
            System.out.print("Enter the base of the value (2-36): ");
            int sourceBase = getValidBase(scanner);  // Get a valid base for the input value

            // Prompt user for the target base to convert to
            System.out.print("Enter the base to convert to (2-36): ");
            int targetBase = getValidBase(scanner);  // Get a valid target base for the conversion

            // Validate the number based on the source base
            if (isValidNumber(number, sourceBase)) {
                System.out.println("\nStep-by-step conversion:");
                long decimalValue = convertToDecimal(number, sourceBase);  // Convert number to decimal
                if (decimalValue < 0) {
                    // If an overflow occurs, show an error message
                    System.out.println("Error: Overflow occurred during the conversion.");
                } else {
                    // Convert the decimal value to the target base
                    convertFromDecimal(decimalValue, sourceBase, targetBase);
                }
            } else {
                // If the input number contains invalid characters for the source base, show an error
                System.out.println("Error: Input contains invalid characters for the specified base. Please try again.");
            }

            // Ask if the user wants to perform another conversion
            System.out.print("\nDo you want to perform another conversion? (yes/no): ");
        } while (scanner.nextLine().equalsIgnoreCase("yes"));

        System.out.println("Thank you for using the Base Converter!");
        scanner.close();  // Close the scanner object
    }

    // Method to get a valid base from the user (between 2 and 36)
    private static int getValidBase(Scanner scanner) {
        while (true) {
            try {
                int base = Integer.parseInt(scanner.nextLine());
                if (base >= 2 && base <= 36) {
                    return base;  // Return the valid base
                } else {
                    System.out.print("Error: Base must be between 2 and 36. Please re-enter the base: ");
                }
            } catch (NumberFormatException e) {
                // Handle non-integer inputs
                System.out.print("Error: Please enter a valid integer for the base: ");
            }
        }
    }

    // Method to check if the input number is valid for the given base
    private static boolean isValidNumber(String number, int base) {
        for (char c : number.toCharArray()) {
            // Check if each character is valid for the given base
            if (Character.digit(c, base) == -1) {
                return false;  // Return false if an invalid character is found
            }
        }
        return true;  // Return true if all characters are valid
    }

    // Method to convert the number to decimal (base 10)
    private static long convertToDecimal(String number, int base) {
        long decimalValue = 0;
        int power = 0;
        System.out.printf("1. Convert %s from base %d to base 10:\n", number, base);

        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Character.digit(number.charAt(i), base);
            long value = (long) digit * (long) Math.pow(base, power);
            
            // Overflow check for large values
            if (decimalValue + value < decimalValue) {
                System.out.println("Error: Overflow occurred during calculation.");
                return -1;  // Return -1 if overflow occurs
            }

            System.out.printf("   - %d * (%d^%d) = %d\n", digit, base, power, value);  // Display conversion step
            decimalValue += value;  // Add the calculated value to the decimal result
            power++;  // Increment power for the next place value
        }
        System.out.printf("   - Total: %d\n", decimalValue);  // Display the final decimal value
        return decimalValue;
    }

    // Method to convert the decimal value to the target base
    private static void convertFromDecimal(long decimalValue, int sourceBase, int targetBase) {
        System.out.printf("2. Convert %d from base %d to base %d:\n", decimalValue, sourceBase, targetBase);
        StringBuilder result = new StringBuilder();
        long tempValue = decimalValue;

        while (tempValue > 0) {
            long remainder = tempValue % targetBase;
            result.append(Character.forDigit((int) remainder, targetBase));  // Append the remainder to the result
            System.out.printf("   - %d / %d = %d (remainder %d)\n", tempValue, targetBase, tempValue / targetBase, remainder);
            tempValue /= targetBase;  // Update the value for the next iteration
        }

        result.reverse();  // Reverse the result to get the correct order
        System.out.printf("   - Result: %s\n", result.toString().toUpperCase());
        System.out.println("\nConverted value: " + result.toString().toUpperCase());  // Display the final result
    }
}
