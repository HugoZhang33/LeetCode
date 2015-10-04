public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0 || k >= n) {
            return new ArrayList<List<Integer>>();
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        find(k, n, 0, 1, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void find(int k, int n, int sum, int index, List<Integer> list, List<List<Integer>> res) {
        if (k == 0) {
            if (sum == n) {
                ArrayList<Integer> tmp = new ArrayList<Integer>(list);
                res.add(tmp);
            }
            return;
        }
        
        for (int i=index; i<10; i++) {
            if (sum + i > n) break;
            list.add(i);
            find(k-1, n, sum+i, i+1, list, res);
            list.remove(list.size()-1);
        }
    }
}