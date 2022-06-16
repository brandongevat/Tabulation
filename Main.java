import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void display_table(int[][] table, int cols) {
        // Test input
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int tab_sum(int[][] L, int rows, int cols) {
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += L[i][j];
            }
        }
        return sum;
    }

    public static int tabulation(int[] X, int[] Y, int n) {
        int L[][] = new int[2][n + 1];

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                L[0][i] = 0;
                L[1][i] = 0;
            } else {
                // if (X[i - 1] + L[1][i - 1] == Y[i - 1])
                // L[1][i] = Y[i - 1];
                if (max(Y[i - 1], X[i - 1] + L[1][i - 1]) == X[i - 1] + L[1][i - 1]) {
                    L[0][i] = X[i - 1];
                } else {
                    L[1][i] = Y[i - 1];
                    i++;
                }
            }

        }
        return tab_sum(L, 2, n + 1);
    }

    public static void main(String[] args) throws FileNotFoundException {

        // Grab input
        int students = 0;
        int l1[], l2[];

        File file = new File("in.txt");
        Scanner stdin = new Scanner(file);

        students = stdin.nextInt();
        l1 = new int[students];
        l2 = new int[students];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < students; j++) {
                if (i == 0)
                    l1[j] = stdin.nextInt();
                else
                    l2[j] = stdin.nextInt();
            }
        }

        // Run bottom-up tabulation
        System.out.print(tabulation(l1, l2, students));

    }

}