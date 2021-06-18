class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        StringBuilder sb = new StringBuilder();
        String s = countAndSay(n - 1);
        char value = s.charAt(0);
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);

            if (target == value) {
                cnt++;
                continue;
            }

            sb.append(cnt).append(value);
            value = target;
            cnt = 1;
        }

        sb.append(cnt).append(value);

        return sb.toString();
    }
}