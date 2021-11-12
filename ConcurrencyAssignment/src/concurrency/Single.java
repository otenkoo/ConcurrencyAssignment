package concurrency;
import java.util.ArrayList;

public class Single {
	public ArrayList<Integer> arry = new ArrayList<Integer>();
	
	// When called, calculates sum of all elements in ArrayList
	public int singleSumOfArray() {
		
		int sum = arry.stream().reduce((a,b) -> a+b).get();
		
		return sum;
	}
}
