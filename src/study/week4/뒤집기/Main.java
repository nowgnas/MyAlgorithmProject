package study.week4.뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputs = br.readLine();

        String[] zero = inputs.split("0");
        String[] one = inputs.split("1");

        int zeroCnt = 0;
        int oneCnt = 0;

        for (String item :
                zero) {
            if (item.length() > 0) zeroCnt++;
        }

        for (String item :
                one) {
            if (item.length() > 0) oneCnt++;
        }

        if (oneCnt > zeroCnt) System.out.println(zeroCnt);
        else if (oneCnt < zeroCnt) System.out.println(oneCnt);
        else System.out.println(zeroCnt);
    }
}
