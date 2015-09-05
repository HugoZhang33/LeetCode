public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int max  = 0;
        int sum1 = 0;
        int sum2 = 0;
        
        for (int i=0; i<nums.length; i++) {
            max = Math.max(max, nums[i]);
            sum2 += nums[i];
        }
        sum1 = max*(max+1)/2;
        
        if (sum1 - sum2 > 0) {
            return sum1 - sum2;
        } else if (nums.length > max) {
            return nums.length;
        } else {
            return 0;
        }
    }
}