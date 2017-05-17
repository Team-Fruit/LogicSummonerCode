package 旅立ちの街_フンケ.召喚の書.攻撃コマンド.kamesuta;

import java.util.Scanner;

public class Main {
	public static void main(final String[] args) {
		final Scanner sc = new Scanner(System.in);
		int damage = 0;
		for (int i = 0; i<5; i++) {
			final String line = sc.nextLine();
			if ("Attack".equals(line))
				damage += 100;
		}
		System.out.println(damage);
		sc.close();
	}
}