import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAppl {

	public static void main(String[] args) {

		
		//=======================================Вычисление суммы листа стримом и forEach: 
		List <Integer> collection = Arrays.asList(1,10,100,1000);
		
		Integer sumOddOld = 0; 
	        for(Integer i: collection) {
	            if(i % 2 == 0) {
	                sumOddOld += i;
	            }
	        }
		System.out.println(sumOddOld);
		
		Integer sumOdd = collection.stream().filter(o -> o % 2 == 0).reduce((s1, s2) -> s1 + s2).orElse(0);
		System.out.println(sumOdd);
		
		
//		//=======================================Запуск stream
//		
//		Collection<String> collectionStr = Arrays.asList("a1", "a2", "a3");
//		Stream<String> streamFromCollection = collectionStr.stream();
//		IntStream streamFromString = "1233443334551223".chars();
//		
		// ========================== Создание стрима из значений
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
        System.out.println("streamFromValues = " + streamFromValues.collect(Collectors.toList())); // напечатает streamFromValues = [a1, a2, a3]
     // ============================== Создание стрима из массива
        String[] array = {"a1","a2","a3"};
        Stream<String> streamFromArrays = Arrays.stream(array);
        System.out.println("streamFromArrays = " + streamFromArrays.collect(Collectors.toList())); // напечатает streamFromArrays = [a1, a2, a3]
		
        Stream<String> streamFromArrays1 = Stream.of(array);
        System.out.println("streamFromArrays1 = " + streamFromArrays1.collect(Collectors.toList())); // напечатает streamFromArrays = [a1, a2, a3]
		
        // Создание стрима из коллекции==============
        Collection<String> collection2 = Arrays.asList("a1", "a2", "a3");
        Stream<String> streamFromCollection = collection2.stream();
        System.out.println("streamFromCollection = " + streamFromCollection.collect(Collectors.toList())); // напечатает streamFromCollection = [a1, a2, a3]
        
        // Создание числового стрима из строки ===================
        IntStream streamFromString = "123333".chars();
        System.out.print("streamFromString = ");
        streamFromString.forEach((e)->System.out.print(e + " , ")); // напечатает streamFromString = 49 , 50 , 51 ,
        System.out.println();
		
        //StreamBuilder==================
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> streamFromBuilder = builder.add("a1").add("a2").add("a3").build();
        System.out.println("streamFromBuilder = " + streamFromBuilder.collect((Collectors.toList()))); // напечатает streamFromFiles = [a1, a2, a3]

        // Создание бесконечных стримов ==============
        // С помощью Stream.iterate   ================
        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n * 2);
        System.out.println("streamFromIterate = " + streamFromIterate.limit(5).collect(Collectors.toList())); // напечатает streamFromIterate = [1, 3, 5]
	
        // С помощью Stream.generate
        Stream<String> streamFromGenerate = Stream.generate(() -> "a1");
        System.out.println("streamFromGenerate = " + streamFromGenerate.limit(3).collect(Collectors.toList())); // напечатает streamFromGenerate = [a1, a1, a1]
	
     // Создать пустой стрим
        Stream<String> streamEmpty = Stream.empty();
        System.out.println("streamEmpty = " + streamEmpty.collect(Collectors.toList())); // напечатает streamEmpty = []
	
        
        
        
        
        //================================
     // вызовы методов у стрима
        //возвращает только записи, соответствующие условию
        Collection<String> collection3 = Arrays.asList("a1", "a2", "a3", "a4", "a5", "a1");
        System.out.println("Count Matches in stream = " + collection3.stream().filter("a1"::equals).count());

        //Позволяет пропустить N первых элементов         ???
        System.out.println("Slice = " + collection3.stream().skip(2).collect(Collectors.toList()));
        
        //Возвращает стрим без дубликатов (для метода equals)
        System.out.println(collection3.stream().distinct().collect(Collectors.toList()));
        
        //Преобразует каждый элемент стрима
        System.out.println(collection3.stream().map((s) -> s + "_1").collect(Collectors.toList()));
        
        //Возвращает тот же стрим, но применяет функцию к каждому элементу стрима
        System.out.println(collection3.stream().map(String::toUpperCase).peek((e) -> System.out.print("," + e)).
collect(Collectors.toList()));
        
        //Возвращает любой подходящий элемент из стрима (возвращает Optional)
        System.out.println(collection3.stream().findAny().orElse("1"));
        
        System.out.println(collection3.stream().anyMatch("a3"::equals));   //содержит ли стрим символ?
        
        System.out.println(collection3.stream().min(String::compareTo).get()); //минимальное / максимальное / среднее значение стрима
        
        System.out.println("========================");
        
        List list4 = Arrays.asList(new People("Вася", 16, Sex.MAN), new People("Петя", 23, Sex.MAN), new People("Елена", 42, Sex.WOMEN), new People("Иван Иванович", 69, Sex.MAN));
        
        
        
        
        
        
	}


}