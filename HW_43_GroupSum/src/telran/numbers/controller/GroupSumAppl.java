package telran.numbers.controller;

import java.util.Random;

import telran.numbers.model.ExecutorGroupSum;
import telran.numbers.model.GroupSum;
import telran.numbers.model.ParallelStreamGroupSum;
import telran.numbers.model.ThreadGroupSum;
import telran.numbers.model.ThreadPoolGroupSum;
import telran.numbers.tests.GroupSumPerfomanceTest;

public class GroupSumAppl {
	private static final int N_GROUPS = 10_000;
	private static final int NUMBERS_PER_GROUP = 10_000;
	static int[][] arr = new int[N_GROUPS][NUMBERS_PER_GROUP];
	static Random random = new Random();

	public static void main(String[] args) {
		fillArray();
		GroupSum executorGroupSum = 
				new ExecutorGroupSum(arr);
		GroupSum threadsGroupSum = 
				new ThreadGroupSum(arr);
		GroupSum streamGroupSum =
				new ParallelStreamGroupSum(arr);
		GroupSum threadPoolGroupSum = 
				new ThreadPoolGroupSum(arr);
		
		new GroupSumPerfomanceTest("ThreadsGroupSum", threadsGroupSum).runTest();
		new GroupSumPerfomanceTest("ParallelStreamGroupSum", streamGroupSum).runTest();
		new GroupSumPerfomanceTest("ExecutorGroupSum", executorGroupSum).runTest();
		new GroupSumPerfomanceTest("ThreadPoolGroupSum",threadPoolGroupSum).runTest();
				
	}

	private static void fillArray() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = random.nextInt();
			}
		}
		
	}

}
