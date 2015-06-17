public class Pow {
    public double pow(double x, int n) {
        if(n==0)
            return 1;
        if(n<0)
            return 1/myPowerFunc(x, -n);
        else 
            return myPowerFunc(x, n);
    }
    
    private double myPowerFunc(double x, int n){
        if(n==0)
            return 1;
        if(n==1)
            return x;
            
        double halfPower = pow(x, n/2);
        
        return halfPower * halfPower * pow(x, n%2);
    }

}