class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int i=1; i<triangle.length; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                int left = (j-1) < 0 ? 0 : triangle[i-1][j-1];
                int right = (j) >= triangle[i-1].length ? 0 : triangle[i-1][j];
                triangle[i][j] = Math.max(left, right) + triangle[i][j];
				
                if((i+1) == triangle.length) {
                    answer = Math.max(answer, (triangle[i][j]));
                }
            }
        }
        return answer;
    }
}
