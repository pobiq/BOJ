class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int bandCount = 0;
        int curHealth = health;
        int time = 0;
        int curTime = 0;
        
        for(int[] attack : attacks) {
            time = attack[0] - curTime - 1;
            curTime = attack[0];
            int fbCount = time / bandage[0];
            
            curHealth += bandage[1] * time;
            curHealth += fbCount * bandage[2];
            if(curHealth > health) {
                curHealth = health;
            }
            
            curHealth -= attack[1];
            if(curHealth <= 0) {
                curHealth = -1;
                break;
            }
            
        }
        
        
        
        return curHealth;
    }
}