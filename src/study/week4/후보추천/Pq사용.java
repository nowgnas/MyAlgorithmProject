package study.week4.후보추천;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Pq사용 {
    static class student {
        int no, rec, old; // 학생번호 추천수 오래된순

        public student(int no, int rec, int old) {
            super();
            this.no = no;
            this.rec = rec;
            this.old = old;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 사진틀 수
        int R = Integer.parseInt(bf.readLine()); // 추천 횟수

        int[] vote = new int[101];

        StringTokenizer st = new StringTokenizer(bf.readLine()); // 추천 받은 학생들
        PriorityQueue<student> pick = new PriorityQueue<>(new Comparator<student>() {

            @Override
            public int compare(student o1, student o2) {
                if (o1.rec == o2.rec) return o1.old - o2.old; // 2. 추천수 같은 경우 시간순
                return o1.rec - o2.rec; // 1. 추천수
            }

        }); // 사진틀에 추가된 사람들을 받을때  !

        int older = 1; // 시간 ..
        while (st.hasMoreTokens()) { // 추천 횟수만큼
            int num = Integer.parseInt(st.nextToken()); // 현재 추천 받은 학생 번호

            if (vote[num] != 0) { // 이미 추천 받았던 학생인 경우
                student[] tmp = new student[pick.size()];
                for (int i = 0; i < tmp.length; i++) {
                    tmp[i] = pick.poll();
                }
                pick.clear(); // pick 우선순위큐를 비우고
                for (student s : tmp) {
                    if (s.no == num) {
                        s.rec++; // 원래 있었던 친구의 추천수 +1
                        vote[num]++;
                    }
                    pick.offer(s); // 나머지는 그냥 다시 옮겨 넣기
                }
            } else if (pick.size() >= N) { // 사진틀이 꽉찬 경우
                student cur = pick.poll();
                vote[cur.no] = 0;
                vote[num]++;
                pick.offer(new student(num, 1, older++));
            } else { // 뉴페이스라면 ?!
                vote[num]++;
                pick.offer(new student(num, 1, older++)); // 큐에 그냥 추가 !
            }
        } // recommend end

        int[] result = new int[N]; // 결과 출력
        int idx = 0;
        while (!pick.isEmpty()) {
            result[idx++] = pick.poll().no;
        }

        // 최종 후보들을 오름차순으로 정렬
        Arrays.sort(result);

        // 출력 !
        for (int s : result) {
            if (s != 0)
                System.out.print(s + " ");
        }

    } // main end

}