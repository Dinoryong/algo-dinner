class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        unordered_map<string,int> DNA;
        vector<string> answer;
        
        if(s.length() < 10) return answer;
        
        for(int i=0;i<s.length()-9;i++){
            DNA[s.substr(i,10)]++;
        }
        
        for(auto dna : DNA){
            if(dna.second > 1)
                answer.push_back(dna.first);
        }
        
        return answer;
    }
};