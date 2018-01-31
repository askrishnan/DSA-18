import java.util.ArrayList;

public class MyArrayList {
    private Cow[] cows;
    private int size;

    // TODO: Runtime: O(?)
    public MyArrayList() {
        cows = new Cow[10];
        size = 0;
    }

    // TODO: Runtime: O(?)
    public MyArrayList(int capacity) {
        cows = new Cow[capacity];
        size = 0;
    }

    // TODO: Runtime: O(?)
    public void add(Cow c) {
        this.add(c);
        size++;

    }

    // TODO: Runtime: O(?)
    public int size() {
        return size;
    }

    // TODO: Runtime: O(?)
    public Cow get(int index) {
        indexCheck(index);
        return cows[index];
    }

    // TODO: Runtime: O(?)
    public Cow remove(int index) {
        indexCheck(index);
        Cow reMooved = cows[index];
        for (int i = index; i <= size(); i++){
            cows[i] = cows[i+1];
        }
        size--;
        return reMooved;
    }

    // TODO: Runtime: O(?)
    public void add(int index, Cow c) {
        indexCheck(index);
        if (size() == cows.length) {
            resize();
        }
        for (int i = size(); i > index; i--) {
            cows[i] = cows[i - 1];
        }
        cows[index] = c;
        size++;
    }

    private void indexCheck(int index) {
        if (index >= size() || index < 0)
            throw new IndexOutOfBoundsException();
        }
}
