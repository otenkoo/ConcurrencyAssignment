package concurrency;
import java.util.ArrayList;
import java.util.Random;

public class Main {

	// Variable to control the size of rng ArrrayList
	public static int arraySize = 200000000;
	public static long begin;
	public static long finish;
	public static long dura;
	
	public static void main(String[] args) {

		// Empty ArrayList that will contain the 200 mil randomly generate numbers
		ArrayList<Integer> rng = CreateRandomArray();

		// Just to create some visual space on top
		System.out.println("");

		// Just to create some visual space on top
		System.out.println("");
		
		int twoThreadSum = TwoThreads(rng);
		
		System.out.println("");
		System.out.println("Multithreaded Combined SUM is: " + twoThreadSum);

		// Finish timer and display
		System.out.println("Execution time: " + dura + " ns");
		System.out.println("");

		int singleSum = SingleThread(rng);
		
		System.out.println("Single thread SUM is: " + singleSum);

		System.out.println("Execution time: " + dura + " ns");

	}

	public static ArrayList<Integer> CreateRandomArray() {
		// Empty ArrayList that will contain the 200 mil randomly generate numbers
		ArrayList<Integer> rng = new ArrayList<Integer>();

		// loop adding random numbers between 1 and 10 until arraySize limit is reached
		for (int i = 0; i < arraySize; i++) {
			rng.add(rand(1, 11));
		}
		
		return rng;
	}
	
	// Generate Random number between 1 and 10
	public static int rand(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}
	
	public static int SingleThread(ArrayList<Integer> rng) {
		// Create objects in relation to Parallel class and Single thread class
		Single sing = new Single();
		
		sing.arry = rng;
		// Start Timer
		begin = System.nanoTime();
		
		int result = sing.singleSumOfArray();
		
		// Finish timer and display
		finish = System.nanoTime();
		dura = finish - begin;
				
		return result;
	}
	
	public static int TwoThreads(ArrayList<Integer> rng) {
		// Create objects in relation to Parallel class and Single thread class
		Plel t1 = new Plel();
		Plel t2 = new Plel();
		
		// 2 new ArrayLists that create subLists based on the first half and the last
		// half of rng ArrayList respectively
		ArrayList<Integer> fh = new ArrayList<Integer>(rng.subList(0, rng.size() / 2));
		ArrayList<Integer> lh = new ArrayList<Integer>(rng.subList((rng.size() / 2), rng.size()));

		// Defining the ArrayLists created in their respective classes assigned to each
		// object/Thread
		t1.arr = fh;
		t2.arr = lh;
		
		// Start Timer
		begin = System.nanoTime();
		
		// Begin the sum calculation
		t1.start();
		t2.start();

		// Allows program to run in proper order
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		// Get sum of both threads results
		int listSum = t1.result + t2.result;
		
		// Finish timer and display
		finish = System.nanoTime();
		dura = finish - begin;
		
		return listSum;
	}
}
