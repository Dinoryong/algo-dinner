import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // 결과를 리턴해 줄 배열 answer, 사이즈는 임시로 record 길이
        String[] answer = new String[record.length
        // 결과에 포함되어야 출력 카운트 = Enter + Leave 개수 (Change는 출력하지 않으므로)
        int index = 0;
        
        // 유저의 고유 정보를 저장할 hashmap, key:uid, value:nickname
        HashMap<String, String> map = new HashMap<>();
        
        for(int i=0; i<record.length; i++) {
            // 공백을 기준으로 데이터를 파싱하여 분기 처리
            // Enter, Leave일 때 : 결과(answer) 배열에 데이터(uid + 출력문구)를 추가
            // Enter, Change일 때 : 유저의 정보를 저장하는 map에 정보를 업데이트
            String[] data = record[i].split(" ");
            switch(data[0]) {
                case "Enter":
                    answer[index++] = data[1] + "님이 들어왔습니다.";
                    map.put(data[1], data[2]);
                    break;
                case "Leave":
                    answer[index++] = data[1] + "님이 나갔습니다.";
                    break;
                case "Change":
                    map.put(data[1], data[2]);
                    break;
            }
        }
        
        // 결과 배열에 저장되어 있는 uid를 읽어와 hashmap에 저장된 nickname을 찾음
        // 기존 uid를 찾은 nickname으로 값을 변경해 줌
        // ex) uid1234님이 들어왔습니다. => Prodo님이 들어왔습니다.
        for(int i=0; i<index; i++) {
            String uid = answer[i].substring(0, answer[i].indexOf("님"));
            String nickName = map.get(uid);
            answer[i] = answer[i].replace(uid, nickName);
        }
        
        // Change의 경우 출력되지 않으므로, 배열 사이즈를 조정함
        answer = Arrays.copyOf(answer, index);
        return answer;
    }
}
