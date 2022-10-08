package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P070_SWEA5658_보물상자비밀번호 {
    static int t, n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            int copyStr = n / 4;
            String line = br.readLine();
            for (int j = 0; j < copyStr; j++) {
                line += line;
            }
            char[] nNum = line.toCharArray();
            int result = getBigNum(nNum, copyStr);
            System.out.println("#" + i + " " + result);
        }
    }

    static int getBigNum(char[] arr, int rotate) {
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < rotate; i++) { // 시작 인덱스
            int tmp = 0;
            String tmpString = "";
            for (int j = i; j < i + n; j++) { // 한 세트
                tmp++;
                tmpString += arr[j];
                if (tmp == rotate) {
                    hashSet.add(tmpString);
                    tmpString = "";
                    tmp = 0;
                }
            }
        }
        List<String> list = new ArrayList<>(hashSet);
        list.sort(Collections.reverseOrder());
        return Integer.parseInt(list.get(k - 1), 16);
    }
}
