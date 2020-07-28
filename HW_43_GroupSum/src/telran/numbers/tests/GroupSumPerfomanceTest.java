package telran.numbers.tests;

import telran.numbers.model.GroupSum;

public class GroupSumPerfomanceTest {
	String name;
	GroupSum groupSum;

	public GroupSumPerfomanceTest(String name, GroupSum groupSum) {
		this.name = name;
		this.groupSum = groupSum;
	}

	public void runTest() {
		long start = System.currentTimeMillis();
		int sum = groupSum.computeSum();
		long finish = System.currentTimeMillis();
		System.out.println("test name: " + name +
				", time: " + (finish - start) + 
				", sum = " + sum);
	}
}
