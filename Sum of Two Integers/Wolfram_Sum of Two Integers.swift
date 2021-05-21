// Solved by Wolfram Hwang
// 굉장히 원초적인 문제입니다.
// 실제 컴퓨터 연산에서 비트를 통해 어떻게 더하고 곱해지고 빼지는지에 대해 생각해볼만한 문제네요.
// 컴퓨터에서 연산은 Exclusive OR연산과, 쉬프트 연산을 통해 구현을 하는데.
// 여기서 OR시 캐리가 생기지 않을 때 까지 반복해서 진행하면 +, -연산기호를 쓰지 않는 문제풀이가 가능합니다.
class Solution {
    func getSum(_ a: Int, _ b: Int) -> Int {
        var first = a
        var second = b
        while (first & second) != 0 {
            let c = first ^ second
            var d = first & second
            d = d << 1
            first = c
            second = d
        }
        return first | second
    }
}
