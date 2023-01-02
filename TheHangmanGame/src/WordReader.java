import java.io.*;
import java.util.*;

public class WordReader {
	HashSet<String> readAllFile (File file) {
		HashSet<String> result = new HashSet<String>();
		
		try {
			Scanner sc = new Scanner (file);
			
			while (sc.hasNextLine()) {
				String str = sc.nextLine();
				result.add(str);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found. Please check the project folder");
			
		} catch (NoSuchElementException e) {
			System.out.println("ERROR! File contains of empty lines. Fix the file");
		}
		return result;
		
	}
}

