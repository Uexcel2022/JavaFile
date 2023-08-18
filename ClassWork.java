package RegularExpression;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassWork {

	public ClassWork() {
		mywork2();
//		mywork();
	}

	public void byLecturer() {
		String word = "abbbbcccdddeeeefbddccrreee";
		for (int i = 1; i < word.length(); i++) {
			String regex = String.format("%s{3,}", String.valueOf(word.charAt(i)));
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(word);
			if (matcher.find(i - 1)) {
				String out = String.format("Matched: %s \nStarts from index : %s \nend at index: %s \n",
						matcher.group(), matcher.start(), matcher.end());
				System.out.println(out);
				i = matcher.end();

			}
		}

	}

	public void mywork2() {
		String word = "abbbbcccdddeeeefbddccrreee";
		for (int i = 0; i < word.length(); i++) {
			String regex = String.format("%s{3,}", String.valueOf(word.charAt(i)));
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(word);
			while (matcher.find()) {
				String out = String.format("Matched: %s \nStarts from index : %s \nend at index: %s \n",
						matcher.group(), matcher.start(), matcher.end());
				System.out.println(out);
				i = matcher.end();

			}
		}

	}

	public static void main(String[] args) {
		new ClassWork();
	}

	public void mywork() {
		String word = "abbbbcccdddeeeefbddccrreee";
		char[] toCharArray = word.toCharArray();
		String string = "";
		String add = "";
		int lenght = toCharArray.length;

		for (int i = 1; i < lenght; i++) {

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
		if (String.valueOf(word.charAt(word.length() - 1)).equals(String.valueOf(string.charAt(string.length() - 1)))) {
			string += String.valueOf(word.charAt(word.length() - 1));
		}

		String[] wordArray = string.split(" ");
		String filterWordArray = "";
		for (int i = 0; i < wordArray.length; i++) {
			if (!wordArray[i].isEmpty() && wordArray[i].length() >= 3) {
				filterWordArray += wordArray[i];
				filterWordArray += " ";
			}

		}

		System.out.println("String: " + word);
		System.out.println("\nBuilded string: " + filterWordArray + "\n");

		String[] filteredWordArray = filterWordArray.split(" ");

//		String[] filteredWordArray = {"bbbb*", "cc*", "ddd*", "eee*", "r*"};   in regex form

		ArrayList<Integer> controlString = new ArrayList<>();

		String regex = "";

		for (String n : filteredWordArray) {

			if (n.length() == 3) {
				regex = String.format("%s", n);

			} else if (n.length() > 3) {

				regex = String.format("%s", n);
			}

			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(word);
			while (matcher.find()) {
				if (!matcher.group().isEmpty()) {
					if (!controlString.contains(matcher.start())) {
						controlString.add(matcher.start());
						System.out.println(matcher.group() + "\nStarts from index :" + matcher.start()
								+ "\nend at index: " + matcher.end());
					}
				}

			}

		}
	}

}
