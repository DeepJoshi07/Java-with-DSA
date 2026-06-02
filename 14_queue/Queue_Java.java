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

    public static void queueReversal(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();

        while(!q.isEmpty()){
            s.push(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    public static void printBinaryToN(int number){
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(number-- > 0){
            String s1 = q.peek();
            System.out.println(q.remove());
            String s2 = s1;
            q.add(s1+"0");
            q.add(s2+"1");
        }
    }

    public static void minimumCost(int len[]){

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0;i < len.length;i++){
            pq.add(len[i]);
        }

        int result = 0;
        while(pq.size() > 1){
            int first = pq.remove();
            int second = pq.remove();
            result += first+second;
            pq.add(first+second);
        }
        System.out.println(result);
    }

    static class Job{
        String jobId;
        int time;
        int profit;
        public Job(String jobId,int time,int profit){
            this.time = time;
            this.jobId = jobId;
            this.profit = profit;
        }

    }

    public static void jobSequence(ArrayList<Job> al){
        PriorityQueue<Job> pq = new PriorityQueue<>((a,b) -> b.profit-a.profit);

        pq.addAll(al);

        int maxDeadline = 0;

        for(Job j:pq){
            maxDeadline = Math.max(maxDeadline, j.time);
        }
        String slot[] = new String[maxDeadline+1];

        while(!pq.isEmpty()){
            Job j = pq.remove();
            for(int i = j.time;i > 0 ;i--){
                if(slot[i] == null){
                    slot[i] = j.jobId;
                    break;
                }
            }
        }

        for(int i = 1;i <= maxDeadline;i++){
            if(slot[i] != null)
            System.out.print(slot[i]+" ");
        }
        System.out.println();
    }

    public static void reverseQueueTillNthElement(Queue<Integer>q,int n){
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i < n;i++){
            s.push(q.remove());
        }

        int size = q.size();
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        
        for(int i = 0;i < size;i++){
            q.add(q.remove());
        }
        System.out.println(q);
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
        Queue<Integer> q2 = new LinkedList<>();
        q2.add(1);
        q2.add(2);
        q2.add(3);
        q2.add(4);
        q2.add(5);
        queueReversal(q2);
         while(!q2.isEmpty()){
            System.out.print(q2.remove()+" ");
        }
        System.out.println();
        System.out.println("---------------------- Question 4 --------------------------");
        System.out.println("-------- Deque ---------");
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addLast(3);
        dq.addLast(4);
        dq.addLast(5);
        System.out.println(dq.getFirst());
        System.out.println(dq.getLast());
        System.out.println(dq);
        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());
        System.out.println(dq);
        System.out.println("---------------------- Question 5 --------------------------");
        int num = 10;
        printBinaryToN(num);
        System.out.println("---------------------- Question 6 --------------------------");
        int len [] = {4,3,2,6};
        minimumCost(len);
        System.out.println("---------------------- Question 7 --------------------------");
        ArrayList<Job> al = new ArrayList<>();
        al.add (new Job("a",4,20));
        al.add (new Job("b",1,10));
        al.add (new Job("c",1,40));
        al.add (new Job("d",1,30));
        jobSequence(al);
        System.out.println("---------------------- Question 8 --------------------------");
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
        reverseQueueTillNthElement(q,5);
    }
}
