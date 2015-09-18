import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = Arrays.toString(c);
            if(map.containsKey(key)) {
                List<String> innerList = list.get(map.get(key));
                for(int i=0; i<innerList.size(); i++) {
                    if(s.compareTo(innerList.get(i))<=0) {
                        innerList.add(i, s);
                        break;
                    }
                    if(i==innerList.size()-1) {
                        innerList.add(innerList.size(), s);
                        break;
                    }
                }
            } else {
                map.put(key, index++);
                list.add(new ArrayList<String>(){{add(s);}});
            }
        }
        return list;
    }
}