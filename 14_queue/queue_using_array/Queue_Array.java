import java.util.NoSuchElementException;

public class Queue_Array {
    static class Queue_Normal_Array{
        int size;
        int rear;
        int arr [] ;
        public Queue_Normal_Array(int size){
            this.size = size;
            this.rear = -1;
            this.arr = new int[size];
        }

        public boolean isEmpty(){
            return rear == -1; 
        }

        public void add(int data){
            if(rear == size-1){
                throw new NoSuchElementException("queue is full!");
            }
            rear++;
            arr[rear] = data;
        }

        public int remove(){
            if(isEmpty()){
                throw new NoSuchElementException("queue is empty!");
            }
            int data = arr[0];
            for(int i = 0;i < rear;i++){
                arr[i] = arr[i+1];
            }
            rear--;
            return data;
        }

        public int peek(){
             if(isEmpty()){
                throw new NoSuchElementException("queue is empty!");
            }
            return arr[0];
        }
    }
    
       public static void main(String[] args) {
        Queue_Normal_Array qna = new Queue_Normal_Array(5);
        qna.add(1);
        qna.add(2);
        qna.add(3);
        qna.add(4);
        qna.add(5);
        while(!qna.isEmpty()){
            System.out.print(qna.remove()+" ");
        }
        System.out.println("------------------------------------");
    }
}
