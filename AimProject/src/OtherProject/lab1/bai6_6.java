package lab1;
import java.util.Scanner;

public class bai6_6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số hàng của ma trận: ");
        int rows = input.nextInt();
        System.out.print("Nhập số cột của ma trận: ");
        int cols = input.nextInt();
        int[][] matrix1 = inputMatrixFromUser(rows, cols, "Nhập ma trận thứ nhất:");
        int[][] matrix2 = inputMatrixFromUser(rows, cols, "Nhập ma trận thứ hai:");
        int[][] result = addMatrices(matrix1, matrix2);
        System.out.println("Ma trận kết quả:");
        printMatrix(result);
    }
    public static int[][] inputMatrixFromUser(int rows, int cols, String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        return matrix;
    }
    // Hàm để cộng hai ma trận
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // Hàm để in ma trận
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

