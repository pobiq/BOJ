class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String[] viedo_len_array = video_len.split(":");

    int video_length =
        Integer.parseInt(viedo_len_array[0]) * 60 + Integer.parseInt(viedo_len_array[1]);

    String[] pos_array = pos.split(":");

    int int_pos = Integer.parseInt(pos_array[0]) * 60 + Integer.parseInt(pos_array[1]);

    String[] op_start_array = op_start.split(":");

    int int_op_start = Integer.parseInt(op_start_array[0]) * 60 + Integer.parseInt(op_start_array[1]);

    String[] op_end_array = op_end.split(":");

    int int_op_end =
        Integer.parseInt(op_end_array[0]) * 60 + Integer.parseInt(op_end_array[1]);

    if(int_pos >= int_op_start && int_pos <= int_op_end) {
      int_pos = int_op_end;
    }

    for(String command : commands) {
      if (command.equals("next")) {
        int next_pos = int_pos + 10;
        int_pos = Math.min(next_pos, video_length);
      } else {
        int next_pos = int_pos - 10;
        int_pos = Math.max(next_pos, 0);
      }
      if (int_pos >= int_op_start && int_pos <= int_op_end) {
        int_pos = int_op_end;
      }
    }

      int answer_minute = int_pos / 60;
      int answer_second = int_pos % 60;

      answer = String.format("%02d", answer_minute) + ":" + String.format("%02d",
          answer_second);
        
        return answer;
    }
}