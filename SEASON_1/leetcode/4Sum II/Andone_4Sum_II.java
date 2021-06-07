class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Set<Integer> set = new HashSet<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int item : nums1) {
            for(int item1 : nums2) {
                map.put(item+item1, map.getOrDefault(item+item1,0)+1);
            }
        }
        
        int answer = 0;
        
        for(int item : nums3) {
            for(int item1 : nums4) {
                answer += map.getOrDefault(-1*(item+item1),0);
            }
        }
        
        
        return answer;
    }
}