class Solution {
    public int maxArea(int[] height) {
        int size = 0;
        int p = 0 , q = height.length - 1;
        
        while(p < q){
            int d = q - p;
            size = Math.max(size, d * Math.min(height[p], height[q]));
            
            if(height[p] < height[q]) p++;
            else q--;
        }
        
        return size;
    }
}