import java.util.LinkedList;
import java.util.Stack;

public class Stack_Java {
    public static void pushAtbottom(Stack<Integer> s, int n) {
        if (s.isEmpty()) {
            s.push(n);
            return;
        }
        int data = s.pop();
        pushAtbottom(s, n);
        s.push(data);
    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty())
            return;

        int data = s.pop();
        reverseStack(s);
        pushAtbottom(s, data);
    }

    public static void stockSpan(int stock[], int span[]) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        span[0] = 1;
        for (int i = 1; i < stock.length; i++) {
            int curr = stock[i];
            while (!s.isEmpty() && stock[s.peek()] <= curr) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
    }

    public static int[] nextRightGreater(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];
            while (!s.isEmpty() && arr[s.peek()] < curr) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        return nextGreater;
    }

    public static boolean validParentheses(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if ((ch == '}' && s.peek() == '{')
                        || (ch == ')' && s.peek() == '(')
                        || (ch == ']' && s.peek() == '[')) {
                    s.pop();
                } else {
                    return false;
                }
            }

        }
        return s.isEmpty();
    }

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                int count = 0;
                while (!s.isEmpty() && s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count > 0) {
                    s.pop();
                } else {
                    return true;
                }
            } else {
                s.push(ch);
            }
        }
        return !s.isEmpty();
    }

    public static int maxAreaInHistogram(int arr[]) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int nextRightSmaller[] = new int[arr.length];

        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];

            while (!s.isEmpty() && arr[s.peek()] >= curr) {
                s.pop();
            }
            nextRightSmaller[i] = s.isEmpty() ? n : s.peek();

            s.push(i);
        }
        s.clear();
        int nextLeftSmaller[] = new int[arr.length];

        for (int i = 0; i < n; i++) {
            int curr = arr[i];

            while (!s.isEmpty() && arr[s.peek()] >= curr) {
                s.pop();
            }
            nextLeftSmaller[i] = s.isEmpty() ? -1 : s.peek();

            s.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = (nextRightSmaller[i] - nextLeftSmaller[i] - 1);
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean palindromeLinkedlist(LinkedList<Integer>ll){
        int n = ll.size();
        Stack<Integer> s = new Stack<>();
        int start = n%2 == 0? n/2:(n/2 +1);
        for(int i = start;i < n;i++){
            s.push(ll.get(i));
        }
        for(int i = 0;i < n/2;i++){
            if(s.peek() != ll.get(i)){
                return false;
            }
            s.pop();
        }
        return true;
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
        pushAtbottom(s1, 4);
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
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
        System.out.println();
        System.out.println("------------------ Question 5 ---------------------");
        int numbers[] = { 6, 8, 0, 1, 3 };
        int next_Right_Greater[] = nextRightGreater(numbers);
        for (int i = 0; i < next_Right_Greater.length; i++) {
            System.out.print(next_Right_Greater[i] + " ");
        }
        System.out.println();
        System.out.println("------------------ Question 6 ---------------------");
        String str1 = "({{[]}}()";
        System.out.println(validParentheses(str1));
        System.out.println("------------------ Question 7 ---------------------");
        String str2 = "((a+b)+(c+d)())";
        System.out.println(isDuplicate(str2));
        System.out.println("------------------ Question 8 ---------------------");
        int heights[] = { 2, 1, 5, 6, 3, 2 };
        System.out.println(maxAreaInHistogram(heights));
        System.out.println("------------------ Question 9 ---------------------");
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        // ll.addFirst(3);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        System.out.println(palindromeLinkedlist(ll));
        System.out.println("------------------ Question 10 ---------------------");
        System.out.println("------------------ Question 11 ---------------------");
    }
}
