package 旅立ちの街_フンケ.生け贄.白い祈りの角笛.kamesuta;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(final String[] args) {
		final Scanner sc = new Scanner(System.in);
		final String input = sc.nextLine();
		sc.close();
		char current = 'b';
		int cont = 0;
		final LinkedList<String> output = new LinkedList<>();
		for (final char c : input.toCharArray()) {
			if (c!=current) {
				output.addLast(String.valueOf(cont));
				current = c;
				cont = 0;
			}
			cont++;
		}
		output.addLast(String.valueOf(cont));
		System.out.println(String.join(" ", output));
	}
}