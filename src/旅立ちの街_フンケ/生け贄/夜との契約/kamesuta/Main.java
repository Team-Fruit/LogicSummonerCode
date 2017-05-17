package 旅立ちの街_フンケ.生け贄.夜との契約.kamesuta;

import java.util.Scanner;

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

		int stablesum = -1;
		while (true) {
			boolean hasBlank = false;
			for (int y = 0; y<size; y++)
				for (int x = 0; x<size; x++) {
					int pick = array[y][x];
					if (pick==0)
						hasBlank = true;
					if (pick==0||stablesum==-1)
						ycheck: {
							int sum = 0;
							int zerocount = 0;
							int sumcount = 0;
							for (int iy = 0; iy<size; iy++) {
								final int current = array[iy][x];
								if (current==0) {
									zerocount++;
									if (zerocount>=2)
										break ycheck;
								} else {
									sum += current;
									sumcount++;
								}
							}
							if (zerocount==0&&pick!=0&&stablesum==-1&&sumcount==size)
								stablesum = sum;
							else if (zerocount==1&&pick==0&&stablesum!=-1&&sumcount==size-1)
								pick = array[y][x] = stablesum-sum;
						}
					if (pick==0||stablesum==-1)
						xcheck: {
							int sum = 0;
							int zerocount = 0;
							int sumcount = 0;
							for (int ix = 0; ix<size; ix++) {
								final int current = array[y][ix];
								if (current==0) {
									zerocount++;
									if (zerocount>=2)
										break xcheck;
								} else {
									sum += current;
									sumcount++;
								}
							}
							if (zerocount==0&&pick!=0&&stablesum==-1&&sumcount==size)
								stablesum = sum;
							else if (zerocount==1&&pick==0&&stablesum!=-1&&sumcount==size-1)
								pick = array[y][x] = stablesum-sum;
						}
				}
			if (!hasBlank)
				break;
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
}