import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class QueueTester {
    public static void main(String[] args) {
        Queue<String> things = new Queue<String>();                         // Make a new empty Queue called "things"
        StdOut.println("Is this new Queue empty? " + things.isEmpty());     // Use the isEmpty() function

        StdOut.println("Enqueue items...");
        things.enqueue("rock");                                             // Use the enqueue() function
        things.enqueue("paper");                                            // Use the enqueue() function
        things.enqueue("scissors");                                         // Use the enqueue() function
        things.enqueue("lizard");                                           // Use the enqueue() function
        things.enqueue("Spock");                                            // Use the enqueue() function
        StdOut.println("Queue now has " + things.size() + " items in it."); // Use the size() function

        StdOut.println("Iterating through Queue items...");
        String allItems = "";                                               // Create a new String to hold the output
        for (String thisItem : things)                                      // Use the Iterator parent class to go through each item
            allItems += (thisItem + " ");                                   // Concatenate each item to the allItems String
        StdOut.println(allItems);                                           // Print out the allItems String

        StdOut.println("Queue still has " + things.size() + " items in it."); // We iterated, not dequeued!

        StdOut.println("Dequeue items...");
        while (!things.isEmpty()) {                                         // Use while loop until Queue isEmpty() is true
            StdOut.print(things.dequeue() + " ");                           // Dequeue each item to the output
        }
        StdOut.println();                                                   // Blank line
        StdOut.println("Queue now has " + things.size() + " items in it."); // Show that Queue has zero items in it now
    }
}
