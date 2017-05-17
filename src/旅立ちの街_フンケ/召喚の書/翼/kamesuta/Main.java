package 旅立ちの街_フンケ.召喚の書.翼.kamesuta;


import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(final String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！
		final Scanner sc = new Scanner(System.in);
		sc.nextLine();
		final String line = sc.nextLine();
		sc.close();
		final LinkedList<String> deque = new LinkedList<String>();
		int i = 1;
		for (final char c : line.toCharArray())
			switch (c) {
				default:
				case 'L':
					deque.addFirst(String.valueOf(i++));
					break;
				case 'R':
					deque.addLast(String.valueOf(i++));
					break;
			}
		System.out.println(String.join(" ", deque));
	}
}
