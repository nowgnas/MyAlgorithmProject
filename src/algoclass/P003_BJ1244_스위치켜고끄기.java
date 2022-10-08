package 이상원;

import java.util.Arrays;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/1244
 */
public class P003_BJ1244_스위치켜고끄기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int switchNum = sc.nextInt();

        int[] arr = new int[switchNum];
        for (int i = 0; i < switchNum; i++) {
            arr[i] = sc.nextInt();
        }

        int student = sc.nextInt();
        int[][] stdArr = new int[student][2];
        for (int i = 0; i < student; i++) {
            for (int j = 0; j < 2; j++) {
                stdArr[i][j] = sc.nextInt();
            }
        }

        // 알고리즘 구현
        // 학생 반복문
        for (int[] item :
                stdArr) {
            if (item[0] == 1) {
                // 남자
                for (int i = 0; i < arr.length; i++) {
                    if ((i + 1) % item[1] == 0) {
                        arr[i] = arr[i] == 0 ? 1 : 0;
                    }
                }
            } else {
                //여자
                int num = item[1] - 1;
                int left = num - 1;
                int right = num + 1;
                arr[num] = arr[num] == 0 ? 1 : 0;
                for (int i = 0; i < arr.length / 2; i++) {

                    if (left >= 0 && right < arr.length && arr[left] == arr[right]) {
                        arr[left] = arr[left] == 0 ? 1 : 0;
                        arr[right] = arr[right] == 0 ? 1 : 0;
                    } else break;
                    left--;
                    right++;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if ((i + 1) % 20 == 0) System.out.println();
        }
    }
}
