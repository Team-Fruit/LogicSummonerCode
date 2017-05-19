import java.util.*;
public class Tree_of_Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        sc.close();

        int x = b/a;
        int y = d/c;

        if (test(x,y)) {
            System.out.println(b);
        } else {
            System.out.println(d);
        }
    }

    public static boolean test(int x, int y) {
        boolean result = (x<y);
        return result;
    }
}
