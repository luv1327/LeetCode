class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int size = n + m;
        int p1 = 0;
        int p2 = 0;
        int idx2 = size / 2;
        int idx1 = idx2 - 1;
        int idx = 0;
        int num1 = -1;
        int num2 = -1;
        while(p1 < n && p2 < m){
            if(nums1[p1] < nums2[p2]){
                if(idx == idx1){
                    num1 = nums1[p1];
                };
                if(idx == idx2) {
                    num2 = nums1[p1];
                };
                p1++;
            }else{
                if(idx == idx1){
                    num1 = nums2[p2];
                };
                if(idx == idx2) {
                    num2 = nums2[p2];
                };
                p2++;
            }
            idx++;
        }

        while(p1 < n){
            if(idx == idx1){
                num1 = nums1[p1];
            };
            if(idx == idx2) {
                num2 = nums1[p1];
            };
            p1++;
            idx++;
        }

        while(p2 < m){
            if(idx == idx1){
                num1 = nums2[p2];
            };
            if(idx == idx2) {
                num2 = nums2[p2];
            };
            p2++;
            idx++;
        }

        if(size % 2 == 0){
            return (double) (num1 + num2) / 2;
        }
        return num2;
    }
}