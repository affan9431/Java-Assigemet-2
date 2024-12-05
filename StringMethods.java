/***
 * Question: Create a Ten string function.
 * The available operations are listed below: Append, CountWords, Replace, isPalindrome, Splice, Split, MaxRepeatingCharacter, Sort, Shift, and Reverse.
 * Owner name: Affan Sayeed.
 * Date: 5-9-2024
 */
import java.util.Scanner;

class StringFunction {
    static String outputString = " ";


    // Return maximum value by comparing two value
    public int maximum(int i, int j) {
        return Math.max(i, j);
    }

    // append string in front of previous string
    // String currentString = "Hello";
    // append(" World"); Result: "Hello World"
    //  append(" Java");  Result: "Hello World Java"
    public void append(String newString) {
        outputString += newString + " ";
        System.out.println(Constants.OUTPUT_STRING + outputString);
    }


   // Count the word from the string
   // String text = "Hello World from Codeup";
   // int wordCount = countWords(); Result: 4
    public int countWords() {
        Scanner input = new Scanner(System.in);
        System.out.println(Constants.ENTER_STRING);
        String inputString = input.nextLine();
        int count = 1;

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }


    // Check String is palindrome or not.
    // String text = "madam";
    // boolean isPal = isPalindrome(); Result: true

    public void isPalindrome() {
        Scanner input = new Scanner(System.in);
        System.out.println(Constants.ENTER_STRING);

        String inputString = input.nextLine().toLowerCase().replace(" ", "");
        char character;
        String output = "";

        for (int i = 0; i < inputString.length(); i++) {
            character = inputString.charAt(i);
            output = character + output;
        }

        if (inputString.equals(output)) {
            System.out.println(Constants.PALINDROME);
        } else {
            System.out.println(Constants.NOT_A_PALINDROME);
        }
    }

    public void maxFrequency() {
        Scanner input = new Scanner(System.in);
        System.out.println(Constants.ENTER_STRING);

        String name = input.nextLine();
        int max = 0;

        for (int i = 0; i < name.length() - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < name.length(); j++) {
                if (name.charAt(i) == name.charAt(j)) {
                    count++;
                }
            }
            max = maximum(max, count);
        }

        int index = -1;
        for (int i = 0; i < name.length() - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < name.length(); j++) {
                if (name.charAt(i) == name.charAt(j)) {
                    count++;
                }
                if (count == max) {
                    index = i;
                }
            }
        }

        if (index != -1) {
            System.out.println(name.charAt(index) + " -> " + max);
        } else {
            System.out.println("No repeated characters found.");
        }
    }

    public void replace(String string, String oldSubstring, String newSubstring) {
        String output = "";
        int i = 0;
        int length = oldSubstring.length();

        while (i <= string.length() - length) {
            if (string.substring(i, i + length).equals(oldSubstring)) {
                output += newSubstring;
                i += length;
            } else {
                output += string.charAt(i);
                i++;
            }
        }
        output += string.substring(i);
        System.out.println(output);
    }

    public String reverse() {
        Scanner input = new Scanner(System.in);
        System.out.println(Constants.ENTER_STRING);
        String inputString = input.nextLine();
        char character;
        String reverseString = "";

        for (int i = 0; i < inputString.length(); i++) {
            character = inputString.charAt(i);
            reverseString = character + reverseString;
        }

        return reverseString;
    }

    public String sort(String string) {
        char[] charArray = string.toCharArray();
        int charArrayLength = charArray.length;

        for (int i = 0; i < charArrayLength - 1; i++) {
            for (int j = 0; j < charArrayLength - i - 1; j++) {
                if (charArray[j] > charArray[j + 1]) {
                    char temp = charArray[j];
                    charArray[j] = charArray[j + 1];
                    charArray[j + 1] = temp;
                }
            }
        }

        return new String(charArray);
    }

    public void splice(String string, int startIndex, int length) {
        String output = "";

        for (int i = 0; i < string.length(); i++) {
            if (i >= startIndex && i < startIndex + length) {
                continue;
            } else {
                output += string.charAt(i);
            }
        }
        System.out.println(output);
    }

    public void split(String string) {
        String[] outputArray = new String[string.length()];
        String output = "";
        int index = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                if (!output.isEmpty()) {
                    outputArray[index] = output;
                    index++;
                }
                output = "";
            } else {
                output += string.charAt(i);
            }
        }

        if (!output.isEmpty()) {
            outputArray[index] = output;
            index++;
        }

        for (int i = 0; i < index; i++) {
            System.out.println(outputArray[i]);
        }
        System.out.println("<---------->");
    }

    public String shiftCharacters(String string, int index) {
        int length = string.length();
        String output = "";
        for (int i = length - index; i < length; i++) {
            output += string.charAt(i);
        }
        for (int i = 0; i < length - index; i++) {
            output += string.charAt(i);
        }

        return output;
    }
}

public class StringMethods {
    public static void main(String[] args) {
        StringFunction stringFunction = new StringFunction();
        Scanner input = new Scanner(System.in);
        String inputString = "";

        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println(Constants.ENTER_STRING);
            inputString = input.nextLine();

            System.out.println(Constants.SELECT_OPERATION);

            if (!input.hasNextInt()) {
                System.out.println(Constants.INVALID_INPUT);
                input.next();
                continue;
            }

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    stringFunction.append(inputString);
                    break;
                case 2:
                    int wordCount = stringFunction.countWords();
                    System.out.println(Constants.NUMBER_OF_WORD+ wordCount);
                    break;
                case 3:
                    stringFunction.isPalindrome();
                    break;
                case 4:
                    stringFunction.maxFrequency();
                    break;
                case 5:
                    String oldSubstring, newSubstring;

                    System.out.println(Constants.ENTER_STRING);
                    inputString = input.nextLine();

                    System.out.println(Constants.ENTER_CHARACTER_TO_REPLACE);
                    oldSubstring = input.nextLine();

                    System.out.println(Constants.ENTER_NEW_CHARACTER);
                    newSubstring = input.nextLine();

                    stringFunction.replace(inputString, oldSubstring, newSubstring);
                    System.out.println(Constants.EXIT_PROGRAM);
                    break;
                case 6:
                    String reversedString = stringFunction.reverse();
                    System.out.println(Constants.REVERSE_STRING + reversedString);
                    break;
                case 7:
                    String sortedString = stringFunction.sort(inputString);
                    System.out.println(Constants.SORTED_STRING + sortedString);
                    break;
                case 8:
                    System.out.println(Constants.ENTER_START_INDEX);
                    int startIndex = input.nextInt();
                    System.out.println(Constants.ENTER_LENGTH_TO_SPLICE);
                    int length = input.nextInt();
                    stringFunction.splice(inputString, startIndex, length);
                    break;
                case 9:
                    stringFunction.split(inputString);
                    break;
                case 10:
                    System.out.println(Constants.ENTER_START_INDEX);
                    int start = input.nextInt();
                    String outputString = stringFunction.shiftCharacters(inputString, start);
                    System.out.println(Constants.OUTPUT_STRING + outputString);
                    break;
                default:
                    System.out.println(Constants.INVALID_CHOICE);
                    break;
            }

            System.out.println(Constants.CONTINUE_PROGRAM);
            String continueChoice = input.nextLine().trim().toLowerCase();

            if (!continueChoice.equals(Constants.YES)) {
                continueProgram = false;
                System.out.println(Constants.EXIT_PROGRAM);
            }
        }
    }
}
