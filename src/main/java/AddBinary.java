public class AddBinary {
    public String addBinary(String a, String b) {
        int[] x = new int[a.length()];
        int[] y = new int[b.length()];
        
        for(int i=0; i<x.length; i++)
            x[i] = Integer.parseInt(a.charAt(i)+"");
        for(int i=0; i<y.length; i++)
            y[i] = Integer.parseInt(b.charAt(i)+"");
        
        int xPointer = x.length-1;
        int yPointer = y.length-1;
        
        int carry=0;
        StringBuilder ans = new StringBuilder();
        while(xPointer>=0 || yPointer>=0){
            int currSum=carry;
            
            if(xPointer>=0){
                currSum += x[xPointer--];
            }
            
            if(yPointer>=0){
                currSum += y[yPointer--];
            }
            
            if(currSum==3){
                carry = 1;
                currSum=1;
            } else if(currSum==2) {
                carry = 1;
                currSum = 0;
            } else {
                carry = 0;
            }
            ans.insert(0, String.valueOf(currSum));
        }
        
        if(carry>0){
            ans = ans.insert(0,String.valueOf(carry));
        }
        return ans.toString();
    }
}