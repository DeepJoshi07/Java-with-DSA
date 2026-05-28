import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Queue_With_Stack {
    static class Queue_Using_Stack1{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty(){
            return s1.isEmpty();
        }

        public void add(int data){
            if(s1.isEmpty()){
                s1.push(data);
                return;
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

             while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        public int remove(){
            if(isEmpty()){
                throw new NoSuchElementException("queue is empty!");
            }
            return s1.pop();
        }

        public int peek(){
             if(isEmpty()){
                throw new NoSuchElementException("queue is empty!");
            }
            return s1.peek();
        }
    }
    
     static class Queue_Using_Stack2{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty(){
            return s1.isEmpty() && s2.isEmpty();
        }

        public void add(int data){
            s1.push(data);
        }

        public int remove(){
            if(isEmpty()){
                throw new NoSuchElementException("queue is empty!");
            }

            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public int peek(){
             if(isEmpty()){
                throw new NoSuchElementException("queue is empty!");
            }

            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }
    }

       public static void main(String[] args) {
        Queue_Using_Stack1  qus1 = new Queue_Using_Stack1();
        qus1.add(1);
        qus1.add(2);
        qus1.add(3);
        qus1.add(4);
        qus1.add(5);
        System.out.println(qus1.peek());
        while(!qus1.isEmpty()){
            System.out.print(qus1.remove()+" ");
        }
        System.out.println();
        System.out.println("------------------------");
        Queue_Using_Stack2  qus2 = new Queue_Using_Stack2();
        qus2.add(1);
        qus2.add(2);
        qus2.add(3);
        qus2.add(4);
        qus2.add(5);
        System.out.println(qus2.peek());
        while(!qus2.isEmpty()){
            System.out.print(qus2.remove()+" ");
        }
        System.out.println();
        
    }
}
