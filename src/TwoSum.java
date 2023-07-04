import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        //nums = [2,7,11,15], target = 9
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums,9)));
    }
    private static int[] twoSum(int[] array , int target){
        HashMap<Integer,Integer> numbersMap = new HashMap<>();
        int index = 0;
        int[] result = new int[2];
        for(int number : array){
            if(numbersMap.containsKey(number)){
                result[0]=numbersMap.get(number);
                result[1]=index;
                return result;
            }
            numbersMap.put(target-number,index);
            index++;
        }
        return result;
    }
}
