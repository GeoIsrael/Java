package telran.person;

public class Person implements Comparable<Person> {

	private int birthYear;
	private String name;
	
	public Person(int birthYear, String name) {
		this.birthYear = birthYear;
		this.name = name;
	}

	
	
	
	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




	@Override
	public String toString() {
		return "|" + birthYear + " " + name + "|";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + birthYear;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (birthYear != other.birthYear)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}




	@Override
	public int compareTo(Person o) {		
		
		
// Сортировки по одному полю
//		return o.birthYear - birthYear;
//		return this.birthYear-o.birthYear;                       //прямая сортировка
//		return birthYear-o.birthYear;                            // возвращает -x,0,x
//		return Integer.compare(this.birthYear, o.birthYear);     // возвращает -1,0,1
		
// Сортировки по нескольким полям
		int res = birthYear - o.birthYear;
		if (res == 0) 
			return this.name.compareToIgnoreCase(o.name);
		else
			return res;
			
		
		
		
		
	}
	
	
	
	
	
	
}
