package tm.thulium;

import java.util.Random;

public class Thulium {
	public static final String VOWELS[] = { "a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "ay", "ey", "ia",
			"ee", "ea", "a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "ay", "ey", "ia", "ui",
			"ee", "ea" };
	public static final String CONSONANTS[] = { "b", "c", "d", "f", "g", "j", "k", "l", "m", "n", "p", "qu", "r", "s",
			"t", "v", "w", "x", "y", "z", "b", "c", "d", "f", "g", "j", "k", "l", "m", "n", "p", "qu", "r", "s",
			"t", "v", "w", "x", "z", "ch", "sh", "th", "b", "c", "d", "f", "g", "j", "k", "l", "m", "n", "p", "r",
			"s", "t", "v", "w", "z", "ch", "sh", "th", "tch", "sk", "sl", "bl", "sb", "sp", "pl", "sg", "ks", "gs",
			"ps", "bs", "ts", "ds", "dz", "sm", "ss", "tt", "dd", "cc" };
	public static final char H = 'h';
	public static final String ENDINGS[] = { "burg", "borg", "berg", "bourg", "ia", "a", "an", "stan", "ia", "a", "an",
			"stan", "ia", "a", "an", "stan" };
	public static final Random R = new Random();

	public Thulium() {
		// TODO Auto-generated constructor stub
	}

	public static String generateName() {
		int len = R.nextInt(1, 2) + R.nextInt(1, 2);
		StringBuffer s = new StringBuffer();
		if (R.nextInt(6) == 3) {
			s.append(VOWELS[R.nextInt(VOWELS.length)]);
		}
		for (int i = 0; i < len; i++) {
			s.append(CONSONANTS[R.nextInt(CONSONANTS.length)]);
			s.append(VOWELS[R.nextInt(VOWELS.length)]);
		}
		if (R.nextInt(6) <= 5) {
			s.append(CONSONANTS[R.nextInt(CONSONANTS.length)]);
		}
		if (R.nextInt(13) <= 4) {
			s.append(VOWELS[R.nextInt(VOWELS.length)]);
			for (int k = 0; k < R.nextInt(1, 4); k++) {
				s.deleteCharAt(s.length() - 1);
			}
			s.append(ENDINGS[R.nextInt(ENDINGS.length)]);
		}
		s.setCharAt(0, (char) (s.charAt(0) - 'a' + 'A'));
		return s.toString();
	}

	public static void main(String[] args) {
		System.out.println("Hello Thulium!");
		for (int i = 1; i <= 100; i++) {
			System.out.println(generateName());
		}

	}

}
