package javalang;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(null==strs || strs.length==0) return "";
        if(strs.length==1) {
            return strs[0];
        }

        String first = null;
        String second = strs[0];
        String lcp = second;
        for(int i=1; i<strs.length; i++) {
            first = second;
            second = strs[i];
            lcp = commonPrefix(first, second);
        }

        return lcp;

    }

    private String commonPrefix(String s1, String s2){
        if(null==s1 && null==s2) {
            return "";
        }
        if(s1==null) return s2;
        if(s2==null) return s1;

        if("".equals(s1) || "".equals(s2)) {
            return "";
        }

        int i = 0;
        while(i<s1.length() && i<s2.length()) {
            if(s1.charAt(i)==s2.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        if(i==0) {
            return "";
        }
        return i<s1.length()? s1.substring(0, i) : s2.substring(0,i);

    }
}