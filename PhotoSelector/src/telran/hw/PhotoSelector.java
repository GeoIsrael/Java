package telran.hw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhotoSelector {
	public static String[] selectPictures(String[] pictures, String regex) {
			
//what is the length of the future array?
		Pattern pattern = Pattern.compile(regex);
		int count = 0;
		for (int i = 0; i < pictures.length; i++) {
		Matcher matcher = pattern.matcher(pictures[i]);
		if (matcher.find()) count+=1;
		}
	
    	String[] ActString = new String[count];
		
//fill the array	
		for (int i = 0; i < pictures.length; i++) {
			Matcher matcher = pattern.matcher(pictures[i]);
			if (matcher.find()) ActString[i] = pictures[i];
		}
			
		return ActString;
	}
}
