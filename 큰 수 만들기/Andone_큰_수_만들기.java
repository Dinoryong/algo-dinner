import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        char[] numberArr = number.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int endpoint = number.length();
        deque.push(numberArr[0]);
        if(number.length()==1) {
            return number;
        }

        for (int i = 1; i < number.length(); i++) {
            if (!deque.isEmpty() && deque.peek() < numberArr[i]) {
                deque.pop();
                count++;
                i--;
            } else {
                deque.push(numberArr[i]);
            }
            if(count==k) {
                endpoint=i;
                while (!deque.isEmpty()) {
                    sb.append(deque.pollLast());
                }

                for(int j = endpoint+1; j < number.length(); j++) {
                    sb.append(numberArr[j]);
                }
                break;
            }
        }

        if(!deque.isEmpty()) {
            for(int i=0;i<number.length()-k;i++) {
                sb.append(deque.pollLast());
            }
        }

        return sb.toString();
    }
}