import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CatsAppl {

	public static void main(String[] args) {
		List<Cat> cats = new ArrayList<Cat>();            //создаем лист с объектами
		Cat c1 = new Cat(1111, "Vasya", 2);
		Cat c2 = new Cat(1112, "Murzik", 3);
		Cat c3 = new Cat(1113, "Masha", 1);
		Cat c4 = new Cat(1114, "Pusik", 4);
		Cat c5 = new Cat(1115, "Yakov Borisovich", 9);
		cats.add(c1);
		cats.add(c2);
		cats.add(c3);
		cats.add(c4);
		cats.add(c5);
//		System.out.println(cats);
		displyaCats(cats);              
		cats.sort(new CatsComparatorByAge());    //сортируем лист методом sort с компаратором (отдельный класс)
		displyaCats(cats);                       
		
		
		
		//==========================================
		cats.sort(new Comparator<Cat>() {            //сортируем лист компаратором с анонимным иннер-классом

			@Override
			public int compare(Cat o1, Cat o2) {      //реализуем компаратор сортировки по имени 
				
				return o1.getName().compareTo(o2.getName());
			}
		});
		displyaCats(cats);
		//===============================================
		cats.sort((o1,o2)->o2.getName().compareTo(o1.getName()));    //сортировка по имени компаратором через лямду
		displyaCats(cats);
		//===============================================
		Comparator<Cat> comparator = (o1,o2)->o2.getId()-o1.getId();    //   (параметры) -> {тело}
		cats.sort(comparator);                    //сохраняем компаратор в переменню. и используем ее
		displyaCats(cats);
		

	}

	private static void displyaCats(List<Cat> cats) {
		for(Cat cat:cats)
		{
			System.out.println(cat);
		}
		System.out.println("===============================================");
		
	}

}

//(parametre) -> {body}
