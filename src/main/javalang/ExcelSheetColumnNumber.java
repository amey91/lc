package javalang;

public class ExcelSheetColumnNumber {
      public int titleToNumber(String s) {
                if(s==null || s.length()==0)
                              return 0;
                        int pow=1;
                                int sum=0;
                                        for(int i=s.length()-1;i>=0;i--){
                                                      sum += getValOfChar(s.charAt(i)) * pow;
                                                                  pow *= 26;
                                                                          }
                                                return sum;
                                                    }
          
          private int getValOfChar(char ch) {
                    return (int) ch - 64;
                        }
}
