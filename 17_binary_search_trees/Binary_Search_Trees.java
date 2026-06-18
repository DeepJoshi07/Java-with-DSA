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
        }

        pathRootToLeaf(root.left, path);
        pathRootToLeaf(root.right, path);
        path.remove(path.size()-1);
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
        System.out.println("------------------------ Question 6 ----------------------");
        System.out.println("------------------------ Question 7 ----------------------");
    }
}
