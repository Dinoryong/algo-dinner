class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] student = new int[n];

        for (int i = 0; i < n; i++) {
            student[i]++;
        }

        for (int steal : lost) {
            student[steal-1]--;
        }

        for (int giving : reserve) {
            student[giving-1]++;
        }

        for (int i = 0; i < n; i++) {
            if (student[i] == 2) {
                if (i != 0 && student[i - 1] == 0) {
                    student[i]--;
                    student[i - 1]++;
                } else if (i != n - 1 && student[i + 1] == 0) {
                    student[i]--;
                    student[i + 1]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (student[i] != 0) {
                answer++;
            }
        }

        return answer;
    }
}
