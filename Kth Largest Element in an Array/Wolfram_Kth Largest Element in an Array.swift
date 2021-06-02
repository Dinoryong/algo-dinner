class Solution {
    func split(data: [Int]) -> [Int] {
        if data.count <= 1 { return data } 	//#1
        let medium = Int(data.count / 2)	//#2
    
        let left = split(data: Array(data[0..<medium])) 	//#3
        let right = split(data: Array(data[medium...]))
    
        return merge(left, right)	//#4
    }

    func merge(_ left: [Int], _ right: [Int]) -> [Int] {
        var merged: [Int] = []	//#1
        var leftPoint = 0		//#2
        var rightPoint = 0
        while left.count > leftPoint, right.count > rightPoint {
            if left[leftPoint] > right[rightPoint] {	//#4
                merged.append(right[rightPoint])
                rightPoint += 1
            }else {
                merged.append(left[leftPoint])
                leftPoint += 1
            }
        }
    
        //#5
        while left.count > leftPoint {
            merged.append(left[leftPoint])
            leftPoint += 1
        }
    
        while right.count > rightPoint {
            merged.append(right[rightPoint])
            rightPoint += 1
        }
    
        return merged
    }

    func findKthLargest(_ nums: [Int], _ k: Int) -> Int {
        var merge : [Int] = split(data: nums)
        return merge[nums.count - k]
    }
}
