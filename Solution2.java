package leetcode;

import java.util.List;
import java.util.ArrayList;

import leetcode.commons.Amey;

public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        int pos=0;
        for(int i=0;i<triangle.size();i++){
            int num1 = getNumber(triangle.get(i),pos);
            Integer num2 = getNumber(triangle.get(i),pos+1);
            if(num2==null){
                sum += num1;
//                pos =  pos; // no change  
            }
            else{
                sum += Math.min(num1, num2);
                pos = num1<num2? pos : (pos+1);
            }
        }
        return sum;
    }
    
    private Integer getNumber(List<Integer> list, int position){
        if(position > (list.size()-1) || position<0)
            return null;
        return list.get(position);
    }
    
    public static void main(String args[]){
    	ArrayList<Integer> a1 = new ArrayList<Integer>();
    	a1.add(-1);
    	ArrayList<Integer> a2 = new ArrayList<Integer>();
    	a2.add(2);
    	a2.add(3);
    	ArrayList<Integer> a3 = new ArrayList<Integer>();
    	a3.add(1);
    	a3.add(-1);
    	a3.add(3);
    			
    	List<List<Integer>> a = new ArrayList<>();
    	a.add(a1);
    	a.add(a2);
    	a.add(a3);
    	Solution2 s = new Solution2();
    	Amey.log(s.minimumTotal(a));
    	
    	Amey.log("abc AB11		1121 ^&%&1$&1@* :\"sibn".replaceAll("[^A-Za-z]", ""));
    	String t = "asd";
    	t.to
    	
    }
}