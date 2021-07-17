class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        N = len(gas)
        maxlen = 0
        tank = 0
        for i in range(N*2):
            tank += (gas[i%N] - cost[i%N])
            if tank >= 0:
                maxlen += 1
            else:
                maxlen = 0
            tank = max(tank, 0)

        if maxlen >= N:
            return (N*2) - maxlen
        else:
            return -1