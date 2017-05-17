package 旅立ちの街_フンケ.生け贄.夜との契約.sjcl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(final String[] args) {
		final Scanner sc = new Scanner(System.in);
		final int size = Integer.valueOf(sc.nextLine());
		final int[][] magic = new int[size][size];
		for (int w = 0; w<size; w++) {
			final String[] line = sc.nextLine().split(" ");
			for (int i = 0; i<size; i++)
				magic[w][i] = Integer.valueOf(line[i]);
		}
		int total = 0;
		boolean validTotal = false;
		final List<Pos> zeroPos = new ArrayList<>();
		for (int w = 0; w<size; w++) {
			boolean zero = false;
			for (int i = 0; i<size; i++) {
				if (magic[w][i]==0) {
					zero = true;
					zeroPos.add(new Pos(w, i));
				}
				if (!validTotal)
					total += magic[w][i];
			}
			if (!zero)
				validTotal = true;
			if (!validTotal)
				total = 0;
		}
		for (final Pos pos : zeroPos) {
			int lineTotal = 0;
			int zeroCount = 0;
			for (int w = 0; w<size; w++) {
				if (magic[w][pos.y]==0)
					zeroCount++;
				lineTotal += magic[w][pos.y];
			}
			if (zeroCount>=2) {
				lineTotal = 0;
				for (int i = 0; i<size; i++)
					lineTotal += magic[pos.x][i];
			}
			magic[pos.x][pos.y] = total-lineTotal;
		}
		for (int w = 0; w<size; w++) {
			final StringBuilder sb = new StringBuilder();
			for (int i = 0; i<size; i++) {
				if (i!=0)
					sb.append(' ');
				sb.append(magic[w][i]);
			}
			System.out.println(sb);
		}
	}

	public static class Pos {
		public final int x, y;

		public Pos(final int x, final int y) {
			this.x = x;
			this.y = y;
		}
	}
}
