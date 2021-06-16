class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] table = new boolean[s.length() + 1];

        table[0] = true;

        Set<String> sets = new HashSet<>(wordDict);

        for (int i = 1; i < table.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (table[j]) {
                    if (sets.contains(s.substring(j, i))) {
                        table[i] = true;
                        break;
                    }
                }
            }
        }
        return table[table.length -1];
    }
}
