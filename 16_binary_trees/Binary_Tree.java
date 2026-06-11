import java.util.LinkedList;
import java.util.Queue;

public class Binary_Tree {

    static class Node {
        int data;
        Node right, left;

        public Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static int idx = -1;

    public static Node buildTree(int nodes[]) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }

        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    public static void preOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
    }

    public static int height(Node root) {
        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    public static int countOfNodes(Node root) {
        if (root == null)
            return 0;

        int left = countOfNodes(root.left);
        int right = countOfNodes(root.right);

        return left + right + 1;
    }

    public static int sumOfTree(Node root) {
        if (root == null)
            return 0;

        int left = sumOfTree(root.left);
        int right = sumOfTree(root.right);

        return left + right + root.data;
    }

    public static int diameterOfTree(Node root) {
        if (root == null)
            return 0;

        int leftDiameter = diameterOfTree(root.left);
        int rightDiameter = diameterOfTree(root.right);
        int left = height(root.left);
        int right = height(root.right);

        int selfDiameter = left + right + 1;

        return Math.max(selfDiameter, Math.max(rightDiameter, leftDiameter));
    }

    static class DiameterInfo {
        int height;
        int diameter;

        public DiameterInfo(int height, int diameter) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static DiameterInfo diameterOfTree2(Node root) {
        if (root == null) {
            return new DiameterInfo(0, 0);
        }

        DiameterInfo left = diameterOfTree2(root.left);
        DiameterInfo right = diameterOfTree2(root.right);

        int selfDiameter = Math.max(Math.max(left.diameter, right.diameter), left.height + right.height + 1);
        int height = Math.max(left.height, right.height) + 1;

        return new DiameterInfo(height, selfDiameter);
    }

    private static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null) {
            return false;
        } else if (node.data != subRoot.data) {
            return false;
        }

        return isIdentical(node.left, subRoot.left) && isIdentical(node.right, subRoot.right);

    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null)
            return false;

        if (root.data == subRoot.data) {
            return isIdentical(root, subRoot);
        }

        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);

        return left || right;
    }

    public static void main(String[] args) {
        System.out.println("-------------------- Question 1 -------------------");
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = buildTree(nodes);
        System.out.println(root.data);
        System.out.println("-------------------- Question 2 -------------------");
        preOrder(root);
        System.out.println();
        System.out.println("-------------------- Question 3 -------------------");
        inOrder(root);
        System.out.println();
        System.out.println("-------------------- Question 4 -------------------");
        postOrder(root);
        System.out.println();
        System.out.println("-------------------- Question 5 -------------------");
        levelOrder(root);
        System.out.println("-------------------- Question 6 -------------------");
        System.out.println(height(root));
        System.out.println("-------------------- Question 7 -------------------");
        System.out.println(countOfNodes(root));
        System.out.println("-------------------- Question 8 -------------------");
        System.out.println(sumOfTree(root));
        System.out.println("-------------------- Question 9 -------------------");
        System.out.println("Diameter approch 1 :" + diameterOfTree(root));
        System.out.println("-------------------- Question 10 -------------------");
        System.out.println("Diameter approch 2 :" + diameterOfTree2(root).diameter);
        System.out.println("-------------------- Question 11 -------------------");
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        System.out.println(isSubtree(root, subRoot));
        System.out.println("-------------------- Question 12 -------------------");
        System.out.println("-------------------- Question 13 -------------------");
        System.out.println("-------------------- Question 14 -------------------");
        System.out.println("-------------------- Question 15 -------------------");
    }
}
