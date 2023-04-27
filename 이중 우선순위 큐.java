// 이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.

//             명령어	수신 탑(높이)
//             I 숫자	큐에 주어진 숫자를 삽입합니다.
//             D 1	큐에서 최댓값을 삭제합니다.
//             D -1	큐에서 최솟값을 삭제합니다.

// 이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 
// [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.

// 제한사항
// operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
// operations의 원소는 큐가 수행할 연산을 나타냅니다.
// 원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
// 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.

// 레벨 3은 대체로 어려울 때가 많았는데, 비교적 우선순위 큐만 알아도 쉽게 풀 수 있었던 문제. 이후에 좀 더 코드가 깨끗해졌으면 싶다.

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> low = new PriorityQueue<>(); // 낮은 숫자 순
        PriorityQueue<Integer> high = // 높은 숫자 순
            new PriorityQueue<>(Collections.reverseOrder());
        
        String[][] arr = new String[operations.length][2];
        
        for (int i = 0; i < operations.length; i++) {
            String[] split = operations[i].split(" ");
            arr[i][0] = split[0];
            arr[i][1] = split[1];
        }
        
        for (int j = 0; j < arr.length; j++) {
            String word = arr[j][0];
            int value = Integer.parseInt(arr[j][1]);
            if (word.equals("I")) { // 양쪽 우선순위 큐에 모두 값을 삽입
                low.add(value);
                high.add(value);
            } else if (word.equals("D")) {
                if (low.isEmpty()) { // 큐가 비어있으면 무시한다.
                    continue;
                } else {
                    if (value == 1) { // 최대값을 제거한다.
                       int highVal = high.poll(); 
                        low.remove(highVal); // 최대값을 최소값 우선순위 큐에서도 제거한다.
                    } else {
                        int lowVal = low.poll();
                        high.remove(lowVal); // 마찬가지로 최소값을 최대값 우선순위 큐에서 제거한다.
                    }
                }
            }
        }
        
        if (low.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = high.poll();
            answer[1] = low.poll();
        }
        return answer;
    }
}
