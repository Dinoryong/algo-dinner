//중복조합을 직접 구현해서 일일이 비교해줬는데 효율성이 하위 5%이다.. 뭔가 이상하다.

class Solution {
    static List<List<Integer>> candidateList;

    void combi(int[] candidate, int n, int r, int start, ArrayList<Integer> list) {
        if(r==0) {
            candidateList.add((List<Integer>) list.clone());
            return;
        }

        for(int i=start; i<n; i++) {
            list.add(candidate[i]);
            combi(candidate,n,r-1,i, list);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        candidateList = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        int cnt = 0;
        Arrays.sort(candidates);
        int minimum = 0;
        while (minimum<=target) {
            minimum+=candidates[0];
            cnt++;
        }
        for(int i=1;i<cnt;i++) {
            combi(candidates, candidates.length, i, 0, new ArrayList<Integer>());
        }
        for(List<Integer> item : candidateList) {
            int total = 0;
            for(int t : item) {
                total += t;
            }
            if(total == target) {
                answer.add(item);
            }
        }

        return answer;
    }
}