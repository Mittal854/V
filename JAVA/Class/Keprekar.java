import java.util.*;

public class Keprekar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sq = (long) n * n;
        String sq1 = Long.toString(sq);
        int len = sq1.length();
        int mid = len / 2;
        String a = sq1.substring(0, mid);
        String b = sq1.substring(mid);
        if (a.equals(""))
            a = "0";
        int p1 = Integer.parseInt(a);
        int p2 = Integer.parseInt(b);
        int k = 1;

        if (p1 + p2 != n)
            k = 0;
        if (k == 1)
            System.out.println("Kaperkar number");
        else
            System.out.println("Not Kaperkar");
        sc.close();
    }
}