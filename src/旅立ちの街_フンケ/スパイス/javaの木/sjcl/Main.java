package 旅立ちの街_フンケ.スパイス.javaの木.sjcl;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	/**
	 * ウ ン チ ー コ ー ド
	 * @param args
	 */
	public static void main(final String[] args) {
		final Scanner sc = new Scanner(System.in);
		final Map<Float, Integer> map = new TreeMap<>();
		for (int i = 0; i<2; i++) {
			final int attack = sc.nextInt();
			final int price = sc.nextInt();
			map.put((float) price/attack, price);
		}
		System.out.println(map.entrySet().iterator().next().getValue());
	}

}
