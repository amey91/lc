package leetcode;

public class SqrtX {
    public int sqrt(int x) {
        double diff = 1.0;
        while(Math.abs(diff*diff-x)>10e-3){
            diff = (diff + (x/diff))/2;
        }
        return (int)diff;
    }
    
}