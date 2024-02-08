package NeetCode150.Stack;
import java.util.*;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        List<Integer> stack = new ArrayList<>();
        int[] ans = new int[n];
        ans[n-1] = 0;
        stack.add(n-1);
        for(int i = n - 2;i >=0 ;i--){
            while(stack.size() > 0 && temperatures[stack.get(stack.size()-1)] <= temperatures[i]){
                stack.remove(stack.size()-1);
            }

            if(stack.size() == 0){
                ans[i] = 0;
            }else{
                int j = stack.get(stack.size()-1);
                ans[i] = j - i;
            }
            stack.add(i);
        } 
        return ans;
    }
}