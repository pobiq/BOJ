import java.util.*;

class Solution {
  static class Process {
    int index;
    int priority;

    Process(int index, int priority) {
      this.index = index;
      this.priority = priority;
    }

    public String toString() {
      return "(" + index + ", "  + priority + ")";
    }
  }

  public int solution(int[] priorities, int location) {
    int answer = 0;

    Queue<Process> queue = new LinkedList<>();

    for(int i = 0; i < priorities.length; i++) {
      queue.add(new Process(i, priorities[i]));
    }

    int order = 0;

    while(!queue.isEmpty()) {

      // 1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
      Process main = queue.poll();

      // 2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
      boolean mostPriority = true;

      Iterator<Process> iterator = queue.iterator();

      while(iterator.hasNext()) {
        if(main.priority < iterator.next().priority) {
          queue.add(main);
          mostPriority = false;
          break;
        }
      }

      // 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
      if(mostPriority) {
        order++;
        // 3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
        if(main.index == location) {
          answer = order;
        }
      }
    }

    return answer;
  }
}