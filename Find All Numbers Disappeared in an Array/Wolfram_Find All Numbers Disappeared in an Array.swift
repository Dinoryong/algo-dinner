// Solved by Wolfram Hwang
// Space Complexity를 추가적으로 사용하지 않고 Time Complexity를 O(N)으로 푸는문제인데요..
// Swift는 인자로 들어오는 nums arrary가 상수로들어오기 때문에 값을 변경할수가없습니다.
// 그래서 추가 공간을 쓰지 않으려면.. 배열의 가변성을 활용해야하는데
// 이 문제에서 swift언어는 활용하지 못하고, 새로운 배열을 추가 선언해줘서 반드시 움직일수 있게끔 만들어주는 과정을 내포하고있기에
// 그냥 추가 배열을 선언해서 체크하는게 더 낫다는 판단을했습니다.


class Solution {
    func findDisappearedNumbers(_ nums: [Int]) -> [Int] {
        var ans : [Int] =  []
        var check: [Bool] = [Bool](repeating: false, count : nums.count + 1)
        for num in nums {
            check[num] = true
        }
        
        for i in 1...nums.count {
            if check[i] == false {
                ans.append(i)
            }
        }
        return ans
    }
}
