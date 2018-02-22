import java.util.HashMap;

public class FrequencyPrint {

    static String frequencyPrint(String s) {
        // TODO
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

        String output_string = "";

        for (Object i : sorted_map.keySet()) {
            output_string += sorted_map.get(i);

        }

        return output_string.trim();
    }

}
