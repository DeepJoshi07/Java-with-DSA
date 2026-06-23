import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heaps_Imp {
    ArrayList<Integer> al = new ArrayList<>();

    public void insert(int data) {
        al.add(data);

        int x = al.size() - 1;
        int parent = (x - 1) / 2;

        while (al.get(x) < al.get(parent)) {
            int temp = al.get(x);
            al.set(x, al.get(parent));
            al.set(parent, temp);

            x = parent;
            parent = (x - 1) / 2;
        }
    }

     public int peek(){
        if(al.isEmpty()){
            throw new NoSuchElementException("Heap is empty!");
        }
        return al.get(0);
    }

    private void heapify(int i){
        int left = i*2 + 1;
        int right = i*2 + 2;
        int minIdx = i;

        if(left < al.size() && al.get(minIdx) > al.get(left)) minIdx = left;
        if(right < al.size() && al.get(minIdx) > al.get(right)) minIdx = right;

        if(minIdx != i){
            int temp = al.get(i);
            al.set(i,al.get(minIdx));
            al.set(minIdx,temp);

            heapify(minIdx);
        }
    }

    public int remove(){

        int temp = al.get(0);
        int val = al.remove(al.size()-1);
        
        if(al.size() > 0){
            al.set(0,val);
            heapify(0);
        }
        return temp;
    }

    public boolean isEmpty(){
        return al.size() == 0;
    }
    public static void main(String[] args) {
        Heaps_Imp hpm = new Heaps_Imp();
        hpm.insert(6);
        hpm.insert(1);
        hpm.insert(8);
        hpm.insert(2);
        hpm.insert(9);

        while(!hpm.isEmpty()){
            System.out.println(hpm.remove());
        }
    }
}
