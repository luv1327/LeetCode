package NeetCode150.ArraysAndHashing;
import java.util.*;;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        // Using List<List<Integer>> for type safety
        List<List<Integer>> frequencyArr = generateList(nums.length + 1);
        HashMap<Integer, Integer> hm = generateHm(nums);

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            frequencyArr.get(value).add(key);
        }

        int[] ans = new int[k];
        int j = 0;

        for (int i = nums.length; i > 0 && j < k; i--) {
            List<Integer> currentFreq = frequencyArr.get(i);
            for (int num : currentFreq) {
                ans[j++] = num;
                if (j == k) {  // Corrected the condition here
                    return ans;
                }
            }
        }
        return ans;
    }

    public static HashMap<Integer, Integer> generateHm(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        return hm;
    }

    public static List<List<Integer>> generateList(int n) {
        List<List<Integer>> frequencyArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            frequencyArr.add(new ArrayList<>());
        }
        return frequencyArr;
    }
}
