import java.util.*;

public class Recursion {
    public static void printNumbersNto1(int num) {
        if (num == 0)
            return;
        System.out.println(num);
        printNumbersNto1(num - 1);
    }

    public static void printNumbers1ToN(int number) {
        if (number == 0)
            return;
        printNumbers1ToN(number - 1);
        System.out.println(number);
    }

    public static int sumOfNnaturalNumbers(int num) {
        if (num == 0)
            return 0;
        return num + sumOfNnaturalNumbers(num - 1);
    }

    public static int printNthFibonachi(int n) {
        if (n == 0 || n == 1)
            return n;
        return printNthFibonachi(n - 1) + printNthFibonachi(n - 2);
    }

    public static boolean arrSortedOrNot(int arr[], int size) {
        if (size < 1)
            return true;

        if (arr[size] < arr[size - 1]) {
            return false;
        }

        return arrSortedOrNot(arr, size - 1);
    }

    public static int firstOccurance(int arr[], int i, int target) {
        if (i == arr.length - 1)
            return -1;

        if (arr[i] == target)
            return i;

        return firstOccurance(arr, i + 1, target);
    }

    public static int lastOccurance(int arr[], int i, int target) {
        if (i == 0)
            return -1;
        if (arr[i] == target)
            return i;
        return lastOccurance(arr, i - 1, target);
    }

    public static int power(int num, int pow) {
        if (pow == 0)
            return 1;

        int halfPow = power(num, pow / 2);
        int fullNumber = halfPow * halfPow;
        if (pow % 2 != 0)
            return fullNumber * num;

        return fullNumber;

    }

    public static int setTiles(int width) {
        if (width == 0 || width == 1)
            return 1;

        return setTiles(width - 1) + setTiles(width - 2);
    }

    public static void removeDuplicates(String str, int idx, StringBuilder sb, boolean arr[]) {
        if (idx == str.length()) {
            System.out.println(sb.toString());
            return;
        }
        char curr = str.charAt(idx);
        if (arr[curr - 'a'] == true) {
            removeDuplicates(str, idx + 1, sb, arr);
        } else {
            arr[curr - 'a'] = true;
            removeDuplicates(str, idx + 1, sb.append(curr), arr);
        }
    }

    public static int friendsPairing(int friends) {
        if (friends == 1 || friends == 2)
            return friends;
        return friendsPairing(friends - 1) + (friends - 1) * friendsPairing(friends - 2);
    }

    public static void printBinaryString(int len, int last, StringBuilder sb) {
        if (len == 0) {
            System.out.println(sb.toString());
            return;
        }
        ;
        printBinaryString(len - 1, 0, sb.append(0));
        sb.deleteCharAt(sb.length() - 1);
        if (last == 0) {
            printBinaryString(len - 1, 1, sb.append(1));
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void allOccurance(int arr[], int size, int target) {
        if (size == arr.length)
            return;

        if (arr[size] == target) {
            System.out.println("Index : " + size);
        }
        allOccurance(arr, size + 1, target);
    }

    public static void numberToString(int num, String numString[]) {
        if (num == 0)
            return;

        numberToString(num / 10, numString);
        int index = num % 10;
        System.out.print(numString[index] + " ");
    }

    public static int lenOfString(String str, int len) {
        if (str.length() == len) {
            return len;
        }
        return lenOfString(str, len + 1);
    }

    public static int countiguousSubstrings(String str, int i, int j, int n) {
        if (n == 1)
            return n;

        if (n <= 0)
            return 0;

        int res = countiguousSubstrings(str, i + 1, j, n - 1) +
                countiguousSubstrings(str, i, j - 1, n - 1) -
                countiguousSubstrings(str, i + 1, j - 1, n - 2);

        if (str.charAt(i) == str.charAt(j))
            res++;
        return res;
    }

    public static void towerOfHanoi(int n,char at,char helper,char tobe ){
        if(n == 1){
            System.out.println("move disk "+n+" from poll "+at+" to poll "+ tobe);
            return;
        };
        towerOfHanoi(n-1, at, tobe, helper);
        // this line says move disks to helper using tobe as aid

        System.out.println("move disk "+n+" from poll "+at+" to poll "+ tobe);

        towerOfHanoi(n-1, helper, at, tobe);
        // this line says move disks to tobe using at as aid
    }
    public static void main(String args[]) {
        System.out.println("-------------------------- Question 1 -----------------------");
        printNumbersNto1(10);
        System.out.println("-------------------------- Question 2 -----------------------");
        printNumbers1ToN(10);
        System.out.println("-------------------------- Question 3 -----------------------");
        System.out.println(sumOfNnaturalNumbers(10));
        System.out.println("-------------------------- Question 4 -----------------------");
        System.out.println(printNthFibonachi(11));
        System.out.println("-------------------------- Question 5 -----------------------");
        int arr[] = { 1, 2, 3, 4, 5, 6, 2 };
        System.out.println(arrSortedOrNot(arr, arr.length - 1));
        System.out.println("-------------------------- Question 6 -----------------------");
        System.out.println(firstOccurance(arr, 0, 6));
        System.out.println("-------------------------- Question 7 -----------------------");
        int arr2[] = { 1, 2, 4, 2, 6, 2, 7, 8, 9, 0, 2, 1, 4 };
        System.out.println(lastOccurance(arr2, arr2.length - 1, 2));
        System.out.println("-------------------------- Question 8 -----------------------");
        System.out.println(power(2, 4));
        System.out.println("-------------------------- Question 9 -----------------------");
        System.out.println(setTiles(4));
        System.out.println("-------------------------- Question 10 -----------------------");
        String str = "helloworld";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
        System.out.println("-------------------------- Question 11 -----------------------");
        System.out.println(friendsPairing(3));
        System.out.println("-------------------------- Question 12 -----------------------");
        printBinaryString(3, 0, new StringBuilder(""));
        System.out.println("-------------------------- Question 13 -----------------------");
        int arr3[] = { 1, 2, 4, 5, 2, 3, 7, 8, 9, 0, 2, 1, 3, 4, 5, 4, 3, 2 };
        allOccurance(arr3, 0, 2);
        System.out.println("-------------------------- Question 14 -----------------------");
        String numbers[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        numberToString(2019, numbers);
        System.out.println();
        System.out.println("-------------------------- Question 15 -----------------------");
        System.out.println(lenOfString("helloworld!", 0));
        System.out.println("-------------------------- Question 16 -----------------------");
        String s = "abcab";
        System.out.println(countiguousSubstrings(s, 0, s.length()-1, s.length()));
        System.out.println("-------------------------- Question 16 -----------------------");
        towerOfHanoi(3,'A','B','C');
    }
}