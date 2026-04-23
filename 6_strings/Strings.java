import java.util.*;

public class Strings {
    // strings are immutable in java.
    // length()
    // concatenation ex: String name = firstNamr + "joshi"
    // .charAt()
    public static void printLetters(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    public static boolean palindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static int shortestPath(String str) {
        int x = 0, y = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'N') {
                y++;
            } else if (str.charAt(i) == 'E') {
                x++;
            } else if (str.charAt(i) == 'S') {
                y--;
            } else if (str.charAt(i) == 'W') {
                x--;
            }
        }
        int x2 = x * x;
        int y2 = y * y;
        return (int) Math.sqrt(x2 + y2);
    }

    public static void subString(String str, int si, int ei) {
        String temp = "";
        for (int i = si; i < ei; i++) {
            temp += str.charAt(i);
        }
        System.out.println(temp);
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String str = new String(" ");
        // String str2 = new String("Deep");
        // String str3 = "Deep";
        // String firstName = sc.next();
        // String lastName = sc.next();

        // String fullName = firstName + " " + lastName;
        // System.out.println(fullName.length());
        // printLetters(fullName);

        System.out.println("----------------------- Question 1 --------------------------");
        String str1 = "racecar";
        // String str1 = "raceacar";
        System.out.println(palindrome(str1));
        System.out.println("----------------------- Question 2 --------------------------");
        String path = "WNEENESENNN";
        // String path = "NS";
        System.out.println(shortestPath(path));
        System.out.println("----------------------- Question 3 --------------------------");
        String str2 = "helloworld";
        subString(str2, 3, 7);
        System.out.println(str2.substring(3, 7));
        System.out.println("----------------------- Question 4 --------------------------");
        System.out.println("----------------------- Question 5 --------------------------");
        System.out.println("----------------------- Question 6 --------------------------");
        System.out.println("----------------------- Question 7 --------------------------");
        System.out.println("----------------------- Question 8 --------------------------");
    }
}
