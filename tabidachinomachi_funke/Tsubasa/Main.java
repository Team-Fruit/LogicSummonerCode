import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        char[] array = sc.nextLine().toCharArray();
        LinkedList<String> list = new LinkedList<String>();
        int i = 1;
        for (char c : array) {
            String s = String.valueOf(i);
            if (c=='L')
                list.addFirst(s);
            else
                list.add(s);
            i++;
        }
        System.out.println(String.join(" ", list));
    }
}
