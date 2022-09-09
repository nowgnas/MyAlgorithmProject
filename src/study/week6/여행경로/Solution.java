package study.week6.여행경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    //    static String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
    static String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};


    public static void main(String[] args) {

        HashMap<String, List> hashMap = new HashMap<>();
        Arrays.sort(tickets, (o1, o2) -> {
            if (o1 == o2) {
                return (char) o1[1].charAt(0) - (char) o2[1].charAt(0);
            }
            return -1;
        });

        for (int i = 0; i < tickets.length; i++) {
            if (hashMap.get(tickets[i][0]) == null) {
                hashMap.put(tickets[i][0], new ArrayList<>());
                List temp = hashMap.get(tickets[i][0]);
                temp.add(tickets[i][1]);
                hashMap.replace(tickets[i][0], temp);
            } else {
                List temp = hashMap.get(tickets[i][0]);
                temp.add(tickets[i][1]);
                hashMap.replace(tickets[i][0], temp);
            }
        }
        List<String> answer = new ArrayList<>();
        String tmp = "ICN";
        answer.add(tmp);
        for (int i = 0; i < hashMap.size(); i++) {
            List next = hashMap.get(tmp);
            tmp = next.get(0).toString();
            answer.add(tmp);
        }

        for (String i :
                answer) {
            System.out.print(i + " ");
        }
    }
}
