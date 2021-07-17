"""

"""
#
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        lookup = set()
        output = set()
        N = len(s)
        for i in range(10, N+1):
            if s[i-10:i] not in lookup:
                lookup.add(s[i-10:i])
            elif s[i-10:i] not in output:
                output.add(s[i-10:i])

        return list(output)

