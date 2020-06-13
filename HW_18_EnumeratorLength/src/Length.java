
public class Length {

	private float number;                //количество
	private LengthUnit unit;             //единица измерения объекта длина
	
	public Length(float number, LengthUnit unit) {
		super();
		this.number = number;
		this.unit = unit;
	}
	public float getNumber() {
		return number;
	}
	public void setNumber(float number) {
		this.number = number;
	}
	public LengthUnit getUnit() {
		return unit;
	}
	public void setUnit(LengthUnit unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return ""+(int)number+unit;                  //"" приводит к строке при конкатенаи
	}
	
	public Length plus(Length length)                              
	{
		Length convLength=length.convert(unit);
		return new Length(number+convLength.number,unit);
	}
	public Length minus(Length length)
	{
		return plus(new Length(-length.number,length.unit));       //отрицательная копия метода плюс
	}
	
	public Length convert(LengthUnit otherUnit)
	{
		return new Length(number*unit.getValue()/otherUnit.getValue(),otherUnit);
	}
	
	@Override
	public boolean equals(Object obj){                              //
		if(!(obj instanceof Length)) return false;                  //если объект не порождение  Length, выхоим
		Length length=(Length)obj;                                 //даункастинг до Length
		return Float.compare(number, length.number)==0 && unit==length.unit;    //сравниваем по количеству и по юнитам
	}
}
