public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0 || k > n) return res;
        
        find(n, k, 1, res, new ArrayList<Integer>());
        return res;
    }
    
    private void find(int n, int k, int index, List<List<Integer>> res, List<Integer> list) {
        if (k == 0) {
            List<Integer> tmp = new ArrayList<Integer>(list);
            res.add(tmp);
            return;
        }
        
        for (int i=index; i<=n; i++) {
            list.add(i);
            find(n, k-1, i+1, res, list);
            list.remove(list.size()-1);
        }
    }
}