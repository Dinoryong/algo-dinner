// Solved by Wolfram Hwang
// dict 로 유일한 ID값을 관리하면 쉬운 문제입니다.
// 이걸 처음부터 하나하나 바뀔때마다 바꿔주는것은 비효율적이니
// 나중에 다하면 한번에바꾸면 좋습니다.

import Foundation

func solution(_ record:[String]) -> [String] {
    let enter = "님이 들어왔습니다."
    let exit = "님이 나갔습니다."
    var dict : [String: String] = [String: String]()
    struct records {
        var userID = ""
        var action = ""
        init(_ ID: String, _ ACTION: String) {
            userID = ID
            action = ACTION
        }
    }
    var history: [records] = []
    for rc in record {
        let split = rc.split(separator: " ")
        if split[0] == "Change" {
            if let id = dict[String(split[1])] {
                dict[String(split[1])] = String(split[2])
            }
        }else{
            if split[0] == "Enter" {
                if let id = dict[String(split[1])] {
                    dict[String(split[1])] = String(split[2])
                }else{
                    dict[String(split[1])] = String(split[2])
                }
                history.append(records(String(split[1]), enter))
            }else{
                history.append(records(String(split[1]), exit))
            }
        }
    }
    var ans : [String] = []
    for his in history {
        if let uidtoID = dict[his.userID] {
            ans.append(uidtoID + his.action)
        }
    }
    return ans
}
