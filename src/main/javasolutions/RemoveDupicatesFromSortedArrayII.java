package javasolutions;

public class RemoveDupicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if(A.length<=2)
            return A.length;
        int count=-1;
        for(int i=0; i<A.length;i++){
            if(i==A.length-1){
                A[++count]=A[i];
                return count+1;
            }
                
            if(A[i]==A[i+1]){
                A[++count]=A[i++];
                A[++count]=A[i];
                while(i<A.length && A[i]==A[count])
                    i++;
                if(i==A.length)
                    return count+1;
                // go back to same value since for will increment i for me
                i--;
            } else {
                A[++count] = A[i];
            }
        }
        
        return count+1;
    }
}