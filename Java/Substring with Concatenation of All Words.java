public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || 
        words == null || words.length == 0) {
            return new ArrayList<Integer>();
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i])+1);
            } else {
                map.put(words[i], 1);
            }
        }
        int len = words[0].length();
        int count = words.length;
        char[] chs = s.toCharArray();
        
        for (int i=0; i+len*count<=s.length(); i++) {
            int p = len + i;
            int subLen = 0;
            HashMap<String, Integer> m = new HashMap<String, Integer>();
            while (subLen < len*count) {
                String subStr = new String(chs, p-len, len);
                if (map.containsKey(subStr)) {
                    int num = map.get(subStr);
                    if (m.containsKey(subStr)) {
                        int mNum = m.get(subStr);
                        if (mNum+1 <= num) {
                            m.put(subStr, mNum+1);
                            p += len;
                            subLen += len;    
                        } else {
                            break;
                        }
                    } else {
                        m.put(subStr, 1);
                        p += len;
                        subLen += len;
                    }
                } else {
                    break;
                }
            }
            if (subLen == len*count) {
                result.add(i);
            }
        }
        
        return result;
    }
}