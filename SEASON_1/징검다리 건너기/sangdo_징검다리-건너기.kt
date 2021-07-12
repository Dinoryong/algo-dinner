// binary search
// 이유: x명이 건널수 있으면 자연스럽게 1 ~ x-1명도 건널 수 있다. ==> 건널 수 있는 인원을 기준으로 바이너리 서치를 돌린다. ==> 시간복잡도 O(Log(200000000))
// 또한, 한 명이 건너면 돌의 높이가 1씩 빠진다 == x명이 건너면 돌의 높이가 x가 빠진다 == x번째 사람은 돌의 높이가 x 이상인 돌만 밟고 건너야한다.
// 즉, x 이상인 돌들의 높이 사이가 k보다 작은지 보고, k보다 작게 돌들을 건널 수 있으면 x명은 모두 돌을 건널 수 있는 것이 된다. ==> O(N)의 시간 복잡도
// x명을 0 ~ 200000000로 바이너리 서치로 찾으면 시간복잡도는 Log(200000000)*O(N) 이되고, 32*O(N)정도라고 보면 된다.

class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = 0
        var s = 1
        var e = 200_000_000
        while(s < e) {
            var cango = true
            var prev = -1
            var m = (s+e)/2
            for(i in stones.indices){
                if(stones[i] >= m) {
                    if(i - prev > k) {
                        cango = false
                        break
                    }                        
                    prev = i
                }
            }
            if(cango && stones.size - prev <= k) s = m+1
            else e = m
        }
        return e-1
    }
}
