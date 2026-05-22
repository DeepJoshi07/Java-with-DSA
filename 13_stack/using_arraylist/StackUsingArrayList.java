import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StackUsingArrayList {
    private ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty(){
        return list.size() == 0;
    } 
    // O(1)
    public void push(int data){
        list.add(data);
    }
    // O(1)
    public int pop(){
        if(isEmpty()){
            throw new NoSuchElementException("list is empty!");
        }
       return list.remove(list.size()-1);
    }
    //O(n)
    public int peek(){
        if(isEmpty()){
            throw new NoSuchElementException("list is empty!");
        }
        return list.get(list.size()-1);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        StackUsingArrayList s = new StackUsingArrayList();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        System.out.println();
    }
}
