package javalang;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int a = m-1;
        int b = n-1;
        while(a>=0 && b>=0){
            A[a+b+1] = A[a]<B[b]?B[b--]:A[a--]; 
        }
        while(b>=0)
            A[b] = B[b--];
    }
}