package telran.numbers.model;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorGroupSum extends GroupSum {

	public ExecutorGroupSum(int[][] numberGroups) {
		super(numberGroups);
	}

	@Override
	public int computeSum() {
		ExecutorService executorService = Executors.newWorkStealingPool();
		OneGroupSum[] groupSums = launchExecutor(executorService);
		executorService.shutdown();
		try {
			executorService.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return computeTotalSum(groupSums);
	}

	private int computeTotalSum(OneGroupSum[] groupSums) {
		return Arrays.stream(groupSums).mapToInt(OneGroupSum::getSum).sum();
	}

	private OneGroupSum[] launchExecutor(ExecutorService executorService) {
		OneGroupSum[] groupSums = new OneGroupSum[numberGroups.length];
		for (int i = 0; i < numberGroups.length; i++) {
			groupSums[i] = new OneGroupSum(numberGroups[i]);
			executorService.execute(groupSums[i]);
		}
		return groupSums;
	}

}
