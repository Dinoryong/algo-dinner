import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        List<Integer> tempList;
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            tempList = new ArrayList<>();
            for (int k = commands[i][0]-1; k<commands[i][1]; k++) {
                tempList.add(array[k]);
            }
            Collections.sort(tempList);
            answerList.add(tempList.get(commands[i][2]-1));
        }
        answer = new int[answerList.size()];
        for(int i=0;i<answerList.size();i++){
            answer[i]=answerList.get(i);
        }

        return answer;
    }
}