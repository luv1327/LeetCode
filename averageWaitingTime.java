class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double totalTime = 0.0;
        double endTimePrevious = 0.0;
        for(int[] customer : customers){
            double startTime =(double) Math.max(customer[0],endTimePrevious);
            double finishTime =(double) startTime + customer[1];
            totalTime += finishTime - customer[0];
            endTimePrevious = finishTime;
        }

        return (double) totalTime / n;
    }
}