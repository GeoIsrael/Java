package telran.numbers;

public interface INumbersBox extends Iterable<Integer>{
void addNumber(int number);
void removeNumber(int number);
boolean containsNumber(int number);
void removeRepeated();
void removeDividedBy(int number);
int size();
void removeInRange(int fromInclusive,int toExclusive);
}
