package codingtest.kakaoblind2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class prob1 {
    static String today = "2022.05.19";
    static String[] terms = {"A 6", "B 12", "C 3"},
            privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};


    public static void main(String[] args) {
        /*
         * 1번부터 n번까지 개인정보가 분류된다
         * 유효기간이 지나면 폐기 해야 한다
         * 모든 달은 28일까지 있다
         * 오늘 날짜로 파기해야 할 개인정보 구하기
         */
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        String[] todayList = today.split("\\.");
        int todayYear = Integer.parseInt(todayList[0]);
        int todayMonth = Integer.parseInt(todayList[1]);
        int todayDay = Integer.parseInt(todayList[2]);

        for (String t :
                terms) {
            String[] arr = t.split(" ");
            hashMap.put(arr[0], Integer.parseInt(arr[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] arr1 = privacies[i].split(" ");
            String startDay = arr1[0];
            String term = arr1[1];

            String[] arr2 = startDay.split("\\.");
            int year = Integer.parseInt(arr2[0]);
            int month = Integer.parseInt(arr2[1]);
            int day = Integer.parseInt(arr2[2]);

            int newYear = 0;
            int newMonth = 0;
            int newDay = 0;

            int termDay = hashMap.get(term);
            if (termDay == 12) {
                newYear = year + 1;
                newMonth = month - 1;
                newDay = day - 1 == 0 ? 28 : day - 1;
            } else {

                newDay = day + (hashMap.get(term) * 28) - 1;
                int addMonth = 0;
                if (newDay > 28) {
                    addMonth = newDay / 28;
                    newDay = newDay % 28 == 0 ? day : newDay % 28;
                }
                newMonth = month + addMonth;
                int addYear = 0;
                if (newMonth > 12) {
                    addYear = newMonth / 12;
                    newMonth = newMonth % 12 == 0 ? newMonth : newMonth % 12;
                }
                newYear = year + addYear;
            }

            System.out.println(newYear + "." + newMonth + "." + newDay);
            if (newYear < todayYear) {
                list.add(i + 1);
            } else {
                if (newMonth < todayMonth) {
                    list.add(i + 1);
                } else {
                    if (newDay < todayDay) {
                        list.add(i + 1);
                    }
                }
            }
        }
        System.out.println(list);
//        return list;

    }
}
