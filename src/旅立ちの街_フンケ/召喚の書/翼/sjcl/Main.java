package 旅立ちの街_フンケ.召喚の書.翼.sjcl;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(final String[] args) {
		final Scanner sc = new Scanner(System.in);
		sc.nextLine();
		final char[] array = sc.nextLine().toCharArray();
		final LinkedList<String> list = new LinkedList<>();
		int i = 1;
		for (final char c : array) {
			final String s = String.valueOf(i);
			if (c=='L')
				list.addFirst(s);
			else
				list.add(s);
			i++;
		}
		System.out.println(String.join(" ", list));
	}
}
