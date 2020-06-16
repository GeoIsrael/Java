package telran.numbers;

import java.util.TreeSet;

public class NumbersBoxTreeSet extends AbstractNumbersBoxSet {
@Override
	public void removeInRange(int min,int max) {            //реализация removeInRange
	((TreeSet<Integer>)collection)                        //даункастинг до treeset
	.subSet(min, max).clear();                            //вызов метода subset (удаление из оригинальной коллекции
}                                                         //потому что subSet дает view
public NumbersBoxTreeSet() {
	collection=new TreeSet<>();
}
}
