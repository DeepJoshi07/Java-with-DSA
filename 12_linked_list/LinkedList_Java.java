

public class LinkedList_Java {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isEmpty(){
        return head == null;
    }

    public static Node head;
    public static Node tail;
    public int size;
    // O(1)
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head=tail=newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        return;
    }

    // O(1)
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
        return;
    }

    // O(n)
    public void add(int idx,int data){
        if(isEmpty() ||idx == 0 ){
            addFirst(data);
            return;
        }else if(idx == size){
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while(i < idx-1){
            i++;
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return;
    }

    // O(n)
    public void printList(){
        if(isEmpty())return;
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedList_Java ll = new LinkedList_Java();
        // 3,2,1,5,4
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(5);
        ll.addLast(4);
        ll.addFirst(3);
        ll.printList();
        ll.add(2,6);
        ll.printList();
    }
}
