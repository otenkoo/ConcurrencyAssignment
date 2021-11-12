package test;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import concurrency.Plel;
import concurrency.Single;

class Testing {

	@Test
	void TestSingleSum() {
		Single singe = new Single();
		ArrayList<Integer> testList = new ArrayList<Integer>();

		testList.add(2);
		testList.add(2);
		testList.add(3);
		testList.add(3);

		if (testList.size() < 1) {
			fail("List was not populated");
		} else if (testList.size() > 0) {
			singe.arry = testList;
		}

		if (singe.singleSumOfArray() == 10) {
			System.out.println("Pass");
		} else {
			fail("Not correct sum");
		}
	}

	@Test
	void TestMultiSum() {
		Plel test2 = new Plel();
		ArrayList<Integer> testList = new ArrayList<Integer>();

		testList.add(2);
		testList.add(2);
		testList.add(3);
		testList.add(3);

		if (testList.size() < 1) {
			fail("List was not populated");
		} else if (testList.size() > 0) {
			test2.arr = testList;
		}

		test2.start();
		try {
			test2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (test2.result == 10) {
			System.out.println("Pass");
		} else {
			fail("Not correct sum");

		}
	}
}
