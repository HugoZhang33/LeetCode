public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            res.add(new ArrayList<String>());
            return res;
        }
        
        for (int i=0; i<s.length(); i++) {
            String preStr = s.substring(0, i+1);
            String posStr = s.substring(i+1);
            if (check(preStr)) {
                List<List<String>> tmp = partition(posStr);
                for (List<String> list : tmp) {
                    list.add(0, preStr);
                    res.add(list);
                }
            }
        }
        
        return res;
    }
    
    private boolean check(String s) {
        int start = 0;
        int end   = s.length()-1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}