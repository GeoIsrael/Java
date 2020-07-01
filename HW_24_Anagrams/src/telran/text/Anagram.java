package telran.text;
import java.util.*;
public class Anagram {
public static boolean isAnagram(String word,String anagram) {
	if(anagram.isEmpty()||anagram.length()>word.length())       //проверка если анаграмма пустая или не проходится проверка по длине
		return false;
	Map<Character,Integer> wordLetters=getWordLetters(word);    //создаем мепу вхождений  из нового метода

	
	//после того как карта вхождений создана:
	
	for(char letter:anagram.toCharArray()) {              //начинаем итерировать посимвольно второе слово - анаграмму
//		int count=wordLetters.getOrDefault(letter,0);     //возьми символ из анаграммы, обратись к карте вхождений word
//		if(count==0)                                      //если данного символа там нет,
//			return false;                                 //верни false, 
//		wordLetters.put(letter, count-1);                 //счетчик символов в карте вхождений word перезапиши на count --                   
		int count=wordLetters.merge(letter, -1, (ov,nv)->ov+nv);   //метод принимает ключ, новое значение и BiFunction интерфейс 
		if(count==-1)                                        //!!!!!!!!еще раз посмотреть merge
			return false;
	}
	return true;
}

private static Map<Character, Integer> getWordLetters(String word) {    //метод создает карту вхождений, возвращает мепу
	Map<Character,Integer>res=new HashMap<>();   //создается мепа
	for(char letter:word.toCharArray()) {        //в цикле итерируется строчка (слово превращается в массив character
//		int count=res.getOrDefault(letter, 0);   //дай из мепы ключ с текущим символом. если его нет то дай 0
//		res.put(letter, count+1);                //добавь символ в мепу с count ++

		//варианнт с merge и lambda
		res.merge(letter, 1, (ov,nv)->ov+nv);    //!!!!!посмотреть merge
	}
	return res;
}
}
