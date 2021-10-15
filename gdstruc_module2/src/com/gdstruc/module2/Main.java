package com.gdstruc.module2;

//import java.util.ArrayList;
//import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create variables for linked list
        Player chicken = new Player( 1, "Chicken", 87);
        Player cornea68 = new Player( 2, "Cornea68", 68);
        Player theChosenOne = new Player( 3, "TheChosenOne", 255);
        Player nullMonster = new Player( 4, "nullmonster", 101);
        Player momKingDad = new Player( 5, "Momkingdad", 238);

        // Create linked list
        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        playerLinkedList.addToFront(chicken);
        playerLinkedList.addToFront(cornea68);
        playerLinkedList.addToFront(theChosenOne);
        playerLinkedList.addToFront(nullMonster);
        playerLinkedList.addToFront(momKingDad);

        // Print linked list before removing first element
        System.out.println("Linked list before removal:");
        playerLinkedList.printList();
        System.out.println("\n[Size of List:] " + playerLinkedList.count()); // Counts the size of array

        // Test to see if the LinkedList contains chicken and get its index
        System.out.println((playerLinkedList.contains(momKingDad)));
        playerLinkedList.indexOf(momKingDad);

        // Remove the first element of a linked list
        playerLinkedList.remove();

        // Print linked list after removing first element
        System.out.println("\n\nLinked list after removal:");
        playerLinkedList.printList();
        System.out.println("\n[Size of List:] " + playerLinkedList.count()); // Counts the size of array

        // Test again to see if the LinkedList contains chicken and get its index
        System.out.println((playerLinkedList.contains(momKingDad)));
        playerLinkedList.indexOf(momKingDad);
    }
}
