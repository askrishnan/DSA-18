import java.util.ArrayList;

public class MyArrayList {
    private Cow[] cows;
    private int size;

<<<<<<< HEAD
    // TODO: Runtime: O(1)
    public MyArrayList() {
        cows = new Cow[10];
        size = 0;
    }

    // TODO: Runtime: O(1)
    public MyArrayList(int capacity) {
        cows = new Cow[capacity];
=======
    // Runtime: O(1)*
    public MyArrayList() {
        // Construct for array list. Defaults to 10 cows if none are specified.
        // Returns arraylist object with 10 cows.
        elems = new Cow[10];
        size = 0;
    }

    // Runtime:O(1)*
    public MyArrayList(int capacity) {
        // Construct an array list with specified capacity.
        // capacity : int amount of cows.
        // Returns arraylist object with 10 cows.
        elems = new Cow[capacity];
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
        size = 0;
    }

    // Runtime: O(1)*
    public void add(Cow c) {
<<<<<<< HEAD
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
=======
        // Adds a cow to a list in theoretically linear time.
        // Cow : Cow object to add to the list.
        // Returns void.
        if (size >= elems.length) {
            Cow[] temp_array = elems;
            elems = new Cow[temp_array.length * 2];
            System.arraycopy(temp_array, 0, elems, 0, size);
        }
        elems[size] = c;
        size++;
    }

    // Runtime: O(1)*
    public int size()  {
        // Returns the size of array list.
        return size;
    }

    // Runtime: O(1)*
    public Cow get(int index) {
        // Returns the specified cow from the list if the cow exists there.
        // index : The index of the cow.
        if (index < size && index > 0) {
            return elems[index];
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    // Runtime: O(n)
    public Cow remove(int index) {
        // Returns the specified cow (by index) from the list if there is a cow there.
        // index : The index of the cow to remove.
        if (index < 0 && index > size) {
            return null;
        }
        // Grab the cow.
        Cow temp_cow = get(index);

        // Actually remove it and move things over and all that.
        for (int i = index; i < size-1; i++) {
            elems[i] = elems[i+1];
        }
        // Memory is basically magic.
        elems[size - 1] = null;
        size--;
        // See if we can downsize the array.
        if (size < elems.length/4) {
            Cow[] temp_array = elems;
            elems = new Cow[temp_array.length / 2];
            System.arraycopy(temp_array, 0, elems, 0, size);
        }
        // Guess you can have your cow back.
        return temp_cow;

    }

    // Runtime: O(n)
    public void add(int index, Cow c) {
        // Adds a cow at some index.
        // index : the index at which to add the object.
        // c : The Cow object to add.
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        add(c);
        for (int i = size; i > index; i--) {
            elems[i] = elems[i - 1];
        }
        elems[index] = c;
    }
}
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
