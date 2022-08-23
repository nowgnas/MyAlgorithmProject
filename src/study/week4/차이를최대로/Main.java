package study.week4.차이를최대로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int [] line;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();



    }
}
