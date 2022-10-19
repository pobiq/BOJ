import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
		Iterator<String> it = skillTrees.iterator();
		
		while(it.hasNext()) {
			String s = it.next();
			
			String b = s.replaceAll("[^"+ skill + "]", "");
			System.out.println(b + skill.indexOf(b));
			if(skill.indexOf(b) != 0) it.remove();
		}
		
		answer = skillTrees.size();
        return answer;
    }
}