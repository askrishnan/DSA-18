<<<<<<< HEAD
import java.util.*;
=======
import java.util.HashMap;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144

public class FrequencyPrint {

    static String frequencyPrint(String s) {
<<<<<<< HEAD
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
=======
        // I think this is O(nlogn), but also I have no clue
        //

        // Place all of the words in a hashmap with the frequencies.
        HashMap<String, Integer> word_map = new HashMap<String, Integer>();
        String[] words_list = s.split("\\s+");
        for (int i = 0; i < words_list.length; i++) {
            String current_word = words_list[i];
            if (!word_map.containsKey(current_word)) {
                word_map.put(current_word, 1);
            }
            else {
                word_map.put(current_word, word_map.get(current_word) + 1);
            }

        }
        // This is horrific but it inverts the keys and values.
        HashMap<Integer, String> sorted_map = new HashMap<Integer, String>();
        for (Object i : word_map.keySet()) {
            if (sorted_map.get(word_map.get(i)) != null) {
                for (int j = 0; j < word_map.get(i); j++) {
                    String k = sorted_map.get(word_map.get(i)) + " " + i;
                    sorted_map.put(word_map.get(i), k);
                }
            }
            else {
                String k = "";
                for (int j = 0; j < (int) word_map.get(i); j++) {
                    k = k + " " + i;
                }
                sorted_map.put(word_map.get(i), k);
            }
        }

        // Make a huge output string and toss it.
        String output_string = "";

        for (Object i : sorted_map.keySet()) {
            output_string += sorted_map.get(i);

        }

        return output_string.trim();
    }
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144

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