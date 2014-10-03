package leetcode;
public class SingleNumberII {
    public int singleNumber(int[] A) {
        int[] flags = new int[32];
        for(int num: A){
            for(int i=0; i<32; i++){
                if((num & (1<<i)) != 0){
                    flags[i]++;       
                }
            }
        }
        int answer = 0;
        // see which flags occured only once
        for(int i=0; i<flags.length; i++){
            if(flags[i]%3==1)
                answer |= (1<<i);
        }
        return answer;
        
    }
}