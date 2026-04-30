public class Recursion{
    public static void printNumbersNto1(int num){
        if(num == 0)return;
        System.out.println(num);
        printNumbersNto1(num-1);
    }
    public static void main(String args[]){
        System.out.println("-------------------------- Question 1 -----------------------");
        printNumbersNto1(10);
        System.out.println("-------------------------- Question 2 -----------------------");
        System.out.println("-------------------------- Question 3 -----------------------");
        System.out.println("-------------------------- Question 4 -----------------------");
        System.out.println("-------------------------- Question 5 -----------------------");
        System.out.println("-------------------------- Question 6 -----------------------");
        System.out.println("-------------------------- Question 7 -----------------------");
        System.out.println("-------------------------- Question 8 -----------------------");
        System.out.println("-------------------------- Question 9 -----------------------");
        System.out.println("-------------------------- Question 109 -----------------------");
    }
}