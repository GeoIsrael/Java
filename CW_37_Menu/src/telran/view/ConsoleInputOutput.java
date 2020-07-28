package telran.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputOutput implements InputOutput {
	BufferedReader br = 
			new BufferedReader(new InputStreamReader(System.in));

	@Override
	public String getString(String prompt) {
		displayLine(prompt);		
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void display(Object object) {
		System.out.print(object);

	}

}
