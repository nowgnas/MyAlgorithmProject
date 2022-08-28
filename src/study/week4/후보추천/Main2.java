package study.week4.후보추천;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main2 {
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
        List<Student> queue = new ArrayList<>();
        int[] vote = new int[101];
        student = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < student.length; i++) {
            int no = student[i];
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
                    // 후보 개수 만족 못했을 경우
                    vote[no] += 1;
                    queue.add(new Student(no, i, vote[no]));
                }

            } else {
                // 후보 추천에 없는 경우
                Collections.sort(queue);
                if (vote[no] == 0) {
                    Student cur = queue.remove(0); // 다 찬 경우 새 후보 추천
                    vote[cur.no] = 0;
                    vote[no] += 1;
                    queue.add(new Student(no, i, vote[no]));
                } else {
                    // 후보에 있는 경우
                    vote[no] += 1;
                    for (Student item :
                            queue) {
                        if (item.no == no) item.vote = vote[no];
                    }
                }
            }
        }
        int[] answer = new int[N];
        for (int i = 0; i < queue.size(); i++) {
            answer[i] = queue.get(i).no;
        }
        Arrays.sort(answer);
        for (int i = 0; i < N; i++) {
            if (answer[i] != 0)
                System.out.print(answer[i] + " ");
        }
    }
}

/*

3
10
3 4 3 3 1 2 4 1 5 7

*/