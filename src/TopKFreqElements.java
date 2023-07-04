import java.util.*;

public class TopKFreqElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,2},2)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer> finalList = new ArrayList<>();
        HashMap<Integer,Integer> countMap = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            countMap.put(num,countMap.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            priorityQueue.add(entry.getValue());
        }

        while (k > 0){
            int value = priorityQueue.poll();
            for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
                if(entry.getValue() == value){
                    finalList.add(entry.getKey());
                    countMap.remove(entry.getKey());
                    break;
                }
            }
            k--;
        }
        return finalList.stream().mapToInt(Integer::intValue).toArray();
    }
}
