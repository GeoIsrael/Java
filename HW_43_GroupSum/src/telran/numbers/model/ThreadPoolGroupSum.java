package telran.numbers.model;

import java.util.Arrays;

import telran.utils.executor.ThreadPool;

public class ThreadPoolGroupSum extends GroupSum {

	public ThreadPoolGroupSum(int[][] numberGroups) {
		super(numberGroups);
	}

	@Override
	public int computeSum() {
		ThreadPool threadPool = new ThreadPool(Runtime.getRuntime().availableProcessors());
		OneGroupSum[] groupSums = launchExecutor(threadPool);
		threadPool.shutdown();
		threadPool.awaitThreads();
		return computeTotalSum(groupSums);
	}

	private int computeTotalSum(OneGroupSum[] groupSums) {
		return Arrays.stream(groupSums).mapToInt(OneGroupSum::getSum).sum();
	}

	private OneGroupSum[] launchExecutor(ThreadPool threadPool) {
		OneGroupSum[] groupSums = new OneGroupSum[numberGroups.length];
		for (int i = 0; i < numberGroups.length; i++) {
			groupSums[i] = new OneGroupSum(numberGroups[i]);
			threadPool.execute(groupSums[i]);
		}
		return groupSums;
	}

}
