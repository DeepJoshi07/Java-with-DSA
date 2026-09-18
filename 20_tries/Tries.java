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
        String arr[] = {"i", "like","sam", "samsung","mobile","ice"};
        for(int i = 0 ;i < arr.length;i++){
            insert(arr[i]);
        }
        System.out.println(wordBreak("ilikesamsung"));
        System.out.println("------------------ Question 4 -------------------");
        System.out.println("------------------ Question 5 -------------------");
        
    }
}