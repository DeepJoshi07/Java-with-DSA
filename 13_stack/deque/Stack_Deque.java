import java.util.*;

public class Stack_Deque {
    Deque<Integer> dq = new LinkedList<>();

    public boolean isEmpty(){
        return dq.isEmpty();
    }

    public void push(int data){
        dq.addLast(data);
    }

    public int pop(){
        return dq.removeLast();
    }

    public int peek(){
        return dq.getLast();
    }
    public static void main(String[] args) {
        Stack_Deque sq = new Stack_Deque();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        sq.push(4);
        sq.push(5);
        System.out.println(sq.peek());
        while(!sq.isEmpty()){
            System.out.println(sq.pop());
        }
    }
}
