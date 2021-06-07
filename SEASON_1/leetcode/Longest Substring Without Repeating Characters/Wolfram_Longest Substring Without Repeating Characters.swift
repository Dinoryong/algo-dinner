// Solved by Wolfram Hwang
// 투포인터 문제네요.
// 근데 덱을 쓰면 더쉽게풀수있는문제!


class Solution {
    func lengthOfLongestSubstring(_ s: String) -> Int {
        if s == "" {
            return 0
        }
        var arr: [Character] = []
        var dic : [Character: Int] = [Character: Int]()
        for c in s {
            arr.append(c)
        }
        var start = 0
        dic[arr[start]] = 1
        var end = 1
        var ans = 1
        while start <= end {
            if end - start > ans {
                ans = end - start
            }
            if start >= arr.count {
                break
            }
            
            
            if end < arr.count{
                if let v = dic[arr[end]] {
                    if v == 0 {
                        dic[arr[end]]? += 1
                        end += 1
                    }else {
                        dic[arr[start]]? -= 1
                        start += 1
                    }
                }else{
                    dic[arr[end]] = 1
                    end += 1
                }
            }else{
                dic[arr[start]]? -= 1
                start += 1
            }
        }
        return ans
    }
}

  
