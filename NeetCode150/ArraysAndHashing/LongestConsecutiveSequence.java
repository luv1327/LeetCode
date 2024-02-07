package NeetCode150.ArraysAndHashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = generateSet(nums);
        int maxCount = 0;
        for(int num : nums){
            int currentCount = 1;
            if(!hs.contains(num - 1)){
                int nextNum = num + 1;
                while(hs.contains(nextNum)){
                   currentCount +=1;
                   nextNum+=1;
                } 
            }
            if(currentCount > maxCount){
                maxCount = currentCount;
            }
        }
        return maxCount;
    }

    public static HashSet<Integer> generateSet(int[] nums){
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums){
            hs.add(num);
        }
        return hs;
    
}
}
