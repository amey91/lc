public class ZigZagConversion {
    public String convert(final String s, int numRows) {
        if(null == s || numRows == 1 || s.length() <= numRows) {
            return s;
        }
        int n = 2 * numRows -2;
        StringBuilder sb = new StringBuilder();

        // first Indices
        for(int j=0; j< numCubes(s, numRows); j++) {
            safeAppend(s, j*n, sb);
        }

        int start = 1;
        // all the others
        boolean flag = true;
        while(flag) {
            for(int j=0; j<numCubes(s, numRows); j++) {
                int firstIndex = j * n + start;
                int secondIndex = (j+1) * n - start;
                if(firstIndex==secondIndex) {
                    safeAppend(s, firstIndex, sb);
                    flag = false;
                } else if(firstIndex>secondIndex){
                    flag=false;
                    break;
                } else {
                    safeAppend(s, firstIndex, sb);
                    safeAppend(s, secondIndex, sb);
                }
            }
            start ++;
        }

        return sb.toString();
    }

    private int numCubes(String s, int numRows) {
        return (int) Math.ceil(s.length() * 1.0 / (2.0 * numRows - 2));
    }

    private void safeAppend(String s, int index, StringBuilder sb) {
        if(index<s.length()) {
            sb.append(s.charAt(index));
        }
    }
}