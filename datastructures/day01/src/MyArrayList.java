import java.util.ArrayList;

public class MyArrayList {
    private Cow[] cows;
    private int size;

    // TODO: Runtime: O(1)
    public MyArrayList() {
        cows = new Cow[10];
        size = 0;
    }

    // TODO: Runtime: O(1)
    public MyArrayList(int capacity) {
        cows = new Cow[capacity];
        size = 0;
    }

    // TODO: Runtime: O(?)
    public void add(Cow c) {
/*      cows[size]= c;
        size++;*/
        add(size,c);

    }

    // TODO: Runtime: O(1)
    public int size() {
        return size;
    }

    // TODO: Runtime: O(1)
    public Cow get(int index) {
        indexCheck(index);
        return cows[index];
    }

    // TODO: Runtime: O(N)
    public Cow remove(int index) {
        indexCheck(index);
        if (size() < cows.length/4&& cows.length>10) {
            smaller();
        }
        Cow reMooved = cows[index];
        for (int i = index; i <= size()-2; i++){
            cows[i] = cows[i+1];
        }

        size--;
        return reMooved;
    }

    // TODO: Runtime: O(N)
    public void add(int index, Cow c) {
        indexCheck(index);

        if (size() == cows.length) {
            bigger();
        }

        for (int i = size(); i > index; i--) {
            cows[i] = cows[i - 1];
        }
        cows[index] = c;
        size++;
    }

    public void bigger() {

            Cow[] moreCows = new Cow[cows.length * 2];
            System.arraycopy(cows, 0, moreCows, 0, cows.length);
            cows = moreCows;
        }


    public void smaller() {
/*        if (size() < cows.length/4) {
            int halfSize = cows.length/2;
            if (halfSize <= 1) {
                halfSize = 2;
            }
            else {
                Cow[] lessCows = new Cow[halfSize];
                System.arraycopy(cows, 0, lessCows,0, lessCows.length);
                cows = lessCows;
            }
        }*/

            int halfSize = cows.length/2;

                Cow[] lessCows = new Cow[halfSize];
                System.arraycopy(cows, 0, lessCows,0, halfSize);
                cows = lessCows;

        }


    private void indexCheck(int index) {
        if (index > size() || index < 0)
            throw new IndexOutOfBoundsException();
        }
}
