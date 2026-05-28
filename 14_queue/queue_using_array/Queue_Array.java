import java.util.NoSuchElementException;

public class Queue_Array {
    static class Queue_Normal_Array {
        int size;
        int rear;
        int arr[];

        public Queue_Normal_Array(int size) {
            this.size = size;
            this.rear = -1;
            this.arr = new int[size];
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public void add(int data) {
            if (rear == size - 1) {
                throw new NoSuchElementException("queue is full!");
            }
            rear++;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                throw new NoSuchElementException("queue is empty!");
            }
            int data = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return data;
        }

        public int peek() {
            if (isEmpty()) {
                throw new NoSuchElementException("queue is empty!");
            }
            return arr[0];
        }
    }

    static class Queue_Circuler_Array {
        int size;
        int rear;
        int arr[];
        int front;

        public Queue_Circuler_Array(int size) {
            this.size = size;
            this.rear = -1;
            this.arr = new int[size];
            this.front = -1;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public void add(int data) {
            if (isFull()) {
                throw new IndexOutOfBoundsException("queue is full!");
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                throw new NoSuchElementException("queue is empty!");
            }
            int data = arr[front];

            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }

            return data;
        }

        public int peek() {
            if (isEmpty()) {
                throw new NoSuchElementException("queue is empty!");
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue_Normal_Array qna = new Queue_Normal_Array(5);
        qna.add(1);
        qna.add(2);
        qna.add(3);
        qna.add(4);
        qna.add(5);
        while (!qna.isEmpty()) {
            System.out.print(qna.remove() + " ");
        }
        System.out.println();
        System.out.println("------------------------------------");
        Queue_Circuler_Array qca = new Queue_Circuler_Array(5);
        qca.add(1);
        qca.add(2);
        qca.add(3);
        qca.add(4);
        qca.add(5);
        // while (!qca.isEmpty()) {
        //     System.out.print(qca.remove() + " ");
        // }
        // System.out.println();
        System.out.println(qca.remove());
        qca.add(6);
        while (!qca.isEmpty()) {
            System.out.print(qca.remove() + " ");
        }
        System.out.println();
        System.out.println("------------------------------------");
    }
}
