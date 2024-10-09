import java.util.*;

class Prime {
    public static boolean isPrime(int n) {
        if (n == 1)
            return true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        int i = 1;
        while (cnt < n) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                cnt++;
            }
            i++;
        }
        sc.close();
    }
}
