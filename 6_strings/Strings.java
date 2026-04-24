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

    public static String largestString(String str[]){
        String s = str[0];
        for(int i = 0;i < str.length;i++){
            if(s.compareToIgnoreCase(str[i]) < 0){
                s = str[i];
            }
        }
        return s;
    }
    
    public static String toUpperCaseString(String str){
        char ch = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(ch));

        for(int i = 1;i < str.length();i++){
            char cha = str.charAt(i);
            if(cha == ' ' && i < str.length()-1){
                sb.append(cha);
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(cha);
            }
        }
        return sb.toString();
    }
   
    public static void compressString(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < str.length();i++){
            char ch = str.charAt(i);
            int count = 1;
            while(i < str.length()-1 && ch == str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(ch);
            if(count > 1){
                sb.append(count);
            }
        }
        System.out.println("the compressed string is : "+sb.toString());
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
        String fruits[] = {"apple","banana","mengo","orange","kivi"};
        System.out.println(largestString(fruits));
        System.out.println("----------------------- Question 5 --------------------------");
        String str3 = "hello my NAME is Deep.";
        System.out.println(toUpperCaseString(str3));
        System.out.println("----------------------- Question 6 --------------------------");
        // String str4 = "aaabbbcccddd";
        String str4 = "abcd";
        compressString(str4);
        System.out.println("----------------------- Question 7 --------------------------");
        System.out.println("----------------------- Question 8 --------------------------");
    }
}
