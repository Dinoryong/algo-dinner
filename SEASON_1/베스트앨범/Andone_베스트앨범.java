//이 문제는.. java라 그런진 모르겠는데 노다가 성이 상당히.. 강하군요..

import java.util.*;
import java.util.stream.Collectors;

class Pair {
    Integer originalKey;
    Integer value;

    public Pair(Integer key, Integer value) {
        this.originalKey = key;
        this.value = value;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();

        Map<String, Integer> maps = new LinkedHashMap<>();
        Map<String, List<Pair>> allPairMap = new HashMap<>();


        //맵에 각 장르별 재생수의 합과 각 고유 번호에 따른 재생수를 Map에 저장한다.
        //재생수의 합은 장르마다의 재생수를 정렬하기 위한 기준이다.
        for (int i = 0; i < genres.length; i++) {
            maps.putIfAbsent(genres[i], 0);
            allPairMap.putIfAbsent(genres[i],new ArrayList());
            int now = i;
            maps.computeIfPresent(genres[i],(String key, Integer value) -> value+=plays[now]);
            allPairMap.computeIfPresent(genres[i], (s, pairs) -> {
                //pair 클래스를 추가해준다. Map의 computeIfPresent함수는 key에 해당하는 값을 찾아서 고친 Value의 값을 리턴해줘야 하기 때문에 pair를 추가해준 뒤 리스트를 리턴한다.
                pairs.add(new Pair(now, plays[now]));
                return pairs;
            });
        }

        
        //LinkedHashMap의 경우는 Map에 집어넣는 순서를 보장한다. 그러나, Map은 List가 아니기 때문에 Map Entry를 스트림으로 정렬한(value기준으로) 것을 List로 collect 해준다.
        List<Map.Entry> list = maps.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        List<String> sortedKey = new ArrayList();
        
        //나중에 꺼낼때 귀찮음을 방지하기 위한 list
        for(Map.Entry<String,Integer> key : list){
            sortedKey.add(key.getKey());
        }
        int genreNum=maps.size();

        //각 키마다 가지고 있는 list를 정렬해준다. 만약에 value가 같다면 original key의 오름차순으로 정렬해준다. (기본은 내림차순)
        for(String keys : maps.keySet()) {
            Collections.sort(allPairMap.get(keys),((o1, o2) -> {
                if(o1.value.compareTo(o2.value)==0) {
                    return o1.originalKey-o2.originalKey;
                } else {
                    return o2.value-o1.value;
                }
            }));
        }


        //각 리스트에서 2개씩 빼온다. 만약 1개라면 1개만 뽑는다.
        for(String key : sortedKey) {
            if(allPairMap.get(key).size()==1) {
                answerList.add(allPairMap.get(key).get(0).originalKey);
            } else {
                for(int i=0;i<2;i++) {
                    answerList.add(allPairMap.get(key).get(i).originalKey);
                }
            }
        }
        answer = new int[answerList.size()];
        for(int i=0;i<answer.length;i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}