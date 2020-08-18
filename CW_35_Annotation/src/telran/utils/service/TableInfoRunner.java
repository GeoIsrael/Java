package telran.utils.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import telran.utils.annotation.Id;
import telran.utils.annotation.Index;
import telran.utils.annotation.Table;

public class TableInfoRunner {

	public static void runInfo(Object object) {
		runInfo(object.getClass());
	}

	public static void runInfo(Class<?> clazz) {
		Table tableAnn = clazz.getAnnotation(Table.class);
		if(tableAnn == null) {
			return;
		}
		String tableName = !"".equals(tableAnn.value()) ? tableAnn.value() : clazz.getSimpleName();
		String idField = null;
		List<String> uniqueIndexes = new ArrayList<>();
		List<String> nonUniqueIndexes = new ArrayList<>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field: fields) {
			//handle @Id
			if (field.isAnnotationPresent(Id.class)) {
				if (idField != null ) {
					throw new RuntimeException("Id duplicated");
				}
				idField = field.getName();
			}
			//handle @Index
			Index indexAnn = field.getAnnotation(Index.class);
			if (indexAnn != null) {
				if (indexAnn.unique()) {
					uniqueIndexes.add(field.getName());
				}else {
					nonUniqueIndexes.add(field.getName());
				}
			}
		}
		if (idField == null ) {
			throw new RuntimeException("No Id is defined");
		}
		displayInfo(tableName, idField, uniqueIndexes, nonUniqueIndexes);
		
	}

	private static void displayInfo(String tableName, String idField, List<String> uniqueIndexes,
			List<String> nonUniqueIndexes) {
		System.out.println("Table: " + tableName);
		System.out.println("Id: " + idField);
		System.out.println("   Unique indexes: ");
		uniqueIndexes.forEach(System.out::println);
		System.out.println("   Nonunique indexes: ");
		nonUniqueIndexes.forEach(System.out::println);
		
	}

}
