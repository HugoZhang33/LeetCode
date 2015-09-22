public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0)
            return new ArrayList<Integer>();
        
        List<String> strs = new ArrayList<String>();
        String s = "";
        for (int i=0; i<input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                s += input.charAt(i);
            } else {
                strs.add(s);
                s = "";
                strs.add(input.charAt(i)+"");
            }
        }
        strs.add(s);
        
        return diffWaysToCompute(strs);
    }
    
    private List<Integer> diffWaysToCompute(List<String> strs) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        return computeAll(strs, 0, map);
    }
    
    private List<Integer> computeAll(List<String> strs, int index, HashMap<Integer, List<Integer>> map) {
        if (map.containsKey(index)) {
            return map.get(index);
        }
        
        if (index == strs.size()-1) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(Integer.parseInt(strs.get(index)));
            map.put(index, list);
            return list;
        }
        
        List<Integer> res = new ArrayList<Integer>();;
        for (int i=index; i<strs.size(); i+=2) {
            if (i+1 >= strs.size()) continue;
            List<String> s = strs.subList(index, i+1);
            List<Integer> l = diffWaysToCompute(s);
            char op = strs.get(i+1).charAt(0);
            List<Integer> list = computeAll(strs, i+2, map);
            for (int a : l) {
                for (int b : list) {
                    switch (op) {
                        case '+':
                            res.add(a+b);
                            break;
                        case '-':
                            res.add(a-b);
                            break;
                        case '*':
                            res.add(a*b);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        
        map.put(index, res);
        return res;
    }
}

// solution 2
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0)
            return new ArrayList<Integer>();
        
        List<String> strs = new ArrayList<String>();
        String s = "";
        for (int i=0; i<input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                s += input.charAt(i);
            } else {
                strs.add(s);
                s = "";
                strs.add(input.charAt(i)+"");
            }
        }
        strs.add(s);
        
        return diffWaysToCompute(strs);
    }
    
    private List<Integer> diffWaysToCompute(List<String> strs) {
        List<Integer> res = new ArrayList<Integer>();
        if (strs.size() == 1) {
            res.add(Integer.parseInt(strs.get(0)));
            return res;
        }
        for (int i=0; i<strs.size(); i+=2) {
            if (i+1 >= strs.size()) continue;
            List<Integer> la = diffWaysToCompute(strs.subList(0, i+1));
            char op = strs.get(i+1).charAt(0);
            List<Integer> lb = diffWaysToCompute(strs.subList(i+2, strs.size()));
            for (int a : la) {
                for (int b : lb) {
                    switch (op) {
                        case '+':
                            res.add(a+b);
                            break;
                        case '-':
                            res.add(a-b);
                            break;
                        case '*':
                            res.add(a*b);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return res;
    }
}

