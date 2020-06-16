//обобщенный абстрактный класс, взаимодействующий с интерфейсом

package telran.numbers;
import java.util.*;
import java.util.function.Predicate;
public abstract class  AbstractNumbersBoxCollection implements INumbersBox {
Collection<Integer> collection;                //создаем поле Collection, потому что любой лист и сет можно привести
	@Override                                  //к этому классу (он выше всех)
	public void addNumber(int number) {
		collection.add(number);                //методы (у каждой коллекции метод реализован по своему

	}

	@Override
	public void removeNumber(int number) {      //используется метод REMOVE ПО ОБЪЕКТУ (не по индексу)
		collection.remove((Integer)number);       

	}

	@Override
	public boolean containsNumber(int number) {  //--
		return collection.contains(number);
	}

	

	@Override
	public void removeDividedBy(int number) {              //в этих методах нужно понмать - что м будем удалять
		collection.removeIf(new Predicate<Integer>() {     //используем метод removeIf c предикатом
			@Override
			public boolean test(Integer t) {               //при помощи анонимного иннер-класса создаем метот TEST
				return t%number==0;                        //строка условия предиката
			}
		});

	}

	@Override
	public int size() {                         //у всех коллекций есть метод size
		return collection.size();
	}
public Iterator<Integer> iterator (){
	return collection.iterator();
}
	@Override
	public void removeInRange(int fromInclusive, int toExclusive) {       //удаление в диапазоне
		collection.removeIf(new Predicate<Integer>() {                  //используем removeIf с предикатом
			@Override
			public boolean test(Integer t) {                          //на основании иннер-класса 
				return t >= fromInclusive && t < toExclusive;         //условие удаления элемента
			}
		});

	}

}
