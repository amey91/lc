public class LongestPalindromicString {
	
   		static class Pair {
		int left;
		int right;
		private Pair(String s, int left, int right){
			this.left = left;
			this.right = right;
			correctIndex(s);
		}
		private void correctIndex(String s) {
			if(left<0 || right>(s.length()-1)){
				System.out.println("this code is shit");
				left++;
				right--;
			}
		}
		
	    private int length() {
			return right-left+1;
		}
		public boolean greaterThan(Pair maxPalindrome) {
			if(maxPalindrome==null)
				return true;
			if((right-left)>(maxPalindrome.right-maxPalindrome.left))
				return true;
			return false;
		}
	}
	
    public String longestPalindrome(String s) {
        if(s.equals("") || s==null)
        	return s;
    	Pair maxPalindrome = new Pair(s, 0, 0);
        int maxLength = s.length(); 
        for(int i=0; i<s.length();i++){
            Pair result = getPalindrome(s,i);
            if(result.length()==maxLength)
                return s;
            if(result.greaterThan(maxPalindrome)){
                maxPalindrome = result;
            }
        }
        return s.substring(maxPalindrome.left, maxPalindrome.right+1);
    }
    
	private static Pair getPalindrome(String s, int pos){
        Pair a = getPalindromeAtPosition(s, pos, pos);
        Pair b= getPalindromeAtPosition(s, pos, pos+1);
        if(Math.abs(a.left-a.right)>Math.abs(b.left-b.right)){
        	return a;
        } else {
        	return b;
        }
    }
    
    private static Pair getPalindromeAtPosition(String s, int left, int right){
        while(left>=0 && right<s.length() && String.valueOf(s.charAt(left)).equals(s.charAt(right)+"")){
            left--;
            right++;
        }
        return new Pair(s,left+1,right-1);
    }
}