import java.util.ArrayList;

public class Binary_Search_Trees {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean searchKey(Node root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (root.data > key) {
            return searchKey(root.left, key);
        } else {
            return searchKey(root.right, key);
        }
    }

    public static Node deleteNode(Node root, int val) {
        if (root.data < val) {
            root.right = deleteNode(root.right, val);
        } else if (root.data > val) {
            root.left = deleteNode(root.left, val);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null) {
                return root.left;
            } else if (root.right != null) {
                return root.right;
            } else {
                Node IS = inorderSuccessor(root.right);
                root.data = IS.data;
                return deleteNode(root, IS.data);
            }
        }
        return root;
    }

    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // public static void printInRange(Node root, int k1, int k2) {
    //     if (root == null)
    //         return;

    //     if (root.data >= k1 && root.data <= k2) {
    //         printInRange(root.left, k1, k2);
    //         System.out.print(root.data + " ");
    //         printInRange(root.right, k1, k2);
    //     } else if (root.data < k1) {
    //         printInRange(root.right, k1, k2);
    //     } else {
    //         printInRange(root.left, k1, k2);
    //     }
    // }

    public static void pathRootToLeaf(Node root, ArrayList<Integer>path){
        if(root == null)return;

        path.add(root.data);

        if(root.left == null && root.right == null){
            System.out.println(path);
            path.remove(path.size()-1);
            return;
        }

        pathRootToLeaf(root.left, path);
        pathRootToLeaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root,Node min,Node max){
        if(root == null)return true;

        if(min != null && root.data <= min.data)return false;//right side even in subtrees

        if(max != null && root.data >= max.data)return false;// left side even in subtrees

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Node mirrorTree(Node root){
        if(root == null)return null;

        Node left = mirrorTree(root.left);
        Node right = mirrorTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static Node createBalancedBST(int arr[],int s,int e){
        if(s > e)return null;

        int mid = (s+e)/2;
        Node root = new Node(arr[mid]);
        root.left = createBalancedBST(arr, s, mid-1);
        root.right = createBalancedBST(arr, mid+1, e);

        return root;
    }

     public static Node createBalancedBST2(ArrayList<Integer> al,int s,int e){
        if(s > e)return null;

        int mid = (s+e)/2;
        Node root = new Node(al.get(mid));
        root.left = createBalancedBST2(al, s, mid-1);
        root.right = createBalancedBST2(al, mid+1, e);

        return root;
    }

    public static void preOrder(Node root){
        if(root == null)return;

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void addValueInArrayListInorder(Node root, ArrayList<Integer>al){
        if(root == null)return;

        addValueInArrayListInorder(root.left, al);
        al.add(root.data);
        addValueInArrayListInorder(root.right, al);
    }

    public static Node balanceBST(Node root){
        ArrayList<Integer> al = new ArrayList<>();

        addValueInArrayListInorder(root, al);

        root = createBalancedBST2(al, 0, al.size()-1);

        return root;

    }

    static class InfoBT{
        int min;
        int max;
        boolean isBST;
        int size;
        
        public InfoBT(boolean isBST,int size,int min,int max){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    public static int maxSizeOfBST = 0;
    public static InfoBT largestBSTinBT(Node root){
        if(root == null) return new InfoBT(true,0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        InfoBT left = largestBSTinBT(root.left);
        InfoBT right = largestBSTinBT(root.right);

        int min = Math.min(root.data,Math.min(left.min,right.min));
        int max = Math.max(root.data,Math.max(left.max,right.max));
        int size = left.size + right.size + 1;

        if(root.data <= left.max || root.data >= right.min){
            return new InfoBT(false, size, min, max);
        }

        if(left.isBST && right.isBST){
            maxSizeOfBST = Math.max(maxSizeOfBST, size);
            return new InfoBT(true,size,min,max);
        }

        return new InfoBT(false, size, min, max);
    }
    public static void main(String[] args) {
        System.out.println("------------------------ Question 1 ----------------------");
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();
        System.out.println("------------------------ Question 2 ----------------------");
        System.out.println(searchKey(root, 7));
        System.out.println(searchKey(root, 6));
        System.out.println("------------------------ Question 3 ----------------------");
        int values2[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root2 = null;
        for (int i = 0; i < values2.length; i++) {
            root2 = insert(root2, i);
        }
        inOrder(root2);
        System.out.println();
        deleteNode(root2, 5);
        inOrder(root2);
        System.out.println();
        System.out.println("------------------------ Question 4 ----------------------");
        // printInRange(root2, 5, 12);
        System.out.println();
        System.out.println("------------------------ Question 5 ----------------------");
        pathRootToLeaf(root, new ArrayList<>());
        inOrder(root);
        System.out.println();
        System.out.println("------------------------ Question 6 ----------------------");
        System.out.println(isValidBST(root2, null,null));
        System.out.println("------------------------ Question 7 ----------------------");
        inOrder(root);
        System.out.println();
        inOrder(mirrorTree(root));
        System.out.println();
        System.out.println("------------------------ Question 8 ----------------------");
        int arr [] = {3,5,6,8,10,11,12};
        inOrder(createBalancedBST(arr,0,arr.length-1));
        System.out.println();
        System.out.println("------------------------ Question 9 ----------------------");
        Node root3 = new Node(8);
        root3.left = new Node(6);
        root3.left.left = new Node(5);
        root3.left.left.left = new Node(3);

        root3.right = new Node(10);
        root3.right.right = new Node(11);
        root3.right.right.right = new Node(12);
        
        preOrder(balanceBST(root3));
        System.out.println();
        System.out.println("------------------------ Question 10 ----------------------");
        Node root4 = new Node(50);
        root4.left = new Node(30);
        root4.left.left = new Node(5);
        root4.left.left = new Node(20);

        root4.right = new Node(60);
        root4.right.left = new Node(45);
        root4.right.right = new Node(70);
        root4.right.right.left = new Node(65);
        root4.right.right.right = new Node(80);

        largestBSTinBT(root4);
        System.out.println(maxSizeOfBST);
        System.out.println("------------------------ Question 11 ----------------------");
    }
}
