public class Tries{
    static class Node{
        Node [] children;
        boolean endOfWord;

        public Node(){
            this.children = new Node[26];
            // for(int i = 0;i < children.length;i++){
            //     children[i] = null;
            // }
            this.endOfWord = false;
        }
    }
    public static Node root = new Node();

    public static void insert(String str){
        Node curr = root;
        for(int i = 0;i < str.length();i++){
            int idx = str.charAt(i) - 'a';
        
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    public static boolean search(String str){
        Node curr = root;

        for(int i = 0;i < str.length();i++){
            int idx = str.charAt(i) - 'a';

            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.endOfWord;
    }

    public static boolean wordBreak(String str){
        if(str.length() == 0){
            return true;
        }

        for(int i = 1;i <= str.length();i++){
            if(search(str.substring(0,i)) && wordBreak(str.substring(i))){
                return true;
            }
        }
        return false;
    }
    
    static class Node2{
        Node2[] children;
        int freq;

        public Node2(){
            this.children = new Node2[26];
            this.freq = 1;
        }
    }

    public static Node2 root2 = new Node2();

    public static void insert2(String str){
        Node2 curr = root2;

        for(int i = 0;i < str.length();i++){
            int idx = str.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node2();
            }else{
                curr.children[idx].freq += 1;
            }
            curr = curr.children[idx];
        }
    }
    
    public static void findPrefix(Node2 root,String ans){
        if(root == null){
            return;
        }

        if(root.freq == 1){
            System.out.println(ans);
            return;
        }

        for(int i = 0; i < root.children.length;i++){
            if(root.children[i] != null){
                findPrefix(root.children[i], ans+(char)(i + 'a'));
            }
        }
    }

    public static boolean startsWith(String word){
        Node curr = root;

        for(int i = 0;i < word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("------------------ Question 1 -------------------");
        String words[] = {"the","a","there","their","any","thee"};
        // for(int i = 0;i < words.length;i++){
        //     insert(words[i]);
        // }
        System.out.println("------------------ Question 2 -------------------");
        // System.out.println(search("thee"));
        // System.out.println(search("an"));
        System.out.println("------------------ Question 3 -------------------");
        // String arr[] = {"i", "like","sam", "samsung","mobile","ice"};
        // for(int i = 0 ;i < arr.length;i++){
        //     insert(arr[i]);
        // }
        // System.out.println(wordBreak("ilikesamsung"));
        System.out.println("------------------ Question 4 -------------------");
        String arr2[] = {"zebra","duck","dog","dove"};
        // for(int i = 0;i < arr2.length;i++){
        //     insert2(arr2[i]);
        // }
        // root2.freq = -1;
        // findPrefix(root2,"");
        System.out.println("------------------ Question 5 -------------------");
        String arr3[] ={"apple", "app", "mango", "man", "woman"};
        for(int i = 0;i < arr3.length;i++){
            insert(arr3[i]);
        }
        System.out.println(startsWith("man")); // "more"   
        System.out.println("------------------ Question 6 -------------------");
        
        System.out.println("------------------ Question 7 -------------------");
        System.out.println("------------------ Question 8 -------------------");
        System.out.println("------------------ Question 9 -------------------");
        System.out.println("------------------ Question 10 -------------------");
    }
}