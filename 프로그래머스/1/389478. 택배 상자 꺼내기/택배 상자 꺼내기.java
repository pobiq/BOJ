class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;

        int h = n / w;

        if(n % w != 0) {
            h++;
        }

        System.out.println(w + " " + h);

        int[][] array = new int[h][w];
        boolean type = true;
        int value = 1;

        loop:
        for(int i = h-1; i >= 0; i--) {
            if(type) {
                for(int j = 0; j < w; j++) {
                    array[i][j] = value++;
                    if(value == n+1) {
                        break loop;
                    }
                }
                type = false;
            } else {
                for(int j = w-1; j >= 0; j--) {
                    array[i][j] = value++;
                    if(value == n+1) {
                        break loop;
                    }
                }
                type = true;
            }
        }

        int r = 0;
        int c = 0;

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(array[i][j] == num) {
                    r = i;
                    c = j;
                    break;
                }
            }
        }

        while(true) {
            r--;
            if(r == -1 || array[r][c] == 0) {
                break;
            } else {
                answer++;
            }
        }
        
        return answer;
    }
}