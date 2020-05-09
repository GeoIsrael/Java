package telran.hw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhotoSelector {
	
	private static final String DELIMITER = ";";
	
	public static String[] selectPictures(String[] pictures, String regex) {
		
		if (pictures.length == 0) return null;
		
		String res = new String();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("");

		for (int i = 0; i < pictures.length; i++) {
			matcher.reset(pictures[i]);
		    if (matcher.find()) res += (pictures[i] + DELIMITER); 
		    }
		
		return res.split(";");		
		
	}
	
}
		
