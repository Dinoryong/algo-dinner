class Solution {
    public int solution(int[] a) {
        int answer = -1;

        int[] keys = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            keys[a[i]]++;
        }

        for (int j = 0; j < a.length; j++) {
            int temp = 0;
            if (keys[j] == 0) continue;
            if (keys[j] <= answer) continue;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] != j && a[i + 1] != j) continue;
                if (a[i] == a[i + 1]) continue;
                temp++;
                i++;
            }
            answer = Math.max(temp, answer);
        }

        return answer * 2;
    }
}