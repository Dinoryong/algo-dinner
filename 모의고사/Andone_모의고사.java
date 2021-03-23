import java.util.*;

class Score {
    int name;
    int score;

    Score(int name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] one = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        List<Integer> answerList = new ArrayList<>();

        List<Score> scoreList = new ArrayList<>();
        scoreList.add(new Score(1, 0));
        scoreList.add(new Score(2, 0));
        scoreList.add(new Score(3, 0));

        for (int i = 0; i < answers.length; i++) {
            if (one[i%one.length] == answers[i]) {
                scoreList.get(0).score++;
            }
        }

        for (int i = 0; i < answers.length; i++) {
            if (two[i%two.length] == answers[i]) {
                scoreList.get(1).score++;
            }
        }

        for (int i = 0; i < answers.length; i++) {
            if (three[i%three.length] == answers[i]) {
                scoreList.get(2).score++;
            }
        }

        Collections.sort(scoreList, (o1, o2) -> o2.score - o1.score);

        answerList.add(scoreList.get(0).name);
        for (int i = 1; i < 3; i++) {
            if (scoreList.get(i - 1).score == scoreList.get(i).score)
                answerList.add(scoreList.get(i).name);
            else
                break;
        }

        answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}