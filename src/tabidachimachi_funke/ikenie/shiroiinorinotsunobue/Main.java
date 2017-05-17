package tabidachimachi_funke.ikenie.shiroiinorinotsunobue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(final String[] args) {
		final Scanner sc = new Scanner(System.in);
		final char[] array = sc.nextLine().toCharArray();
		final List<String> list = new ArrayList<>();
		if (array[0]=='w')
			list.add("0");
		int c = 0;
		char prev = array[0];
		for (int i = 0; i<array.length; i++) {
			if (prev!=array[i]) {
				list.add(String.valueOf(c));
				c = 0;
			}
			prev = array[i];
			c++;
		}
		list.add(String.valueOf(c));
		System.out.println(String.join(" ", list));
	}

}
