import java.util.ArrayList;
import java.util.List;
// Time complexity : O(3^n)
// Space complexity : O(hours)


public class CoinsOnAClock {

    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        List<char[]> result = new ArrayList<>();
        char[] answer = new char[hoursInDay];
        return coinsRec(result, answer, pennies, nickels, dimes, hoursInDay, 0,0);
    }
    public static List<char[]> coinsRec(List<char[]> result, char[] answer, int pennies, int nickels, int dimes, int hoursInDay, int a, int b) {
        if (b == hoursInDay) {
            char[] copy = new char[answer.length];
            System.arraycopy(answer, 0, copy, 0, answer.length);
            result.add(copy);
            return result;
        }
        for (int i = 0; i < 3; i++) {
            int c;
            if (answer[a] != 'p' && answer[a] != 'n' && answer[a] != 'd') {
                if (i == 0 && pennies > 0) {
                    answer[a] = 'p';
                    pennies--;
                    c = (a + 1) % answer.length;
                    coinsRec(result, answer, pennies, nickels, dimes, hoursInDay, c, b+1);
                    answer[a] = 0;
                    pennies++;
                }
                if (i == 1 && nickels > 0) {
                    answer[a] = 'n';
                    nickels--;
                    c = (a + 5) % answer.length;
                    coinsRec(result, answer, pennies, nickels, dimes, hoursInDay, c, b+1);
                    answer[a] = 0;
                    nickels++;
                }
                if (i==2 && dimes > 0) {
                    answer[a] = 'd';
                    dimes--;
                    c = (a + 10) % answer.length;
                    coinsRec(result, answer, pennies, nickels, dimes, hoursInDay, c, b+1);
                    answer[a] = 0;
                    dimes++;
                }
            }
        }
        return result;
    }
}
