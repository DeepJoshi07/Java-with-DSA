import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.ArrayList;

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

    static class HDInfo{
        int hd;
        Node node;
        public HDInfo(int hd,Node node){
            this.hd = hd;
            this.node = node;
        }
    }
    
    public static void topView(Node root){
        Queue<HDInfo> q = new LinkedList<>();
        int min = 0,max = 0;
        HashMap<Integer,Node> hm = new HashMap<>();
        q.add(new HDInfo(0,root));
        q.add(null);

        while(!q.isEmpty()){
            HDInfo curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
            }else{
                if(!hm.containsKey(curr.hd)){
                    hm.put(curr.hd,curr.node);
                }
                if(curr.node.left != null){
                    q.add(new HDInfo(curr.hd - 1,curr.node.left));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new HDInfo(curr.hd+1, curr.node.right));
                    max = Math.max(max,curr.hd+1);
                }
            }

        }
        for(int i = min;i <= max;i++){
            System.out.print(hm.get(i).data+" ");
        }
        System.out.println();
    }

    public static void kthLevelNodes(Node root,int level,int k){
        if(root == null)return;

        if(level == k){
            System.out.print(root.data+" ");
            return;
        }

        kthLevelNodes(root.left, level+1, k);
        kthLevelNodes(root.right, level+1, k);
    }

    private static boolean getPath(Node root,int n,ArrayList<Node>al){
        if(root == null){
            return false;
        }
        al.add(root);
        if(root.data == n){
            return true;
        }
        boolean left = getPath(root.left, n, al);
        boolean right = getPath(root.right, n, al);

        if(left || right){
            return true;
        }
        al.remove(al.size()-1);
        return false;
    }

    public static Node lca(Node root,int n1,int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        boolean found1 = getPath(root,n1,path1);
        boolean found2 = getPath(root,n2,path2);

        if(!found1 || !found2)return null;

        int i = 0;
        for(;i < path1.size() && i < path2.size();i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        return path1.get(i-1);
    }

    private static boolean isExists(Node root, int val){
        if(root == null)return false;

        if(root.data == val)return true;

        // boolean left = isExists(root.left, val);
        // boolean right = isExists(root.right, val);

        // return left || right;

        return isExists(root.left, val) || isExists(root.right, val);
    }
    
    private static Node lca2(Node root,int n1,int n2){
        if(root == null)return root;
        if(root.data == n1 || root.data == n2)return root;

        Node left = lca2(root.left, n1, n2);
        Node right = lca2(root.right, n1, n2);

        if(left != null && right != null)return root;

        return (left == null)? right:left;
        
    }

    public static Node safeLca(Node root,int n1,int n2){
        if(!isExists(root, n1) || !isExists(root, n2)) throw new NoSuchElementException("n1 or n2 does not exists");
        Node val = lca2(root, n1, n2);
        if(val == null){
            throw new NoSuchElementException("n1 or n2 does not exists");
        }
        return val;

    }

    private static int distenceFromLca(Node node,int val){
        if(node == null){
            return -1;
        }
        if(node.data == val){
            return 0;
        }
        int left = distenceFromLca(node.left, val);
        int right = distenceFromLca(node.right, val);

        if(left == -1 && right == -1){
            return -1;
        }
        if(left == -1) return right+1;
        else return left+1;
    }

    public static int distenceBetweenTwoNodes(Node root,int n1,int n2){
        Node lca = safeLca(root, n1, n2);
        int d1 = distenceFromLca(lca,n1);
        int d2 = distenceFromLca(lca,n2);
        return d1+d2;
    }

    public static int kthAnsector(Node root,int val,int k){
        if(root == null)return -1;

        if(root.data == val)return 0;

        int left = kthAnsector(root.left, val, k);
        int right = kthAnsector(root.right, val, k);

        if(left == -1 && right == -1)return -1;

        int max = Math.max(left, right);

        if(max+1 == k){
            System.out.println(root.data);
        }
        return max+1;
    }

    // public static int sumTree(Node root){
    //     if(root == null)return 0; 

    //     int left = sumTree(root.left);
    //     int right = sumTree(root.right);

    //     int data = root.data;
    //     int newLeft = root.left != null? root.left.data:0;
    //     int newRight = root.right != null? root.right.data:0;
    //     root.data = newLeft + newRight + left + right;
    //     return data;

    // }
    
    public static int sumTree(Node root) {
    if (root == null) return 0;

    int left = sumTree(root.left);
    int right = sumTree(root.right);

    int data = root.data;
    root.data = left + right + data;          // update node’s data to sum of children
    return left + right + data;        // return total sum of subtree
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
        topView(root);
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.left.left = new Node(4);
        root2.left.left.left = new Node(10);
        root2.left.left.right = new Node(5);
        root2.left.right = new Node(3);
        root2.left.right.right = new Node(6);
        topView(root2);
        System.out.println("-------------------- Question 13 -------------------");
        kthLevelNodes(root, 1, 3);
        System.out.println();
        System.out.println("-------------------- Question 14 -------------------");
        System.out.println(lca(root,4,5).data);
        System.out.println("-------------------- Question 15 -------------------");
        System.out.println(safeLca(root,4,5).data);
        System.out.println("-------------------- Question 16 -------------------");
        System.out.println(distenceBetweenTwoNodes(root,4,5));
        System.out.println("-------------------- Question 17 -------------------");
        kthAnsector(root,5,2);
        System.out.println("-------------------- Question 18 -------------------");
        System.out.println(sumTree(root));
        preOrder(root);
        System.out.println();
        System.out.println("-------------------- Question 19 -------------------");
        System.out.println("-------------------- Question 20 -------------------");
    }
}
