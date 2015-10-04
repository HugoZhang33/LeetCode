public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<String>();
        }
        
        List<String> res = new ArrayList<String>();
        int start = nums[0];
        int pos   = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i]-nums[i-1] == 1) continue;
            String tmp = start+"";
            if (i-1 != pos) tmp += "->"+nums[i-1];
            res.add(tmp);
            start = nums[i];
            pos   = i;
        }
        String tmp = start+"";
        if (pos != nums.length-1) tmp += "->"+nums[nums.length-1];
        res.add(tmp);
        return res;
    }
}