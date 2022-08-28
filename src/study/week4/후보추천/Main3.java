package study.week4.후보추천;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main3 {
    static int N, recommend;
    static int[] student;

    static class Student implements Comparable<Student> {
        int no, create, vote;

        public Student(int no, int create, int vote) {
            this.no = no;
            this.create = create;
            this.vote = vote;
        }

        @Override
        public int compareTo(Student o) {
            if (this.vote == o.vote) {
                return this.create - o.create;
            }
            return this.vote - o.vote;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        recommend = Integer.parseInt(br.readLine());

        // 학생 번호, 생성 시점, 투표 수
        Queue<Student> queue = new PriorityQueue<>();
        int[] vote = new int[101];
        student = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < recommend; i++) {
            int no = student[i];
            // 추천 수 만큼 돌면서
            if (queue.size() < N) {
                int flag = 0;
                for (Student item :
                        queue) {
                    if (item.no == no) {
                        vote[no] += 1;
                        item.vote = vote[no];
                    } else flag += 1;
                }
                if (flag == queue.size()) {
                    vote[no] += 1;
                    queue.offer(new Student(no, i, vote[no]));
                }
            } else {
                if (vote[no] == 0) {
                    Queue<Student> temp = new PriorityQueue<>();
                    int size = queue.size();
                    for (int j = 0; j < size; j++) {
                        temp.offer(queue.remove());
                    }
                    queue = temp;
                    // 정렬을 다시 해야 함
                    Student cur = queue.remove();
                    vote[cur.no] = 0;
                    vote[no] += 1;
                    queue.offer(new Student(no, i, vote[no]));
                } else {
                    vote[no] += 1;
                    for (Student item :
                            queue) {
                        if (item.no == no) item.vote = vote[no];
                    }
                }
            }

        }
        int[] answer = new int[N];
        int idx = 0;
        for (Student item :
                queue) {
            answer[idx] = item.no;
            idx++;
        }
        Arrays.sort(answer);
        for (int item :
                answer) {
            if (item != 0)
                System.out.print(item + " ");
        }
    }
}
/*

3
10
3 4 3 3 1 2 4 1 5 7

3
14
2 1 4 3 5 6 2 7 2 100 100 54 54 50

50 54 100

3
9
2 2 4 3 5 6 2 7 2

2 6 7

3
2
1 1
====1

2
11
1 2 2 2 3 3 1 1 1 3 3
====1 3

*/