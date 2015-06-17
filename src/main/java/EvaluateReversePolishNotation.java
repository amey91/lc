public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens){
        int result = 0;
        java.util.Stack<Integer> s = new java.util.Stack<Integer>();
        for(int i=0; i<tokens.length; i++){
            if(isOperator(tokens[i])){
                // pop 2 and perform op
                int a = s.pop();
                int b = s.pop();
                result = performOp(tokens[i],b,a);    
                s.push(result);
            } else{
                //push onto stack
                s.push(Integer.parseInt(tokens[i]));                
            }
        }
        return s.pop();
    }
    
    private static int performOp (String op, int a, int b){
        op=op.trim();
        switch(op){
            case "+":
                return a + b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
        }
		return 0;
        
    }
    
    private static boolean isOperator(String a){
        a=a.trim();
        if(a.matches("[+-/*]"))   
            return true;
        return false;
    }
}