import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyVersion {

	static int res = 0;
	static int rows = 5;
	static int column = 4;
	static List<List<Integer>> grid =  new ArrayList<>();
//	static int[] r1 = {1,1,0,0};
//	static int[] r2 = {0,0,1,0};
//	static int[] r3 = {0,0,0,0};
//	static int[] r4 = {1,0,1,1};
//	static int[] r5 = {1,1,1,1};

	
	
	public static int numberAmazonTreasureTrucks(int rows, int column, List<List<Integer>> grid) {
		Iterator iterator = grid.iterator();
		
		for (Iterator iterator2 = grid.iterator(); iterator2.hasNext();) {
			List<Integer> list = (List<Integer>) iterator2.next();
			for (Iterator iterator3 = list.iterator(); iterator3.hasNext();) {
				Integer integer = (Integer) iterator3.next();
				if (integer == 1 && iterator3.hasNext() && (Integer)iterator3.next() == 1) { res ++ ; }
			}
		}
				
		
		return res;
	}

	public static int verticaleCorrect(int[][]grid) {
		return 0;
	}
	
	
	
	public static int horisontaleAllCounter(int[][]grid) {
		//TODO
		return 0;
	}
	
	

	public static void main(String[] args) {
		
		grid.add(Arrays.asList(1,1,0,0));
		grid.add(Arrays.asList(0,0,1,0));
		grid.add(Arrays.asList(0,0,0,0));
		grid.add(Arrays.asList(1,0,1,1));
		grid.add(Arrays.asList(1,1,1,1));
		
		
		
	}



}
