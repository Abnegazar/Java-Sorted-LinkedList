package saintpaul.edu.pa5;

/**
 * Class used to create a new node in our LinkedList
 */
public class Node {

    char data; // The new node's value
    Node next; // The following node after this one

    public Node() {
    }

    /**
     * Constructor used to create a new node which data's value is "data"
     * @param data
     */
    public Node(char data) {
        this.data = data;
    }

}
