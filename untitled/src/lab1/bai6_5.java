package lab1;

import java.util.Scanner;
import java.util.Arrays;

public class bai6_5 {
    public static void main(String[] args) {

        int[] arr;
        arr = inputArrayFromUser();
        // Sắp xếp mảng
        Arrays.sort(arr);

        // Tính tổng và giá trị trung bình của các phần tử
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double average = (double) sum / arr.length;

        // In mảng đã sắp xếp
        System.out.println("Mảng đã sắp xếp: " + Arrays.toString(arr));
        System.out.println("Tổng các phần tử: " + sum);
        System.out.println("Giá trị trung bình: " + average);
    }

    // Hàm để nhập mảng từ người dùng
    public static int[] inputArrayFromUser() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = input.nextInt();

        int[] arr = new int[n];
        System.out.println("Nhập " + n + " phần tử:");

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        return arr;
    }
}
