package leetcode;

/* Definition for a point.
 */
class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
	public String toString(){
		return "Point ("+x+","+y +")"; 
	}
}


public class MaxPointsOnLine {
	public int maxPoints(Point[] points) {
		if(points.length<3)
			return points.length;
		int currCount = 0;
		int maxCount = 0;
		for(int i=1; i<points.length;i++){
			currCount=2; // since there are 2 points on this line already
			if(pointsSame(points[i-1],points[i])){
				for(int k=0;k<points.length;k++){
					if(k!=(i-1)&&k!=i&&pointsSame(points[i],points[k]))
						currCount++;
				}
			} else {
				LineEquation line = createLine(points[i-1], points[i]);
				for(int j=0; j<points.length;j++){
					if(j!=(i-1)&&j!=i){
						// j is not the current points that make up the line
						if(liesOnLine(points[j], line))
							currCount++;
					} 
				}
			}
			maxCount = Math.max(currCount, maxCount);    

		}

		return maxCount;
	}

	private static boolean pointsSame(Point p1, Point p2){
		if(p1.x==p2.x && p1.y==p2.y)
			return true;
		return false;
	}

	private static boolean liesOnLine(Point p, LineEquation e){
		if((p.x*e.xCoeff + p.y*e.yCoeff)==e.cons)
			return true;
		return false;
	}

	private static LineEquation createLine(Point p1, Point p2){
		int xCoeff = p2.y-p1.y;
		int yCoeff = p1.x-p2.x;
		int cons = p1.x*xCoeff+p1.y*yCoeff;
		return new LineEquation(xCoeff, yCoeff, cons);
	}

	// line represented by ax + by = c
	private static class LineEquation{
		int xCoeff;
		int yCoeff;
		int cons;
		public LineEquation(){
			xCoeff = 0;
			yCoeff = 0;
			cons = 0;
		}
		public LineEquation(int x, int y, int c){
			xCoeff = x;
			yCoeff = y;
			cons = c;
		}
		public String toString(){
			return "Line "+xCoeff+"x"+" + "+yCoeff+"y = "+cons;
		}
	}
}