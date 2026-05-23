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

    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        for(int i = 0;i < str.length();i++){
            s.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void reverseStack(Stack<Integer>s){
        if(s.isEmpty())return;

        int data = s.pop();
        reverseStack(s);
        pushAtbottom(s, data);
    }

    public static void stockSpan(int stock[],int span[]){
        Stack<Integer> s = new Stack<>();
        s.push(0);
        span[0] = 1;
        for(int i = 1;i < stock.length;i++){
            int curr = stock[i];
            while(!s.isEmpty() && stock[s.peek()] <= curr){
                s.pop();
            }

            if(s.isEmpty()){
                span[i] = i + 1;
            }else{
                span[i] = i - s.peek();
            }
            s.push(i);
        }
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
        System.out.println("------------------ Question 2 ---------------------");
        String str = "HelloWorld!";
        System.out.println(reverseString(str));
        System.out.println("------------------ Question 3 ---------------------");
        Stack<Integer> s2 = new Stack<>();
        s2.push(1);
        s2.push(2);
        s2.push(3);
        s2.push(4);
        System.out.println(s2);
        reverseStack(s2);
        System.out.println(s2);
        System.out.println("------------------ Question 4 ---------------------");
        int stocks [] = {100,80,60,70,60,85,100};
        int span [] = new int[stocks.length];  
        stockSpan(stocks,span);
        for(int i = 0;i < span.length;i++){
            System.out.print(span[i]+" ");
        }
        System.out.println();
        System.out.println("------------------ Question 5 ---------------------");
        System.out.println("------------------ Question 6 ---------------------");
        System.out.println("------------------ Question 7 ---------------------");
    }
}
