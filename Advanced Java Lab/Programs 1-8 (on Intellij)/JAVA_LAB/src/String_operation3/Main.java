package String_operation3;



import java.util.Scanner;
import String_operation3.StringProcessor;

public class Main {
    public static void main(String[] args) {
        StringProcessor s = new StringProcessor();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        System.out.println("\n--- String Operations Result ---");
        System.out.println("Reversed: " + s.reverse(input));
        System.out.println("Palindrome: " + s.isPalindrome(input));
        System.out.println("Uppercase: " + s.toUpperCase(input));
        System.out.println("Lowercase: " + s.toLowerCase(input));
        System.out.println("Vowel Count: " + s.countVowels(input));
        System.out.println("Word Count: " + s.wordCount(input));

        System.out.println("\nEnter another string for concatenation:");
        String secondInput = sc.nextLine();
        System.out.println("Concatenated String: " + s.concatenate(input, secondInput));
    }
}
