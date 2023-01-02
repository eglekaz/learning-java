import java.io.*;
import java.util.*;

public class Program {

	public static void main(String[] args) {
		
		File file = new File("test2.txt");
		HashSet<String> wordsLibrary = new WordReader().readAllFile(file);
		GameMaster gm = new GameMaster();
		
		gm.play(wordsLibrary);
		
		

	}

}
