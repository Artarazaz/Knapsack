import java.util.Scanner;

public class bag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];

        System.out.println("Enter the values and weights of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Value of item " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
            System.out.print("Weight of item " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        int[][] valueTable = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    valueTable[i][j] = Math.max(valueTable[i - 1][j], values[i - 1] + valueTable[i - 1][j - weights[i - 1]]);
                } else {
                    valueTable[i][j] = valueTable[i - 1][j];
                }
            }
        }

        System.out.println("Maximum value that can be carried: " + valueTable[n][capacity]);

        int w = capacity;
        System.out.print("Selected items: ");
        for (int i = n; i > 0 && w > 0; i--) {
            if (valueTable[i][w] != valueTable[i - 1][w]) {
                System.out.print((i) + " ");
                w -= weights[i - 1];
            }
        }
    }
}