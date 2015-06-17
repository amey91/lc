import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            if(answer.size()==0){
                //first entry
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(1);
                answer.add(a);
                continue;
            }
            ArrayList<Integer> toBeInserted = new ArrayList<Integer>();
            ArrayList<Integer> previousList = (ArrayList<Integer>)answer.get(i-1);
            Iterator<Integer> iter = previousList.iterator();
            int prev = 0;
            while(iter.hasNext()){
                int now = iter.next();
                toBeInserted.add(now+prev);
                prev = now;
            }
            toBeInserted.add(prev);
            answer.add(toBeInserted);
        }
        return answer;
    }
}