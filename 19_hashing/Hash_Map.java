import java.util.LinkedList;
import java.util.ArrayList;

public class Hash_Map {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
        }
        
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBuckets[] = buckets;
            N = N * 2;
            buckets = new LinkedList[N];

            for(int i = 0;i < N;i++){
                buckets[i] = new LinkedList<>();
            }

            // for(int i = 0;i < oldBuckets.length;i++){
            //     LinkedList<Node> ll = oldBuckets[i]; 
            //     for(int j = 0;j < ll.size();j++){
            //         Node node = ll.remove();
            //         put(node.key,node.value);
            //     }
            // }
            for(LinkedList<Node> ll : oldBuckets){
                for(Node n : ll){
                    put(n.key,n.value);
                }
                ll.clear();
            }

        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            int idx = Math.abs(hc) % N;
            return idx;
        }

        private int searchInLL(K key,int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for(Node n : ll){
                if(n.key.equals(key)){
                    return di;
                }
                di++;
            }
            return  -1;
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);

            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            }else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lamda = (double)n/N;
            if(lamda > 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            
            if(di != -1){
                return true;
            }else{
                return false;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1){
                Node node = buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> al = new ArrayList<>();
            for(LinkedList<Node> ll : buckets){
                for(Node n: ll){
                    al.add(n.key);
                }
            }
            return al;
        }

    }

    public static void main(String[] args) {

    }
}
