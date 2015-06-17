import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        for(int i =0; i<s.length(); i++){
            if(isOpeningBracket(s.charAt(i)))
                charStack.push(s.charAt(i));
            else {
                if(charStack.isEmpty())
                    return false;
                if(!matchingPair(charStack.pop(), s.charAt(i)))
                    return false;
            }
        }
        return charStack.isEmpty();
    }
    
    private boolean matchingPair(char openingBracket, char closingBracket){
        if(!isOpeningBracket(openingBracket) || !isClosingBracket(closingBracket))
            return false;
        switch(openingBracket){
            case '[':
                if(closingBracket==']')
                    return true;
                break;
            case '(':
                if(closingBracket==')')
                    return true;
                break;
            case '{':
                if(closingBracket=='}')
                    return true;
                break;
            default : 
                System.out.println("Please add the add/close braket types \""
                                +openingBracket+" "+closingBracket+"\" to matchingPair()" );
                return false;
        }
        return false;
    }
    
    private boolean isOpeningBracket(char c){
        if(c=='[' || c=='{' || c=='(')
            return true;
        return false;
    }
    
    private boolean isClosingBracket(char c){
        if(c==']' || c=='}' || c==')')
            return true;
        return false;
    }
}