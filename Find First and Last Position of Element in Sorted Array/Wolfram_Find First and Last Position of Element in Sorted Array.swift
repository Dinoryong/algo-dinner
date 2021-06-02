class Solution {
    func lower_bound (_ arr: [Int], _ target : Int)->Int {
        var start = 0, end = arr.count - 1
        while end > start {
            let mid = (start + end) / 2
            if arr[mid] >= target {
                end = mid
            }
            else{
                start = mid + 1
            }
        }
        return end
    }
    
    func upper_bound (_ arr: [Int], _ target : Int)->Int {
        var start = 0, end = arr.count - 1
        while end > start {
            let mid = (start + end) / 2
            if arr[mid] > target {
                end = mid
            }
            else{
                start = mid + 1
            }
        }
        return end
    }

    func searchRange(_ nums: [Int], _ target: Int) -> [Int] {
        var ar : [Int] = [Int.min]
        ar += nums
        ar.append(Int.max)
        if nums.count == 0 {
            return [-1, -1]
        }
        let lower = lower_bound(ar, target)
        let upper = upper_bound(ar, target)
        print(ar[lower])
        print(ar[upper - 1])
        if ar[lower] <= target && ar[upper - 1] >= target{
            return [lower - 1, upper - 2]
        }
        return [-1, -1]        
    }
}
