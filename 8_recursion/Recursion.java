public class Recursion{
    public static void printNumbersNto1(int num){
        if(num == 0)return;
        System.out.println(num);
        printNumbersNto1(num-1);
    }

    public static void printNumbers1ToN(int number){
        if(number == 0)return;
        printNumbers1ToN(number-1);
        System.out.println(number);
    }

    public static int sumOfNnaturalNumbers(int num){
        if(num == 0)return 0;
        return num + sumOfNnaturalNumbers(num-1);
    }

    public static int printNthFibonachi(int n){
        if(n == 0 || n == 1)return n;
        return printNthFibonachi(n-1) + printNthFibonachi(n-2);
    }
    public static void main(String args[]){
        System.out.println("-------------------------- Question 1 -----------------------");
        printNumbersNto1(10);
        System.out.println("-------------------------- Question 2 -----------------------");
        printNumbers1ToN(10);
        System.out.println("-------------------------- Question 3 -----------------------");
        System.out.println(sumOfNnaturalNumbers(10));
        System.out.println("-------------------------- Question 4 -----------------------");
        System.out.println(printNthFibonachi(11));
        System.out.println("-------------------------- Question 5 -----------------------");
        System.out.println("-------------------------- Question 6 -----------------------");
        System.out.println("-------------------------- Question 7 -----------------------");
        System.out.println("-------------------------- Question 8 -----------------------");
        System.out.println("-------------------------- Question 9 -----------------------");
        System.out.println("-------------------------- Question 109 -----------------------");
    }
}