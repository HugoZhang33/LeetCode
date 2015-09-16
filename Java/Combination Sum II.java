public class Solution {
    public List<List<Integer>> combinationSum2(int[] cans, int t) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (cans == null || cans == null || t <= 0)
            return res;
            
        Arrays.sort(cans);
        find(cans, t, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void find(int[] cans, int t, int index, ArrayList<Integer> path, List<List<Integer>> res) {
        if (t == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        int pre = -1;
        for (int i=index; i<cans.length; i++) {
            if (cans[i] > t) break;
            if (pre != -1 && pre == cans[i]) continue;
            
            path.add(cans[i]);
            find(cans, t-cans[i], i+1, path, res);
            path.remove(path.size()-1);
            
            pre = cans[i];
        }
    }
}