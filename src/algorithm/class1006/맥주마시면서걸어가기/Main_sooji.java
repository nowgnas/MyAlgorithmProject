package algorithm.class1006.맥주마시면서걸어가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_sooji {
    static class node {
        int x, y;
        int dis;

        public node(int x, int y, int dis) { // 편의점이랑 집 거리나 ... 편의점에서 편의점 거리 ... 편의점이랑 락페 거리나 ...
            super();
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        public node(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(bf.readLine()); // 편의점의 개수

            // 집의 좌표
            String s[] = bf.readLine().split(" ");
            node home = new node(Integer.parseInt(s[0]), Integer.parseInt(s[1]));

            // 편의점의 좌표 + 마지막엔 락페 좌표
            node[] store = new node[N + 1];
            for (int i = 0; i < N + 1; i++) {
                String s2[] = bf.readLine().split(" ");
                store[i] = new node(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]), 0);
            }

            boolean flag = false; // 갈 수 있는 경우 없는 경우를 나타냄

            // 집이랑 편의점 + 락페까지 !
            for (int i = 0; i < N + 1; i++) {

                // 편의점 안거치고 바로 락페로 가는 경우 !
                if (Math.abs(home.x - store[N].x) + Math.abs(home.y - store[N].y) <= 1000) {
                    flag = true;
                    break;
                }

                int tmp = Math.abs(home.x - store[i].x) + Math.abs(home.y - store[i].y);
                if (tmp <= 1000)
                    home.x = store[i].x;
                home.y = store[i].y;
            }

            // 처음 출발한 좌표가 락페 똑같냐 ? happy
            if (flag) System.out.println("happy");
                // 아니면 sad
            else System.out.println("sad");


        } // test case
    } // main end

}