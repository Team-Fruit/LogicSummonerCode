package 旅立ちの街_フンケ.生け贄.夜との契約.kamesuta;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(final String[] args) {
		final Scanner sc = new Scanner(System.in);
		final int size = Integer.parseInt(sc.nextLine());
		final int[][] array = new int[size][];
		for (int y = 0; y<size; y++) {
			final String[] strs = sc.nextLine().split(" ");
			final int[] row = new int[size];
			for (int x = 0; x<size; x++)
				row[x] = Integer.parseInt(strs[x]);
			array[y] = row;
		}
		sc.close();

		int stablesum = 0;
		stablesum: for (int y = 0; y<size; y++)
			for (int x = 0; x<size; x++) {
				check: {
					int sum = 0;
					for (int iy = 0; iy<size; iy++) {
						final int current = array[iy][x];
						if (current==0)
							break check;
						sum += current;
					}
					stablesum = sum;
					break stablesum;
				}
				check: {
					int sum = 0;
					for (int ix = 0; ix<size; ix++) {
						final int current = array[y][ix];
						if (current==0)
							break check;
						sum += current;
					}
					stablesum = sum;
					break stablesum;
				}
			}

		final Set<Integer> all = new HashSet<>();
		final Set<int[]> unknownposes = new HashSet<>();
		for (int i = 1; i<=size*size; i++)
			all.add(i);

		for (int y = 0; y<size; y++)
			for (int x = 0; x<size; x++) {
				final int num = array[y][x];
				if (num!=0)
					all.remove(num);
				else
					unknownposes.add(new int[] { x, y });
			}

		check: {
			final List<int[]> listPos = new ArrayList<>(unknownposes);
			final int[] posA = listPos.get(0);
			final int[] posB = listPos.get(1);
			final List<Integer> listAll = new ArrayList<>(all);
			final int valA = listAll.get(0);
			final int valB = listAll.get(1);
			array[posA[1]][posA[0]] = valA;
			array[posB[1]][posB[0]] = valB;
			if (check(size, stablesum, array))
				break check;
			array[posA[1]][posA[0]] = valB;
			array[posB[1]][posB[0]] = valA;
			if (check(size, stablesum, array))
				break check;
		}

		for (int w = 0; w<size; w++) {
			final StringBuilder sb = new StringBuilder();
			for (int i = 0; i<size; i++) {
				if (i!=0)
					sb.append(' ');
				sb.append(array[w][i]);
			}
			System.out.println(sb);
		}
	}

	private static boolean check(final int size, final int stablesum, final int[][] array) {
		for (int y = 0; y<size; y++) {
			int sum = 0;
			for (int x = 0; x<size; x++)
				sum += array[y][x];
			if (sum!=stablesum)
				return false;
		}
		for (int x = 0; x<size; x++) {
			int sum = 0;
			for (int y = 0; y<size; y++)
				sum += array[y][x];
			if (sum!=stablesum)
				return false;
		}
		return true;
	}
}