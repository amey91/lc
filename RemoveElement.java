package leetcode;
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if(A.length==0)
            return A.length;
        int i=0;
        int rear=A.length;
        while(i<A.length && i<rear){
            if(A[i]==elem){
                swap(A, i, --rear);
            } else {
                i++;
            }
        }
        return i;
    }
    
    private void swap(int[] A, int index1, int index2){
        int temp=A[index1];
        A[index1]=A[index2];
        A[index2]=temp;
    }
}