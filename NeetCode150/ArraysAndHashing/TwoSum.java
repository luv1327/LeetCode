package NeetCode150.ArraysAndHashing;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        return twoSumJava(nums,target);
    }
    public static int[] twoSumJava(int[] nums,int target){
      int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i < n;i++){
            int k = target - nums[i];
            if(hm.containsKey(k)){
                return new int[]{hm.get(k),i};
            }else{
                hm.put(nums[i],i);
            }
        }
        return new int[]{1,2};
    }

    
}
