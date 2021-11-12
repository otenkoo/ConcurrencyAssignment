package concurrency;
import java.util.ArrayList;

public class Plel extends Thread {

	public ArrayList<Integer> arr = new ArrayList<Integer>();
	public int result;

	// When called, calculates sum of all elements in ArrayList
	@Override
	public void run() {

		Single sum = new Single();
 		sum.arry = this.arr;

		result = sum.singleSumOfArray();

		System.out.println("Thread " + Thread.currentThread().getId() + "'s sum is: " + result);

	}

}
