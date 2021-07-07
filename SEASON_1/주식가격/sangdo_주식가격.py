def solution(prices):
    answer = [0]*len(prices)
    st = []
    for i,v in enumerate(prices):
        while st and st[len(st)-1][0] > v:
            idx = st[len(st)-1][1]
            answer[idx] = i-idx
            st.pop()
            
        st.append((v,i))
        
    while st:
        idx = st[len(st)-1][1]
        answer[idx] = len(prices)-1 - idx
        st.pop()
        
    return answer
