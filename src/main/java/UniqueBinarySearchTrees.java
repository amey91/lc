public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n<=0)
            return 0;
        if(n<=2)
            return n;
        int[] solutions = new int[n+1];
        solutions[0]=1;
        for(int i=1; i<=n; i++)
            for(int j=0; j<i; j++)
                solutions[i] += solutions[j]*solutions[i-j-1];
        return solutions[n];
    }
}