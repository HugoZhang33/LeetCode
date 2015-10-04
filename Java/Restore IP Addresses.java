public class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<String>();
        }
        
        List<String> res = new ArrayList<String>();
        find(s, 0, 0, new String(), res);
        return res;
    }
    
    private void find(String s, int index, int level, String tmp, List<String> res) {
        if (s.length()-index > 3*(4-level)) {
            return;
        }
        if (index >= s.length()) {
            if (level == 4) {
                res.add(tmp);   
            }
            return;
        }
        
        String str = tmp;
        for (int i=index; i<3+index&&i<s.length(); i++) {
            String subStr = s.substring(index, i+1);
            if (Integer.parseInt(subStr) > 255) continue;
            str += subStr;
            if (level <= 2) str += ".";
            find(s, i+1, level+1, str, res);
            if (s.charAt(index) == '0') break;
            str = tmp;
        }
    }
}