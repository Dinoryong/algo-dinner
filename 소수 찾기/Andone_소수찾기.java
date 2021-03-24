import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    Set<Integer> lists = new HashSet<>();

    public Set<Integer> permute(String numbers) {
        char[] nums = numbers.toCharArray();
        for(int i = 1; i<=numbers.length();i++) {
            permutation(nums, new char[i], new boolean[nums.length], 0, nums.length, i);
        }
        return lists;
    }

    public void permutation(char[] nums, char[] outputs, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            for (char singleNum : outputs) {
                sb.append(singleNum);
            }
            insertToList(sb.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                outputs[depth] = nums[i];
                permutation(nums, outputs, visited, depth+1, n, r);
                visited[i] = false;
            }
        }
    }

    public void insertToList(String outputs) {
        lists.add(Integer.parseInt(outputs));
    }

    public int solution(String numbers) {
        int answer = 0;
        boolean[] prime = new boolean[10000001];
        prime[0] = prime[1] = true;

        for(int i=2; i*i<=prime.length-1; i++){
            // prime[i]가 소수라면
            if(!prime[i]){
                for(int j=i*i; j<=prime.length-1; j+=i) prime[j]=true;
            }
        }

        permute(numbers);

        for(int item : lists) {
            if(!prime[item]){
                answer++;
            }
        }

        return answer;
    }
}
