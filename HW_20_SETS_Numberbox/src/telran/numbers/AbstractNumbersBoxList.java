

package telran.numbers;

import java.util.HashSet;
import java.util.function.Predicate;

public abstract class AbstractNumbersBoxList extends AbstractNumbersBoxCollection {

	@Override
	public void removeRepeated() {
		HashSet<Integer> helper=new HashSet<>();             //создается HashSet helper
		collection.removeIf(new Predicate<Integer>() {       //удаление из коллекции по предикату
			@Override
			public boolean test(Integer t) {
				return !helper.add(t);             //предикат представляет то, что он будет принимать какое то 
			}                              //число, и пытаться добавить в helper. helper может сказать могу добавить
			                                     //или не могу добавить. если такой элемент там бы, он вернет false
		});                                      //делаем реверс и по возвращаем true.
		                                         //helper нужен только для проверки на повторяемость элементов

	}

}
