# Sorted linked list

Java program that implements a sorted linked list.


## Problem

Write a Java program that implements a sorted linked list. You have to implement four of the following operations: insert, that adds an element into the list, print that prints the entire list (this would be in sorted order), remove deletes or removes the linked list, and exit to exit from the program. The program prompts the user to enter one of the following four commands: insert, print, remove, and exit. insert lets the user add a character to the list, print prints the list, remove gets rid of the current list and exit terminates the program. For other requests the program displays an error message.

=> Some additional rules cannot exit while there is a none null linked list (have to remove first), can only enter lower case letters ‘a’ to ‘z’.

#### Below is a sample run of the program.

> insert 
enter a char: a

> insert
enter a char: b

> print
a b

> insert
enter a char: c

> print
a b c

> insert
enter a char: b

> sort
Error: unknown request 'sort'

> print
a b b c

> remove
Linked list is now empty

> exit
