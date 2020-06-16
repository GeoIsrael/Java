package telran.test.maps;


import java.util.Map;
import java.util.Map.Entry;

import java.util.TreeMap;

public class MapsTestAppl {

	public static void main(String[] args) {
		Map<String, Integer> months = new TreeMap<>();
		fillmap(months);
		System.out.println(months.values());
		System.out.println(months.keySet());
		System.out.println(months.entrySet());
		
//		months.values().removeIf(new Predicate<Integer>() {          //удаляет пары 
//
//			@Override
//			public boolean test(Integer t) {
//				if(t==null) return false;
//				return t%2==0;                     
//			}
//		});
		System.out.println(months);
		
//		months.entrySet().removeIf(new Predicate<Entry>() {
//
//			@Override
//			public boolean test(Entry t) {
//				
//				return t.getKey().equals("May");
//			}
//		});
//		System.out.println(months);
		
		months.remove("May");
		System.out.println(months);
		iterateEntries(months);
		iterateMonthNames(months);
		iterateMonthNumbers(months);

	}

	private static void iterateMonthNumbers(Map<String, Integer> months) {
		System.out.println("iterating month numbers");
		for(Integer number:months.values())
		{
			System.out.println(number);
		}
		System.out.println("-----------------------------------");
		
	}

	private static void iterateMonthNames(Map<String, Integer> months) {
		System.out.println("iterating month names");
		for(String name:months.keySet())
		{
			System.out.println(name);
		}
		System.out.println("-----------------------------------");
		
	}

	private static void iterateEntries(Map<String, Integer> months) {
		System.out.println("iterating entries");
		for(Entry<String, Integer> e:months.entrySet())
		{
			System.out.println(e);
			
		}
		System.out.println("-----------------------------------");
	}

	private static void fillmap(Map<String, Integer> months) {
		months.put("Jan",1);
		months.put("Feb",2);
		months.put("Mar",3);
		months.put("Apr",4);
		months.put("May",5);
		
	}

}
