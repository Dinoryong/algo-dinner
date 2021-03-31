"""

zip()
Counter()
sort()
(https://wikidocs.net/16041)
hash()


"""
def solution(participant, completion):
    participant.sort()
    completion.sort()

    for i in range(len(completion)):
        if participant[i] != completion[i]:
            return participant[i]

    return participant[i+1]