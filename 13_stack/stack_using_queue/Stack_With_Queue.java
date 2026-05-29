import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Stack_With_Queue {
    static class Stack_Using_Queue1 {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data) {
            q1.add(data);
        }

        public int pop() {
            if (isEmpty()) {
                throw new NoSuchElementException("stack is empty!");
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty())
                        break;
                    q2.add(top);
                }

            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty())
                        break;
                    q1.add(top);
                }

            }
            return top;
        }

        public int peek() {
            if (isEmpty()) {
                throw new NoSuchElementException("stack is empty!");
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }

            return top;
        }
    }

    static class Stack_Using_Queue2 {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data){
            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }
            q1.add(data);
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
        }

        public int pop(){
            if(isEmpty()){
                throw new NoSuchElementException("stack is empty!");
            }
            return q1.remove();
        }

         public int peek(){
            if(isEmpty()){
                throw new NoSuchElementException("stack is empty!");
            }
            return q1.peek();
        }
    }

    public static void main(String[] args) {
        Stack_Using_Queue1 suq1 = new Stack_Using_Queue1();
        suq1.push(1);
        suq1.push(2);
        suq1.push(3);
        suq1.push(4);
        System.out.println(suq1.peek());
        while (!suq1.isEmpty()) {
            System.out.println(suq1.pop());
        }
        System.out.println("-------------------------");
         Stack_Using_Queue2 suq2 = new Stack_Using_Queue2();
        suq2.push(1);
        suq2.push(2);
        suq2.push(3);
        suq2.push(4);
        System.out.println(suq2.peek());
        while (!suq2.isEmpty()) {
            System.out.println(suq2.pop());
        }
    }
}