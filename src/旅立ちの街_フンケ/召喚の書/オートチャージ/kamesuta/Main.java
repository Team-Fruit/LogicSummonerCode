package 旅立ちの街_フンケ.召喚の書.オートチャージ.kamesuta;

import java.util.Scanner;

public class Main {
	public static void main(final String[] args) {
		final Scanner sc = new Scanner(System.in);
		final String[] args1 = sc.nextLine().split(" ");
		int health = Integer.parseInt(args1[1]);
		final int heallimit = Integer.parseInt(args1[2]);
		final int heal = Integer.parseInt(args1[3]);

		final String[] damages = sc.nextLine().split(" ");
		for (final String sdamage : damages) {
			final int damage = Integer.parseInt(sdamage);
			health += damage;
			if (health<=heallimit)
				health += heal;
		}

		System.out.println(health);
		sc.close();
	}
}