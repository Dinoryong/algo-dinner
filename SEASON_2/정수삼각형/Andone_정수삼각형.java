import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = -1;
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<triangle.length;i++) {
            list.add(new ArrayList<>());
        }
        
        list.get(0).add(triangle[0][0]);

        
        for(int i=1; i<triangle.length; i++) {
            for(int j = 0;j<triangle[i].length; j++) {
                if(j==0)
                    list.get(i).add(triangle[i][j]+list.get(i-1).get(0));
                else if(j==triangle[i].length-1)
                    list.get(i).add(triangle[i][j]+list.get(i-1).get(j-1));
                else {
                    list.get(i).add(Math.max(triangle[i][j]+list.get(i-1).get(j-1),triangle[i][j]+list.get(i-1).get(j)));
                }
            }
        }
        
        for(int item : list.get(triangle.length-1)) {
            answer = Math.max(answer,item);
        }
        
        return answer;
    }
}