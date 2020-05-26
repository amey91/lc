package javalang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Snippet {

	public static void main(String args[]){


		//		# [�pastel�, �staple�, �banana�, �kiwi�, �late�, �tale�] -> [�pastel�, �staple�, �late�, �tale�]

		String[] words =  {"test", "test", "est", "ttes"};// -> ['test', 'test', 'ttes']

		//	anagramMap['pastel'] = sorted('pastel')  ... ['staple', 'tale']

		ArrayList<String> answer = new ArrayList<>();
		HashMap<String, String> anagramMap = new HashMap<>();
		for(String s: words){
			// sort the string
			String s_ = sort(s);
			if(!anagramMap.containsKey(s_))
				anagramMap.put(s_,s);
		}

		for(String s: words){
			if(anagramMap.containsKey(sort(s)))
				answer.add(s);
		}
		//					if(answer.size()==0)
		//						return new String[0];
		String[] ans = new String[answer.size()];
		for(int i=0; i<ans.length; i++){
			System.out.println(answer.get(i));
		}
		//					return ans;

	}
	
	private static String sort(String s){
		char[] c= s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}

