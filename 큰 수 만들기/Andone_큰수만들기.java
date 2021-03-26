import java.util.*;

class Solution {
    public void intToString(int[] numbers, String[] stringNumbers) {
        for (int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = Integer.toString(numbers[i]);
        }
    }

    public void sortStringArray(String[] stringNumbers) {
        Arrays.sort(stringNumbers, ((o1, o2) -> {
            String temp1 = o1+o2;
            String temp2 = o2+o1;

            if(Integer.parseInt(temp1) > Integer.parseInt(temp2)) {
                return -1;
            } else if (Integer.parseInt(temp1) < Integer.parseInt(temp2)) {
                return 1;
            } else {
                return 0;
            }

        }));
    }

    public String solution(int[] numbers) {
        String answer = "";
        String[] stringNumbers = new String[numbers.length];
        int sum = 0;
        for(int item : numbers) {
            sum+=item;
        }

        if(sum == 0) {
            return "0";
        }

        intToString(numbers, stringNumbers);

        //요소 비교
        sortStringArray(stringNumbers);

        //합치는 함수
        StringBuilder sb = new StringBuilder();

        for(String i : stringNumbers) {
            sb.append(i);
        }
        answer = sb.toString();
        return answer;
    }
}
