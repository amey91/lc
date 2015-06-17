public class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        if(arr.length==1)
            return s;
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>0; i--){
            sb.append(arr[i] + " ");
        }
        sb.append(arr[0]); // to avoid the last unncessary "space" before returning
        return sb.toString();
    }
}
