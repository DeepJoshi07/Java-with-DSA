

public class LinkedList_Java {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head=tail=newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        return;
    }
    public static void main(String[] args) {
        LinkedList_Java ll = new LinkedList_Java();
    }
}
