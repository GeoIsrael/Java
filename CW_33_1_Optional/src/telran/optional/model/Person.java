package telran.optional.model;

public class Person {         //тестовый класс
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;                       //с двумя полями
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {              //если ссылка на один и тот же объект (== сравнивает ссылки (работает только со стеком))
			return true;
		}
		if (!(obj instanceof Person)) { //если obj не яявлется instance класса person то false (оъекты разных классов не равны)
			return false;
		}
		Person other = (Person) obj;    //сравнение по полям
		if (age != other.age) {
			return false;
		}
		if (name == null) {              //сравнение по полям и прверка для безопасности следующего if, чтобы исключить NullPointerExeption
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {   //
			return false;
		}
		return true;
	}

}
