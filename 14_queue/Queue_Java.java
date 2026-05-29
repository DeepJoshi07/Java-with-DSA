import java.util.*;

public class Queue_Java {
    public static void printArray(String arr[]){
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+' ');
        }
        System.out.println();
    }

    public static void firstNonReapitingCharacter(String s){
        Queue<Character> q = new LinkedList<>();
        int freq [] = new int[26];

        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
       System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("---------------------- Question 1 --------------------------");
        String str1 = "aabccxb";
        firstNonReapitingCharacter(str1);
        System.out.println("---------------------- Question 2 --------------------------");
        System.out.println("---------------------- Question 3 --------------------------");
        System.out.println("---------------------- Question 4 --------------------------");
    }
}
