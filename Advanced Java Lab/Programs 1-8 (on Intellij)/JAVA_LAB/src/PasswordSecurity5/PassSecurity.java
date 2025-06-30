package PasswordSecurity5;



import java.util.Scanner;
public class PassSecurity {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your password");
        String password=sc.nextLine();
        boolean hasupper=false, haslower=false, hasdigit=false;
        int spec_characters=0;
        String masked_password;
        for(char ch:password.toCharArray())
        {
            if(Character.isUpperCase(ch))hasupper=true;
            else if(Character.isLowerCase(ch))haslower=true;
            else if(Character.isDigit(ch))hasdigit=true;
            else
                spec_characters++;

        }
        System.out.println("\nPassword check");
        System.out.println("password  contain uppercase letters:"+hasupper);
        System.out.println("password  contain lowercase letters:"+haslower);
        System.out.println("password  contain digit:"+hasdigit);
        System.out.println("password  contain specialcase letters:"+spec_characters);
        if(password.length()<2)
        {
            masked_password=password;
            System.out.println("masked password is :"+masked_password);
        }
        else
        {
            StringBuilder sb=new StringBuilder();
            sb.append(password.charAt(0));
            for(int i=1;i<password.length()-1;i++)
            {
                sb.append('*');
            }
            sb.append(password.charAt(password.length()-1));
            masked_password=sb.toString();
            System.out.println("masked password is :"+masked_password);
        }
        StringBuilder sb1=new StringBuilder(password);
        String reversed_password=sb1.reverse().toString();
        System.out.println("reversed password is :"+reversed_password);
        int randN=(int)(Math.random()*1001);
        String token=String.valueOf("@"+randN+"!");
        String secured_password=password+token;
        System.out.println("secured password is :"+secured_password);

        StringBuilder sb2 = new StringBuilder(password);
        for (int i = 0; i < sb2.length(); i++) {
            char ch2 = Character.toLowerCase(sb2.charAt(i));
            if (ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u') {
                sb2.setCharAt(i, '#');
            }
        }
        System.out.println("password(vowel) is :"+sb2);

    }
}