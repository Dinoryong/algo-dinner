/*
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 

Constraints:

1 <= s.length <= 105
s[i] is either 'A', 'C', 'G', or 'T'.
Accepted
*/
// Solved by Wolfram Hwang

class Solution {
    func findRepeatedDnaSequences(_ s: String) -> [String] {
        if s.count < 10 {
            return []
        }
        var map : [String : Int] = [String: Int]()
        var str : Set<String> = Set<String>()
        var arr : [String] = []
        for c in s {
            arr.append(String(c))
        }
        var last = 10
        var comp = ""
        for i in 0..<10 {
            comp += arr[i]
        }
        map[comp] = 1
        while last < arr.count {
            comp.removeFirst()
            comp += arr[last]
            if let v = map[comp] {
                str.insert(comp)
            }else{
                map[comp] = 1
            }
            last += 1
        }
        var ans = [String]()
        for x in str {
            ans.append(x)
        }
        return ans
    }
}
