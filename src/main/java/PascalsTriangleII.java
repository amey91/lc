import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII  {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(1);
        
        if(rowIndex==0)
            return ans;
        
        for(int i = 0; i<rowIndex; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for(int j=0; j<ans.size()-1;j++){
                temp.add(ans.get(j)+ans.get(j+1));                
            }
            temp.add(1);
            ans=temp;
        }
        
        return ans;
    }
}