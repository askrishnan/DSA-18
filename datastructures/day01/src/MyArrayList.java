public class MyArrayList {
    private Cow[] elems;
    private int size;

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
        size = 0;
    }

    // Runtime: O(1)*
    public void add(Cow c) {
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