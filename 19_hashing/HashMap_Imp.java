import java.util.HashMap;

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

        System.out.println("----------------- Question 1 ------------------------");
        System.out.println("----------------- Question 1 ------------------------");
        System.out.println("----------------- Question 1 ------------------------");
    }
}
