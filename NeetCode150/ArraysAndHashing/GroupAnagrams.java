package NeetCode150.ArraysAndHashing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm = new HashMap<>();
        int n = strs.length;
        for(int i = 0; i<n; i++){
           int[] freq = new int[26];
           for(int j = 0;j < strs[i].length(); j++){
               int idx = (int) strs[i].charAt(j) - 'a';
               freq[idx] +=1;
           }
        String key = Arrays.toString(freq); 
        if (!hm.containsKey(key)) {
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(strs[i]);
        }
        return new ArrayList<>(hm.values());
    }
    
    public static void printHashMapValues(HashMap<String, List<String>> map) {
        for (List<String> valueList : map.values()) {
            System.out.println(valueList);
        }
    }
}
