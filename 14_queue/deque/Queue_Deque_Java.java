import java.util.*;

public class Queue_Deque_Java {
    Deque<Integer> dq = new LinkedList<>();

    public boolean isEmpty(){
        return dq.isEmpty();
    }

    public void add(int data){
        dq.addLast(data);
    }

    public int remove(){
        return dq.removeFirst();
    }

    public int peek(){
        return dq.getFirst();
    }
    public static void main(String[] args) {
        Queue_Deque_Java dqj = new Queue_Deque_Java();
        dqj.add(1);
        dqj.add(2);
        dqj.add(3);
        dqj.add(4);
        dqj.add(5);
        System.out.println(dqj.peek());
        while(!dqj.isEmpty()){
            System.out.println(dqj.remove());
        }
    }
}
