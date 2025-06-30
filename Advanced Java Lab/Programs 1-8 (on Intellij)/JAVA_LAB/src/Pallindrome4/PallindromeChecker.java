package Pallindrome4;

import java.util.*;
class InvalidInputException extends Exception{
    public InvalidInputException(String message) {
        super(message);
    }
}
class ShortStringException extends Exception{
    public ShortStringException(String message) {
        super(message);
    }
}
public class  PallindromeChecker {

    public static void validateInput(String str) throws  InvalidInputException, ShortStringException{
        if(!str.matches("[a-zA-Z]+")) {
            throw new InvalidInputException("Input must contain only alphabetic characters.");
        }
        if(str.length() <3) {
            throw new ShortStringException("Input String must be at least 3 characters long.");
        }
    }
    public static  boolean ispalindrome(String str) {
        str =str.toLowerCase();
        StringBuffer original = new StringBuffer(str);
        StringBuffer reversed= new StringBuffer(str).reverse();

        return original.toString().equals(reversed.toString());
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a String to check for pallindrome:");
            String input =scanner.nextLine();
            validateInput(input);

            if (ispalindrome(input))
            {
                System.out.println("The string is a palindrome");
            }
            else {
                System.out.println("The string is not a palindrome");
            }
        }
        catch(InvalidInputException | ShortStringException e)
        {
            System.out.println("Error:"+e.getMessage());
        }
        finally {
            scanner.close();
        }
    }
}
