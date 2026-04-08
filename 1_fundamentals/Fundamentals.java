import java.util.*;
public class Fundamentals{
    public static int binaryToDecimal(int num){
        int ans = 0;
        int i = 0;
        while(num != 0){
            if(num % 10 != 0){
                ans = ans + (int)Math.pow(2, i); 
            }
            num = num / 10;
            i++;
        }
        return ans;
    }
    public static int decimalToBinary(int num){
        int ans = 0;
        int i = 0;
        while(num != 0){
            if(num % 2 != 0){
                ans += Math.pow(10,i);
            }
            num = num/2;
            i++;
        }
        return ans;
    }
    public static void main(String args[]){
        System.out.println(binaryToDecimal(111000));
        System.out.println(decimalToBinary(56));
    }
}