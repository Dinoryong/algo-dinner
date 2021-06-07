class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int totalBlock = brown + yellow;
        for(int i=3;i<=Math.sqrt(totalBlock);i++) {
            if(totalBlock%i == 0) {
                int yellowNum = (i-2) * (totalBlock/i - 2);
                if(yellowNum == yellow) {
                    answer[0] = totalBlock/i;
                    answer[1] = i;

                    break;
                }
            }
        }

        return answer;
    }
}