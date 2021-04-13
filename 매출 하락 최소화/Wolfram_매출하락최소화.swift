// Solved By Wolfram Hwang
// 문제가 어려웠네요.
// 트리형 DP이긴합니다만.
// DP의 본질은 대부분 써도 괜찮은지 안괜찮은지에 대한 여부라고 생각해요 -> In 기업 입사 시험
// 이번문제도 비슷했는데, 자식들중 쓰냐 안쓰냐를 가지고 내가 쓸지 안쓸지 여부를 판단해서
// 값을 계속 갱신해 나가면 됐습니다.


import Foundation

var dp : [[Int]] = [[Int]]()
var graph: [[Int]] = [[Int]]()
var sale:[Int] = [0]
func go(_ now : Int) {
    if graph[now].count == 0 {
        dp[now][0] = 0
        dp[now][1] = sale[now]
        return
    }
    for next in graph[now]  {
        go(next)
    }
    dp[now][1] += sale[now]
    var isOK = false
    for next in graph[now] {
        dp[now][1] += min(dp[next][0], dp[next][1])
	// 일단 자식에서 쓰는지, 안쓰는지 중 최솟값을 넣어주는데.. 만약  쓴다면 체크해줌( 최소 자식 중 한명이라도 써야하는 상황을 만족했기 때문임 )
        if dp[next][0] > dp[next][1] {
            dp[now][0] += dp[next][1]
            isOK = true
        }else{
            dp[now][0] += dp[next][0]
        }
    }
//만약 자식들 중 한개도 쓰지않는다면, 그중에서 최소 결괏값을 넣어주게됌
    if isOK == false{
        var mx = 987654321
        for next in graph[now] {
            dp[now][0] -= dp[next][0]
            dp[now][0] += dp[next][1]
            if dp[now][0] < mx {
                mx = dp[now][0]
            }
            dp[now][0] -= dp[next][1]
            dp[now][0] += dp[next][0]
        }
        dp[now][0] = mx
    }
}
func solution(_ sales:[Int], _ links:[[Int]]) -> Int {
    // 부모 사용 O = min( 자식 사용안하는 애들 중 최소 , 사용하는 애들 중 최소) +  자기 자신
    // 부모 사용 X = 자식에서 min(사용, 안사용) 근데 아무도 안사용하면, 그중에서 가장 결과 최소값을 넣어준다.
    graph = [[Int]](repeating: [], count: sales.count + 1)
    dp = [[Int]](repeating: [0,0], count: sales.count + 1)// n x 2
    for tuple in links {
        graph[tuple[0]].append(tuple[1])
    }
    for i in sales {
        sale.append(i)
    }
    //dp[10][0]
    go(1)
    return min(dp[1][0], dp[1][1])
}

