class Solution {
    var notPrime = Array<Boolean>(10000000){false}
    var primes = ArrayList<IntArray>()
    init {
            notPrime[1] = true
        	for(i in 4 until 10000000 step 2) notPrime[i] = true

            for(i in 2 until 10000000) {
                if(notPrime[i]) continue
                var nums = IntArray(10)
                var str = i.toString()
                for(c in str) {
                    nums[c.toInt() - '0'.toInt()]++
                }
                primes.add(nums)
                for(j in i+i+i until 10000000 step i*2) {
                    notPrime[j] = true
                }
            }
    }
    fun solution(numbers: String): Int {
        var answer = 0
        var nums = IntArray(10)
        for(c in numbers){
            nums[c.toInt()- '0'.toInt()]++
        }
        nums.forEach{println("$it ")}
        println()
        for(arr in primes) {
            var find = true
            for(j in 0 .. 9){
                if(arr[j] > nums[j]) {
                    find = false;
                    break;
                }
            }
            if(find) answer++
        }
        return answer
    }
}