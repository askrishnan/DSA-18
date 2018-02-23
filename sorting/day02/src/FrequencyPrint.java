import java.util.*;

public class FrequencyPrint {

    static String frequencyPrint(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String[] ss = s.split(" ");

        for (String word: ss) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
            else {
                map.put(word, 1);
            }
        }

        // switching words and counts to sort by counts
        HashMap<Integer, List<String>> flipMap = new HashMap<Integer, List<String>>();

        for (String i : map.keySet()) {
            List<String> words = new ArrayList<String>();
            words = flipMap.getOrDefault(map.get(i), words);
            words.add(i);
            flipMap.put(map.get(i), words);
        }

        List<Integer> keys = new ArrayList<Integer>(flipMap.keySet());
        Collections.sort(keys);

        String print = "";
        int i = 0;
        for (Integer key:keys) {
            List<String> temp = flipMap.get(key);
            for (String val:temp) {
                while (i != key) {
                    print += val + " ";
                    i++;
                }
                i = 0;
            }
        }
        return print;
    }
}