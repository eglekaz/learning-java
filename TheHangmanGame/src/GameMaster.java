import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class GameMaster {
	
	Scanner sc = new Scanner (System.in);
	Random rnd = new Random();
	final int numberOfMoves = 15;

	
	public String  getRandomWord (HashSet<String> set) {
		int index = rnd.nextInt(set.size());
		ArrayList<String> arr = new ArrayList<String>(set);
		String word = arr.get(index);
		return word.toUpperCase();
	}
	
	public char getRandomLetter (String word) {
		HashSet<Character> letters = new HashSet<Character>();
		
		for (char e : word.toCharArray()) {
			letters.add(e);
		}
		
		ArrayList<Character> arr = new ArrayList<Character> (letters);
		int index = rnd.nextInt(arr.size());
		return arr.get(index);
	}
	
	public String checkTheLetter (char letter, String firstWord, String secondWord) {
		
		String result = "";
		for (int i = 0; i < secondWord.length(); i++) {
			if (secondWord.charAt(i) == letter) 
				result += letter;
			else 
				result += firstWord.charAt(i);
		}
		return result;
	}
	
	public char getLetterFromPlayer () {
		System.out.println("Please enter the letter of your guess");
		char result;
		try {
			String temp = sc.next();
			result = temp.toUpperCase().charAt(0);
			if (Character.isLetter(result))
				return result;

		} catch (Exception e){
			System.out.println("Do not cheat!");
		}
		return '0';
	}
	
	public void play (HashSet<String> listOfWords) {
		System.out.println("Let's start!");
		
		String secretWord = getRandomWord(listOfWords);
		char letter = getRandomLetter(secretWord);
		
		String visibleWord = "----------------------------";
		visibleWord = checkTheLetter(letter, visibleWord, secretWord);
		System.out.println(visibleWord);
		
		for (int i = 0; i < numberOfMoves; i++) {
			char playersGuess = getLetterFromPlayer();
			visibleWord = checkTheLetter(playersGuess, visibleWord, secretWord);
			System.out.println(visibleWord);
			
			if (visibleWord.equals(secretWord)) {
				System.out.println("Congratulations!!! You won :)");
				break;
			}
				
		}
		
	}
}
