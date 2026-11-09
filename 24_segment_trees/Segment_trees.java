public class Segment_trees{
    static int tree[];

    public static void init(int n){
        tree = new int[n*4];
    }

    public static int buildST(int arr[],int i,int start,int end){
        if(start == end){
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = start + (end-start)/2;
        int left = buildST(arr, 2*i+1, start, mid);
        int right = buildST(arr, 2*i+2, mid+1, end);

        tree[i] = left + right;
        // or
        // tree[i] = tree[2*i+1] + tree[2*i+2];
        return tree[i];
    }

    public static int getSum(int arr[],int qi, int qj){
        int n = arr.length;
        return getSumUtil(0,qi,qj,0,n-1);
    }

    public static int getSumUtil(int i,int qi,int qj,int si,int sj){
        if(qj <= si || qi >= sj){
            return 0;
        }else if (si >= qi && sj <= qj){
            return tree[i];
        }else{
            int mid = si + (sj-si)/2;
            int left = getSumUtil(2*i+1, qi, qj, si, mid);
            int right = getSumUtil(2*i+2, qi, qj, mid+1, sj);
            return left + right;
        }
    }

    public static void updateST(int arr[],int idx,int val){
        int diff = arr[idx] - val;
        arr[idx] = val;
        int n = arr.length;
        updateSTUtill(arr,0, idx, diff,0,n-1);
    }

    public static void updateSTUtill(int arr[],int i,int idx,int diff,int si,int sj){
        if(si > idx || sj < idx){
            return;
        }
        
        tree[i] -= diff;

        if(si != sj){
            int mid = si + (sj-si)/2;
            updateSTUtill(arr, 2*i+1, idx, diff, si, mid);
            updateSTUtill(arr, 2*i+2, idx, diff, mid+1, sj);
        }
    }
    public static void main(String[] args) {
        System.out.println("---------------- Question 1 ----------------");
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);
        for(int i = 0;i < tree.length;i++){
            System.out.print(tree[i]+" ");
        }
        System.out.println();
        System.out.println("---------------- Question 2 ----------------");
        System.out.println(getSum(arr, 2, 5));
        System.out.println("---------------- Question 3 ----------------");
        updateST(arr,2,2);
        System.out.println(getSum(arr,2,5));
        System.out.println("---------------- Question 4 ----------------");
    }
}