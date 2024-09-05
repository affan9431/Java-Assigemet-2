/***
 * Question: Create a ten string function.
 * The available operations are listed below: Append, CountWords, Replace, isPalindrome, Splice, Split, MaxRepeatingCharacter, Sort, Shift, and Reverse.
 * Owner name: Affan Sayeed.
 * Date: 5-9-2024
 */
import java.util.Scanner;

class StringFunction {
    static String outputString = " ";

    public int maximum(int i, int j) {
        return i > j ? i : j;
    }

    public void append(String newString) {
        outputString += newString + " ";
        System.out.println("Output String: " + outputString);
    }

    public int countWords() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Constants.ENTER_STRING);
        String str = sc.nextLine();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }

    public void isPalindrome() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Constants.ENTER_STRING);

        String str = sc.nextLine().toLowerCase().replace(" ", "");
        char character;
        String output = "";

        for (int i = 0; i < str.length(); i++) {
            character = str.charAt(i);
            output = character + output;
        }

        if (str.equals(output)) {
            System.out.println("Yes, it is palindrome.");
        } else {
            System.out.println("No, it is not palindrome.");
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

        int idx = -1;
        for (int i = 0; i < name.length() - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < name.length(); j++) {
                if (name.charAt(i) == name.charAt(j)) {
                    count++;
                }
                if (count == max) {
                    idx = i;
                }
            }
        }

        if (idx != -1) {
            System.out.println(name.charAt(idx) + " -> " + max);
        } else {
            System.out.println("No repeated characters found.");
        }
    }

    public void replace(String string, String oldSubstring, String newSubstring) {
        String output = "";
        int i = 0;
        int len = oldSubstring.length();

        while (i <= string.length() - len) {
            if (string.substring(i, i + len).equals(oldSubstring)) {
                output += newSubstring;
                i += len;
            } else {
                output += string.charAt(i);
                i++;
            }
        }
        output += string.substring(i);
        System.out.println(output);
    }

    public String reverse() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Constants.ENTER_STRING);
        String str = sc.nextLine();
        char character;
        String reverseString = "";

        for (int i = 0; i < str.length(); i++) {
            character = str.charAt(i);
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
        String[] arr = new String[string.length()];
        String output = "";
        int index = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                if (!output.isEmpty()) {
                    arr[index] = output;
                    index++;
                }
                output = "";
            } else {
                output += string.charAt(i);
            }
        }

        if (!output.isEmpty()) {
            arr[index] = output;
            index++;
        }

        for (int i = 0; i < index; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("<---------->");
    }

    public String shiftCharacters(String s, int index) {
        int length = s.length();
        String output = "";
        for (int i = length - index; i < length; i++) {
            output += s.charAt(i);
        }
        for (int i = 0; i < length - index; i++) {
            output += s.charAt(i);
        }

        return output;
    }
}

public class StringMethods {
    public static void main(String[] args) {
        StringFunction stringFunction = new StringFunction();
        Scanner sc = new Scanner(System.in);
        String str = "";

        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println(Constants.ENTER_STRING);
            str = sc.nextLine();

            System.out.println(Constants.SELECT_OPERATION);

            if (!sc.hasNextInt()) {
                System.out.println(Constants.INVALID_INPUT);
                sc.next();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    stringFunction.append(str);
                    break;
                case 2:
                    int wordCount = stringFunction.countWords();
                    System.out.println("Number of words: " + wordCount);
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
                    str = sc.nextLine();

                    System.out.println(Constants.ENTER_CHARACTER_TO_REPLACE);
                    oldSubstring = sc.nextLine();

                    System.out.println(Constants.ENTER_NEW_CHARACTER);
                    newSubstring = sc.nextLine();

                    stringFunction.replace(str, oldSubstring, newSubstring);
                    System.out.println(Constants.EXIT_PROGRAM);
                    break;
                case 6:
                    String reversedString = stringFunction.reverse();
                    System.out.println("Reversed string: " + reversedString);
                    break;
                case 7:
                    String sortedString = stringFunction.sort(str);
                    System.out.println("Sorted string: " + sortedString);
                    break;
                case 8:
                    System.out.println(Constants.ENTER_START_INDEX);
                    int startIndex = sc.nextInt();
                    System.out.println(Constants.ENTER_LENGTH_TO_SPLICE);
                    int length = sc.nextInt();
                    stringFunction.splice(str, startIndex, length);
                    break;
                case 9:
                    stringFunction.split(str);
                    break;
                case 10:
                    System.out.println(Constants.ENTER_START_INDEX);
                    int start = sc.nextInt();
                    String outputString = stringFunction.shiftCharacters(str, start);
                    System.out.println("Output string: " + outputString);
                    break;
                default:
                    System.out.println(Constants.INVALID_CHOICE);
                    break;
            }

            System.out.println(Constants.CONTINUE_PROGRAM);
            String continueChoice = sc.nextLine().trim().toLowerCase();

            if (!continueChoice.equals("yes")) {
                continueProgram = false;
                System.out.println(Constants.EXIT_PROGRAM);
            }
        }
    }
}
