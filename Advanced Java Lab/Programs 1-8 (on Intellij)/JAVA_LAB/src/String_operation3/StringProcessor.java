package String_operation3;

public class StringProcessor implements StringManipulator {

    public String toUpperCase(String input) {
        return input.toUpperCase();
    }

    public String toLowerCase(String input) {
        return input.toLowerCase();
    }

    public String concatenate(String str1, String str2) {
        return str1.concat(str2);
    }

    public String reverse(String input) {
        char[] chars = input.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public boolean isPalindrome(String input) {
        String reversed = reverse(input);
        return input.equalsIgnoreCase(reversed);
    }

    public int wordCount(String input) {
        if (input.trim().isEmpty()) {
            return 0;
        }
        return input.trim().split("\\s+").length;
    }

    public int countVowels(String input) {
        int count = 0;
        String vowels = "AEIOUaeiou";
        for (char ch : input.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
}