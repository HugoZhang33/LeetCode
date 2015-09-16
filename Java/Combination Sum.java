public class Solution {
    public List<List<Integer>> combinationSum(int[] cans, int t) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (cans == null || cans.length == 0)
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
        
        for (int i=index; i<cans.length; i++) {
            if (cans[i] > t) break;
            path.add(cans[i]);
            find(cans, t-cans[i], i, path, res);
            path.remove(path.size()-1);
        }
    }
}