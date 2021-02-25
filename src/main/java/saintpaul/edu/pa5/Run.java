package saintpaul.edu.pa5;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        LinkedList testList = new LinkedList();
        Scanner keyboard = new Scanner(System.in);
        String triggeredOperation;
        do {
            System.out.print("> ");
            triggeredOperation = keyboard.nextLine();
            switch(triggeredOperation.toLowerCase()) {
                case "insert":
                    testList.insert();
                    break;
                case "print":
                    testList.print();
                    break;
                case "remove":
                    testList.remove();
                    break;
                case "exit":
                    if (!testList.isEmpty()){
                        System.out.println("You should remove the list before exit.");
                        triggeredOperation = "";
                    }
                    break;
                default:
                    System.out.println("Error: unknown request '" + triggeredOperation + "'.");
            }

        }while (!triggeredOperation.toLowerCase().equals("exit"));

    }
}
