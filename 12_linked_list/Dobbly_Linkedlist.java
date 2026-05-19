public class Dobbly_Linkedlist {
    public class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

    }

    public Node head;
    public Node tail;
    public int size;

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public void addLast(int data){
        Node newNode = new Node(data);

        if(isEmpty()){
            head = tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void printLinkedlist(){
        if(isEmpty())return;
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Dobbly_Linkedlist ddl = new Dobbly_Linkedlist();
        ddl.addFirst(2);
        ddl.addFirst(1);
        ddl.addLast(3);
        ddl.addLast(4);
        ddl.printLinkedlist();
    }
}
