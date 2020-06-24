package javasolutions;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x<0)
			return false;
		if(x<10)
			return true;
		if(x%10==0)
			return false;
		int divisor=1;
		int intLen = String.valueOf(x).length()-1;
		while(intLen-->0)
			divisor *= 10;
		while(x!=0){
			int left = x/divisor;
			int right = x%10;
			if(left!=right)
				return false;
			x = x%divisor;
			x = x/10;
			divisor /= 100;
		}
		char[] c = "".toCharArray();
		return true;
		
	}
}