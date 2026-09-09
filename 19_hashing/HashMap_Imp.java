
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class HashMap_Imp {
    public static void majorityElement(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        for (Integer key : hm.keySet()) {
            if (hm.get(key) > arr.length / 3) {
                System.out.println(key);
            }
        }
    }

    public static boolean isAnangram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);

            if (hm.get(ch) != null) {
                if (hm.get(ch) == 1) {
                    hm.remove(ch);
                } else {
                    hm.put(ch, hm.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return hm.isEmpty();
    }

    public static void itenaryForTickets(HashMap<String, String> tickets) {
        HashMap<String, String> hm = new HashMap<>();

        for (String key : tickets.keySet()) {
            hm.put(tickets.get(key), key);
        }

        String start = "";
        for (String key : tickets.keySet()) {
            if (!hm.containsKey(key)) {
                start = key;
            }
        }

        if (start != "") {
            System.out.print(start + " --> ");
            for (String key : tickets.keySet()) {
                System.out.print(tickets.get(start) + " --> ");
                start = tickets.get(start);
            }
            System.out.println();
        }
    }

     public static void largestSubarryWithSum0(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int len = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (hm.containsKey(sum)) {
                len = Math.max(len, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }

        System.out.println("largest length is : " + len);
    }

    public static void main(String[] args) {
        System.out.println("----------------- implimantation ------------------------");
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("india", 100);
        hm.put("chaina", 150);
        hm.put("us", 40);
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

        HashMap<String, Integer> hm2 = new HashMap<>();
        hm2.put("india", 100);
        hm2.put("chaina", 150);
        hm2.put("Us", 40);

        Set<String> s1 = hm2.keySet();
        Set<Entry<String, Integer>> s2 = hm2.entrySet();

        System.out.println("-------- keys ----------");
        for (String s : s1) {
            System.out.println(s);
        }
        System.out.println("-------- entry set ----------");
        for (Entry<String, Integer> s : s2) {
            System.out.println(s);
        }

        System.out.println("------------------ LinkedHashMap ----------------------");

        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("india", 150);
        lhm.put("chaina", 160);
        lhm.put("us", 44);
        System.out.println(lhm);

        System.out.println("------------------ TreeHashMap ----------------------");
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("india", 150);
        tm.put("chaina", 160);
        tm.put("indonasia", 34);
        tm.put("us", 44);
        System.out.println(tm);

        System.out.println("----------------- Question 1 ------------------------");
        int nums[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        majorityElement(nums);
        System.out.println("----------------- Question 2 ------------------------");
        String str1 = "race";
        String str2 = "care";
        System.out.println(isAnangram(str1, str2));
        System.out.println("----------------- Question 3 ------------------------");
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("channai", "bengluru");
        tickets.put("mumbai", "delhi");
        tickets.put("goa", "channai");
        tickets.put("delhi", "goa");
        itenaryForTickets(tickets);
        System.out.println("----------------- Question 4 ------------------------");
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        largestSubarryWithSum0(arr);
        System.out.println("----------------- Question 5 ------------------------");
        System.out.println("----------------- Question 6 ------------------------");
        System.out.println("----------------- Question 7 ------------------------");
        System.out.println("----------------- Question 8 ------------------------");
    }
}
