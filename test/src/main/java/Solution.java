import java.util.ArrayList;

/**
 * Created by kelnor on 8/11/16.
 */
class Solution {
    public int solution(int X, int[] A) {
        ArrayList<Integer> matchIndices = new ArrayList<Integer>();
        int length = A.length;
        for(int i = 0; i < length; i++){
            if(A[i] == X){
                matchIndices.add(i);
            }
        }
        int count = 0;
        int matchSize = matchIndices.size();
        if(matchSize == 0){
            return length;
        }else {
            if (matchSize == length) {
                return 0;
            }else {
                for (int i = matchSize - 1; i >= 0; i--) {
                    Integer index = matchIndices.get(i);
                    int numNonMatch = length - count - index - 1;
                    int numMatch = i + 1;
                    if (numMatch <= numNonMatch) {
                        return (index + (numNonMatch - numMatch) + 1);
                    }
                    count++;
                }
                Integer lastIndex = matchIndices.get(0);
                return lastIndex; //The last checked match index still had more matches than non matches. Can only happen when non matches = 0 which means every higher index matched. Answer is lastIndex, so 0 matches in first array, 0 non-matches in last array.
            }
        }
    }
}