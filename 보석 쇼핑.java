// https://school.programmers.co.kr/learn/courses/30/lessons/67258

import java.util.*;

class Solution {
    static HashMap<String, Integer> hm = new HashMap<>();
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[0] = Integer.MAX_VALUE;
        answer[1] = Integer.MIN_VALUE;
        int size = new HashSet<String>(Arrays.asList(gems)).size();
        
        for (int i = 0; i < gems.length; i++) {
            hm.put(gems[i], i + 1);
            if (hm.size() == size) {
                break;
            }
        }
        
        for (String key : hm.keySet()) {
            answer[0] = Math.min(answer[0], hm.get(key));
            answer[1] = Math.max(answer[1], hm.get(key));
        }
        
        return answer;
    }
}
