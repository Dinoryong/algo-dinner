import Foundation

func solution(_ jobs:[[Int]]) -> Int {
    var sortedJobs = jobs.sorted {
        if $0[0] == $1[0] {
            return $0[1] < $1[1]
        }
        return $0[0] < $1[0]
    }
    var pq = [[Int]]()
    var answer = 0
    var time = 0

    while  !sortedJobs.isEmpty || !pq.isEmpty {
        while !sortedJobs.isEmpty {
            if sortedJobs[0][0] <= time {
                pq.append(sortedJobs.removeFirst())
            } else {
                break
            }
        }
        if !pq.isEmpty {
            pq.sort { $0[1] < $1[1] }
            time += pq.first![1]
            answer += time - pq.first![0]
            pq.removeFirst()
        } else {
            time = sortedJobs[0][0]
        }
    }
    return answer / jobs.count
}
