import java.util.*;

public class NQueens {

    static int[] x;

    public static void Nqueens(int k, int n) {

        for (int i = 1; i <= n; i++) {

            if (place(k, i)) {

                x[k] = i;

                if (k == n) {

                    // Print column positions
                    for (int j = 1; j <= n; j++) {
                        System.out.print(x[j] + " ");
                    }
                    System.out.println();

                } else {
                    Nqueens(k + 1, n);
                }
            }
        }
    }

    public static boolean place(int k, int j) {

        for (int i = 1; i <= k - 1; i++) {

            if (x[i] == j) {
                return false;
            }

            if (Math.abs(x[i] - j) == Math.abs(i - k)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        x = new int[n + 1];

        Nqueens(1, n);

        sc.close();
    }
}