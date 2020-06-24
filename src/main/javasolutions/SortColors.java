package javasolutions;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] A) {
        if(A.length<=1)
            return;
        int red=-1;
        int blue=A.length;
        int curr=0;
        int whiteCount=0;
        while(curr<blue){
            if(A[curr]==0){
                // red
                A[++red]=0;
                curr++;
            } else if(A[curr]==2){
                //blue
                swap(A, curr, --blue);
            } else {
                //white
                // do nothing for now
                // later replace space between blue and red
                whiteCount++;
                curr++;
            }        
        }
        while(whiteCount-- >0){
            A[++red]=1;
        }
    }
    
    private void swap(int[] A, int index1, int index2){
        int temp=A[index1];
        A[index1]=A[index2];
        A[index2]=temp;
    }

    // update 2020, did the 2 pass solution pretty cleanly here
    public void sortColors2020(int[] nums) {
        int[] count = new int[3];
        for (int num: nums) {
            count[num]++;
        }
        int currIndex = 0;
        for (int i = 0; i< 3; i++) {
            Arrays.fill(nums, currIndex, currIndex + count[i], i);
            currIndex += count[i];
        }
    }
}