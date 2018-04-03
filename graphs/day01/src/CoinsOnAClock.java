import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CoinsOnAClock {

    /**
     * Space: O(N^2) -> array of arrays
     * Time: O(3^N)
     */
    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        // TODO
        List<char[]> result = new ArrayList<>();
        char[] answer = new char[hoursInDay];
        coinsRecursive(result, answer, pennies, nickels, dimes, 0, 0);
        return result;
    }

    public static List<char[]> coinsRecursive(List<char[]> result, char[] answer, int pennies, int nickels, int dimes, int loc, int finCount) {
        if (finCount == answer.length) { // if the coin order is long enough add it to the result
            char[] fin = new char[answer.length];
            System.arraycopy(answer, 0, fin, 0, answer.length);
            result.add(fin);
            return result;
        }
        for (int i=0; i<3; i++) {
            int newLoc;
            if (answer[loc] == 'p' || answer[loc] == 'n' || answer[loc] == 'd') {
                i = 3;
            }
            if (answer[loc] != 'p' && answer[loc] != 'n' && answer[loc] != 'd') { // if the time has no coin
                if (i == 0 && pennies > 0) {
                    answer[loc] = 'p';
                    pennies--;
                    newLoc = (loc + 1) % answer.length; // modulo 12 to give a number that is on the clock
                    coinsRecursive(result, answer, pennies, nickels, dimes, newLoc, finCount + 1); // checks to see if new location is full, if it is coin is removed
                    answer[loc] = 0;
                    pennies++;
                }
                if (i == 1 && nickels > 0) {
                    answer[loc] = 'n';
                    nickels--;
                    newLoc = (loc + 5) % answer.length;
                    coinsRecursive(result, answer, pennies, nickels, dimes, newLoc, finCount + 1);
                    answer[loc] = 0;
                    nickels++;
                }
                if (i == 2 && dimes > 0) {
                    answer[loc] = 'd';
                    dimes--;
                    newLoc = (loc + 10) % answer.length;
                    coinsRecursive(result, answer, pennies, nickels, dimes, newLoc, finCount + 1);
                    answer[loc] = 0;
                    dimes++;
                }
            }
        }
        return result;

    }
}

