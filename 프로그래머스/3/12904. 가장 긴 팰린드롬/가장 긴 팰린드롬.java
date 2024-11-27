class Solution
{
public int solution(String s) {
    int n = s.length();

    char[] array = s.toCharArray();

    for(int length = n; length >= 2; length--) {
      for(int start_index = 0; start_index <= n-length; start_index++) {
        if(isPalindrome(array, start_index, length)) {
          return length;
        }
      }
    }
    return 1;
  }

  private boolean isPalindrome(char[] array, int startIndex, int length) {
    int width = length/2;
    int endIndex = startIndex + length - 1;

    for(int i = 0; i < width; i++) {
      if(array[startIndex+i] != array[endIndex-i]) {
        return false;
      }
    }
    return true;
  }
}