package study.week4.문자열집합조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String X = br.readLine();
        String Y = br.readLine();
        String Z = br.readLine();
        int k = Integer.parseInt(br.readLine());

        String[] arr = new String[k];
        String[] arr2 = new String[k];
        String[] arr3 = new String[k];

        comb(0, 0, k, X, arr);
        comb(0, 0, k, Y, arr2);
        comb(0, 0, k, Z, arr3);

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String item :
                list) {
            if (hashMap.get(item) == null) {
                hashMap.put(item, 1);
            } else {
                int cnt = hashMap.get(item);
                hashMap.put(item, cnt + 1);
            }
        }
        List<String> list1 = new ArrayList<>();
        for (String item :
                hashMap.keySet()) {
            if (hashMap.get(item) > 1) list1.add(item);
        }
        if (list1.size() == 0) {
            System.out.println(-1);
            System.exit(0);
        }
        Collections.sort(list1);
        for (String item :
                list1) {
            System.out.println(item);
        }
    }

    static void comb(int cnt, int start, int pick, String string, String[] str) {
        if (cnt == pick) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length; i++) {
                sb.append(str[i]);
            }
            list.add(String.valueOf(sb));
            return;
        }

        for (int i = start; i < string.length(); i++) {
            str[cnt] = String.valueOf(string.charAt(i));
            comb(cnt + 1, i + 1, pick, string, str);

        }
    }
}
