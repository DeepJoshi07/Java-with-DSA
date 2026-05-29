import java.util.*;

public class Queue_Java {
    public static void printArray(String arr[]){
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+' ');
        }
        System.out.println();
    }

    public static void firstNonRepeatingCharacter(String s){
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

    public static void interleave(Queue<Integer>q ){
        Queue<Integer> q1 = new LinkedList<>();
        int size = q.size();
        for(int i = 0;i < size/2;i++){
            q1.add(q.remove());
        }

        while(!q1.isEmpty()){
            q.add(q1.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        System.out.println("---------------------- Question 1 --------------------------");
        String str1 = "aabccxb";
        firstNonRepeatingCharacter(str1);
        System.out.println("---------------------- Question 2 --------------------------");
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        q1.add(6);
        q1.add(7);
        q1.add(8);
        q1.add(9);
        q1.add(10);
        interleave(q1);
        while(!q1.isEmpty()){
            System.out.print(q1.remove()+" ");
        }
        System.out.println();
        System.out.println("---------------------- Question 3 --------------------------");
        System.out.println("---------------------- Question 4 --------------------------");
    }
}
