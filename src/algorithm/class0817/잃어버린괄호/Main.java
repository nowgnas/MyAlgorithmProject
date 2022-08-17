package algorithm.class0817.잃어버린괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] minus = line.split("-");

        List<Integer> list = new ArrayList<>();
        int answer = 0;
        for (String item :
                minus) {
            int cnt = 0;
            String[] plus = item.split("[+]");
            for (String num :
                    plus) {
                cnt += Integer.parseInt(num);
            }
            list.add(cnt);
        }

        answer = list.get(0) * 2;
        for (Integer item :
                list) {
            answer -= item;

        }
        System.out.println(answer);
    }
}
