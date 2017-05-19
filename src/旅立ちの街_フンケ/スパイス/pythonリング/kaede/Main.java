package 旅立ちの街_フンケ.スパイス.pythonリング.kaede;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();
        sc.close();

        int x = i+50;

        if (test(i,x)) {
            System.out.println(x);
            } else {
                System.out.println("100");
            }
        }
    public static boolean test(int i, int x) {
        boolean resolt = (x<100);
        return resolt;
    }
}
