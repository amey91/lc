package leetcode;
public class SingleNumber{
    public int singleNumber(int[] A) {
        if(A.length==0)
            return 0;
        int k = A[0];
        for(int i=1; i<A.length; i++)
            k = k^A[i];
        return k;
    }
}