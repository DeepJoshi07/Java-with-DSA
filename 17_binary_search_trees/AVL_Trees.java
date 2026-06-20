public class AVL_Trees {
    static class Node {
        int data, height;
        Node left, right;

        public Node(int data) {
            this.data = data;
            height = 1;
            this.left = null;
            this.right = null;
        }
    }

    public static Node root;

    public static int height(Node root) {
        if (root == null)
            return 0;
        return root.height;
    }

    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node z = y.left;

        y.left = x;
        x.right = z;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return y;
    }

    public static Node rightRotate(Node x) {
        Node y = x.left;
        Node z = y.right;

        y.right = x;
        x.left = z;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return y;
    }

    public static int getBalanced(Node root) {
        if (root == null)
            return 0;

        return height(root.left) - height(root.right);
    }

    public static Node insert(Node root, int key){
        if(root == null) return new Node(key);

        if(root.data > key){
            root.left = insert(root.left, key);
        }else if(root.data < key){
            root.right = insert(root.right, key);
        }else{
            return root;
        }

        root.height = 1 + Math.max(height(root.left),height(root.right));

        int bf = getBalanced(root);

        if(bf > 1 && root.left.data > key){
            return rightRotate(root);
        }

        if(bf < -1 && root.right.data < key){
            return leftRotate(root);
        }

        if(bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if(bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static void preOrder(Node root){
        if(root == null)return;

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        root = insert(root,10);
        root = insert(root,20);
        root = insert(root,30);
        root = insert(root,40);
        root = insert(root,50);
        root = insert(root,25);

        preOrder(root);
    }
}
