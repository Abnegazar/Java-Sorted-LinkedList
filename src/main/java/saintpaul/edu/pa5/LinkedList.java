package saintpaul.edu.pa5;

import java.util.Scanner;

public class LinkedList {

    // This node represent the first node of our list
    private Node head;

    /**
     * used to receive a character from user and check if it's a lower case letter
     *
     * @return a lower case alphabetical character
     */
    public char askLowercaseLetter() {
        char userVal; // the return variable
        String lowerCaseCharacters = "abcdefghijklmnopqrstuvwxyz"; // string of all lowercase letter
        Scanner fromUser = new Scanner(System.in); //Scanner used to receive user entries
        do { //repeat the following instructions while....
            System.out.print("Please, enter lower case letters ‘a’ to ‘z’: ");// Ask for a letter
            userVal = fromUser.next().charAt(0);//get a value from user
        } while (lowerCaseCharacters.indexOf(userVal) == -1); //... the entered value isn't in our lowercaseString
        return userVal;
    }

    /**
     * Method used to add a new node at the end of the linkedList.
     * We create get a value from user and store it in a variable called data, after checking that it's a letter with our function askLowerCaseLetter
     * create a new node which data's value is "data" and set his next to null, because it'll be the last node of our list
     * if our list doesn't have any node yet, we add the new node at the beginning
     * else if we already have some elements in the list, we go through each element of the list by going next to next, till the last element
     * of the list (element with null as next) and then we set the next of the last element as our new node
     */
    public void insert() {
        char data = askLowercaseLetter();
        Node node = new Node(data);
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node iterate = head;
            while (iterate.next != null) {
                iterate = iterate.next;
            }
            iterate.next = node;
        }

    }


    Node sortedMerge(Node a, Node b) {
        Node result;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    /**
     * head is the first node of the linked list to be sorted and h a pointer to head.
     * We need a reference to head in MergeSort()
     * The below implementation changes next links to sort the linked lists, so head node has to be changed if the data at the original head is not the smallest value in the linked list.
     *
     *If the head is NULL or there is only one element in the Linked List then return.
     *
     * Else divide the linked list into two halves.  FrontBackSplit(head, &a, &b); ||a and b are two halves||
     *
     * Sort the two halves a and b.
     *       MergeSort(a);
     *       MergeSort(b);
     *
     *  Merge the sorted a and b (using SortedMerge() discussed here)
     *    and update the head pointer using headRef.
     *      *headRef = SortedMerge(a, b);
     *
     * @param h
     * @return
     */
    Node mergeSort(Node h) {
        // Base case : if head is null 
        if (h == null || h.next == null) {
            return h;
        }

        // get the middle of the list 
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.next;

        // set the next of middle Node to null 
        middle.next = null;

        // Apply mergeSort on left list 
        Node left = mergeSort(h);

        // Apply mergeSort on right list 
        Node right = mergeSort(nextofmiddle);

        // Merge the left and right lists 
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    // Utility function to get the middle of the linked list 
    public static Node getMiddle(Node node) {
        if (node == null)
            return null;

        Node slow = node, fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * Used to print all of the elements of the list
     * travel to the list's last node by going next to next from the head
     * And for each node print his data attribute's value, followed by a space
     */
    public void print() {
        System.out.println("print");
        if (this.head == null) {
            System.out.println("There is nothing in the list.");
        } else {
            LinkedList temp = this;
            Node iterate = temp.mergeSort(temp.head);
            while (iterate.next != null) {
                System.out.print(iterate.data + " ");
                iterate = iterate.next;
            }
            System.out.print(iterate.data+"\n");
        }
    }

    /**
     * remove all the element from the list
     * We just set the head value to null
     */
    public void remove() {
        head = null;
        System.out.println("Linked list is now empty.");
    }

    //Check if the list is empty
    public boolean isEmpty(){
        return head == null;
    }
}
