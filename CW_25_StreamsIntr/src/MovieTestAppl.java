import java.util.Arrays;

public class MovieTestAppl {

	public static void main(String[] args) {
		
		Movie[] movies = {
				new Movie("a", 2017, 4.0f, 192000000.0),
				new Movie("b", 2018, 4.5f, 492000000.0),
				new Movie("c", 2017, 4.5f, 342000000.0),
				new Movie("d", 2018, 3.5f, 692000000.0),
				new Movie("e", 2019, 5.5f, 82000000.0)
		};
		float rating = 3.0f;
		displayMovieByRating(movies, rating);  //метод распечатывает все фильмы классом выше rating

	}

	private static void displayMovieByRating(Movie[] movies, float rating) {
		Arrays.stream(movies)        //в данном случае стрим можно запустить только из класса Arrays
		.filter(m->m.rating>=rating)  ///фильтруем только те значения у которых рейтинг больше рейтинг
		.sorted((m1,m2)->Float.compare(m2.rating,m1.rating))  //сортируем стандартным компаратором класса Float в обратном порядке (2знач , 1знач)
		.map(m->m.title)        //берем только названия у объектов
		.forEach(System.out::println);  //и распечатываем
		
	}

	
}
