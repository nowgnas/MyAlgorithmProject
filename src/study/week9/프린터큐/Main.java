package study.week9.프린터큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int tc, n, m;
    static BufferedReader br;
    static StringTokenizer st;

    static class Node {
        int idx, val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 문서 개수
            m = Integer.parseInt(st.nextToken()); // 궁금한 문서
            st = new StringTokenizer(br.readLine());
            List<Node> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(new Node(j, Integer.parseInt(st.nextToken())));
            }
            int cnt = 0;
            while (true) {
                int maxVal = Integer.MIN_VALUE;
                for (Node n :
                        list) {
                    if (maxVal < n.val) {
                        maxVal = n.val;
                    }
                }
                if (maxVal != list.get(0).val) {
                    Node tmp = list.remove(0);
                    list.add(tmp);
                } else if (maxVal == list.get(0).val && m != list.get(0).idx) {
                    list.remove(0);
                    cnt++;
                } else if (maxVal == list.get(0).val && m == list.get(0).idx) {
                    cnt++;
                    break;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb.toString());

    }
}