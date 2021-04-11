//무슨 문제지..?

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < answer.length; i++) {
            int cnt = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j])
                    answer[i]++;
                else {
                    answer[i]++;
                    break;
                }

            }
        }

        return answer;
    }
}