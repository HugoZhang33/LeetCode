public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int[] lens = new int[n+1];
        lens[0] = 1;
        for (int i=1; i<=n; i++) {
            nums.add(i);
            lens[i] = lens[i-1]*i;
        }
        
        k -= 1;
        StringBuilder res = new StringBuilder();
        
        while (n > 1) {
            int len = lens[n-1];
            int num = nums.get(k/len);
            res.append(num);
            nums.remove(k/len);
            n -= 1;
            k = k%len;
        }
        
        res.append(nums.get(0));
        return res.toString();
    }
}
