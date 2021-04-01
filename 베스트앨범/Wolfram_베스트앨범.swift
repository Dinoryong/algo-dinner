import Foundation
struct pair{
    var idx: Int
    var score: Int
    init(_ idx: Int, _ score: Int){
        self.idx = idx
        self.score = score
    }
    func getIdx()->Int{
        return self.idx
    }
}
func comp(_ left: pair, _ right: pair)->Bool{
    if(left.score > right.score){
        return true
    }
    else if left.score == right.score {
        return left.idx < right.idx
    }
    return false
}
func solution(_ genres:[String], _ plays:[Int]) -> [Int] {
    var genToCount: [String: Int] = [String: Int]()
    var genToIdx: [String: [pair]] = [String: [pair]]()
    
    var idx = 0
    var answer: [Int] = [Int]()
    for gen in genres{
        if let val = genToCount[gen]{
            genToCount[gen] = val + plays[idx]
        }else{
            genToCount[gen] = plays[idx]
        }        
        if var varr = genToIdx[gen]{
            let vall = pair(idx, plays[idx])
            varr.append(vall)
            genToIdx[gen] = varr
        }else{
            genToIdx[gen] = [pair]()
            let vall = pair(idx, plays[idx])
            genToIdx[gen]!.append(vall)
        }
        idx += 1
    }

    let order = genToCount.sorted{ (left: Dictionary<String, Int>.Element, right:  Dictionary<String, Int>.Element) -> Bool in
    return left.value > right.value
}
    for gen in order{
        var os:[pair] = [pair]()  
        if let vs = genToIdx[gen.key]{                 
           for x in vs{
               os.append(x)
           }
           let st = os.sorted(by: comp)
            //print(st)
           var idd = 0
           for vval in st{
               answer.append(vval.getIdx())
               idd += 1
               if idd == 2{
                   idd = 0
                   break
               }
           }
        }

    }

    return answer
}
