package telran.text.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import telran.text.Anagram;

public class AnagramTest {
	String word="electricity";
	

	@Test
	public void isAnagramTestTrue() {
		assertTrue(Anagram.isAnagram(word,"electric"));
		assertTrue(Anagram.isAnagram(word,"tric"));
		assertTrue(Anagram.isAnagram(word,"city"));
		assertTrue(Anagram.isAnagram(word,"tet"));
		
	}
	@Test
	public void isAnagramTestFalse() {
		assertFalse(Anagram.isAnagram(word, "ellect"));//ll
		assertFalse(Anagram.isAnagram(word, "toc"));//o
		assertFalse(Anagram.isAnagram(word, "select"));//s
		assertFalse(Anagram.isAnagram(word, "tel e"));//space
		assertFalse(Anagram.isAnagram(word, "teeel"));//eee
		
	}

}
