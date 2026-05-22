import java.util.Stack;
public class Stack_Java {
    public static void pushAtbottom(Stack<Integer>s,int n){
        if(s.isEmpty()){
            s.push(n);
            return;
        }
        int data = s.pop();
        pushAtbottom(s, n);
        s.push(data);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
        System.out.println("------------------ Question 1 ---------------------");
        Stack<Integer> s1 = new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        System.out.println(s1);
        pushAtbottom(s1,4);
        System.out.println(s1);
        System.out.println("------------------ Question 1 ---------------------");
        System.out.println("------------------ Question 1 ---------------------");
        System.out.println("------------------ Question 1 ---------------------");
        System.out.println("------------------ Question 1 ---------------------");
        System.out.println("------------------ Question 1 ---------------------");
        System.out.println("------------------ Question 1 ---------------------");
    }
}
