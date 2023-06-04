// https://school.programmers.co.kr/learn/courses/30/lessons/64063


// HashMap 재귀 함수 문제
import java.util.*;

class Solution {
    static HashMap<Long, Long> map = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++)
            answer[i] = findEmptyRoom(room_number[i]);
        return answer;
    }

    public Long findEmptyRoom(long room_num) {
        if (!map.containsKey(room_num)) { 
            map.put(room_num, room_num + 1); // 빈 방이면 map에 다음 방 번호까지 추가
            return room_num;
        }
        
        long empty = findEmptyRoom(map.get(room_num));
        map.put(room_num, empty);
        return empty;
    }
}
