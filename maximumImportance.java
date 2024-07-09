
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public long maximumImportanceHeap(int n, int[][] roads) {
        int total = 0;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int[] road : roads){
            int source = road[0];
            int destination = road[1];
            hm.put(source,hm.getOrDefault(source,0) + 1);
            hm.put(destination,hm.getOrDefault(destination,0) + 1);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> b[0] - a[0]);
        for(int key : hm.keySet()){
            int freq = hm.get(key);
            int[] arr = new int[]{freq,key};
            maxHeap.offer(arr);
        }
        while(!maxHeap.isEmpty()){
            int[] arr = maxHeap.poll();
            int key = arr[1];
            hm.put(key,n);
            n--;
        }

        for(int[] road : roads){
            int source = road[0];
            int destination = road[1];
            int currentValue = hm.get(source) + hm.get(destination);
            total += currentValue;
        }

        return total;
    }

    public long maximumImportanceSorting(int n, int[][] roads) {
        long totalImportance = 0;
        Map<Integer, Integer> cityFrequency = new HashMap<>();
        
        // Step 1: Count the frequency of each city in the roads
        for (int[] road : roads) {
            int city1 = road[0];
            int city2 = road[1];
            cityFrequency.put(city1, cityFrequency.getOrDefault(city1, 0) + 1);
            cityFrequency.put(city2, cityFrequency.getOrDefault(city2, 0) + 1);
        }
        
        // Step 2: Store frequencies in an array and sort it by frequency in descending order
        int[][] frequencyArray = new int[cityFrequency.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : cityFrequency.entrySet()) {
            frequencyArray[index][0] = entry.getKey();
            frequencyArray[index][1] = entry.getValue();
            index++;
        }
        Arrays.sort(frequencyArray, (a, b) -> b[1] - a[1]);
        
        // Step 3: Assign importance values starting from n down to 1
        Map<Integer, Integer> cityImportance = new HashMap<>();
        int importanceValue = n;
        for (int[] entry : frequencyArray) {
            int city = entry[0];
            cityImportance.put(city, importanceValue--);
        }
        
        // Step 4: Calculate the total importance of all roads
        for (int[] road : roads) {
            int city1 = road[0];
            int city2 = road[1];
            totalImportance += cityImportance.get(city1) + cityImportance.get(city2);
        }
        
        return totalImportance;
    }
}