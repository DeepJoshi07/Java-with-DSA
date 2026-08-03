
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class HashMap_Imp {
    public static void main(String[] args) {
        System.out.println("----------------- implimantation ------------------------");
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("india",100);
        hm.put("chaina",150);
        hm.put("us",40);
        System.out.println(hm);

        System.out.println(hm.get("india"));
        System.out.println(hm.get("indinasia"));
        System.out.println("-------------------");
        
        System.out.println(hm.containsKey("india"));
        System.out.println(hm.containsKey("indonasia"));
        System.out.println("-------------------");
        
        System.out.println(hm.remove("india"));
        System.out.println(hm.remove("indnasia"));
        System.out.println("-------------------");

        System.out.println(hm.size());
        System.out.println("-------------------");

        System.out.println(hm.isEmpty());
        System.out.println("-------------------");

        hm.clear();
        System.out.println(hm.isEmpty());

        System.out.println("-----------------------");

        HashMap<String,Integer> hm2 = new HashMap<>();
        hm2.put("india",100);
        hm2.put("chaina",150);
        hm2.put("Us", 40);

        Set<String> s1 = hm2.keySet();
        Set<Entry<String,Integer>> s2 = hm2.entrySet();

        System.out.println("-------- keys ----------");
        for(String s : s1){
            System.out.println(s);
        }
        System.out.println("-------- entry set ----------");
        for(Entry<String,Integer> s:s2){
            System.out.println(s);
        }
        System.out.println("----------------- Question 1 ------------------------");
        System.out.println("----------------- Question 1 ------------------------");
        System.out.println("----------------- Question 1 ------------------------");
    }
}
