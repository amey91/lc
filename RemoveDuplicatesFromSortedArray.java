package leetcode;

public class RemoveDuplicatesFromSortedArray {
	 public int removeDuplicates(int[] A) {
	        if(A==null || A.length ==0)
	            return 0;
	        if(A.length==1)
	            return 1;
	        int endIndex = 1;
	        int i = 0;
	        outerloop:
	        while(endIndex<A.length){
	            if(A[i]==A[endIndex]){
	                while(A[i]==A[endIndex]){
	                    endIndex++;
	                    if(endIndex==A.length)
	                        break outerloop;
	                }
	                if(endIndex==A.length)
	                    return i+1;
	                A[++i]=A[endIndex++];
	            } else {
	                A[++i] = A[endIndex++];
	            }
	        }
	        return i+1;
	    }
}
