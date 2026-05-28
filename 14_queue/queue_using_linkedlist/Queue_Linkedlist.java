import java.util.NoSuchElementException;

public class Queue_Linkedlist {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
            size++;
            return;
        }
        size++;
        tail.next = newNode;
        tail = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty!");
        }
        int data = head.data;
        size--;
        if (tail == head) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return data;
    }
    
    public int peek(){
        if(isEmpty()){
            throw new NoSuchElementException("queue is empty!");
        }
        return head.data;
    }

    public int size(){
        if(isEmpty()){
            throw new NoSuchElementException("queue is empty!");
        }
        return size;
    }
    public static void main(String[] args) {
        Queue_Linkedlist ql = new Queue_Linkedlist();
        ql.push(1);
        ql.push(2);
        ql.push(3);
        ql.push(4);
        System.out.println(ql.peek());
        System.out.println(ql.size());
        while(!ql.isEmpty()){
            System.out.print(ql.pop()+" ");
        }
        System.out.println();
    }
}
