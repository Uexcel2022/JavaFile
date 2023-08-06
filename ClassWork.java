package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassWork {

	public ClassWork() {
		String word = "abbbbcccdddeeeefbddccrreee";
		char[] toCharArray = word.toCharArray();
		String string = "";
		String add = "";
		int lenght = toCharArray.length;

		for (int i =1; i < lenght; i++) {

			if (toCharArray[i] == toCharArray[i - 1]) {
				add = String.valueOf(toCharArray[i]);
				string += toCharArray[i - 1];
			} else {
				if (string.contains(add)) {
					string += add;
					add = " ";
					string += " ";
				}
			}

		}
		if ( String.valueOf(word.charAt(word.length() - 1)).equals(String.valueOf(string.charAt(string.length() - 1))) ) {
			string += String.valueOf(word.charAt(word.length() - 1));
		}

		String[] wordArray = string.split(" ");
		String filterWordArray = "";
		for (int i = 0; i < wordArray.length; i++) {
			if (!wordArray[i].isEmpty()) {
				filterWordArray += wordArray[i];
				filterWordArray += " ";
			}

		}

		System.out.println("String: " + word);
		System.out.println("\nBuilded string: " + filterWordArray + "\n");

		String[] filteredWordArray = filterWordArray.split(" ");
		
//		String[] filteredWordArray = {"bbbb*", "cc*", "ddd*", "eee*", "r*"};   in regex form
		
		String controlString = "";

		String regex = "";
		
		for (String n : filteredWordArray) {

			if (!controlString.contains(n)) {
				controlString += n;
				if (n.length() >= 3) {
					regex = String.format("%s*", String.valueOf(n.charAt(0)) + String.valueOf(n.subSequence(1, 3)));
				} else {
					regex = String.format("%s*", n);
				}
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(word);
				while (matcher.find()) {
					if (!matcher.group().isEmpty()) {
						System.out.println(matcher.group() + "\nStarts from index :" + matcher.start()
								+ "\nend at index: " + matcher.end());
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		new ClassWork();
	}

}

//			
//			
