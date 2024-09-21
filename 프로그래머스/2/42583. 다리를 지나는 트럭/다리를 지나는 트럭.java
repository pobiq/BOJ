import java.util.*;

class Solution {
  static class Node {
    int weight;
    int enter_time;

    Node(int weight, int enter_time) {
      this.weight = weight;
      this.enter_time = enter_time;
    }

    @Override
    public String toString() {
      return "(" + weight + ", " + enter_time + ")";
    }
  }

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;

    Queue<Integer> waitingTrucks = new LinkedList<>();
    Queue<Node> goingTrucks = new LinkedList<>();
    Queue<Integer> goOverTrucks = new LinkedList<>();

    int n = truck_weights.length;
    int bridge_weight = 0;

    for(int truck_weight : truck_weights) {
      waitingTrucks.add(truck_weight);
    }

    while(goOverTrucks.size() < n) {
      answer++;

      if (!goingTrucks.isEmpty()) {
        Node temp = goingTrucks.peek();
        if(temp.enter_time + bridge_length == answer) {
          Node cur = goingTrucks.poll();
          goOverTrucks.add(cur.weight);
          bridge_weight -= cur.weight;
        }
      }

      if(!waitingTrucks.isEmpty()) {
        int truck = waitingTrucks.peek();
        if(bridge_weight + truck <= weight && goingTrucks.size() <= bridge_length) {
          goingTrucks.add(new Node(waitingTrucks.poll(), answer));
          bridge_weight += truck;
        }
      }
      
    }

    return answer;
  }
}