class Solution {
   func threeSum(_ nums: [Int]) -> [[Int]] {
        var ret = [[Int]]()
      
        let nums = nums.sorted()
        var idx = 0        
        while idx < (nums.count - 2) {
            
            var start = idx + 1
            var end = nums.count - 1
            
            while start < end {
                let sum = nums[idx] + nums[start] + nums[end]                
                if sum == 0 {
                    ret.append([nums[idx], nums[start], nums[end]])
                }                    
                if sum < 0 {
                    let currentStart = start
                    while start < end && nums[start] == nums[currentStart] {
                        start += 1
                    }
                } else {
                    let currentEnd = end
                    while start < end && nums[end] == nums[currentEnd] {
                        end -= 1
                    }
                }   
            }            
            let cidx = idx
            while idx < (nums.count - 2) && nums[idx] == nums[cidx] {
                idx += 1
            }
        }
        
        return ret
    }
}
