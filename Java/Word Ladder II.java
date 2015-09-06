public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        Queue<String> Q = new LinkedList<String>();
        Q.add(start);
        Set<String> preSet = new HashSet<String>();
        
        findLadders(end, dict, preSet, Q, result);
        
        return result;
    }
    
    private void findLadders(String end, Set<String> dict, Set<String> preSet,
                             Queue<String> Q, List<List<String>> result) {
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        Queue<String> nextQ = new LinkedList<String>();
        
        int size = Q.size();
        for (int i=0; i<size; i++) {
            String start = Q.poll();
            preSet.add(start); // record the word been used
            char[] chs = start.toCharArray();
            for (int j=0; j<start.length(); j++) {
                char ch = chs[j];
                for (char c='a'; c<='z'; c++) {
                    chs[j] = c;
                    String tmp = new String(chs);
                    if (preSet.contains(tmp)) continue; // ignore the word been used in last level
                    if (tmp.equals(end)) {
                        LinkedList<String> list = new LinkedList<String>();
                        list.addFirst(end);
                        list.addFirst(start);
                        result.add(list);
                    }
                    else if (dict.contains(tmp)) {
                        ArrayList<String> strs = null;
                        if (!map.containsKey(tmp)) {
                            nextQ.offer(tmp); // avoid add duplicate word into queue
                            strs = new ArrayList<String>();
                        }
                        else {
                            strs = map.get(tmp);
                        }
                        strs.add(start);
                        map.put(tmp, strs);
                    }
                }
                chs[j] = ch;
            }
        }
        
        if (result.size() > 0 || nextQ.size() == 0) { // when queue's size is 0, meaning no result
            return;
        }
        else {
            findLadders(end, dict, preSet, nextQ, result);
            int m = result.size();
            for (int i=0; i<m; i++) {
                List<String> list = result.get(i);
                List<String> copy = new LinkedList<String>(list);
                
                ArrayList<String> preStrs = map.get(list.get(0)); // preStrs would be used multiple time
                list.add(0,preStrs.get(0));
                
                int mm = preStrs.size();
                for (int j=1; j<mm; j++) {
                    List<String> newList = new LinkedList<String>(copy);
                    String s = preStrs.get(j);
                    newList.add(0, s);
                    result.add(newList);
                }
            }
        }
    }
}