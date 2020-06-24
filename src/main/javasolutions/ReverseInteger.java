package javasolutions;

public class ReverseInteger {
    public int reverse(int x) {
        boolean negNumber = false;
        if(x<0){
            negNumber = true;
            x *= -1;
        }
        int answer = 0;
        char[] c = String.valueOf(x).toCharArray();
        for(int i=c.length-1; i>=0; i--){
            int temp = Character.getNumericValue(c[i]);
            answer = answer*10 + temp;
        }
        
        if(negNumber)
            return -1*answer;
        return answer;
    }
}
