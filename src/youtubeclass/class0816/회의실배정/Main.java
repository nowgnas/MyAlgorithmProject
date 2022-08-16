package youtubeclass.class0816.회의실배정;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Meeting implements Comparable<Meeting> {
        int start, end; // 회의 시작, 종료 시간

        public Meeting(int start, int end) {
            super();
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) { // 종료 시간으로 오름차순 정렬, 같으면 시작시간 기준 오름차순
            return this.end != o.end ? this.end - o.end : this.start - o.start;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }
        List<Meeting> result = getSchedule(meetings);
        for (Meeting meeting :
                result) {
            System.out.println(meeting.start + " " + meeting.end);
        }
    }

    private static List<Meeting> getSchedule(Meeting[] meetings) {
        List<Meeting> result = new ArrayList<>();
        // 모든 회의를 종료시간 기준 오름차순, 종료시간 길면 시작 시간 기준 오름차순
        Arrays.sort(meetings);
        result.add(meetings[0]); // 첫 번째 회의는 무조건 추가

        for (int i = 1, size = meetings.length; i < size; i++) {
            if (result.get(result.size() - 1).end <= meetings[i].start) {
                result.add(meetings[i]);
            }
        }
        return result;

    }
}
