/* NAME:        SWAPNA MUKKAMALLA
   COURSE:      IT-516 DATA STRUCTURES AND ALGORITHMS
   DATE:        09/16/2019
   DESCRIPTION: IMPLEMENTED THE CLASS FOR RESIZING ARRAY QUEUE
                cONSISTS OF USUAL ENQUEUE DEQUEUE METHODS
                THIS IMPLEMENTATION USES A RESIZING ARRAY,WHICH DOUBLE THE
                UNDERLYNG ARRAY WHEN IT IS FULL AND HALVES THE ARRAY WHEN
                IT IS 1/4 FULL.
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;
@SuppressWarnings("unchecked")

public class QueueAsArray<Item> implements Iterable<Item>
{
    private Item[] a ;     // queue items
    private int N ;        // number of items
    private int position;  // index


    // constructor for initializing the variables
    public QueueAsArray() {

        a = (Item[]) new Object[1];
        N = 0;
        position = 0;
    }

    // returns whether queue is empty or not
    public boolean isEmpty()
    {
        return N == 0;
    }

    //returns the size of the queue
    public int size()
    {
        return N;
    }

    //resizing the array
    private void resize(int max)
    { // Move queue to a new array of size max.
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i+position];
        }
        a = temp;

    }
    //add items to the queue
    public void enqueue(Item item)
    { // Add item to top of stack.
        if (N == a.length) {
            resize(2*a.length);
        }
        a[N+position] = item;
        N++;
    }

    //remove items  and returns which is least recently added
    public Item dequeue()
    {

        if (N > 0 && N == a.length / 4){
            resize(a.length / 2);
            position =0;
        }



            Item item = a[position];
            a[position++] = null;
            N--;
            return item;

    }

    // returns iterator that iterates over the queue
    public Iterator<Item> iterator()
    {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item>
    { // FIFO iteration.
        private int i = 0;

        public boolean hasNext()
        {
            return i < N;
        }
       public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = a[(i + position) % a.length];
            i++;
            return item;
        }
      public void remove() {
            throw new UnsupportedOperationException();
        }
    }




}

