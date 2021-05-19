import java.util.*;

class Solution {
    // n의 길이만큼 이진수 앞에 0을 채우는 함수
    public String padZero(String binary, int diff) {
        for(int i=0; i<diff; i++) {
            binary = "0" + binary;
        }
        return binary;
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++) {
            // 이진수 변환
            String binary1 = Integer.toBinaryString(arr1[i]);
            String binary2 = Integer.toBinaryString(arr2[i]);
            
            // n의 길이만큼 이진수 앞에 0을 채움
            int diff1 = n - binary1.length();
            int diff2 = n - binary2.length();
            binary1 = padZero(binary1, diff1);
            binary2 = padZero(binary2, diff2);
            
            // 이진수 binary1과 binary2를 자리 수마다 비교
            // 모두 0일 경우 공백, 하나라도 1일 경우 #
            String s = "";
            for(int j=0; j<n; j++) {
                if(binary1.charAt(j) == '0' && binary2.charAt(j) == '0') s += " ";
                else s += "#";
            }
            answer[i] = s;
        }
        return answer;
    }
}
