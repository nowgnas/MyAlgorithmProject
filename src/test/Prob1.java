package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob1 {
    static class House {
        int y, x, d;

        public House(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            // 테스트 케이스 시작

            int N = Integer.parseInt(br.readLine());
            List<House> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int[] item = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                list.add(new House(item[0] + 15, item[1] + 15, item[2]));
            }
            boolean flag = false;
            map = new int[30][30];
            for (int j = 0; j < 30; j++) {
                for (int k = 0; k < 30; k++) {
                    for (int l = 0; l < list.size(); l++) {
                        House node = list.get(l);
                        if (node.d >= dist(node.y, node.x, j, k)) {
                            map[j][k] += 1;
                            flag = map[j][k] > 1;
                        }
                    }
                }
            }
            // flag가 true면 겹친다
            if (!flag && list.size() < 3) System.out.println("#" + i + " 2");
            else {
                // 중복 있음

            }
        }
    }

    static int dist(int y, int x, int y2, int x2) {
        return Math.abs(y - y2) + Math.abs(x - x2);
    }
}

/*

1
2
-2 0 1
1 3 2


 */