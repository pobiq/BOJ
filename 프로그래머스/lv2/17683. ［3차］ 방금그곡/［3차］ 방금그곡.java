import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        m = replace(m);
		ArrayList<String>[] list = new ArrayList[musicinfos.length];
		
		for(int i=0; i<musicinfos.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		int index = 1000;
		int time = -1;
		
		for(int i=0; i<musicinfos.length; i++) {
			String[] temp = musicinfos[i].split(",");
			String startTime = temp[0];
			String[] start = startTime.split(":");
			String endTime = temp[1];
			String[] end = endTime.split(":");
			String songName = temp[2];
			list[i].add(songName);
			
			String note = replace(temp[3]);
			
			int playTime = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60 +
					Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
			list[i].add(String.valueOf(playTime));
			
			StringBuffer play = new StringBuffer();
			for(int j=0; j<playTime; j++) {
				char c = note.charAt(j%note.length());
				play.append(c);
			}
			
			if(play.toString().contains(m)) {
				list[i].add("true");
			} else {
				list[i].add("false");
			}
			
			if(list[i].get(2).equals("true") && time <= playTime) {
				if(time < playTime) {
					time = playTime;
					index = i;
				}else if(time == playTime) {
					time = playTime;
					if(index > i) {
						index = i;
					}
				}
			}
			
			
			list[i].add(play.toString());
		}
		
		if(time == - 1) {
			answer = "(None)";
		} else {
			answer = list[index].get(0);
		}
        
        return answer;
    }
    
    static String replace(String s) {
		s = s.replaceAll("C#", "H");
		s = s.replaceAll("D#", "I");
		s = s.replaceAll("F#", "J");
		s = s.replaceAll("G#", "K");
		s = s.replaceAll("A#", "L");
		return s;
	}
    
}