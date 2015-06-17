import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
    	// same as getting the size of the triangle, as 
        // triangle has n elements at the nth level
        int[] sol = new int[triangle.get(triangle.size()-1).size()];
        for(int i=0;i<triangle.get(triangle.size()-1).size();i++){
            sol[i] = triangle.get(triangle.size()-1).get(i);
        }
        //iterate from the end to the top
        for(int i=triangle.size()-2; i>=0; i--){
            for(int j=0; j<triangle.get(i).size(); j++){
                sol[j] = triangle.get(i).get(j) 
                        + Math.min(sol[j], sol[j+1]);
            }
        }
        return sol[0];
    }
}