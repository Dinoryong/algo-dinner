// Solved by Wolfram hwang
// N*N 복잡도를 가진 구현 방법입니다.


class Solution {
    func fourSumCount(_ nums1: [Int], _ nums2: [Int], _ nums3: [Int], _ nums4: [Int]) -> Int {
        var arr1: [Int: Int] = [Int: Int]()
        for n1 in nums1 {
            for n2 in nums2 {
                if let v = arr1[n1 + n2] {
                    arr1[n1 + n2]? += 1
                }else{
                    arr1[n1 + n2] = 1
                }
            }
        }
        var ans = 0
        for n1 in nums3 {
            for n2 in nums4 {
                let cnt = -(n1 + n2)
                ans += arr1[cnt] ?? 0
            }
        }
        return ans
    }
}

