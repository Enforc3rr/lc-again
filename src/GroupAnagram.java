import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{""}));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)
            return null;
        ArrayList<List<String>> finalListOfList = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            String sortedStr = sortedString(str);
            if(map.containsKey(sortedStr)){
                map.get(sortedStr).add(str);
            }else{
                map.put(sortedStr,new ArrayList<>(List.of(str)));
            }
        }
        for(Map.Entry<String,List<String>> entrySet : map.entrySet()){
            finalListOfList.add(entrySet.getValue());
        }
        return finalListOfList;
    }

    private static String sortedString(String unSortedString){
        char[] unSortedStringCharArray = unSortedString.toCharArray();
        Arrays.sort(unSortedStringCharArray);
        return new String(unSortedStringCharArray);
    }
}
