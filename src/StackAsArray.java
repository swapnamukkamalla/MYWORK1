import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class StackAsArray<Item> implements Iterable<Item>
{
    private Item[] a = (Item[]) new Object[1]; // stack items
    private int N = 0; // number of items
    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }
    private void resize(int max)
    { // Move stack to a new array of size max.
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }
    public void push(Item item)
    { // Add item to top of stack.
        if (N == a.length) resize(2*a.length);
        a[N++] = item;
    }
    public Item pop()
    { // Remove item from top of stack.
        Item item = a[--N];
        a[N] = null; // Avoid loitering (see text).
        if (N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }
    public Iterator<Item> iterator()
    { return new ReverseArrayIterator(); }
    private class ReverseArrayIterator implements Iterator<Item>
    { // Support LIFO iteration.
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public Item next() { return a[--i]; }
        public void remove() { }
    }

    public static void main(String[] args) {
        StackAsArray<String> things = new StackAsArray<String>();            // Make a new empty Queue called "things"
        StdOut.println("Is this new Queue empty? " + things.isEmpty());     // Use the isEmpty() function

        StdOut.println("Enqueue items...");
        things.push("rock");                                             // Use the enqueue() function
        things.push("paper");                                            // Use the enqueue() function
        things.push("scissors");                                         // Use the enqueue() function
        things.push("lizard");                                           // Use the enqueue() function
        things.push("Spock");                                            // Use the enqueue() function
        StdOut.println("stack now has " + things.size() + " items in it."); // Use the size() function

        StdOut.println("Iterating through Queue items...");
        String allItems = "";                                               // Create a new String to hold the output
        for (String thisItem : things)                                      // Use the Iterator class to go through each item
            allItems += (thisItem + " ");                                   // Concatenate each item to the allItems String
        StdOut.println(allItems);                                           // Print out the allItems String

        StdOut.println("Stack still has " + things.size() + " items in it.");

        StdOut.println("Dequeue items...");
        while (!things.isEmpty()) {                                         // Use while loop until Queue isEmpty() is true
            StdOut.print(things.pop() + " ");                           // Dequeue each item to the output
        }
        StdOut.println();                                                   // Blank line
        StdOut.println("Queue now has " + things.size() + " items in it."); // Show that Queue has zero items in it now
    }
}
